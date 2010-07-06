package genetic.algorithm.robby;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class TestEvolve {

	private Evolve evolve;
	List<Strategy> strategies;
	
	@Before
	public void setUp() throws Exception {
		evolve = new Evolve(generateTestStrategies(20));
		evolve.sortFitness();
		strategies = evolve.getStrategies();
	}

	@Test
	public void testStrategySort() throws Exception {
		for(int i=0; i<strategies.size() - 1; i++) {
			System.out.println(strategies.get(i).getFitness());
			// The sort doesn't need to be perfect due to integer casting, hence the + 1
			assertTrue(strategies.get(i + 1).getFitness() < strategies.get(i).getFitness() + 1);
		}
	}
	
	@Test
	public void testGaussianNaturalSelect() throws Exception {
		Random rand = new Random();
		for (int i = 0; i < 2; i++) {
			int index = (int) Math.abs(rand.nextGaussian() * (strategies.size() / 3));
			System.out.println(index);
		}
	}
	
	public List<Strategy> generateTestStrategies(int numStrategies) {
		List<Strategy> strategies = new ArrayList<Strategy>();
		for (int i = 0; i < numStrategies; i++) {
			Strategy strategy = new Strategy();
			strategy = strategy.generateStrategy();
			strategy.setFitness(generateGaussianFitness());
			strategies.add(strategy);
		}
		return strategies;
	}

	//our mean is roughly -13, w/ std dev 58
	private double generateGaussianFitness() {
		Random rand = new Random();
		return (rand.nextGaussian() * 58) - 13;
	}
}
