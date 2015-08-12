package test.klaatu;

import static org.junit.Assert.*;

import org.junit.Test;

import common.handeval.klaatu.FastEval;

public class TestingKlaatuHandEvalFullHouse {

	
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
	public void test() {

		int c1 = FastEval.encode(1, FastEval.CLUBS), 
			c2 = FastEval.encode(1, FastEval.HEARTS),
			c3 = FastEval.encode(0, FastEval.DIAMONDS), 
			c4 = FastEval.encode(0, FastEval.SPADES),
			c5 = FastEval.encode(0, FastEval.CLUBS);
			//c6 = FastEval.encode(6, FastEval.CLUBS),
			//c7 = FastEval.encode(7, FastEval.CLUBS);
					
		
		System.out.println(FastEval.eval5(c1, c2, c3, c4, c5));
		//System.out.println(FastEval.eval6(c1, c2, c3, c4, c5, c6));
		//System.out.println(FastEval.eval7(c1, c2, c3, c4, c5, c6, c7));
		
		
		System.out.println(FastEval.fromBrecher5(FastEval.toBrecher5(FastEval.eval5(c1, c2, c3, c4, c5))));
		//System.out.println(FastEval.fromBrecher6(FastEval.toBrecher6(FastEval.eval6(c1, c2, c3, c4, c5, c6))));
		//System.out.println(FastEval.fromBrecher7(FastEval.toBrecher7(FastEval.eval7(c1, c2, c3, c4, c5, c6, c7))));
			
		assertEquals(7140, FastEval.fromBrecher5(FastEval.toBrecher5(FastEval.eval5(c1, c2, c3, c4, c5))));
		//assertEquals(4488, FastEval.fromBrecher6(FastEval.toBrecher6(FastEval.eval6(c1, c2, c3, c4, c5, c6))));
		//assertEquals(3273, FastEval.fromBrecher7(FastEval.toBrecher7(FastEval.eval7(c1, c2, c3, c4, c5, c6, c7))));
		
	}

}
