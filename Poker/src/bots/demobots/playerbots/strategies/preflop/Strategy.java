package bots.demobots.playerbots.strategies.preflop;

import com.biotools.meerkat.Action;
import com.biotools.meerkat.Card;
import com.biotools.meerkat.GameInfo;

/**
 * 
 * Strategy Interface
 * 
 * @author igalna
 *
 */
public interface Strategy {
	
	Action getAction(Card c1, Card c2, GameInfo gi, int seat);
}
