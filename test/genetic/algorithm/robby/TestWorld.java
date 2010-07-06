package genetic.algorithm.robby;

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
	public void testGetSquareInfo() throws Exception {
		List<Integer> mockedLocations = createMockedLocations();
		when(mockedCans.locations()).thenReturn(mockedLocations);
		Point p = new Point(0,0);
		assertEquals(world.getSquareInfo(p, 0, 0), 3);
		assertEquals(world.getSquareInfo(p, 0, 1), 1);
		assertEquals(world.getSquareInfo(p, 1, 1), 1);
		assertEquals(world.getSquareInfo(p, 5, 1), 1);
		assertEquals(world.getSquareInfo(p, 5, 2), 0);
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
