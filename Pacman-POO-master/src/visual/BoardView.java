package visual;

import java.awt.HeadlessException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.net.URL;
import model.Square;

public class BoardView extends JFrame {
	@SuppressWarnings("null")


	public BoardView(Square[][] squareArray, Layers layers) throws HeadlessException {
		super("jUEGO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 840);
		
		int capa=1000;
		JLabel[][] Fondo = new JLabel[20][20];
		for (int i = 0; i < squareArray.length; i++) {
			capa++;
			for (int j = 0; j < squareArray.length; j++) {
				capa++;
				Fondo[i][j] = new JLabel();
				String identidadSquare = squareArray[i][j].getClass().getName();

				switch (identidadSquare) {
				case "model.Path":
					Fondo[i][j].setIcon(new ImageIcon("resources/1.png"));
					break;
				case "model.Wall":
					Fondo[i][j].setIcon(new ImageIcon("resources/0.png"));
					break;
				case "model.Hell":
					Fondo[i][j].setIcon(new ImageIcon("resources/6.png"));
					break;
				case "model.Teleport":
					Fondo[i][j].setIcon(new ImageIcon("resources/1.png"));
					break;
				}
				Fondo[i][j].setBounds(i * 40, j * 40, 40, 40);
				layers.add(Fondo[i][j], capa);
			}
		}
		setContentPane(layers);
		setVisible(true);
	}
}
