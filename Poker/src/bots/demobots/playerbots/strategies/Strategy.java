package bots.demobots.playerbots.strategies;

import com.biotools.meerkat.Action;
import com.biotools.meerkat.Card;
import com.biotools.meerkat.GameInfo;

public interface Strategy {

	Action getPreFlopAction(Card c1, Card c2, GameInfo gi, int seat);
	
	Action getPostFlopAction(double toCall);
}
