package bots.demobots.playerbots.strategies.preflop;

import com.biotools.meerkat.Action;
import com.biotools.meerkat.Card;
import com.biotools.meerkat.GameInfo;

/**
 * 
 * Raiser Strategy
 * 
 * If it can it raises all the time
 * 
 * 
 * @author igalna
 *
 */
public class Raiser implements Strategy {

	@Override
	public Action getAction(Card c1, Card c2, GameInfo gi, int seat) {
		if (gi.getNumRaises() < 2) {
			return Action.raiseAction(gi);
		}
		
		return Action.callAction(gi);
	}
}