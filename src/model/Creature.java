package model;

public abstract class Creature {

	boolean alive = true;
	Direction direction = Direction.RIGHT;
	Square position = null;

	public Direction getDirection() {
		return direction;
	}

	public Square getPosition() {
		return position;
	}

	public boolean isDead() {
		return !alive;
	}

	public void kill() {
		alive = false;
	}

	public void setDirection(Direction direction) {

		this.direction = direction;
	}

	public void setPosition(Square position) {
		this.position = position;
	}

}
