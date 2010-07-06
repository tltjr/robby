package genetic.algorithm.robby;

import genetic.algorithm.robby.Robby.Move;
import genetic.algorithm.robby.World.Square;

public class SituationTable {
	
	public Move getMove(Strategy strategy, Square north, Square south, Square east,
			Square west, Square current) {
		int index = convertSquaresToIndex(north, south, east, west, current);
		return strategy.getMoves().get(index);
	}

	// generate a unique index for all 243 (3^5) possible combinations of squares
	public int convertSquaresToIndex(Square north, Square south, Square east,
			Square west, Square current) {
		int result = 0;
		result += incrementIndex(north, 4);
		result += incrementIndex(south, 3);
		result += incrementIndex(east, 2);
		result += incrementIndex(west, 1);
		result += incrementIndex(current, 0);
		return result;
	}

	private int incrementIndex(Square square, int column) {
		switch(square){
			case EMPTY: return 0;
			case CAN: return (int) Math.pow(3, column) * 1;
			case WALL: return (int) Math.pow(3, column) * 2;
			default: return 0;
		}
	}

}
