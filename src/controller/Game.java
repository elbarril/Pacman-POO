package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Board;
import model.BoardConfiguration;
import model.Creature;
import model.Direction;
import model.Ghost;
import model.Pacman;
import model.Square;

public class Game implements KeyListener {

	static Creature pacman;

	public static void main(String[] args) {
		BoardConfiguration boardconfiguration = new BoardConfiguration();
		Board board = new Board(boardconfiguration.level1Board);
		Square[][] boardMatrix = board.getBoard();
		pacman = new Pacman();
		pacman.setPosition(boardMatrix[9][14]);
		Creature ghost = new Ghost();
		board.move(pacman);
		// board.move(ghost);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		switch (arg0.getKeyCode()) {
		case KeyEvent.VK_LEFT: {
			pacman.setDirection(Direction.LEFT);
			break;
		}
		case KeyEvent.VK_UP: {
			pacman.setDirection(Direction.UP);
			break;
		}
		case KeyEvent.VK_RIGHT: {
			pacman.setDirection(Direction.RIGHT);
			break;
		}
		case KeyEvent.VK_DOWN: {
			pacman.setDirection(Direction.DOWN);
			break;
		}
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
