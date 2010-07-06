package genetic.algorithm.robby;

import genetic.algorithm.robby.Robby.Move;
import genetic.algorithm.robby.World.Square;

public class Navigator {

	private World world;
	private Robby robby;
	private SituationTable situationTable;
	private int score = 0;
	
	public Navigator(World world, Robby robby) {
		this.situationTable = new SituationTable();
		this.world = world;
		this.robby = robby;
	}
	
	public void makeNextMove() {
		int x = robby.getX();
		int y = robby.getY();
		Square north = world.squareStatus(x, (y-1));
		Square south = world.squareStatus(x, (y+1));
		Square east = world.squareStatus((x+1), y);
		Square west = world.squareStatus((x-1), y);
		Square current = world.squareStatus(x, y);
		Move move = situationTable.getMove(north, south, east, west, current);
		moveRobby(move);
	}
	
	public void moveRobby(Move move) {
		if(move.equals(Move.PICKUP)) {
			pickupCan();
		}
		else {
			if(!robby.move(move)) {
				score -= 5;
			}
		}
	}
	
	public void pickupCan() {
		int x = robby.getPoint().x;
		int y = robby.getPoint().y;
		if(world.squareStatus(x, y) == Square.CAN) {
			score += 10;
			world.removeCans(x, y);
		}
		else {
			score -= 1;
		}
	}
	
	public int getScore() {
		return score;
	}
}
