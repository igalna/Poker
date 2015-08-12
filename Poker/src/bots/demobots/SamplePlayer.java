package bots.demobots;

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
	private GameInfo gi;;
	private Preferences playerPrefs;


	public SamplePlayer() {
	}

	@Override
	public void actionEvent(int arg0, Action arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dealHoleCardsEvent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void gameOverEvent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void gameStartEvent(GameInfo gi) {
		this.gi = gi;
	}

	@Override
	public void gameStateChanged() {
		// TODO Auto-generated method stub

	}

	@Override
	public void showdownEvent(int arg0, Card arg1, Card arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void stageEvent(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void winEvent(int arg0, double arg1, String arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public Action getAction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void holeCards(Card c1, Card c2, int seat) {
		this.c1 = c1;
		this.c2 = c2;
		this.seat = seat;

	}

	@Override
	public void init(Preferences playerPrefs) {
		this.playerPrefs = playerPrefs;

	}

}
