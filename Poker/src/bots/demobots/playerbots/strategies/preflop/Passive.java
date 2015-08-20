package bots.demobots.playerbots.strategies.preflop;

import com.biotools.meerkat.Action;
import com.biotools.meerkat.Card;
import com.biotools.meerkat.GameInfo;

public class Passive implements Strategy {

	@Override
	public Action getAction(Card c1, Card c2, GameInfo gi, int seat) {
		
		double toCall = gi.getAmountToCall(seat);
		
		// if you have pocket pairs, call
		if (c1.getRank() == c2.getRank()) {
			return Action.callAction(toCall);
		}
		
		// if both hole cards are bigger than 10, call
		if (c1.getRank() > Card.TEN && c2.getRank() > Card.TEN) {
			return Action.callAction(toCall);
		}
		
		// raise if both hole cards are within range of a straight
		if (Math.abs(c1.getRank() - c2.getRank()) < 4) {
			return Action.callAction(toCall);
		}
		
		
		return Action.checkOrFoldAction(toCall);
		
	}
}
