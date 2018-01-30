package visual;

import java.awt.HeadlessException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.IdentidadSquares;
import model.Square;

public class BoardView extends JFrame {
	// GOOGLEAR OBSERVER PATTERN
	@SuppressWarnings("null")
	public BoardView(Square[][] squareArray) throws HeadlessException {

		super("jUEGO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 800);
		setVisible(true);

		JLabel[][] Fondo = null;
		for (int i = 0; i < squareArray.length; i++) {
			for (int j = 0; j < squareArray.length; j++) {
				Fondo[i][j] = new JLabel();
				IdentidadSquares identidadSquares = squareArray[i][j].getIdentidadSquares();
				switch (identidadSquares) {
				case Path:
					Fondo[i][j].setIcon(new ImageIcon("resources/1.png"));
					break;
				case Wall:
					Fondo[i][j].setIcon(new ImageIcon("resources/0.png"));
					break;
				case Hell:
					Fondo[i][j].setIcon(new ImageIcon("resources/6.png"));
					break;
				}
				Fondo[i][j].setBounds(i * 40, j * 40, 40, 40);

			}
		}
	}
}
