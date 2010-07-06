package genetic.algorithm.robby;


import static org.junit.Assert.*;

import java.awt.Point;

import genetic.algorithm.robby.Robby.Move;
import org.junit.Before;
import org.junit.Test;

public class TestRobby {

	private Robby robby;
	
	@Before
	public void setUp() throws Exception {
		robby = new Robby();
	}
	
	@Test
	public void testMoveDirectional() throws Exception {
		robby.move(Move.EAST);
		assertEquals(robby.getX(), 1);
		assertEquals(robby.getY(), 0);
		robby.move(Move.SOUTH);
		assertEquals(robby.getX(), 1);
		assertEquals(robby.getY(), 1);
		robby.move(Move.WEST);
		assertEquals(robby.getX(), 0);
		assertEquals(robby.getY(), 1);
		robby.move(Move.NORTH);
		assertEquals(robby.getX(), 0);
		assertEquals(robby.getY(), 0);
	}
	
	@Test
	public void testIllegalMoves() throws Exception {
		robby.setPoint(new Point(0, 9));
		assertFalse(robby.move(Move.SOUTH));
		robby.setPoint(new Point(9, 0));
		assertFalse(robby.move(Move.EAST));
		robby.setPoint(new Point(0, 0));
		assertFalse(robby.move(Move.NORTH));
		robby.setPoint(new Point(0, 0));
		assertFalse(robby.move(Move.WEST));
	}
}
