import java.awt.*;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PictureTile extends Tile{
	
	private Image image;
	private String name;
	
	public PictureTile(String name) {
		this.name = name;
		
		if(this.toString().equals("Bamboo 1")) {
			URL imgUrl = getClass().getResource("images/Sparrow.png");
			image = Toolkit.getDefaultToolkit().getImage(imgUrl);
			image = image.getScaledInstance(80, 80, image.SCALE_SMOOTH);
		}
		else if(name.equals("Chrysanthemum")) {
			URL imgUrl = getClass().getResource("images/Chrysanthemum.png");
			image = Toolkit.getDefaultToolkit().getImage(imgUrl);
			image = image.getScaledInstance(80, 80, image.SCALE_SMOOTH);
		}
		else if(name.equals("Orchid")) {
			URL imgUrl = getClass().getResource("images/Orchid.png");
			image = Toolkit.getDefaultToolkit().getImage(imgUrl);
			image = image.getScaledInstance(80, 80, image.SCALE_SMOOTH);	
		}
		else if(name.equals("Plum")) {
			URL imgUrl = getClass().getResource("images/Plum.png");
			image = Toolkit.getDefaultToolkit().getImage(imgUrl);
			image = image.getScaledInstance(80, 80, image.SCALE_SMOOTH);	
		}
		else if(name.equals("Bamboo")) {
			URL imgUrl = getClass().getResource("images/Bamboo.png");
			image = Toolkit.getDefaultToolkit().getImage(imgUrl);
			image = image.getScaledInstance(80, 80, image.SCALE_SMOOTH);
		}
		else if(name.equals("Spring")) {
			URL imgUrl = getClass().getResource("images/Spring.png");
			image = Toolkit.getDefaultToolkit().getImage(imgUrl);
			image = image.getScaledInstance(80, 80, image.SCALE_SMOOTH);
		}
		else if(name.equals("Spring")) {
			URL imgUrl = getClass().getResource("images/Spring.png");
			image = Toolkit.getDefaultToolkit().getImage(imgUrl);
			image = image.getScaledInstance(80, 80, image.SCALE_SMOOTH);
		}
		else if(name.equals("Summer")) {
			URL imgUrl = getClass().getResource("images/Summer.png");
			image = Toolkit.getDefaultToolkit().getImage(imgUrl);
			image = image.getScaledInstance(80, 80, image.SCALE_SMOOTH);
		}
		else if(name.equals("Fall")) {
			URL imgUrl = getClass().getResource("images/Fall.png");
			image = Toolkit.getDefaultToolkit().getImage(imgUrl);
			image = image.getScaledInstance(80, 80, image.SCALE_SMOOTH);
		}
		else if(name.equals("Winter")) {
			URL imgUrl = getClass().getResource("images/Winter.png");
			image = Toolkit.getDefaultToolkit().getImage(imgUrl);
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
