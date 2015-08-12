package test.klaatu;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import common.handeval.klaatu.FastEval;

public class TestingKlaatuHandEvalTwoPair {


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
	public void testTwoPairTwosAndThrees() {
		
		int c1 = FastEval.encode(0, FastEval.CLUBS), 
			c2 = FastEval.encode(0, FastEval.DIAMONDS),
			c3 = FastEval.encode(1, FastEval.HEARTS), 
			c4 = FastEval.encode(1, FastEval.SPADES),
			c5 = FastEval.encode(8, FastEval.CLUBS),
			c6 = FastEval.encode(4, FastEval.HEARTS),
			c7 = FastEval.encode(6, FastEval.DIAMONDS);
			
			
			System.out.println(FastEval.eval5(c1, c2, c3, c4, c5));
			System.out.println(FastEval.eval6(c1, c2, c3, c4, c5, c6));
			System.out.println(FastEval.eval7(c1, c2, c3, c4, c5, c6, c7));
			
			System.out.println(FastEval.fromBrecher5(FastEval.toBrecher5(FastEval.eval5(c1, c2, c3, c4, c5))));
			System.out.println(FastEval.fromBrecher6(FastEval.toBrecher6(FastEval.eval6(c1, c2, c3, c4, c5, c6))));
			System.out.println(FastEval.fromBrecher7(FastEval.toBrecher7(FastEval.eval7(c1, c2, c3, c4, c5, c6, c7))));
			
			assertEquals(4143, FastEval.fromBrecher5(FastEval.toBrecher5(FastEval.eval5(c1, c2, c3, c4, c5))));
			assertEquals(2910, FastEval.fromBrecher6(FastEval.toBrecher6(FastEval.eval6(c1, c2, c3, c4, c5, c6))));
			assertEquals(1880, FastEval.fromBrecher7(FastEval.toBrecher7(FastEval.eval7(c1, c2, c3, c4, c5, c6, c7))));
		
	}
	
	
	@Test
	public void testTwoPairTwosAndFours() {
		
		int c1 = FastEval.encode(0, FastEval.CLUBS), 
		c2 = FastEval.encode(0, FastEval.DIAMONDS),
		c3 = FastEval.encode(2, FastEval.HEARTS), 
		c4 = FastEval.encode(2, FastEval.SPADES),
		c5 = FastEval.encode(8, FastEval.CLUBS),
		c6 = FastEval.encode(4, FastEval.HEARTS),
		c7 = FastEval.encode(6, FastEval.DIAMONDS);
			
			
		System.out.println(FastEval.eval5(c1, c2, c3, c4, c5));
		System.out.println(FastEval.eval6(c1, c2, c3, c4, c5, c6));
		System.out.println(FastEval.eval7(c1, c2, c3, c4, c5, c6, c7));
		
		System.out.println(FastEval.fromBrecher5(FastEval.toBrecher5(FastEval.eval5(c1, c2, c3, c4, c5))));
		System.out.println(FastEval.fromBrecher6(FastEval.toBrecher6(FastEval.eval6(c1, c2, c3, c4, c5, c6))));
		System.out.println(FastEval.fromBrecher7(FastEval.toBrecher7(FastEval.eval7(c1, c2, c3, c4, c5, c6, c7))));

		assertEquals(4154, FastEval.fromBrecher5(FastEval.toBrecher5(FastEval.eval5(c1, c2, c3, c4, c5))));
		assertEquals(2920, FastEval.fromBrecher6(FastEval.toBrecher6(FastEval.eval6(c1, c2, c3, c4, c5, c6))));
		assertEquals(1888, FastEval.fromBrecher7(FastEval.toBrecher7(FastEval.eval7(c1, c2, c3, c4, c5, c6, c7))));
		
	}
	
	
	@Test
	public void testTwoPairTwosAndFives() {
		
		int c1 = FastEval.encode(0, FastEval.CLUBS), 
			c2 = FastEval.encode(0, FastEval.DIAMONDS),
			c3 = FastEval.encode(3, FastEval.HEARTS), 
			c4 = FastEval.encode(3, FastEval.SPADES),
			c5 = FastEval.encode(8, FastEval.CLUBS),
			c6 = FastEval.encode(4, FastEval.HEARTS),
			c7 = FastEval.encode(6, FastEval.DIAMONDS);
			
			
			System.out.println(FastEval.eval5(c1, c2, c3, c4, c5));
			System.out.println(FastEval.eval6(c1, c2, c3, c4, c5, c6));
			System.out.println(FastEval.eval7(c1, c2, c3, c4, c5, c6, c7));
			
			System.out.println(FastEval.fromBrecher5(FastEval.toBrecher5(FastEval.eval5(c1, c2, c3, c4, c5))));
			System.out.println(FastEval.fromBrecher6(FastEval.toBrecher6(FastEval.eval6(c1, c2, c3, c4, c5, c6))));
			System.out.println(FastEval.fromBrecher7(FastEval.toBrecher7(FastEval.eval7(c1, c2, c3, c4, c5, c6, c7))));

			assertEquals(4176, FastEval.fromBrecher5(FastEval.toBrecher5(FastEval.eval5(c1, c2, c3, c4, c5))));
			assertEquals(2941, FastEval.fromBrecher6(FastEval.toBrecher6(FastEval.eval6(c1, c2, c3, c4, c5, c6))));
			assertEquals(1906, FastEval.fromBrecher7(FastEval.toBrecher7(FastEval.eval7(c1, c2, c3, c4, c5, c6, c7))));
		
	}
	
