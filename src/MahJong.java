import javax.swing.*;

public class MahJong extends JFrame{
	private MahJongBoard board;
	
	public MahJong()
	{
		board = new MahJongBoard(this);
		
		setTitle("MahJong");
		setSize(1800,1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(board);

		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new MahJong();
	}
}
