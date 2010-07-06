package genetic.algorithm.robby;

import genetic.algorithm.robby.Robby.Move;

public class Navigator {

	private World world;
	private Robby robby;
	private int score = 0;
	
	public Navigator(World world, Robby robby) {
		this.world = world;
		this.robby = robby;
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
		if(world.getSquareInfo(robby.getPoint(), x, y) == 3) {
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
