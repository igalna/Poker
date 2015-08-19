package test.handConverter;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import bots.demobots.playerbots.utilities.CardConverter;

import com.biotools.meerkat.Card;
import com.biotools.meerkat.GameInfo;
import com.biotools.meerkat.Hand;

import common.handeval.klaatu.FastEval;

public class TestingConverterFromMeerkatHandToEvalHand {

	
	/*
	 * 
	 *  FASTEVAL CARD FORMAT
	 * 
	 * 	SUITS ->
	 * 
	 * 		CLUBS = 0,  DIAMONDS = 1, HEARTS = 2, SPADES = 3
	 * 
	 * 
	 * RANKS ->
	 * 
	 * 		2 = 0
	 * 		3 = 1
	 * 		4 = 2
	 * 		5 = 3
	 * 		6 = 4
	 * 		7 = 5
	 * 		8 = 6
	 * 		9 = 7
	 * 		10 = 8
	 * 		J = 9
	 * 		Q = 10
	 * 		K = 11
	 * 		A = 12
	 * 
	 */
	
	
	@Test
	public void testConvertFromClubsToSpades() {
		Card c1 = new Card(Card.TWO, Card.CLUBS);
		//System.out.println(c1);
		//System.out.println(c1.getRank());
		//System.out.println(c1.getSuit());
		//System.out.println(FastEval.encode(c1.getRank(), c1.getSuit()));
		//System.out.println(Card.CLUBS);
		//System.out.println(FastEval.CLUBS);
		
		
		//System.out.println(FastEval.encode(c1.getRank(), c1.getSuit()));
		//System.out.println(FastEval.encode(c1.getRank(), CardConverter.convertCards(c1.getSuit())));
		
		//System.out.println(FastEval.encode(1, CardConverter.convertCards(c1.getSuit())));
		//System.out.println(FastEval.encode(1, c1.getSuit()));
		
		for (int x = 0; x < 13; x++)
			System.out.println(" The " + x + " of CLUBS is : " + FastEval.encode(x, FastEval.CLUBS));
		
		for (int x = 0; x < 13; x++)
			System.out.println(" The " + x + " of DIAMONDS is : " + FastEval.encode(x, FastEval.DIAMONDS));
		
		for (int x = 0; x < 13; x++)
			System.out.println(" The " + x + " of HEARTS is : " + FastEval.encode(x, FastEval.HEARTS));
		
		for (int x = 0; x < 13; x++)
			System.out.println(" The " + x + " of SPADES is : " + FastEval.encode(x, FastEval.SPADES));
		
		for (int x = 0; x < 13; x++) {
			Card card = new Card(x, Card.CLUBS);
			System.out.println("The Meerkat Card " + x + " Of CLUBS is : " + card.getIndex());
		}
		
		for (int x = 0; x < 13; x++) {
			Card card = new Card(x, Card.DIAMONDS);
			System.out.println("The Meerkat Card " + x + " Of DIAMONDS is : " + card.getIndex());
		}
		
		for (int x = 0; x < 13; x++) {
			Card card = new Card(x, Card.HEARTS);
			System.out.println("The Meerkat Card " + x + " Of HEARTS is : " + card.getIndex());
		}
		
		for (int x = 0; x < 13; x++) {
			Card card = new Card(x, Card.SPADES);
			System.out.println("The Meerkat Card " + x + " Of SPADES is : " + card.getIndex());
		}
		
		System.out.println(c1.getIndex());
		System.out.println(FastEval.encode(c1.getRank(), CardConverter.convertCards(c1.getSuit())));
		
		assertEquals(39, c1.getIndex());
		assertEquals(0, FastEval.encode(c1.getRank(), CardConverter.convertCards(c1.getSuit())));
		
	}
	
	@Test
	public void testThreeOfClubs() {
		Card c1 = new Card(Card.THREE, Card.CLUBS);
		
		System.out.println(c1.getIndex());
		System.out.println(FastEval.encode(c1.getRank(), CardConverter.convertCards(c1.getSuit())));
		
		assertEquals(40, c1.getIndex());
		assertEquals(4, FastEval.encode(c1.getRank(), CardConverter.convertCards(c1.getSuit())));
		
	}
	
	@Test
	public void testFourOfClubs() {
		Card c1 = new Card(Card.FOUR, Card.CLUBS);
		
		System.out.println(c1.getIndex());
		System.out.println(FastEval.encode(c1.getRank(), CardConverter.convertCards(c1.getSuit())));
		
		assertEquals(41, c1.getIndex());
		assertEquals(8, FastEval.encode(c1.getRank(), CardConverter.convertCards(c1.getSuit())));
	}
	@Ignore
	@Test
	public void testDeckOfCards() {
		
		List<Integer> listOfIndexes = new ArrayList<Integer>();
		for (int i = 0; i < 52; i++) {
			listOfIndexes.add(Integer.valueOf(i));
		}
		
		Card c1 = new Card(Card.ACE, Card.CLUBS);
		Card c2 = new Card(Card.KING, Card.CLUBS);
		

		Integer cardOneIndex = FastEval.encode(c1.getRank(), CardConverter.convertCards(c1.getSuit()));
		Integer cardTwoIndex = FastEval.encode(c2.getRank(), CardConverter.convertCards(c2.getSuit()));
		
		List<Integer> deckOfCardIndexes = new ArrayList<Integer>();
		for (int i = 0; i < 52; i++) {
			deckOfCardIndexes.add(Integer.valueOf(i));
		}
		deckOfCardIndexes.remove(cardOneIndex);
		deckOfCardIndexes.remove(cardTwoIndex);
		
		System.out.println(deckOfCardIndexes);
	}
	
	@Test
	public void testGetCardsFromHand() {
		
		Hand hand = new Hand();
		hand.addCard(0);
		hand.addCard(1);
		hand.addCard(2);
		
		System.out.println(hand);
		
		assertEquals(0, hand.getCard(1).getIndex());
		assertEquals(1, hand.getCard(2).getIndex());
		assertEquals(2, hand.getCard(3).getIndex());
	}
	
	@Test
	public void testRemoveBoardCardsFromDeck() {
		Hand hand = new Hand();
		hand.addCard(0);
		hand.addCard(1);
		hand.addCard(2);
		
		Integer[] boardCards = new Integer[hand.size()];
		
		List<Integer> deckOfCardIndexes = new ArrayList<Integer>();
		for (int i = 0; i < 52; i++) {
			deckOfCardIndexes.add(Integer.valueOf(i));
		}
		
		for (int x = 0; x < hand.size(); x++) {
			Card card = hand.getCard(x + 1);
			boardCards[x] = FastEval.encode(card.getRank(), CardConverter.convertCards(card.getSuit()));
			deckOfCardIndexes.remove(boardCards[x]);
		}
		
		System.out.println(deckOfCardIndexes);
		
		
	}
}