import java.awt.*;
import java.awt.geom.Arc2D;

import javax.swing.*;

public class BambooTile extends RankTile{
	Bamboo[] b = new Bamboo[9];
	
	static {
		for(int i = 0; i<9; i++) {
			
		}
	}
		
	public BambooTile(int rank) {
		super(rank);
		Color darkGreen = new Color(34, 139, 34);
		
		if(rank == 2) {	
			b[0] = new Bamboo(62, 65, Color.blue);
			b[1] = new Bamboo(62, 39, darkGreen);
		}
		
		else if(rank == 3) {
			b[0] = new Bamboo(62, 39, Color.blue);
			b[1] = new Bamboo(50, 65, darkGreen);
			b[2] = new Bamboo(75, 65, darkGreen);
		}
		
		else if(rank == 4) {
			b[0] = new Bamboo(50, 65, darkGreen);
			b[1] = new Bamboo(75, 65, Color.blue);
			b[2] = new Bamboo(50, 39, Color.blue);
			b[3] = new Bamboo(75, 39, darkGreen);
		}
		
		else if(rank == 5) {
			b[0] = new Bamboo(35, 65, darkGreen);
			b[1] = new Bamboo(90, 65, Color.blue);
			b[2] = new Bamboo(35, 39, Color.blue);
			b[3] = new Bamboo(90, 39, darkGreen);
			b[4] = new Bamboo(62, 50, Color.red);
		}
		
		else if(rank == 6) {
			b[0] = new Bamboo(40, 65, Color.blue);
			b[1] = new Bamboo(65, 65, Color.blue);
			b[2] = new Bamboo(90, 65, Color.blue);
			b[3] = new Bamboo(40, 39, darkGreen);
			b[4] = new Bamboo(65, 39, darkGreen);
			b[5] = new Bamboo(90, 39, darkGreen);
		}
		
		else if(rank == 7) {
			b[0] = new Bamboo(40, 85, Color.blue);
			b[1] = new Bamboo(65, 85, Color.blue);
			b[2] = new Bamboo(90, 85, Color.blue);
			b[3] = new Bamboo(40, 59, darkGreen);
			b[4] = new Bamboo(65, 59, darkGreen);
			b[5] = new Bamboo(90, 59, darkGreen);
			b[6] = new Bamboo(65, 33, Color.red);
		}
		
		else if(rank == 8) {
			b[0] = new Bamboo(40, 33, darkGreen);
			b[1] = new Bamboo(65, 33, darkGreen);
			b[2] = new Bamboo(90, 33, darkGreen);
			b[3] = new Bamboo(40, 85, Color.blue);
			b[4] = new Bamboo(65, 85, Color.blue);
			b[5] = new Bamboo(90, 85, Color.blue);
			b[6] = new Bamboo(52, 59, Color.red);
			b[7] = new Bamboo(77, 59, Color.red);
		}
		else if(rank == 9) {
			b[0] = new Bamboo(40, 33, Color.red);
			b[1] = new Bamboo(65, 33, Color.blue);
			b[2] = new Bamboo(90, 33, darkGreen);
			b[3] = new Bamboo(40, 59, Color.red);
			b[4] = new Bamboo(65, 59, Color.blue);
			b[5] = new Bamboo(90, 59, darkGreen);
			b[6] = new Bamboo(40, 85, Color.red);
			b[7] = new Bamboo(65, 85, Color.blue);
			b[8] = new Bamboo(90, 85, darkGreen);
		}
		
		
		
	}
	
	public String toString() {
		return "Bamboo " + super.rank;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (Bamboo bb : b) {
			if(bb != null) {
				bb.draw(g);
			}
		}
		
		
	}
	
	
	
	public class Bamboo{
		
		private int x;
		private int y;
		Color color;
		
		public Bamboo(int x, int y, Color color) {
			this.x = x;
			this.y = y;
			this.color = color;
		}
		
		public void draw(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;

			g2.setColor(color);
			g2.fill(new Arc2D.Double(x, y, 10, 12, 0, 180, Arc2D.OPEN));
			g2.fill(new Arc2D.Double(x, y-10, 10, 12, 0, 180, Arc2D.OPEN));
			g2.fill(new Arc2D.Double(x, y-20, 10, 12, 0, 180, Arc2D.OPEN));
			g.fillRect(x+3, y-18, 5, 19);
			
			g.setColor(Color.lightGray);
			g.drawLine(x+6, y+5, x+6, y-4);
			g.drawLine(x+6, y-8, x+6, y-16);
		}
		
		
		
		
	}

}
