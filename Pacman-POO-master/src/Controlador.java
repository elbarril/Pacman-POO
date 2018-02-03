import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controlador implements KeyListener {
	Modelo modelo;
	Visual visual;
	public Controlador(Modelo modelo, Visual visual) {
		super();
		this.modelo = modelo;
		this.visual = visual;
		visual.dibujarPuntos(modelo.puntos);
		//modelo.nombreJugador=visual.ingresarNombre();
	}

	public void initControlador() {
		visual.addKeyListener(this);
		modelo.pathfinder();
		modelo.setMovimientoCriatura(modelo.mounstro.direction);
		
		//if (modelo.nombreJugador != "ingresar nombre") { 
			initVisual();
			//}
	}

	private void initVisual() {
		//System.out.println(modelo.nombreJugador);
		visual.mounstroGrafico.setBounds(modelo.getPosicionCriatura()[0], modelo.getPosicionCriatura()[1], 39, 39);
		visual.setPuntos(modelo.puntos);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		switch (arg0.getKeyCode()) {
		case 37: {


			modelo.mounstro.direction = "izquierda";
			break;
		}
		case 38: {
			modelo.mounstro.direction = "arriba";
			break;
		}
		case 39: {
			modelo.mounstro.direction = "derecha";
			break;
		}
		case 40: {
			modelo.mounstro.direction = "abajo";
			break;
		}
		}


	}

	public void controladorCriatura() {
		visual.moverCriatura(modelo.setMovimientoCriatura(modelo.mounstro.direction)[0],modelo.setMovimientoCriatura(modelo.mounstro.direction)[1]);
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 37: {

			modelo.mounstro.direction = "izquierda";
			break;
		}
		case 38: {
			modelo.mounstro.direction = "arriba";
			break;
		}
		case 39: {
			modelo.mounstro.direction = "derecha";
			break;
		}
		case 40: {
			modelo.mounstro.direction = "abajo";
			break;
		}
		}
	}

}
