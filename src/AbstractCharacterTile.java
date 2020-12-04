import java.awt.Color;
import java.awt.Graphics;

public abstract class AbstractCharacterTile extends Tile{

		public AbstractCharacterTile() {
			
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setColor(Color.red);
			g.drawString(this.toString(), 105, 20);
			
			
		}
}
 