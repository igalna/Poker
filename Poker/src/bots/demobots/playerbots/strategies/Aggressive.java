package bots.demobots.playerbots.strategies;

import com.biotools.meerkat.Action;
import com.biotools.meerkat.Card;
import com.biotools.meerkat.GameInfo;

/**
 * 
 * Aggressive strategy
 * 
 * Implements an aggressive strategy for players
 * 
 * 
 * @author igalna
 *
 */
public class Aggressive implements Strategy {

	@Override
	public Action getPreFlopAction(Card c1, Card c2, GameInfo gi, int seat) {
		double tocall = gi.getAmountToCall(seat);
		
		// if you have pocket pairs, raise.
		if (c1.getRank() == c2.getRank()) {
			if (gi.getNumRaises() < 2) {
				return Action.raiseAction(gi);
			}
			if (gi.getNumRaises() < 3) {
				return Action.callAction(tocall);
			}
		}
		
		// raise if both hole cards are bigger than 10
		if (c1.getRank() > Card.TEN && c2.getRank() > Card.TEN) {
			if (gi.getNumRaises() < 2) {
				return Action.raiseAction(gi);
			}
			return Action.callAction(tocall);
		}
		
		// raise if both hole cards are within range of a straight
		if (Math.abs(c1.getRank() - c2.getRank()) < 4) {
			return Action.raiseAction(gi);
		}
		
		
		return Action.checkOrFoldAction(tocall);
	}

	@Override
	public Action getPostFlopAction(Card c1, Card c2, GameInfo gi, int seat) {
		return Action.callAction(gi.getAmountToCall(seat));
	}

}
