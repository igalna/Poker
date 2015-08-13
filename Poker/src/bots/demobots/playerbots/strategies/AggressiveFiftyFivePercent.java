package bots.demobots.playerbots.strategies;

import com.biotools.meerkat.Action;
import com.biotools.meerkat.Card;
import com.biotools.meerkat.GameInfo;

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

public class AggressiveFiftyFivePercent implements Strategy {

	@Override
	public Action getPreFlopAction(Card c1, Card c2, GameInfo gi, int seat) {
		
		// if player has pocket pairs and pairs are 5 or greater, raise
		if (c1.getRank() == c2.getRank()) {
			if (c1.getRank() >= Card.FOUR && c2.getRank() >= Card.FOUR) {
				if (gi.getNumRaises() < 2) {
					return Action.raiseAction(gi);
				}
				return Action.callAction(gi);
			}
		}
		
		if (c1.getRank() == Card.ACE || c2.getRank() == Card.ACE) {
			if (c1.getRank() >= Card.SEVEN || c2.getRank() >= Card.SEVEN) {
				return Action.raiseAction(gi);
			}
		}
		
		if (c1.getRank() == Card.KING || c2.getRank() == Card.KING) {
			if (c1.getRank() >= Card.NINE || c2.getRank() >= Card.NINE) {
				return Action.raiseAction(gi);
			}
		}
		
		if (c1.getRank() == Card.QUEEN || c2.getRank() == Card.QUEEN) {
			if (c1.getRank() >= Card.TEN || c2.getRank() >= Card.TEN) {
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
		return Action.callAction(gi);
	}

}
