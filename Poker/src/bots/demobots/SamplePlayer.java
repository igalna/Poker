package bots.demobots;

import com.biotools.meerkat.Action;
import com.biotools.meerkat.Card;
import com.biotools.meerkat.GameInfo;
import com.biotools.meerkat.Player;
import com.biotools.meerkat.util.Preferences;

import common.handeval.klaatu.FastEval;
import common.handeval.klaatu.PartialStageFastEval;

public class SamplePlayer implements Player {

	private int seat;
	private Card c1, 
				 c2;
	private GameInfo gi;
	private Preferences playerPrefs;

	public SamplePlayer() {
	}
	
	@Override
	public void holeCards(Card c1, Card c2, int seat) {
		this.c1 = c1;
		this.c2 = c2;
		this.seat = seat;
	}

	@Override
	public void gameStartEvent(GameInfo gi) {
		this.gi = gi;
	}
	
	@Override
	public Action getAction() {
		if (gi.isPreFlop()) {
			return getPreFlopAction();
		}
		double toCall = gi.getAmountToCall(seat);
		return Action.callAction(toCall);
	}

	private Action getPreFlopAction() {
		double toCall = gi.getAmountToCall(seat);
		
		// if you have pocket pairs, raise.
		if (c1.getRank() == c2.getRank()) {
			if (gi.getNumRaises() < 2) {
				return Action.raiseAction(gi);
			}
			if (gi.getNumRaises() < 3) {
				return Action.callAction(toCall);
			}
		}
		
		// raise if both hole cards are bigger than 10
		if (c1.getRank() > Card.TEN && c2.getRank() > Card.TEN) {
			if (gi.getNumRaises() < 2) {
				return Action.raiseAction(gi);
			}
			return Action.callAction(toCall);
		}
		
		// raise if both hole cards are within range of a straight
		if (Math.abs(c1.getRank() - c2.getRank()) < 4) {
			return Action.raiseAction(gi);
		}
		
		
		return Action.checkOrFoldAction(toCall);
	}

	@Override
	public void actionEvent(int arg0, Action arg1) {
	}

	@Override
	public void dealHoleCardsEvent() {
	}

	@Override
	public void gameOverEvent() {
	}


	@Override
	public void gameStateChanged() {
	}

	@Override
	public void showdownEvent(int arg0, Card arg1, Card arg2) {
	}

	@Override
	public void stageEvent(int arg0) {
	}

	@Override
	public void winEvent(int arg0, double arg1, String arg2) {
	}

	@Override
	public void init(Preferences playerPrefs) {
		this.playerPrefs = playerPrefs;

	}

}
