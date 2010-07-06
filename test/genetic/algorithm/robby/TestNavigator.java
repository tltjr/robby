package genetic.algorithm.robby;


import genetic.algorithm.robby.Robby.Move;
import genetic.algorithm.robby.World.Square;

import java.awt.Point;

import junit.framework.TestCase;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;

public class TestNavigator extends TestCase {

	private Navigator nav;
	private Robby mockRob;
	private World mockWorld;
	
	@Before
	public void setUp() throws Exception {
		mockRob = mock(Robby.class);
		mockWorld = mock(World.class);
		nav = new Navigator(mockWorld, mockRob);
	}

	@Test
	public void testPickupCan() throws Exception {
		Point p = new Point(0, 0);
		when(mockRob.getPoint()).thenReturn(p);
		when(mockWorld.squareStatus(0, 0)).thenReturn(Square.CAN);
		nav.pickupCan();
		assertEquals(nav.getScore(), 10);
		verify(mockWorld).removeCans(0, 0);
	}
	
	@Test
	public void testNegativePickupCan() throws Exception {
		Point p = new Point(0, 0);
		when(mockRob.getPoint()).thenReturn(p);
		when(mockWorld.squareStatus(0, 0)).thenReturn(Square.EMPTY);
		nav.pickupCan();
		assertEquals(nav.getScore(), -1);
	}
	
	@Test
	public void testMoveRobby() throws Exception {
		nav.moveRobby(Move.EAST);
		verify(mockRob).move(Move.EAST);
	}
	
	@Test
	public void testMoveRobbyCallsPickupCan() throws Exception {
		Point p = new Point(0, 0);
		when(mockRob.getPoint()).thenReturn(p);
		when(mockWorld.squareStatus(0, 0)).thenReturn(Square.EMPTY);
		nav.moveRobby(Move.PICKUP);
		assertEquals(nav.getScore(), -1);
	}
	
	@Test
	public void testWallPenalty() throws Exception {
		when(mockRob.move(Move.EAST)).thenReturn(false);
		nav.moveRobby(Move.EAST);
		assertEquals(nav.getScore(), -5);
	}
}
