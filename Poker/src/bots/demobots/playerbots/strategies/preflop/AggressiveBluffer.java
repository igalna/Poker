package bots.demobots.playerbots.strategies.preflop;

import com.biotools.meerkat.Action;
import com.biotools.meerkat.Card;
import com.biotools.meerkat.GameInfo;

public class AggressiveBluffer implements Strategy {

	@Override
	public Action getAction(Card c1, Card c2, GameInfo gi, int seat) {
		
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
		
		if (Math.random() < 0.05) {
			return Action.callAction(tocall);
		}
		
		return Action.checkOrFoldAction(tocall);
	}
}