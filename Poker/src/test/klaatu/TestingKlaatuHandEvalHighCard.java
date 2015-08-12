package test.klaatu;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import common.handeval.klaatu.FastEval;

public class TestingKlaatuHandEvalHighCard {

	/*
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
	public void testHighCardSeven() {
		
		int c1 = FastEval.encode(0, FastEval.SPADES), 
				c2 = FastEval.encode(1, FastEval.HEARTS),
				c3 = FastEval.encode(2, FastEval.HEARTS), 
				c4 = FastEval.encode(3, FastEval.SPADES),
				c5 = FastEval.encode(5, FastEval.CLUBS);
		
		System.out.println(FastEval.eval5(c1, c2, c3, c4, c5));
		
		System.out.println(FastEval.fromBrecher5(FastEval.toBrecher5(FastEval.eval5(c1, c2, c3, c4, c5))));
			
		assertEquals(0, FastEval.fromBrecher5(FastEval.toBrecher5(FastEval.eval5(c1, c2, c3, c4, c5))));
		
	}
	
	@Test
	public void testHighCardEight() {
		
		int c1 = FastEval.encode(0, FastEval.SPADES), 
				c2 = FastEval.encode(1, FastEval.HEARTS),
				c3 = FastEval.encode(2, FastEval.HEARTS), 
				c4 = FastEval.encode(3, FastEval.SPADES),
				c5 = FastEval.encode(6, FastEval.CLUBS);
		
		System.out.println(FastEval.eval5(c1, c2, c3, c4, c5));
		
		System.out.println(FastEval.fromBrecher5(FastEval.toBrecher5(FastEval.eval5(c1, c2, c3, c4, c5))));
			
		assertEquals(4, FastEval.fromBrecher5(FastEval.toBrecher5(FastEval.eval5(c1, c2, c3, c4, c5))));
		
	}
	
	
	@Test
	public void testHighCardNine() {
		
		int c1 = FastEval.encode(0, FastEval.SPADES), 
				c2 = FastEval.encode(1, FastEval.HEARTS),
				c3 = FastEval.encode(2, FastEval.HEARTS), 
				c4 = FastEval.encode(3, FastEval.SPADES),
				c5 = FastEval.encode(7, FastEval.SPADES);
		
		System.out.println(FastEval.eval5(c1, c2, c3, c4, c5));
		
		assertEquals(18, FastEval.eval5(c1, c2, c3, c4, c5));
		
	}
	
	@Test
	public void testHighCardTen() {
		
		int c1 = FastEval.encode(0, FastEval.SPADES), 
				c2 = FastEval.encode(2, FastEval.HEARTS),
				c3 = FastEval.encode(4, FastEval.HEARTS), 
				c4 = FastEval.encode(6, FastEval.SPADES),
				c5 = FastEval.encode(8, FastEval.SPADES);
		
		System.out.println(FastEval.eval5(c1, c2, c3, c4, c5));
		
		assertEquals(72, FastEval.eval5(c1, c2, c3, c4, c5));
		
	}
	
	@Test
	public void testHighCardJack() {
		
		int c1 = FastEval.encode(0, FastEval.SPADES), 
				c2 = FastEval.encode(2, FastEval.HEARTS),
				c3 = FastEval.encode(4, FastEval.HEARTS), 
				c4 = FastEval.encode(6, FastEval.SPADES),
				c5 = FastEval.encode(9, FastEval.HEARTS);
		
		System.out.println(FastEval.eval5(c1, c2, c3, c4, c5));
		
		assertEquals(141, FastEval.eval5(c1, c2, c3, c4, c5));
		
	}
	
	@Test
	public void testHighCardQueen() {
		
		int c1 = FastEval.encode(0, FastEval.SPADES), 
				c2 = FastEval.encode(2, FastEval.HEARTS),
				c3 = FastEval.encode(4, FastEval.HEARTS), 
				c4 = FastEval.encode(6, FastEval.SPADES),
				c5 = FastEval.encode(10, FastEval.HEARTS);
		
		System.out.println(FastEval.eval5(c1, c2, c3, c4, c5));
		
		assertEquals(266, FastEval.eval5(c1, c2, c3, c4, c5));
		
	}
	
	
	@Test
	public void testHighCardKing() {
		
		int c1 = FastEval.encode(0, FastEval.SPADES), 
				c2 = FastEval.encode(2, FastEval.HEARTS),
				c3 = FastEval.encode(4, FastEval.HEARTS), 
				c4 = FastEval.encode(6, FastEval.SPADES),
				c5 = FastEval.encode(11, FastEval.HEARTS);
		
		System.out.println(FastEval.eval5(c1, c2, c3, c4, c5));
		
		assertEquals(475, FastEval.eval5(c1, c2, c3, c4, c5));
		
	}
	
	@Test
	public void testHighCardAce() {
		
		int c1 = FastEval.encode(0, FastEval.SPADES), 
			c2 = FastEval.encode(2, FastEval.HEARTS),
			c3 = FastEval.encode(4, FastEval.HEARTS), 
			c4 = FastEval.encode(6, FastEval.SPADES),
			c5 = FastEval.encode(12, FastEval.SPADES),
			c6 = FastEval.encode(8, FastEval.HEARTS),
			c7 = FastEval.encode(7, FastEval.DIAMONDS);
		
		System.out.println(FastEval.eval5(c1, c2, c3, c4, c5));
		System.out.println(FastEval.eval6(c1, c2, c3, c4, c5, c6));
		System.out.println(FastEval.eval7(c1, c2, c3, c4, c5, c6, c7));
		
		assertEquals(803, FastEval.eval5(c1, c2, c3, c4, c5));
		assertEquals(493, FastEval.fromBrecher6(FastEval.toBrecher6(FastEval.eval6(c1, c2, c3, c4, c5, c6))));
		assertEquals(249, FastEval.fromBrecher7(FastEval.toBrecher7(FastEval.eval7(c1, c2, c3, c4, c5, c6, c7))));
		
	}
	

}
