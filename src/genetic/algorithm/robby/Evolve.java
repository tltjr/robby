package genetic.algorithm.robby;

import java.util.Collections;
import java.util.List;

public class Evolve {

	private List<Strategy> strategies;
	
	public Evolve(List<Strategy> strategies) {
		this.strategies = strategies;
	}

	public void sortFitness() {
		Collections.sort(strategies);
	}

	public List<Strategy> getStrategies() {
		return strategies;
	}

}
