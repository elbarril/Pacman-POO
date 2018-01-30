package visual;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PacmanView extends JLabel {
	public PacmanView() {
		this.setBounds(321, 561, 30, 30);
		setIcon(new ImageIcon("resources/CRIATURA.png"));
		// layeredPane.add(this, 10000);
	}
}
