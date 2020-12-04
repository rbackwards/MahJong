import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PictureTile extends Tile{
	
	private Image image;
	private String name;
	
	public PictureTile(String name) {
		this.name = name;
		
		if(this.toString().equals("Bamboo 1")) {
			image = Toolkit.getDefaultToolkit().getImage("images/Sparrow.png");
			image = image.getScaledInstance(80, 80, image.SCALE_SMOOTH);
		}
		else if(name.equals("Chrysanthemum")) {
			image = Toolkit.getDefaultToolkit().getImage("images/Chrysanthemum.png");
			image = image.getScaledInstance(80, 80, image.SCALE_SMOOTH);
		}
		else if(name.equals("Orchid")) {
			image = Toolkit.getDefaultToolkit().getImage("images/Orchid.png");
			image = image.getScaledInstance(80, 80, image.SCALE_SMOOTH);	
		}
		else if(name.equals("Plum")) {
			image = Toolkit.getDefaultToolkit().getImage("images/Plum.png");
			image = image.getScaledInstance(80, 80, image.SCALE_SMOOTH);	
		}
		else if(name.equals("Bamboo")) {
			image = Toolkit.getDefaultToolkit().getImage("images/Bamboo.png");
			image = image.getScaledInstance(80, 80, image.SCALE_SMOOTH);
		}
		else if(name.equals("Spring")) {
			image = Toolkit.getDefaultToolkit().getImage("images/Spring.png");
			image = image.getScaledInstance(80, 80, image.SCALE_SMOOTH);
		}
		else if(name.equals("Spring")) {
			image = Toolkit.getDefaultToolkit().getImage("images/Spring.png");
			image = image.getScaledInstance(80, 80, image.SCALE_SMOOTH);
		}
		else if(name.equals("Summer")) {
			image = Toolkit.getDefaultToolkit().getImage("images/Summer.png");
			image = image.getScaledInstance(80, 80, image.SCALE_SMOOTH);
		}
		else if(name.equals("Fall")) {
			image = Toolkit.getDefaultToolkit().getImage("images/Fall.png");
			image = image.getScaledInstance(80, 80, image.SCALE_SMOOTH);
		}
		else if(name.equals("Winter")) {
			image = Toolkit.getDefaultToolkit().getImage("images/Winter.png");
			image = image.getScaledInstance(80, 80, image.SCALE_SMOOTH);
		}
		
		
		
		MediaTracker tracker = new MediaTracker(this);
		tracker.addImage(image, 0);
		try {
			tracker.waitForAll();
		}
		catch(InterruptedException ie) {
			JOptionPane.showMessageDialog(this, "Unable to load Image", "Image Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public String toString() {
		return name;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		setToolTipText(toString());
		g.drawImage(image, 25, 5, this);
		
	}
}
