package bots.demobots.playerbots.strategies.postflop;

import java.util.ArrayList;

import util.Utils;
import bots.demobots.playerbots.strategies.preflop.Strategy;

import com.biotools.meerkat.Action;
import com.biotools.meerkat.Card;
import com.biotools.meerkat.GameInfo;
import com.biotools.meerkat.Hand;
import com.biotools.meerkat.Holdem;
import common.handeval.klaatu.PartialStageFastEval;

public class PostFlopSimpleBot implements Strategy {

	private GameInfo gi;
	private int ourSeat;
	
	@Override
	public Action getAction(Card c1, Card c2, GameInfo gi, int ourSeat) {
		this.gi = gi;
		this.ourSeat = ourSeat;
		
		// number of players left in the hand (including us)
		int np = gi.getNumActivePlayers();

		// amount to call
		double toCall = gi.getAmountToCall(ourSeat);

		// immediate pot odds
		double PO = toCall / (double) (gi.getEligiblePot(ourSeat) + toCall);

		EnumerateResult result = enumerateHands(c1, c2, gi.getBoard());
		// compute our current hand rank
		double HRN = Math.pow(result.HR, np - 1);

		// compute a fast approximation of our hand potential
		double PPOT = 0.0;
		if (gi.getStage() < Holdem.RIVER) {
			PPOT = result.PPot;
		}

		if (HRN == 1.0) {
			// dah nuts -- raise the roof!
			return betOrRaisePot();
		}

		// consider checking or betting:
		if (toCall == 0) {
			if (Math.random() < HRN * HRN) {
				return betOrRaisePot(); // bet a hand in proportion to it's strength
			}
			if (Math.random() < PPOT) {
				return betOrRaisePot(); // semi-bluff
			}
			// just check
			return Action.checkAction();
		} else {
			// consider folding, calling or raising:        
			if (Math.random() < Math.pow(HRN, 1 + gi.getNumRaises())) {
				// raise in proportion to the strength of our hand
				return betOrRaisePot();
			}

			if (HRN * HRN * gi.getEligiblePot(ourSeat) > toCall || PPOT > PO) {
				// if we have draw odds or a strong enough hand to call
				return Action.callAction(toCall);
			}
			return Action.checkOrFoldAction(toCall);
		}
	}

	/**
	 * if fixed-limit: just bets or raises<br>
	 * in no-limit:<br>
	 * - bets 2/3 pot<br>
	 * - or raises a 2/3*(pot + toCall) if someone bet before<br>
	 * thus always giving 1:2.5 pot odds to the villain.<br>
	 * <br>
	 * if stack is lower than to call, just bets the stack
	 * if stack remaining after the raise is lower than the bet/raise goes
	 * all-in
	 * @return
	 */
	private Action betOrRaisePot() {
		if (gi.isFixedLimit()) {
			return Action.raiseAction(gi);
		} else {
			if (gi.getAmountToCall(ourSeat) > 0) {
				if (gi.getBankRoll(ourSeat) > gi.getAmountToCall(ourSeat)) {
					double wantedRaiseAmount = Utils.roundToCents((gi.getMainPotSize() + gi.getAmountToCall(ourSeat)) / 3 * 2);
					double maxPossibleRaise = Utils.roundToCents(gi.getBankRoll(ourSeat) - gi.getAmountToCall(ourSeat));
					if (maxPossibleRaise < wantedRaiseAmount) {
						wantedRaiseAmount = maxPossibleRaise;
					}
					return Action.raiseAction(gi, wantedRaiseAmount);
				} else {
					return Action.callAction(gi);
				}
			} else {
				double betAmount = Utils.roundToCents(gi.getMainPotSize() / 3 * 2);
				if (gi.getBankRoll(ourSeat) - betAmount < betAmount) {
					betAmount = gi.getBankRoll(ourSeat);
				}

				return Action.betAction(betAmount);
			}
		}
	}

