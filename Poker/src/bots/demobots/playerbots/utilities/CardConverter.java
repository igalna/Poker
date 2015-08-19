package bots.demobots.playerbots.utilities;

import com.biotools.meerkat.Card;

public class CardConverter {

	
	public static int convertCards(int originalSuitNumber) {
		
		int convertedSuitNumber = -1;
		
		if (originalSuitNumber == Card.CLUBS)
			convertedSuitNumber = 0;
		if (originalSuitNumber == Card.HEARTS)
			convertedSuitNumber = 1;
		if (originalSuitNumber == Card.DIAMONDS)
			convertedSuitNumber = 2;
		if (originalSuitNumber == Card.SPADES)
			convertedSuitNumber = 3;
		
		return convertedSuitNumber;
	}
}
