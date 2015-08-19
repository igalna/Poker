package bots.demobots.playerbots.strategies;

import java.util.ArrayList;
import java.util.List;

import bots.demobots.playerbots.utilities.CardConverter;

import com.biotools.meerkat.Action;
import com.biotools.meerkat.Card;
import com.biotools.meerkat.GameInfo;
import com.biotools.meerkat.Hand;

import common.handeval.klaatu.FastEval;
import common.handeval.klaatu.PartialStageFastEval;
import common.handeval.stevebrecher.*;

/**
 * 
 * Strategy uses hole card average winning percentages to decide on play
 * 
 * if the average winning percentage of the hole cards is greater than 60% the player will play
 * uses the average winning percentage stats from http://www.beatthefish.com
 * 
 * @author igalna
 *
 */

public class AggressiveSixtyPercent implements Strategy {	
	
	@Override
	public Action getPreFlopAction(Card c1, Card c2, GameInfo gi, int seat) {
		
		// if player has pocket pairs and pairs are 5 or greater, raise
		if (c1.getRank() == c2.getRank()) {
			if (c1.getRank() >= Card.FIVE && c2.getRank() >= Card.FIVE) {
				if (gi.getNumRaises() < 2) {
					return Action.raiseAction(gi);
				}
				return Action.callAction(gi);
			}
		}
		
		if (c1.getRank() == Card.ACE || c2.getRank() == Card.ACE) {
			if (c1.getRank() >= Card.EIGHT || c2.getRank() >= Card.EIGHT) {
				return Action.raiseAction(gi);
			}
		}
		
		if (c1.getRank() == Card.KING || c2.getRank() == Card.KING) {
			if (c1.getRank() >= Card.TEN || c2.getRank() >= Card.TEN) {
				return Action.raiseAction(gi);
			}
		}
		
		if (c1.getRank() == Card.QUEEN || c2.getRank() == Card.QUEEN) {
			if (c1.getRank() >= Card.JACK || c2.getRank() >= Card.JACK) {
				return Action.raiseAction(gi);
			}
		}
		
		// If both hole cards are within range of a straight
		if (Math.abs(c1.getRank() - c2.getRank()) < 4) {
			return Action.raiseAction(gi);
		}
		
		return Action.checkOrFoldAction(gi);
	}

	@Override
	public Action getPostFlopAction(Card c1, Card c2, GameInfo gi, int seat) {
		
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
		
		
		
		
		
		
		return Action.callAction(gi);
		
	}

}
