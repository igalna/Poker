package bots.demobots.playerbots.strategies.postflop;

import java.util.ArrayList;
import java.util.List;

import bots.demobots.playerbots.strategies.preflop.Strategy;
import bots.demobots.playerbots.utilities.CardConverter;

import com.biotools.meerkat.Action;
import com.biotools.meerkat.Card;
import com.biotools.meerkat.GameInfo;
import com.biotools.meerkat.Hand;

import common.handeval.klaatu.FastEval;

public class PostFlopHandStrength implements Strategy {

	private GameInfo gi;
	
	@Override
	public Action getAction(Card c1, Card c2, GameInfo gi, int seat) {
		this.gi = gi;
		
		Integer cardOneIndex = FastEval.encode(c1.getRank(), CardConverter.convertCards(c1.getSuit()));
		Integer cardTwoIndex = FastEval.encode(c2.getRank(), CardConverter.convertCards(c2.getSuit()));
		
		Hand hand = gi.getBoard();
		Integer[] boardCards = new Integer[hand.size()];
		
		List<Integer> deckOfCardIndexes = new ArrayList<Integer>();
		for (int i = 0; i < 52; i++) {
			deckOfCardIndexes.add(Integer.valueOf(i));
		}
		deckOfCardIndexes.remove(cardOneIndex);
		deckOfCardIndexes.remove(cardTwoIndex);
		
		for (int x = 0; x < hand.size(); x++) {
			Card card = hand.getCard(x + 1);
			boardCards[x] = FastEval.encode(card.getRank(), CardConverter.convertCards(card.getSuit()));
			deckOfCardIndexes.remove(boardCards[x]);
		}
		
		Integer ourHandStrength = evaluateHand(boardCards, cardOneIndex, cardTwoIndex);
		
		return calculateOpponentStrength(deckOfCardIndexes, ourHandStrength,
				boardCards);
	}

	private Action calculateOpponentStrength(List<Integer> deckOfCardIndexes,
			Integer ourHandStrength, Integer[] boardCards) {
		int opponentHasStrongerHand = 0;
		int opponentHasSameHand = 0;
		int opponentHasWorseHand = 0;
		
		for (int x = 0; x < deckOfCardIndexes.size(); x ++) {
			Integer opponentFirstCard = deckOfCardIndexes.get(x);
			
			for (int y = x + 1; y < deckOfCardIndexes.size(); y++) {
				Integer opponentSecondCard = deckOfCardIndexes.get(y);
				Integer opponentHandStrength = evaluateHand(boardCards, opponentFirstCard, opponentSecondCard);
				
				if (opponentHandStrength > ourHandStrength)
					opponentHasStrongerHand++;
				if (opponentHandStrength == ourHandStrength)
					opponentHasSameHand++;
				if (opponentHandStrength < ourHandStrength)
					opponentHasWorseHand++;
			}
		}
		
		if (opponentHasStrongerHand > opponentHasWorseHand)
			return Action.checkOrFoldAction(gi);
		if (opponentHasStrongerHand < opponentHasWorseHand)
			return Action.raiseAction(gi);
		else
			return Action.callAction(gi);
	}

	
	private int evaluateHand(Integer[] boardCards, Integer firstEncodedCard, Integer secondEncodedCard) {
		if (boardCards.length == 3)
			return FastEval.eval5(boardCards[0], boardCards[1], boardCards[2], firstEncodedCard, secondEncodedCard);
		else if (boardCards.length == 4)
			return FastEval.eval6(boardCards[0], boardCards[1], boardCards[2], boardCards[3], firstEncodedCard, secondEncodedCard);
		else
			return FastEval.eval7(boardCards[0], boardCards[1], boardCards[2], boardCards[3], boardCards[4], firstEncodedCard, secondEncodedCard);
	}

}
