import java.awt.*;

import javax.swing.*;

public class CircleTile extends RankTile{

		public CircleTile(int rank) {
			super(rank);
		}
		
		@Override
		public Tile makeCopy() {
			return new CircleTile(rank);
		}
		
		
		public String toString() {
			return "Circle " + super.rank;
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			Color darkGreen = new Color(34, 139, 34);
			
			
			if(rank == 1) {
				g.setColor(darkGreen);
				g.fillOval(27, 10, 80, 80);
				g.setColor(Color.black);
				g.drawOval(27, 10, 80, 80);
				
				g.setColor(Color.red);
				g.fillOval(55, 38, 25, 25);
				
				g.setColor(Color.lightGray);
				g.drawOval(55, 38, 25, 25);
				g.drawLine(60, 42, 75, 60);
				g.drawLine(60, 62, 75, 40);
				
				int x = 64;
				int y = 15;
				
				for(int i = 0; i < 3; i++) {
					g.fillOval(x, y, 7, 7);
					x -= 14;
					y += 7;
				}
				x = 64;
				y = 15;
			
				for(int i = 0; i < 3; i++) {
					g.fillOval(x, y, 7, 7);
					x += 14;
					y += 7;
				}
				y += 21;
				for(int i = 0; i < 3; i++) {
					x -= 14;
					y += 7;
					g.fillOval(x, y, 7, 7);
				}
				
				for(int i = 0; i < 3; i++) {
					g.fillOval(x,  y,  7, 7);
					x -= 14;
					y -=7;
				}
			}
			
			else if(rank == 2) {
				g.setColor(darkGreen);
				g.fillOval(62, 20, 20, 20);
				
				
				g.setColor(Color.lightGray);
				g.drawLine(65, 23, 79, 37);
				g.drawLine(65, 37, 79, 23);
				
				//g.fillOval(x, y, width, height);
				g.setColor(Color.red);
				g.fillOval(62, 60, 20, 20);
				
				
				g.setColor(Color.lightGray);
				g.drawLine(65, 63, 79, 77);
				g.drawLine(65, 77, 79, 63);
				
			}
			
			else if (rank == 3) {
				g.setColor(darkGreen);
				g.fillOval(62, 40, 20, 20);
			
				g.setColor(Color.blue);
				g.fillOval(30, 10, 20, 20);
				
				g.setColor(Color.red);
				g.fillOval(90, 70, 20, 20);
				
				g.setColor(Color.lightGray);
				g.drawLine(65, 43, 79, 57);
				g.drawLine(65, 57, 79, 43);
				
				g.drawLine(32, 13, 47, 27);
				g.drawLine(32, 27, 47, 13);
				
				g.drawLine(93, 73, 107, 87);
				g.drawLine(93, 87, 107, 73);
			}
			
			else if(rank == 4) {
				int x1 = 44;
				int x2 = 57;
				int y1 = 63;
				int y2 = 76;
				
				g.setColor(darkGreen);
				g.fillOval(40, 60, 20, 20);
				g.fillOval(80, 20, 20, 20);
				
				g.setColor(Color.blue);
				g.fillOval(80, 60, 20, 20);
				g.fillOval(40, 20, 20, 20);
				
				
				g.setColor(Color.lightGray);
				
				g.drawLine(x1, y1, x2, y2);
				g.drawLine(x1, y1+13, x2, y2-13);
				
				g.drawLine(x1+40, y1, x2+40, y2);
				g.drawLine(x1+40, y1+13, x2+40, y2-13);
				
				g.drawLine(x1, y1-40, x2, y2-40);
				g.drawLine(x1, y1-27, x2, y2-53);
				
				g.drawLine(x1+40, y1-40, x2+40, y2-40);
				g.drawLine(x1+40, y1-27, x2+40, y2-53);
			}
			
			else if(rank == 5) {
				int x1 = 33;
				int x2 = 46;
				int y1 = 13;
				int y2 = 26;
				
				g.setColor(darkGreen);
				g.fillOval(30, 70, 20, 20);
				g.fillOval(90, 10, 20, 20);
				
				g.setColor(Color.blue);
				g.fillOval(90, 70, 20, 20);
				g.fillOval(30, 10, 20, 20);
				
				g.setColor(Color.red);
				g.fillOval(60, 40, 20, 20);
				
				g.setColor(Color.lightGray);
				
				g.drawLine(x1, y1, x2, y2);
				g.drawLine(x1, y1+13, x2, y2-13);
				
				g.drawLine(x1+60, y1, x2+60, y2);
				g.drawLine(x1+60, y1+13, x2+60, y2-13);
				
				g.drawLine(x1, y1+60, x2, y2+60);
				g.drawLine(x1, y1+72, x2, y2+48);
				
				g.drawLine(x1+60, y1+60, x2+60, y2+60);
				g.drawLine(x1+60, y1+72, x2+60, y2+48);
				
				g.drawLine(x1+30, y1+30, x2+30, y2+30);
				g.drawLine(x1+30, y1+42, x2+30, y2+18);
			}
			
			else if(rank == 6) {
				int x1 = 43;
				int x2 = 56;
				int y1 = 13;
				int y2 = 26;
				
				g.setColor(darkGreen);
				g.fillOval(40, 10, 20, 20);
				g.fillOval(80, 10, 20, 20);
				
				g.setColor(Color.red);
				g.fillOval(40, 40, 20, 20);
				g.fillOval(80, 40, 20, 20);
				g.fillOval(40, 70, 20, 20);
				g.fillOval(80, 70, 20, 20);
				
				g.setColor(Color.lightGray);
				
				g.drawLine(x1, y1, x2, y2);
				g.drawLine(x1, y1+13, x2, y2-13);
				
				g.drawLine(x1, y1+30, x2, y2+30);
				g.drawLine(x1, y1+43, x2, y2+17);
				
				g.drawLine(x1+40, y1+60, x2+40, y2+60);
				g.drawLine(x1+40, y1+73, x2+40, y2+47);
				
				g.drawLine(x1+40, y1, x2+40, y2);
				g.drawLine(x1+40, y1+13, x2+40, y2-13);
				
				g.drawLine(x1+40, y1+30, x2+40, y2+30);
				g.drawLine(x1+40, y1+43, x2+40, y2+17);
				
				g.drawLine(x1, y1+60, x2, y2+60);
				g.drawLine(x1, y1+73, x2, y2+47);
			}
			
			else if(rank == 7) {
				int x1 = 33;
				int x2 = 46;
				int y1 = 13;
				int y2 = 26;
				
				g.setColor(darkGreen);
				g.fillOval(30, 10, 20, 20);
				g.fillOval(60, 20, 20, 20);
				g.fillOval(90, 30, 20, 20);
				
				g.setColor(Color.red);
				g.fillOval(40, 50, 20, 20);
				g.fillOval(80, 50, 20, 20);
				g.fillOval(40, 70, 20, 20);
				g.fillOval(80, 70, 20, 20);
				
				
				g.setColor(Color.lightGray);
				
				g.drawLine(x1, y1, x2, y2);
				g.drawLine(x1, y1+13, x2, y2-13);
				
				g.drawLine(x1+30, y1+10, x2+30, y2+10);
				g.drawLine(x1+30, y1+23, x2+30, y2-3);
				
				g.drawLine(x1+60, y1+20, x2+60, y2+20);
				g.drawLine(x1+60, y1+33, x2+60, y2+7);
				
				g.drawLine(x1+10, y1+40, x2+10, y2+40);
				g.drawLine(x1+10, y1+53, x2+10, y2+30);
				
				g.drawLine(x1+10, y1+60, x2+10, y2+60);
				g.drawLine(x1+10, y1+73, x2+10, y2+50);
				
				g.drawLine(x1+50, y1+40, x2+50, y2+40);
				g.drawLine(x1+50, y1+53, x2+50, y2+30);
				
				g.drawLine(x1+50, y1+60, x2+50, y2+60);
				g.drawLine(x1+50, y1+73, x2+50, y2+50);
			}
			
			else if (rank == 8) {
				int x1 = 43;
				int x2 = 56;
				int y1 = 8;
				int y2 = 21;
				
				g.setColor(Color.blue);
				g.fillOval(40, 5, 20, 20);
				g.fillOval(80, 5, 20, 20);
				g.fillOval(40, 30, 20, 20);
				g.fillOval(80, 30, 20, 20);
				g.fillOval(40, 55, 20, 20);
				g.fillOval(80, 55, 20, 20);
				g.fillOval(40, 80, 20, 20);
				g.fillOval(80, 80, 20, 20);
				
				
				g.setColor(Color.lightGray);
				
				
				for(int i=0; i<4; i++) {
					
					g.drawLine(x1, y1, x2, y2);
					g.drawLine(x1, y1+13, x2, y2-13);
					x1 += 40;
					x2 += 40;
					
					g.drawLine(x1, y1, x2, y2);
					g.drawLine(x1, y1+13, x2, y2-13);
					y1 +=25;
					y2 +=25;
					x1 -= 40;
					x2 -= 40;
				}
	
			}
			
			else if(rank == 9) {
				int x1 = 33;
				int x2 = 46;
				int y1 = 13;
				int y2 = 25;
				
				g.setColor(darkGreen);
				g.fillOval(90, 10, 20, 20);
				g.fillOval(60, 10, 20, 20);
				g.fillOval(30, 10, 20, 20);
				
				g.setColor(Color.red);
				g.fillOval(90, 40, 20, 20);
				g.fillOval(60, 40, 20, 20);
				g.fillOval(30, 40, 20, 20);
				
				g.setColor(Color.blue);
				g.fillOval(90, 70, 20, 20);
				g.fillOval(60, 70, 20, 20);
				g.fillOval(30, 70, 20, 20);
				
				
				g.setColor(Color.lightGray);
				
				
				for(int i=0; i<3; i++) {
					g.drawLine(x1, y1, x2, y2);
					g.drawLine(x1, y1+13, x2, y2-13);	
					x1 +=30;
					x2 +=30;
				}
				x1-=90;x2-=90;y1+=30;y2+=30;
				for(int i=0; i<3; i++) {
					g.drawLine(x1, y1, x2, y2);
					g.drawLine(x1, y1+13, x2, y2-13);	
					x1 +=30;
					x2 +=30;
				}
				x1-=90;x2-=90;y1+=30;y2+=30;
				for(int i=0; i<3; i++) {
					g.drawLine(x1, y1, x2, y2);
					g.drawLine(x1, y1+13, x2, y2-13);	
					x1 +=30;
					x2 +=30;
				}
				
				

			}
		}
		
}
