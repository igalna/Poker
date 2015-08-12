package test.klaatu;

import static org.junit.Assert.*;

import org.junit.Test;

import common.handeval.klaatu.FastEval;

public class TestingKlaatuHandEvalStraight {

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
	public void testLowStraight() {
		
		int c1 = FastEval.encode(0, FastEval.CLUBS), 
			c2 = FastEval.encode(1, FastEval.DIAMONDS),
			c3 = FastEval.encode(2, FastEval.HEARTS), 
			c4 = FastEval.encode(3, FastEval.SPADES),
			c5 = FastEval.encode(4, FastEval.CLUBS),
			c6 = FastEval.encode(8, FastEval.HEARTS),
			c7 = FastEval.encode(7, FastEval.DIAMONDS);
			
		System.out.println(FastEval.eval5(c1, c2, c3, c4, c5));
		System.out.println(FastEval.eval6(c1, c2, c3, c4, c5, c6));
		System.out.println(FastEval.eval7(c1, c2, c3, c4, c5, c6, c7));
		
		System.out.println(FastEval.fromBrecher5(FastEval.toBrecher5(FastEval.eval5(c1, c2, c3, c4, c5))));
		System.out.println(FastEval.fromBrecher6(FastEval.toBrecher6(FastEval.eval6(c1, c2, c3, c4, c5, c6))));
		System.out.println(FastEval.fromBrecher7(FastEval.toBrecher7(FastEval.eval7(c1, c2, c3, c4, c5, c6, c7))));
			
		assertEquals(5854, FastEval.fromBrecher5(FastEval.toBrecher5(FastEval.eval5(c1, c2, c3, c4, c5))));
		assertEquals(4467, FastEval.fromBrecher6(FastEval.toBrecher6(FastEval.eval6(c1, c2, c3, c4, c5, c6))));
		assertEquals(3216, FastEval.fromBrecher7(FastEval.toBrecher7(FastEval.eval7(c1, c2, c3, c4, c5, c6, c7))));
			
		
	}

	@Test
	public void testHighStraight() {
		
		int c1 = FastEval.encode(12, FastEval.CLUBS), 
			c2 = FastEval.encode(11, FastEval.DIAMONDS),
			c3 = FastEval.encode(10, FastEval.HEARTS), 
			c4 = FastEval.encode(9, FastEval.SPADES),
			c5 = FastEval.encode(8, FastEval.CLUBS),
			c6 = FastEval.encode(0, FastEval.HEARTS),
			c7 = FastEval.encode(1, FastEval.DIAMONDS);
			
		System.out.println(FastEval.eval5(c1, c2, c3, c4, c5));
		System.out.println(FastEval.eval6(c1, c2, c3, c4, c5, c6));
		System.out.println(FastEval.eval7(c1, c2, c3, c4, c5, c6, c7));
		
		System.out.println(FastEval.fromBrecher5(FastEval.toBrecher5(FastEval.eval5(c1, c2, c3, c4, c5))));
		System.out.println(FastEval.fromBrecher6(FastEval.toBrecher6(FastEval.eval6(c1, c2, c3, c4, c5, c6))));
		System.out.println(FastEval.fromBrecher7(FastEval.toBrecher7(FastEval.eval7(c1, c2, c3, c4, c5, c6, c7))));
			
		assertEquals(5862, FastEval.fromBrecher5(FastEval.toBrecher5(FastEval.eval5(c1, c2, c3, c4, c5))));
		assertEquals(4475, FastEval.fromBrecher6(FastEval.toBrecher6(FastEval.eval6(c1, c2, c3, c4, c5, c6))));
		assertEquals(3224, FastEval.fromBrecher7(FastEval.toBrecher7(FastEval.eval7(c1, c2, c3, c4, c5, c6, c7))));
			
		
	}
	
}
