package genetic.algorithm.robby;

import java.awt.Point;
import java.util.Random;

public class Robby {
	
	private Point point;
	
	public enum Move {
	    NORTH, SOUTH, EAST, WEST, 
	    STAY, RANDOM, PICKUP 
	}
	
	public Robby() {
		this.point = new Point(0, 0);
	}
	
	public boolean move(Move move) {
		int x = 0;
		int y = 0;
		switch(move) {
			case NORTH: 
				y = point.y - 1;
				if(y >= 0) {
					point.move(point.x, y);
					return true;
				}
				return false;
			case SOUTH: 
				y = point.y + 1;
				if(y < 10) {
					point.move(point.x, y);
					return true;
				}
				return false;
			case EAST: 
				x = point.x + 1;
				if(x < 10) {
					point.move(x, point.y);
					return true;
				}
				return false;
			case WEST: 
				x = point.x - 1;
				if(x >=0) {
					point.move(x, point.y);
					return true;
				}
				return false;
			case STAY: 
				return true;
			case RANDOM: return makeRandomMove();
		}
		return false;
	}

	private boolean makeRandomMove() {
		int direction = new Random().nextInt(4);
		switch(direction) {
			case 0: return move(Move.EAST);
			case 1: return move(Move.WEST);
			case 2: return move(Move.NORTH);
			case 3: return move(Move.SOUTH);
		}
		return false;
	}

	public Point getPoint() {
		return point;
	}
	
	public int getY() {
		return point.y;
	}

	public int getX() {
		return point.x;
	}
	
	public void setPoint(Point p) {
		point = p;
	}
}
