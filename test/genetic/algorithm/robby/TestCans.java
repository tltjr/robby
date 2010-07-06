package genetic.algorithm.robby;

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
}
