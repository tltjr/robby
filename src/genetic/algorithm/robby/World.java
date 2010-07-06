package genetic.algorithm.robby;

import java.awt.Point;
import java.util.List;

public class World {

	private Cans cans;
	
	public World(Cans cans) {
		this.cans = cans;
	}
	
	public int getSquareInfo(Point robby, int x, int y) {
		int result = 0;
		List<Integer> locations = cans.locations();
		if(x == robby.x && y == robby.y) {
			result+=2;
		}
		if(locations.contains(getGridBasedIndex(x, y))){
			result++;
		}
		return result;
	}

	private int getGridBasedIndex(int x, int y) {
		return (y * 10) + x;
	}

	public void removeCans(int x, int y) {
		cans.remove(getGridBasedIndex(x, y));
	}
	
}
