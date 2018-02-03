import java.awt.HeadlessException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.BoardConfiguration;

public class Visual extends JFrame {

	private static final long serialVersionUID = 1L;
	BoardConfiguration arrays = new BoardConfiguration();
	JButton botonJugar = new JButton("Empezar");
	private JLabel[][] Dots = new JLabel[40][40];
	private JLabel[][] Fondo = new JLabel[40][40];
	ImageIcon imagenFondo;
	JLayeredPane layeredPane = new JLayeredPane();
	JLabel mounstroGrafico;
	JTextField nombre;
	JFrame panelVentana = new JFrame();

	JTextField puntos = new JTextField();
	JOptionPane ventana = new JOptionPane();

	public Visual() throws HeadlessException {
		super("jUEGO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 800);
		setVisible(true);
		mostrarCriatura();
		// ingresarNombre();
		dibujarDots();
		dibujarMapa();

		setContentPane(layeredPane);
		setVisible(true);

	}

	/*
	 * private void mostrarMensaje() { panelVentana.setVisible(true);
	 * panelVentana.setContentPane(ventana); panelVentana.setSize(200, 200);
	 * ventana.setMessage(layeredPane.getComponents()); }
	 */
	private void dibujarDots() {

		int capa = 6000;
		for (int i = 0; i < 20; i++) {

			for (int j = 0; j < 19; j++) {

				if (arrays.Dots[i][j] == 1) {
					Dots[i][j] = new JLabel();
					if (((i == 1) && (j == 4)) || ((i == 1) && (j == 14)) || ((i == 18) && (j == 3))
							|| ((i == 18) && (j == 14))) {
						// Dots[i][j].setIcon(new
						// ImageIcon("C:\\\\Users\\\\Brisa\\\\Documents\\\\GitHub\\\\Juego/src/Imagenes/superdot.png"));
						// Dots[i][j].setIcon(new
						// ImageIcon("/C:/Users/Nigga/Workspace/Juego/src/Imagenes/superdot.png"));
						Dots[i][j].setIcon(new ImageIcon(
								"/C:\\\\Users\\\\Peteca\\\\Documents\\\\GitHub\\\\Juego/src/Imagenes/superdot.png"));
					} else {
						// Dots[i][j].setIcon(new
						// ImageIcon("C:\\\\Users\\\\Brisa\\\\Documents\\\\GitHub\\\\Juego/src/Imagenes/dot.png"));
						// Dots[i][j].setIcon(new
						// ImageIcon("/C:/Users/Nigga/Workspace/Juego/src/Imagenes/dot.png"));
						Dots[i][j].setIcon(new ImageIcon(
								"/C:\\\\Users\\\\Peteca\\\\Documents\\\\GitHub\\\\Juego/src/Imagenes/dot.png"));
					}

				}

			}
		}
		for (int i = 0; i < 20; i++) {
			capa++;
			for (int j = 0; j < 19; j++) {
				capa++;
				if (arrays.Dots[i][j] == 1) {
					Dots[i][j].setBounds(i * 40, j * 40, 40, 40);
					layeredPane.add(Dots[i][j], capa);
				}

			}

		}
	}

	private void dibujarMapa() {

		int capa = -1000;
		for (int i = 0; i < 20; i++) {

			for (int j = 0; j < 19; j++) {
				Fondo[i][j] = new JLabel();
				if (arrays.level1Board[i][j] == 1) {
					// Fondo[i][j].setIcon(new
					// ImageIcon("/C:/Users/Nigga/Workspace/Juego/src/Imagenes/1.png"));
					Fondo[i][j].setIcon(
							new ImageIcon("/C:\\\\Users\\\\Peteca\\\\Documents\\\\GitHub\\\\Juego/src/Imagenes/1.png"));
				} else if (arrays.level1Board[i][j] == 0) {
					// Fondo[i][j].setIcon(new
					// ImageIcon("/C:/Users/Nigga/Workspace/Juego/src/Imagenes/0.png"));
					Fondo[i][j].setIcon(
							new ImageIcon("/C:\\\\Users\\\\Peteca\\\\Documents\\\\GitHub\\\\Juego/src/Imagenes/0.png"));
				} else if (arrays.level1Board[i][j] == 6) {
					// Fondo[i][j].setIcon(new
					// ImageIcon("/C:/Users/Nigga/Workspace/Juego/src/Imagenes/6.png"));
					Fondo[i][j].setIcon(
							new ImageIcon("/C:\\\\Users\\\\Peteca\\\\Documents\\\\GitHub\\\\Juego/src/Imagenes/6.png"));
				}
			}
		}

		for (int i = 0; i < 20; i++) {
			capa--;
			for (int j = 0; j < 19; j++) {
				capa--;

				Fondo[i][j].setBounds(i * 40, j * 40, 40, 40);
				layeredPane.add(Fondo[i][j], capa);

			}

		}
	}

	/*
	 * public String ingresarNombre() { nombre = new JTextField("ingresar nombre");
	 * nombre.setBounds(300, 300, 120, 20); layeredPane.add(nombre);
	 * botonJugar.setBounds(300,330,120,20); layeredPane.add(botonJugar,2000000);
	 * return nombre.getText(); }
	 */
	public void dibujarPuntos(Integer p) {
		puntos.setText("puntos:" + p.toString());
		// System.out.println(p.toString());

		puntos.setLocation(10, 10);
		puntos.setBounds(10, 10, 80, 20);
		layeredPane.add(puntos, 100000);

	}

	public void mostrarCriatura() {
		mounstroGrafico = new JLabel();
		mounstroGrafico.setBounds(321, 561, 30, 30);
		// mounstroGrafico.setIcon(new ImageIcon
		// ("C:\\Users\\Brisa\\Documents\\GitHub\\Juego\\src\\Imagenes\\CRIATURA.png"));
		mounstroGrafico.setIcon(new ImageIcon("resources/CRIATURA.png"));
		// mounstroGrafico.setIcon(new
		// ImageIcon("C:\\Users\\Nigga\\workspace\\Juego\\src\\Imagenes\\CRIATURA.png"));
		layeredPane.add(mounstroGrafico, 10000);

	}

	public void moverCriatura(int x, int y) {
		mounstroGrafico.setBounds(x, y, 30, 30);
		mounstroGrafico.repaint();
	}

	public void setPuntos(Integer p) {
		puntos.setText("puntos:" + p.toString());
	}
}
