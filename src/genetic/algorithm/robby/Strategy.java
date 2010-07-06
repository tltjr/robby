package genetic.algorithm.robby;

import genetic.algorithm.robby.Robby.Move;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Strategy implements Comparable<Strategy> {

	private List<Move> moves;
	private double fitness;
	
	public Strategy() {
		moves = new ArrayList<Move>();
	}
	
	public Strategy generateStrategy() {
		Random rand = new Random();
		for(int i=0; i<243; i++) {
			int move = rand.nextInt(7);
			switch(move) {
				case 0: moves.add(Move.NORTH);
				break;
				case 1: moves.add(Move.SOUTH);
				break;
				case 2: moves.add(Move.EAST);
				break;
				case 3: moves.add(Move.WEST);
				break;
				case 4: moves.add(Move.STAY);
				break;
				case 5: moves.add(Move.RANDOM);
				break;
				case 6: moves.add(Move.PICKUP);
				break;
			}
		}
		return this;
	}
	
	public List<Move> getMoves() {
		return moves;
	}

	public void setFitness(double fitness) {
		this.fitness = fitness;
	}
	
	public double getFitness() {
		return fitness;
	}

	@Override
	public int compareTo(Strategy arg0) {
		return (int) (arg0.fitness - this.fitness);
	}
}
