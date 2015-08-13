package bots.demobots.playerbots.strategies;

import com.biotools.meerkat.Action;
import com.biotools.meerkat.Card;
import com.biotools.meerkat.GameInfo;

public class AggressiveSixtyFivePercent implements Strategy {

	@Override
	public Action getPreFlopAction(Card c1, Card c2, GameInfo gi, int seat) {
		
		// if player has pocket pairs and pairs are 5 or greater, raise
		if (c1.getRank() == c2.getRank()) {
			if (c1.getRank() >= Card.SEVEN && c2.getRank() >= Card.SEVEN) {
				if (gi.getNumRaises() < 2) {
					return Action.raiseAction(gi);
				}
				return Action.callAction(gi);
			}
		}
		
		if (c1.getRank() == Card.ACE || c2.getRank() == Card.ACE) {
			if (c1.getRank() >= Card.TEN || c2.getRank() >= Card.TEN) {
				return Action.raiseAction(gi);
			}
		}
		
		if (c1.getRank() == Card.KING || c2.getRank() == Card.KING) {
			if (c1.getRank() >= Card.QUEEN || c2.getRank() >= Card.QUEEN) {
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