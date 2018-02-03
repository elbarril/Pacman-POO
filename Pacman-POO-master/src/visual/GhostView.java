package visual;

import javax.swing.ImageIcon;

public class GhostView extends CreatureView {
	public GhostView (Layers layers)
	{
		this.setBounds(320, 160, 40, 40);
		setIcon(new ImageIcon("resources/GHOST.png"));
		layers.add(this,6);
	}
}
