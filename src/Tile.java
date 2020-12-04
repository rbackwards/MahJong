import java.awt.*;

import javax.swing.*;

public class Tile extends JPanel{
	
		protected static Dimension 		SIZE;
		private static Polygon 			SIDE1;
		private static Polygon 			BOTTOM1;
		private static Polygon 			SIDE2;
		private static Polygon 			BOTTOM2;
		private static Rectangle 		FACE;
		private static GradientPaint 	GRAD1;
		private static GradientPaint 	GRAD2;
		private static Color 			bg;
		private int 					row;
		private int						col;
		private int						layer;
		
		
		public Tile()  {
			setOpaque(false);
			setPreferredSize(SIZE);
			setSize(SIZE);
			
		}
		
		
		public boolean matches(Tile other) {
			
			if(this.getClass() == other.getClass()) {					
				return true;
					
			}
	
			return false;	
			
		}
		
		public void positionTile(int row, int col, int layer) {
			this.row = row;
			this.col = col;
			this.layer = layer;
		}
		
		public int getRow() {
			return row;
		}

		public int getCol() {
			return col;
		}
		
		public int getLayer() {
			return layer;
		}
		
		public void paintComponent(Graphics g) {
			Graphics2D g2 =(Graphics2D)g;
			super.paintComponent(g);
			
			
			g2.setPaint(GRAD1);
			g2.fill(SIDE2);
			g2.fill(BOTTOM2);
			
			g2.setPaint(GRAD2);
			g2.fill(FACE);
			g2.fill(SIDE1);
			g2.fill(BOTTOM1);
			
			g2.setColor(Color.BLACK);
			g2.draw(FACE);
			
			g.setColor(Color.BLACK);
			g.drawPolygon(SIDE1);
			g.drawPolygon(BOTTOM1);
			g.drawPolygon(SIDE2);
			g.drawPolygon(BOTTOM2);	
		}
		
		static
		{
			bg = new Color(250, 250, 210);
			SIZE = new Dimension(121, 121);
			
			
			FACE = new Rectangle(20, 0, 100, 100);
			
			int[] sideX1 = {10, 20, 20, 10 };
			int[] sideY1 = {10, 0, 100, 110}; 
			int[] bottomX1 = {10, 20, 120, 110};
			int[] bottomY1 = {110, 100, 100, 110};
			
			int[] sideX2 = {0, 10, 10, 0 };
			int[] sideY2 = {20, 10, 110, 120}; 
			int[] bottomX2 = {0, 10, 110, 100};
			int[] bottomY2 = {120, 110, 110, 120};
			
			SIDE1 = new Polygon(sideX1, sideY1, 4);
			BOTTOM1 = new Polygon(bottomX1, bottomY1, 4);
			SIDE2 = new Polygon(sideX2, sideY2, 4);
			BOTTOM2 = new Polygon(bottomX2, bottomY2, 4);
			
			GRAD1 = new GradientPaint(20, 250, Color.WHITE, 120, 0, Color.blue);
			GRAD2 = new GradientPaint(20, 200, Color.WHITE, 120, 0, bg);
		}
		
		
}