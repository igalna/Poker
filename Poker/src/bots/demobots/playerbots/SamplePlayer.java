package bots.demobots.playerbots;

import bots.demobots.playerbots.strategies.Strategy;

import com.biotools.meerkat.Action;
import com.biotools.meerkat.Card;
import com.biotools.meerkat.GameInfo;
import com.biotools.meerkat.Player;
import com.biotools.meerkat.util.Preferences;

import common.handeval.klaatu.FastEval;
import common.handeval.klaatu.PartialStageFastEval;

public class SamplePlayer implements Player {

	private int seat;
	private Card c1, 
				 c2;
	private GameInfo gi;
	private Preferences playerPrefs;
	private Strategy strategy;

	public SamplePlayer() {
	}
	
	@Override
	public void holeCards(Card c1, Card c2, int seat) {
		this.c1 = c1;
		this.c2 = c2;
		this.seat = seat;
	}

	@Override
	public void gameStartEvent(GameInfo gi) {
		this.gi = gi;
	}
	
	@Override
	public Action getAction() {
		if (gi.isPreFlop()) {
			return strategy.getPreFlopAction(c1, c2, gi, seat);
		}
		return strategy.getPostFlopAction(c1, c2, gi, seat);
	}

	@Override
	public void actionEvent(int arg0, Action arg1) {
	}

	@Override
	public void dealHoleCardsEvent() {
	}

	@Override
	public void gameOverEvent() {
	}


	@Override
	public void gameStateChanged() {
	}

	@Override
	public void showdownEvent(int arg0, Card arg1, Card arg2) {
	}

	@Override
	public void stageEvent(int arg0) {
	}

	@Override
	public void winEvent(int arg0, double arg1, String arg2) {
	}

	@Override
	public void init(Preferences playerPrefs) {
		this.playerPrefs = playerPrefs;
		
		try {
			this.strategy = (Strategy) Class.forName(playerPrefs.getPreference("STRATEGY")).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
