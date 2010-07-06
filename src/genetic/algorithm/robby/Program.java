package genetic.algorithm.robby;

import java.util.ArrayList;
import java.util.List;

public class Program {

	/**
	 * @param args
	 */
	final static int NUMBER_STRATEGIES = 200;
	final static int CLEANING_SESSIONS = 100;
	final static int MOVES_PER_SESSION = 100;
	static double[] data = new double[200];
	static int i = 0;
	static List<Strategy> strategies = new ArrayList<Strategy>();
	
	public static void main(String[] args) {
		System.out.println("Begin Execution");
		generateStrategies(NUMBER_STRATEGIES);
		double fitness = 0;
		for (Strategy strategy : strategies) {
			fitness = calculateFitness(strategy);
			System.out.print(fitness + ",");
			strategy.setFitness(fitness);
			storeData(fitness);
		}
		double mean = computeAverage();
		System.out.println("\n" + "Mean: " + mean);
		System.out.println("Standard Deviation: " + computeStdDev(mean));
		System.out.println("Stop Execution");
		Evolve evolve = new Evolve(strategies);
	}
	
	private static double computeStdDev(double mean) {
		double sum = 0;
		for(int i=0; i < data.length; i++) {
			double v = data[i] - mean;
			sum += v*v;
		}
		return Math.sqrt( sum / (NUMBER_STRATEGIES - 1));
	}

	private static double computeAverage() {
		double sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return sum / NUMBER_STRATEGIES;
	}

	private static void storeData(double fitness) {
		data[i] = fitness;
		i++;
	}

	private static double calculateFitness(Strategy strategy) {
		int rating = 0;
		for (int i = 0; i < CLEANING_SESSIONS; i++) {
			rating += executeCleaningSession(strategy);
		}
		return rating / CLEANING_SESSIONS;
	}

	private static int executeCleaningSession(Strategy strategy) {
		Navigator nav = new Navigator(new World(new Cans()), new Robby());
		for(int i = 0; i < MOVES_PER_SESSION; i++) {
			nav.makeNextMove(strategy);
		}
		return nav.getScore();
	}

	public static void generateStrategies(int numStrategies) {
		for (int i = 0; i < numStrategies; i++) {
			Strategy strategy = new Strategy();
			strategies.add(strategy.generateStrategy());	
		}
	}

}
