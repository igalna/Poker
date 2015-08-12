package test.klaatu;

import static org.junit.Assert.*;

import org.junit.Test;

import common.handeval.klaatu.FastEval;

public class TestingKlaatuHandEvalThreeOfAKind {

	@Test
	public void testThreeOfAKindTwos() {
		
		int c1 = FastEval.encode(0, FastEval.CLUBS), 
			c2 = FastEval.encode(0, FastEval.DIAMONDS),
			c3 = FastEval.encode(0, FastEval.HEARTS), 
			c4 = FastEval.encode(12, FastEval.SPADES),
			c5 = FastEval.encode(9, FastEval.CLUBS),
			c6 = FastEval.encode(8, FastEval.HEARTS),
			c7 = FastEval.encode(7, FastEval.DIAMONDS);
		
		System.out.println(FastEval.eval5(c1, c2, c3, c4, c5));
		System.out.println(FastEval.eval6(c1, c2, c3, c4, c5, c6));
		System.out.println(FastEval.eval7(c1, c2, c3, c4, c5, c6, c7));
		
		System.out.println(FastEval.fromBrecher5(FastEval.toBrecher5(FastEval.eval5(c1, c2, c3, c4, c5))));
		System.out.println(FastEval.fromBrecher6(FastEval.toBrecher6(FastEval.eval6(c1, c2, c3, c4, c5, c6))));
		System.out.println(FastEval.fromBrecher7(FastEval.toBrecher7(FastEval.eval7(c1, c2, c3, c4, c5, c6, c7))));
			
		assertEquals(5058, FastEval.fromBrecher5(FastEval.toBrecher5(FastEval.eval5(c1, c2, c3, c4, c5))));
		assertEquals(3803, FastEval.fromBrecher6(FastEval.toBrecher6(FastEval.eval6(c1, c2, c3, c4, c5, c6))));
		assertEquals(2680, FastEval.fromBrecher7(FastEval.toBrecher7(FastEval.eval7(c1, c2, c3, c4, c5, c6, c7))));
		
	}
	
	@Test
	public void testThreeOfAKindThrees() {
		
		int c1 = FastEval.encode(1, FastEval.CLUBS), 
			c2 = FastEval.encode(1, FastEval.DIAMONDS),
			c3 = FastEval.encode(1, FastEval.HEARTS), 
			c4 = FastEval.encode(12, FastEval.SPADES),
			c5 = FastEval.encode(9, FastEval.CLUBS),
			c6 = FastEval.encode(8, FastEval.HEARTS),
			c7 = FastEval.encode(7, FastEval.DIAMONDS);
		
		System.out.println(FastEval.eval5(c1, c2, c3, c4, c5));
		System.out.println(FastEval.eval6(c1, c2, c3, c4, c5, c6));
		System.out.println(FastEval.eval7(c1, c2, c3, c4, c5, c6, c7));
		
		System.out.println(FastEval.fromBrecher5(FastEval.toBrecher5(FastEval.eval5(c1, c2, c3, c4, c5))));
		System.out.println(FastEval.fromBrecher6(FastEval.toBrecher6(FastEval.eval6(c1, c2, c3, c4, c5, c6))));
		System.out.println(FastEval.fromBrecher7(FastEval.toBrecher7(FastEval.eval7(c1, c2, c3, c4, c5, c6, c7))));
			
		assertEquals(5124, FastEval.fromBrecher5(FastEval.toBrecher5(FastEval.eval5(c1, c2, c3, c4, c5))));
		assertEquals(3858, FastEval.fromBrecher6(FastEval.toBrecher6(FastEval.eval6(c1, c2, c3, c4, c5, c6))));
		assertEquals(2723, FastEval.fromBrecher7(FastEval.toBrecher7(FastEval.eval7(c1, c2, c3, c4, c5, c6, c7))));
		
	}
	
	@Test
	public void testThreeOfAKindAces() {
		
		int c1 = FastEval.encode(12, FastEval.CLUBS), 
			c2 = FastEval.encode(12, FastEval.DIAMONDS),
			c3 = FastEval.encode(12, FastEval.HEARTS), 
			c4 = FastEval.encode(0, FastEval.SPADES),
			c5 = FastEval.encode(9, FastEval.CLUBS),
			c6 = FastEval.encode(8, FastEval.HEARTS),
			c7 = FastEval.encode(7, FastEval.DIAMONDS);
		
		System.out.println(FastEval.eval5(c1, c2, c3, c4, c5));
		System.out.println(FastEval.eval6(c1, c2, c3, c4, c5, c6));
		System.out.println(FastEval.eval7(c1, c2, c3, c4, c5, c6, c7));
		
		System.out.println(FastEval.fromBrecher5(FastEval.toBrecher5(FastEval.eval5(c1, c2, c3, c4, c5))));
		System.out.println(FastEval.fromBrecher6(FastEval.toBrecher6(FastEval.eval6(c1, c2, c3, c4, c5, c6))));
		System.out.println(FastEval.fromBrecher7(FastEval.toBrecher7(FastEval.eval7(c1, c2, c3, c4, c5, c6, c7))));
			
		assertEquals(5823, FastEval.fromBrecher5(FastEval.toBrecher5(FastEval.eval5(c1, c2, c3, c4, c5))));
		assertEquals(4446, FastEval.fromBrecher6(FastEval.toBrecher6(FastEval.eval6(c1, c2, c3, c4, c5, c6))));
		assertEquals(3197, FastEval.fromBrecher7(FastEval.toBrecher7(FastEval.eval7(c1, c2, c3, c4, c5, c6, c7))));
		
	}

}
