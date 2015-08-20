package bots.demobots.playerbots.strategies.postflop;

import bots.demobots.playerbots.strategies.preflop.Strategy;

import com.biotools.meerkat.Action;
import com.biotools.meerkat.Card;
import com.biotools.meerkat.GameInfo;

public class PostFlopAlwaysCall implements Strategy {

	@Override
	public Action getAction(Card c1, Card c2, GameInfo gi, int seat) {
		return Action.callAction(gi);
	}

}
