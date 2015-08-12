package test.spears2p2;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import spears2p2.Card;
import spears2p2.Hand;
import spears2p2.StateTableEvaluator;

public class TestingSpears2p2 {

	@Ignore
	@BeforeClass
	public static void setUpClass() {
		long startTime = System.nanoTime();

		StateTableEvaluator.initialize();

		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		double seconds = (double) duration / 1000000000.0;
		System.out.println("It took :" + seconds
				+ " seconds to call StateTableEvaluator.initialize()");
	}

	@Ignore
	@Test
	public void testHighCardAce() {

		long startTime = System.nanoTime();

		String testHand = "AdKcQcJc9d8d7d";

		Hand hand = Hand.parse(testHand);

		int rank = StateTableEvaluator.getRank(hand);

		assertEquals(1276, rank);

		System.out.println("Hand Rank of : " + hand + " is : " + rank);

		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		double seconds = (double) duration / 1000000000.0;
		System.out.println("It took :" + seconds
				+ " seconds to parse and get the rank of one hand");
	}

	@Test
	public void testParseStringOfFiveCardsToCardArray() {

		String testHand = "AdKcQcJc9d8d7d";

		Hand hand = Hand.parse(testHand);

		int rank = StateTableEvaluator.getRank(hand);

		System.out.println(rank);

	}

	@Test
	public void speedTest() {

		StateTableEvaluator.initialize();

		Card[] cards = new Card[7];
		for (int i = 0; i < 7; i++)
			cards[i] = Card.parse("As");

		for (Card card : cards) {
			System.out.println(card);
		}
		long startTime = System.currentTimeMillis();

		long sum = 0;
		long count = 0;
		int h1, h2, h3, h4, h5, h6, h7;
		for (h1 = 0; h1 < 52; h1++) {
			cards[0] = Card.get(h1);
			for (h2 = h1 + 1; h2 < 52; h2++) {
				cards[1] = Card.get(h2);
				for (h3 = h2 + 1; h3 < 52; h3++) {
					cards[2] = Card.get(h3);
					for (h4 = h3 + 1; h4 < 52; h4++) {
						cards[3] = Card.get(h4);
						for (h5 = h4 + 1; h5 < 52; h5++) {
							cards[4] = Card.get(h5);
							for (h6 = h5 + 1; h6 < 52; h6++) {
								cards[5] = Card.get(h6);
								for (h7 = h6 + 1; h7 < 52; h7++) {

									cards[6] = Card.get(h7);
									StateTableEvaluator.getRank(cards);
									count++;
								}
							}
						}
					}
				}
			}
		}

		long endTime = System.currentTimeMillis() - startTime;

		System.out.println("Spears eval : " + endTime + "ms");
		System.out.println("Number of Hands : " + count);
		float res = (float) count / ((float) endTime / (float) 1000);
		System.out.println(res / 1000000 + " million hands per second");

	}

	@Test
	public void anotherSpeedTest() {
		System.out.println(Runtime.getRuntime().freeMemory() + " "
				+ Runtime.getRuntime().totalMemory());
		StateTableEvaluator.initialize();
		System.out.println(Runtime.getRuntime().freeMemory() + " "
				+ Runtime.getRuntime().totalMemory());
		long startTime = System.currentTimeMillis();
		long sum = 0;
		int h1, h2, h3, h4, h5, h6, h7;
		int u0, u1, u2, u3, u4, u5;
		int[] handRanks = StateTableEvaluator.handRanks;
		int[] handEnumerations = new int[10];
		int[][] equivalencyEnumerations = new int[10][3000];
		String[] handDescriptions = { "Invalid Hand", "High Card", "One Pair",
				"Two Pair", "Three of a Kind", "Straight", "Flush",
				"Full House", "Four of a Kind", "Straight Flush" };
		int count = 0;
		int handRank;
		for (h1 = 1; h1 < 53; h1++) {
			u0 = handRanks[53 + h1];
			for (h2 = h1 + 1; h2 < 53; h2++) {
				u1 = handRanks[u0 + h2];
				for (h3 = h2 + 1; h3 < 53; h3++) {
					u2 = handRanks[u1 + h3];
					for (h4 = h3 + 1; h4 < 53; h4++) {
						u3 = handRanks[u2 + h4];
						for (h5 = h4 + 1; h5 < 53; h5++) {
							u4 = handRanks[u3 + h5];
							for (h6 = h5 + 1; h6 < 53; h6++) {
								u5 = handRanks[u4 + h6];
								for (h7 = h6 + 1; h7 < 53; h7++) {
									sum += handRanks[u5 + h7];

									handRank = handRanks[u5 + h7];
									handEnumerations[handRank >>> 12]++;
									count++;
									equivalencyEnumerations[handRank >>> 12][handRank & 0xFFF]++;

								}
							}
						}
					}
				}
			}
		}
		long endTime = System.currentTimeMillis() - startTime;

		System.out.println("Spears eval 2 : " + endTime + "ms");
		System.out.println("Number of Hands : " + count);
		float res = (float) count / ((float) endTime / (float) 1000);
		System.out.println(res / 1000000 + " million hands per second");
	}
}