	@Test
	public void testTwoPairTwosAndSixes() {
		
		int c1 = FastEval.encode(0, FastEval.CLUBS), 
			c2 = FastEval.encode(0, FastEval.DIAMONDS),
			c3 = FastEval.encode(4, FastEval.HEARTS), 
			c4 = FastEval.encode(4, FastEval.SPADES),
			c5 = FastEval.encode(8, FastEval.CLUBS),
			c6 = FastEval.encode(5, FastEval.HEARTS),
			c7 = FastEval.encode(6, FastEval.DIAMONDS);
			
			
			System.out.println(FastEval.eval5(c1, c2, c3, c4, c5));
			System.out.println(FastEval.eval6(c1, c2, c3, c4, c5, c6));
			System.out.println(FastEval.eval7(c1, c2, c3, c4, c5, c6, c7));
			
			System.out.println(FastEval.fromBrecher5(FastEval.toBrecher5(FastEval.eval5(c1, c2, c3, c4, c5))));
			System.out.println(FastEval.fromBrecher6(FastEval.toBrecher6(FastEval.eval6(c1, c2, c3, c4, c5, c6))));
			System.out.println(FastEval.fromBrecher7(FastEval.toBrecher7(FastEval.eval7(c1, c2, c3, c4, c5, c6, c7))));

			assertEquals(4209, FastEval.fromBrecher5(FastEval.toBrecher5(FastEval.eval5(c1, c2, c3, c4, c5))));
			assertEquals(2973, FastEval.fromBrecher6(FastEval.toBrecher6(FastEval.eval6(c1, c2, c3, c4, c5, c6))));
			assertEquals(1934, FastEval.fromBrecher7(FastEval.toBrecher7(FastEval.eval7(c1, c2, c3, c4, c5, c6, c7))));
		
	}
	
	
	@Test
	public void testTwoPairTwosAndSevens() {
		
		int c1 = FastEval.encode(0, FastEval.CLUBS), 
			c2 = FastEval.encode(0, FastEval.DIAMONDS),
			c3 = FastEval.encode(5, FastEval.HEARTS), 
			c4 = FastEval.encode(5, FastEval.SPADES),
			c5 = FastEval.encode(8, FastEval.CLUBS),
			c6 = FastEval.encode(6, FastEval.HEARTS),
			c7 = FastEval.encode(7, FastEval.DIAMONDS);
		
		assertEquals(4253, FastEval.fromBrecher5(FastEval.toBrecher5(FastEval.eval5(c1, c2, c3, c4, c5))));
		assertEquals(3016, FastEval.fromBrecher6(FastEval.toBrecher6(FastEval.eval6(c1, c2, c3, c4, c5, c6))));
		assertEquals(1973, FastEval.fromBrecher7(FastEval.toBrecher7(FastEval.eval7(c1, c2, c3, c4, c5, c6, c7))));
	}
	
	@Test
	public void testTwoPairTwosAndEights() {
		
		int c1 = FastEval.encode(0, FastEval.CLUBS), 
			c2 = FastEval.encode(0, FastEval.DIAMONDS),
			c3 = FastEval.encode(6, FastEval.HEARTS), 
			c4 = FastEval.encode(6, FastEval.SPADES),
			c5 = FastEval.encode(9, FastEval.CLUBS),
			c6 = FastEval.encode(8, FastEval.HEARTS),
			c7 = FastEval.encode(7, FastEval.DIAMONDS);
		
		
		assertEquals(4309, FastEval.fromBrecher5(FastEval.toBrecher5(FastEval.eval5(c1, c2, c3, c4, c5))));
		assertEquals(3071, FastEval.fromBrecher6(FastEval.toBrecher6(FastEval.eval6(c1, c2, c3, c4, c5, c6))));
		assertEquals(2023, FastEval.fromBrecher7(FastEval.toBrecher7(FastEval.eval7(c1, c2, c3, c4, c5, c6, c7))));
		
	}
	
	@Test
	public void testTwoPairAcesAndKings() {
		
		int c1 = FastEval.encode(11, FastEval.CLUBS), 
			c2 = FastEval.encode(11, FastEval.DIAMONDS),
			c3 = FastEval.encode(12, FastEval.HEARTS), 
			c4 = FastEval.encode(12, FastEval.SPADES),
			c5 = FastEval.encode(9, FastEval.CLUBS),
			c6 = FastEval.encode(8, FastEval.HEARTS),
			c7 = FastEval.encode(7, FastEval.DIAMONDS);
		
		assertEquals(4993, FastEval.fromBrecher5(FastEval.toBrecher5(FastEval.eval5(c1, c2, c3, c4, c5))));
		assertEquals(3749, FastEval.fromBrecher6(FastEval.toBrecher6(FastEval.eval6(c1, c2, c3, c4, c5, c6))));
		assertEquals(2638, FastEval.fromBrecher7(FastEval.toBrecher7(FastEval.eval7(c1, c2, c3, c4, c5, c6, c7))));
		
	}
}
