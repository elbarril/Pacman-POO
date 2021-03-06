package visual;

import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Dot;

public class DotsView extends JPanel implements Observer {
	
	public DotsView(Dot[][] dots,Layers layers)
	{
		int capa=1;
		JLabel[][] dotMatrix = new JLabel[20][20];
		for (int i = 0; i < dots.length; i++) {
			capa++;
			for (int j = 0; j < dots.length; j++) {
				capa++;
				dotMatrix[i][j] = new JLabel();
				String identidadDot="";
				if(dots[i][j]!= null){
				identidadDot = dots[i][j].getClass().getName();}
				
				switch (identidadDot) {
				case "model.Dot":
					dotMatrix[i][j].setIcon(new ImageIcon("resources/dot.png"));
					break;
				case "model.SuperDot":
					dotMatrix[i][j].setIcon(new ImageIcon("resources/superdot.png"));
					break;
				}
				dotMatrix[i][j].setBounds(i * 40, j * 40, 40, 40);
				layers.add(dotMatrix[i][j], capa);
			}
		}
	
	}
	@Override
	public void update (Observable o, Object arg){
		
	}
}
