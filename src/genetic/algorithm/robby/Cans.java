package genetic.algorithm.robby;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cans {

	private List<Integer> locations;
	private Random rand;
	
	public Cans() {
		rand = new Random();
	}
	
	public List<Integer> locations() {
		locations = new ArrayList<Integer>();
		int i = 0;
		while(i < 50) {
			locations.add(nextUniqueRand());
			i++;
		}
		return locations;
	}

	public Integer nextUniqueRand() {
		int next = rand.nextInt(100);
		while(locations.contains(next)) {
			next = rand.nextInt(100);
		}
		return next;
	}

	public void remove(int num) {
		locations.remove((Object) num);
	}

	public void setLocations(List<Integer> locations) {
		this.locations = locations;
	}
	
	public List<Integer> getLocations() {
		return locations;
	}
	

}
