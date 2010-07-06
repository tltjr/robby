package genetic.algorithm.robby;

import genetic.algorithm.robby.World.Square;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;

public class TestWorld extends TestCase {

	private World world;
	private Cans mockedCans;
	
	@Before
	public void setUp() throws Exception {
		mockedCans = mock(Cans.class);
		world = new World(mockedCans); 
	}

	@Test
	public void testSquareStatus() throws Exception {
		List<Integer> mockedLocations = createMockedLocations();
		when(mockedCans.locations()).thenReturn(mockedLocations);
		Point p = new Point(0,0);
		assertEquals(world.squareStatus(0, 0), Square.CAN);
		assertEquals(world.squareStatus(0, 1), Square.EMPTY);
		assertEquals(world.squareStatus(1, 2), Square.CAN);
		assertEquals(world.squareStatus(1, 1), Square.CAN);
		assertEquals(world.squareStatus(5, 1), Square.EMPTY);
		assertEquals(world.squareStatus(5, 2), Square.EMPTY);
		assertEquals(world.squareStatus(10, 2), Square.WALL);
	}
	
	private List<Integer> createMockedLocations() {
		List<Integer> mockedLocations = new ArrayList<Integer>();
		mockedLocations.add(0);
		mockedLocations.add(1);
		mockedLocations.add(11);
		mockedLocations.add(21);
		mockedLocations.add(31);
		mockedLocations.add(41);
		mockedLocations.add(51);
		mockedLocations.add(61);
		return mockedLocations;
	}
}