	/**
	 * Calculate the raw (unweighted) PPot1 and NPot1 of a hand. (Papp 1998, 5.3)
	 * Does a one-card look ahead.
	 * 
	 * @param c1 the first hole card
	 * @param c2 the second hole card
	 * @param bd the board cards
	 * @return 
	 */
	public EnumerateResult enumerateHands(Card c1, Card c2, Hand bd) {
		double[][] HP = new double[3][3];
		double[] HPTotal = new double[3];
		int ourrank7, opprank;
		int index;
		int[] boardIndexes = new int[bd.size()];
		int[] boardIndexes2 = new int[bd.size() + 1];

		int c1Index;
		int c2Index;

		ArrayList<Integer> deck = new ArrayList<Integer>();
		for (int i = 0; i < 52; i++) {
			deck.add(Integer.valueOf(i));
		}
		for (int i = 0; i < bd.size(); i++) {
			Card card = bd.getCard(i + 1);
			boardIndexes[i] = PartialStageFastEval.encode(card.getRank(), card.getSuit());
			boardIndexes2[i] = PartialStageFastEval.encode(card.getRank(), card.getSuit());
			deck.remove(Integer.valueOf(boardIndexes[i]));
		}
		c1Index = PartialStageFastEval.encode(c1.getRank(), c1.getSuit());
		c2Index = PartialStageFastEval.encode(c2.getRank(), c2.getSuit());
		deck.remove(Integer.valueOf(c1Index));
		deck.remove(Integer.valueOf(c2Index));

		int ourrank5 = eval(boardIndexes, c1Index, c2Index);

		// pick first opponent card
		for (int i = 0; i < deck.size(); i++) {
			int o1Card = deck.get(i);
			// pick second opponent card
			for (int j = i + 1; j < deck.size(); j++) {
				int o2Card = deck.get(j);
				opprank = eval(boardIndexes, o1Card, o2Card);
				if (ourrank5 > opprank)
					index = AHEAD;
				else if (ourrank5 == opprank)
					index = TIED;
				else
					index = BEHIND;
				HPTotal[index]++;
				if (bd.size() < 5) {

					// tally all possiblities for next board card
					for (int k = 0; k < deck.size(); k++) {
						if (i == k || j == k)
							continue;
						boardIndexes2[boardIndexes2.length - 1] = deck.get(k);
						ourrank7 = eval(boardIndexes2, c1Index, c2Index);
						opprank = eval(boardIndexes2, o1Card, o2Card);
						if (ourrank7 > opprank)
							HP[index][AHEAD]++;
						else if (ourrank7 == opprank)
							HP[index][TIED]++;
						else
							HP[index][BEHIND]++;
					}
				}
			}
		} /* end of possible opponent hands */

		double den1 = (45 * (HPTotal[BEHIND] + (HPTotal[TIED] / 2.0)));
		double den2 = (45 * (HPTotal[AHEAD] + (HPTotal[TIED] / 2.0)));
		EnumerateResult result = new EnumerateResult();
		if (den1 > 0) {
			result.PPot = (HP[BEHIND][AHEAD] + (HP[BEHIND][TIED] / 2.0) + (HP[TIED][AHEAD] / 2.0)) / (double) den1;
		}
		if (den2 > 0) {
			result.NPot = (HP[AHEAD][BEHIND] + (HP[AHEAD][TIED] / 2.0) + (HP[TIED][BEHIND] / 2.0)) / (double) den2;
		}
		result.HR = (HPTotal[AHEAD] + (HPTotal[TIED] / 2)) / (HPTotal[AHEAD] + HPTotal[TIED] + HPTotal[BEHIND]);

		return result;
	}

	private int eval(int[] boardIndexes, int c1Index, int c2Index) {
		if (boardIndexes.length == 5) {
			return PartialStageFastEval.eval7(boardIndexes[0], boardIndexes[1], boardIndexes[2], boardIndexes[3], boardIndexes[4], c1Index, c2Index);
		} else if (boardIndexes.length == 4) {
			return PartialStageFastEval.eval6(boardIndexes[0], boardIndexes[1], boardIndexes[2], boardIndexes[3], c1Index, c2Index);
		} else {
			return PartialStageFastEval.eval5(boardIndexes[0], boardIndexes[1], boardIndexes[2], c1Index, c2Index);
		}
	}

	// constants used in above method:
	private final static int AHEAD = 0;
	private final static int TIED = 1;
	private final static int BEHIND = 2;

	class EnumerateResult {
		double HR;
		double PPot;
		double NPot;
	}	
}