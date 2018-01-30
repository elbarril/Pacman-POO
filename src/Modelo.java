import java.util.Formatter;

import model.BoardConfiguration;
import model.Creature;

public class Modelo {

	BoardConfiguration arrays = new BoardConfiguration();
	Creature mounstro = new Creature();
	int i;
	int[] perimetro = new int[5];
	int[] perisferia = new int[4];
	Formatter puntosFile;
	Integer posicionJugador, puntos =0;
	String nombreJugador="ingresar nombre";

	public Modelo() {
		/*try {
			 puntosFile = new Formatter("C:\\Users\\Peteca\\Documents\\GitHub\\Juego\\src\\Puntos.txt");
			puntosFile.format("%s %s %s",posicionJugador, nombreJugador , puntos, "/r /n");
		}catch(Exception e)
			{
				System.out.println("error");
			}*/
	}

	public int[] setMovimientoCriatura(String direccion) {

		mounstro.direction = direccion;
		switch (direccion) {
		case "izquierda":
			mounstro.setPosicion(mounstro.posicion[0] - 40, mounstro.posicion[1]);
			break;
		case "derecha":
			mounstro.setPosicion(mounstro.posicion[0] + 40, mounstro.posicion[1]);
			break;
		case "arriba":
			mounstro.setPosicion(mounstro.posicion[0], mounstro.posicion[1] - 40);
			break;
		case "abajo":
			mounstro.setPosicion(mounstro.posicion[0], mounstro.posicion[1] + 40);
			break;
		case "detenido":
			mounstro.setPosicion(mounstro.posicion[0], mounstro.posicion[1]);
			break;
		}

		try {
			puntos++;
			Thread.sleep(80);

		} catch (InterruptedException time) {

		}

		return mounstro.posicion;
	}

	public void pathfinder() {

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 19; j++) {

				calcularPerimetro(i, j);

				if (mounstro.direction.equals("izquierda")) {
					if ((mounstro.posicion[0] - 2 <= perimetro[2]) && (mounstro.posicion[0] - 2 >= perimetro[0])
							&& (mounstro.posicion[1] + 20 <= perimetro[3])
							&& (mounstro.posicion[1] >= perimetro[1]) && (perimetro[4] != 1)) {
						if (mounstro.direccionAnterior == mounstro.direction) {
							mounstro.direction = "detenido";
						} else {
							mounstro.direction = mounstro.direccionAnterior;
						}
					}
				}
				if (mounstro.direction == "arriba") {


					if ((mounstro.posicion[1] - 2 <= perimetro[3]) && (mounstro.posicion[1] - 2 >= perimetro[1])
							&& (mounstro.posicion[0] + 20 <= perimetro[2]) && (mounstro.posicion[0] >= perimetro[0])
							&& (perimetro[4] != 1)
							) {
						if (mounstro.direccionAnterior == mounstro.direction) {
							mounstro.direction = "detenido";
						} else {
							mounstro.direction = mounstro.direccionAnterior;
						}
					}
				}
				if (mounstro.direction == "derecha") {
					if ((mounstro.posicion[0] + 40 >= perimetro[0]) && (mounstro.posicion[0] + 2 <= perimetro[2])
							&& (mounstro.posicion[1] + 20 <= perimetro[3]) && (mounstro.posicion[1] >= perimetro[1])
							&& (perimetro[4] != 1)
							) {
						if (mounstro.direccionAnterior == mounstro.direction) {
							mounstro.direction = "detenido";
						} else {
							mounstro.direction = mounstro.direccionAnterior;
						}
					}
				}
				if (mounstro.direction == "abajo") {
					if ((mounstro.posicion[1] + 40 >= perimetro[1]) && (mounstro.posicion[1] + 2 <= perimetro[3])
							&& (mounstro.posicion[0] + 20 <= perimetro[2]) && (mounstro.posicion[0] >= perimetro[0])
							&& (perimetro[4] != 1)
							) {
						if (mounstro.direccionAnterior == mounstro.direction) {
							mounstro.direction = "detenido";
						} else {
							mounstro.direction = mounstro.direccionAnterior;
						}
					}
				}
			}
		}
		mounstro.direccionAnterior = mounstro.direction;
	}


	public void calcularPerimetro(int i, int j) {
		perimetro[0] = i * 40; // izquierda
		perimetro[1] = j * 40; // arriba
		perimetro[2] = (i * 40) + 39; // derecha
		perimetro[3] = (j * 40) + 39; // abajo
		perimetro[4] = arrays.level1Board[i][j]; // si es camino pisable o no
	}


	public void setDireccionCriatura() {

	}
	public int[] getPosicionCriatura() {

		return mounstro.posicion;

	}

}
