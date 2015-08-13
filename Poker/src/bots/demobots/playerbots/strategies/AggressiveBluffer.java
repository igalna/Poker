package bots.demobots.playerbots.strategies;

import com.biotools.meerkat.Action;
import com.biotools.meerkat.Card;
import com.biotools.meerkat.GameInfo;

public class AggressiveBluffer extends Aggressive {

	@Override
	public Action getPreFlopAction(Card c1, Card c2, GameInfo gi, int seat) {
		
		if ((Math.random()  * 100) < 95) {
			return  super.getPreFlopAction(c1, c2, gi, seat);
		}
		return Action.callAction(gi.getAmountToCall(seat));
	}
	
	@Override
	public Action getPostFlopAction(Card c1, Card c2, GameInfo gi, int seat) {
		
		if ((Math.random() * 100) < 95) {
			return super.getPreFlopAction(c1, c2, gi, seat);
		}
		return Action.callAction(gi.getAmountToCall(seat));
	}
}
