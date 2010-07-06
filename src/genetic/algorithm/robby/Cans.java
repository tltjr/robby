package genetic.algorithm.robby;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cans {

	private List<Integer> cans;
	private Random rand;
	
	public Cans() {
		rand = new Random();
	}
	
	public List<Integer> locations() {
		cans = new ArrayList<Integer>();
		int i = 0;
		while(i < 50) {
			cans.add(nextUniqueRand());
			i++;
		}
		return cans;
	}

	public Integer nextUniqueRand() {
		int next = rand.nextInt(100);
		while(cans.contains(next)) {
			next = rand.nextInt(100);
		}
		return next;
	}

	public void remove(int num) {
		cans.remove(num);
	}

}
