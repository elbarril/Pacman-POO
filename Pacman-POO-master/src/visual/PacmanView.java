package visual;

import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;

import model.Creature;
import model.Direction;
import model.Pacman;

public class PacmanView extends CreatureView implements Observer{
	public PacmanView (Layers layers)
	{
		this.setBounds(360, 560, 40, 40);
		setIcon(new ImageIcon("resources/CRIATURA.png"));
		layers.add(this,6);


	}
}
