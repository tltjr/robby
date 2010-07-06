package genetic.algorithm.robby;


import static org.junit.Assert.*;
import genetic.algorithm.robby.World.Square;

import org.junit.Before;
import org.junit.Test;

public class TestSituationTable {

	private SituationTable situationTable;
	
	@Before
	public void setUp() throws Exception {
		situationTable = new SituationTable();
	}
	
	@Test
	public void testConvertSquaresToIndexForAllEmpty() throws Exception {
		int index = 
			situationTable.convertSquaresToIndex(Square.EMPTY, Square.EMPTY, Square.EMPTY, Square.EMPTY, Square.EMPTY);
		assertEquals(0, index);
	}
	
	@Test
	public void testConvertSquaresToIndexForAllWall() throws Exception {
		int index = 
			situationTable.convertSquaresToIndex(Square.WALL, Square.WALL, Square.WALL, Square.WALL, Square.WALL);
		assertEquals(242, index);
	}
	
	@Test
	public void testConvertSquaresToIndexForAllCan() throws Exception {
		int index = 
			situationTable.convertSquaresToIndex(Square.CAN, Square.CAN, Square.CAN, Square.CAN, Square.CAN);
		assertEquals(121, index);
	}

}
