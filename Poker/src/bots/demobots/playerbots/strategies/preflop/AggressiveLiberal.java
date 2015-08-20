package bots.demobots.playerbots.strategies.preflop;

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
public class AggressiveLiberal implements Strategy {

	@Override
	public Action getAction(Card c1, Card c2, GameInfo gi, int seat) {
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
		
		// raise if both hole cards are bigger than Eight
		if (c1.getRank() >= Card.EIGHT && c2.getRank() >= Card.EIGHT) {
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
}
