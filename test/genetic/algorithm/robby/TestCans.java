package genetic.algorithm.robby;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class TestCans extends TestCase {
	
	private Cans cans;

	@Before
	public void setUp() throws Exception {
		cans = new Cans();
	}

	@Test
	public void testLocations() throws Exception {
		assertEquals(cans.locations().size(), 50);
	}
	
	@Test
	public void testRemoveCans() throws Exception {
		List<Integer> locations = createTestLocations();
		cans.setLocations(locations);
		assertTrue(cans.getLocations().contains(15));
		cans.remove(15);
		assertFalse(cans.getLocations().contains(15));
	}

	@Test
	public void testRemoveCansTwo() throws Exception {
		List<Integer> locations = createTestLocations();
		cans.setLocations(locations);
		assertTrue(cans.getLocations().contains(59));
		cans.remove(59);
		assertFalse(cans.getLocations().contains(59));
	}
	
	private List<Integer> createTestLocations() {
		List<Integer> locations = new ArrayList<Integer>();
		locations.add(0);
		locations.add(15);
		locations.add(56);
		locations.add(59);
		return locations;
	}
}
