package model;

public class Path extends Square {
	
	public Path()
	{
		this.identidadSquares = IdentidadSquares.Path;  
	}
	@Override
	public boolean isNavegable(Creature creature) {
		return true;
	}
	

}
