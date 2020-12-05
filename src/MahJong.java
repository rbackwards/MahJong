import java.awt.event.*;

import javax.swing.*;

public class MahJong extends JFrame implements ActionListener{
	private MahJongBoard board;
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu = new JMenu("Menu");
	private int num;
	private boolean sound = true;
	
	public MahJong()
	{
		board = new MahJongBoard(this);
		
		setTitle("MahJong");
		setSize(1800,1000);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(board);
		
		addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent evt){
                int x = JOptionPane.showConfirmDialog(null, 
                    "Are you sure you want to exit ?", "Comform !",
                    JOptionPane.YES_NO_OPTION);

                if(x == JOptionPane.YES_OPTION) {
                    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }else{
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
		
		menuBar.add(menu);
		JMenu menuGame = new JMenu("Game");
		JMenu menuSound = new JMenu("Sound");
		JMenu menuMove = new JMenu("Move");
		JMenu menuHelp = new JMenu("Help");
		
		menu.add(menuGame);
		menu.add(menuSound);	
		menu.add(menuMove);
		menu.add(menuHelp);
		
		
		JMenuItem menuPlay = new JMenuItem("Play");
		JMenuItem menuRestart = new JMenuItem("Restart");
		JMenuItem menuNum = new JMenuItem("Numbered");
		JMenuItem menuExit = new JMenuItem("Exit");

		menuGame.add(menuPlay);
		menuGame.add(menuRestart);
		menuGame.add(menuNum);
		menuGame.add(menuExit);
		
		menuPlay.addActionListener(this);
		menuRestart.addActionListener(this);
		menuNum.addActionListener(this);
		menuExit.addActionListener(this);		
		
		JMenuItem menuOn = new JMenuItem("On");
		JMenuItem menuOff = new JMenuItem("Off");
		
		menuSound.add(menuOn);
		menuSound.add(menuOff);
		
		menuOn.addActionListener(this);
		menuOff.addActionListener(this);
		
		
		JMenuItem menuUndo = new JMenuItem("Undo");
		
		menuMove.add(menuUndo);
		
		menuUndo.addActionListener(this);
		
		JMenuItem menuOp = new JMenuItem("Operation");
		JMenuItem  menuRules= new JMenuItem("Game Rules");

		menuHelp.add(menuOp);
		menuHelp.add(menuRules);
		
		menuOp.addActionListener(this);
		menuRules.addActionListener(this);
		
		setJMenuBar(menuBar);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new MahJong();
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		
		if(str.equals("Play")) {
			board = null;
			//Container parent = getParent();
			board = new MahJongBoard(this);
			board.newGame(-1);
			//parent.repaint();
		}
		
		if(str.equals("Restart")) {
			int gm = board.getGameNum();
			board = null;
			board = new MahJongBoard(this);
			board.newGame(gm);
		}
		
		if(str.equals("Numbered")) {		
			num = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Game Seed(-1 for random)",  -1));

			board = null;
			board = new MahJongBoard(this);
			board.newGame(num);
		}
		
		if(str.equals("Exit")) {
			int x = JOptionPane.showConfirmDialog(null, 
                "Are you sure you want to exit ?", "Comform !",
                JOptionPane.YES_NO_OPTION);

            if(x == JOptionPane.YES_OPTION) {
                System.exit(0);
            }else{
                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
		}
		
		if(str.equals("On")) {
			sound = true;
		}
		if(str.equals("Off")) {
			sound = false;
		}
		
		if(str.equals("Operation")) {
			JOptionPane.showMessageDialog(null, "Click on matching tiles to remove them from the board.");
		}
		
		if(str.equals("Game Rules")) {
			JOptionPane.showMessageDialog(null, "The 144 tiles are arranged in a special four-layer pattern with their faces upwards. "
					+ "\n A tile is said to be open or exposed if it can be moved either left or right without disturbing other tiles. "
					+ "\n The goal is to match open pairs of identical tiles and remove them from the board, exposing the tiles under them for play. "
					+ "\n The game is finished when all pairs of tiles have been removed from the board or when there are no exposed pairs remaining.\r\n" + 
					"\r\n" + 
					"Tiles that are below other tiles cannot be seen. \n But by repeated undos or restarts which some programs offer, one gradually gets more and more information. "
					+ "\n Sometimes, tiles are only partially covered by other tiles, and the extent to which such tiles can be distinguished depends on the actual tile set. ");
		}
		
		
	}
}
