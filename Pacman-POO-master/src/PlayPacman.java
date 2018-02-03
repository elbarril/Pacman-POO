
public class PlayPacman {

	public static void main(String[] args) {
		int i = 1;
		Visual visual = new Visual();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador(modelo, visual);
		modelo.mounstro.setDireccion("izquierda");
		while (i == 1) {
			controlador.initControlador();
		}

	}
}
