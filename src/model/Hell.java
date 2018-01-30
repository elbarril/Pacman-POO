package model;

public class Hell extends Square {

	public Hell() {
		identidadSquares = IdentidadSquares.Hell;
	}

	@Override
	public boolean isNavegable(Creature creature) {
		return creature.isDead();
	}

}
