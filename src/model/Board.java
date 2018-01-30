package model;

public class Board {

	Square[][] board;

	public Board(int[][] levelBoard) {
		Path path = new Path();
		Wall wall = new Wall();
		Hell hell = new Hell();
		board = new Square[levelBoard.length][levelBoard.length];
		for (int i = 0; i < levelBoard.length; i++) {
			for (int j = 0; j < levelBoard.length; j++) {
				switch (levelBoard[i][j]) {
				case 1:
					board[i][j] = path;
					break;
				case 0:
					board[i][j] = wall;
					break;
				case 6:
					board[i][j] = hell;
					break;
				}
			}
		}

		for (int i = 0; i < levelBoard.length; i++) {
			for (int j = 0; j < levelBoard.length; j++) {
				if (j - 1 >= 0) {
					board[i][j].setDown(board[i][j - 1]);

				}
				if (j + 1 < levelBoard.length) {
					board[i][j].setUp(board[i][j + 1]);
				}
				if (i - 1 >= 0) {
					board[i][j].setLeft(board[i - 1][j]);
				}
				if (i + 1 < levelBoard.length) {
					board[i][j].setRight(board[i + 1][j]);
				}
			}
		}
	}

	public Square[][] getBoard() {
		return board;
	}

	public void move(Creature creature) {
		Direction direction = creature.getDirection();
		Square position = creature.getPosition();
		Square nextPosition = position.get(direction);
		if (nextPosition.isNavegable(creature)) {
			creature.setPosition(nextPosition);
		}
	}

	public void setBoard(Square[][] board) {
		this.board = board;
	}
}
