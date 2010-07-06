package genetic.algorithm.robby;

public class World {

	private Cans cans;
	
	public enum Square {
		EMPTY, CAN, WALL
	}
	
	public World(Cans cans) {
		this.cans = cans;
	}
	
	public Square squareStatus(int x, int y) {
		if(x > 9 || y > 9) {
			return Square.WALL;
		}
		if(checkCan(x, y)) {
			return Square.CAN;
		}
		return Square.EMPTY;
	}

	private boolean checkCan(int x, int y) {
		return cans.locations().contains(getGridBasedIndex(x, y));
	}

	private int getGridBasedIndex(int x, int y) {
		return (y * 10) + x;
	}

	public void removeCans(int x, int y) {
		cans.remove(getGridBasedIndex(x, y));
	}
	
}
