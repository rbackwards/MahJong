import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MahJongBoard extends JPanel implements MouseListener
{
	private MahJong game;
	private MahJongModel model;
	private Image image;
	private int gameNum;

	
	public MahJongBoard(MahJong game, int gameNum)
	{
		this.game = game;
		this.gameNum = gameNum;
		model = new MahJongModel(this, gameNum);
		//setPreferredSize(new Dimension(400, 400));



		setLayout(null);
		//addMouseListener(this);
		setBackground(Color.red);
		image = Toolkit.getDefaultToolkit().getImage("bin/images/dragon_bg.png");
		MediaTracker tracker = new MediaTracker(this);
		tracker.addImage(image, 0);
		try {
			tracker.waitForAll();
		}
		catch(InterruptedException ie) {
			JOptionPane.showMessageDialog(this, "Unable to load Image", "Image Error", JOptionPane.ERROR_MESSAGE);
		}

		
		setVisible(true);
	}
	
	public void newGame(int gameNum) {
		model = new MahJongModel(this, gameNum);
	}
	
	public int getGameNum() {
		return model.getGameNum();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(image, getParent().getWidth()/2 - image.getWidth(null) /2, getParent().getHeight()/2 - image.getHeight(null) /2, this);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("x: " + e.getX() + " y: " + e.getY() );	
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}