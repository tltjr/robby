package genetic.algorithm.robby;


import static org.junit.Assert.*;

import genetic.algorithm.robby.Robby.Move;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestStrategy {

	private Strategy strategy;
	
	@Before
	public void setUp() throws Exception {
		strategy = new Strategy();
		
	}

	@Test
	public void testRandomMovesInStrategy() throws Exception {
		List<Move> result = strategy.generateStrategy().getMoves();
		int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, g = 0;
		for(Move move : result) {
			switch(move) {
				case NORTH: a++;
				break;
				case SOUTH: b++;
				break;
				case EAST: c++;
				break;
				case WEST: d++;
				break;
				case STAY: e++;
				break;
				case RANDOM: f++;
				break;
				case PICKUP: g++;
				break;
			}
		}
		//highly unlikely random sample outside these ranges
		assertTrue(a > 5 && a < 65);
		assertTrue(b > 5 && b < 65);
		assertTrue(c > 5 && c < 65);
		assertTrue(d > 5 && d < 65);
		assertTrue(e > 5 && e < 65);
		assertTrue(f > 5 && f < 65);
		assertTrue(g > 5 && g < 65);
	}
}
