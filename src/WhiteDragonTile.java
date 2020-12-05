import java.awt.Color;
import java.awt.Graphics;

public class WhiteDragonTile extends Tile
{
	public WhiteDragonTile()
	{
		setToolTipText("White Dragon");
	}
	
	@Override
	public Tile makeCopy() {
		return new WhiteDragonTile();
	}
	
	public String toString()
	{
		return "White Dragon";
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.blue);
		int x = 30;
		int y = 10;
		g.drawRect(x, y, 10, 70);
		g.drawRect(x, y, 80, 10);
		g.drawRect(x+70, y+10, 10, 60);
		g.drawRect(x, y+70, 80, 10);
		g.fillRect(x, y, 13, 10);
		g.fillRect(x+25, y, 13, 10);
		g.fillRect(x+55, y, 13, 10);
		g.fillRect(x, y+25, 10, 13);
		g.fillRect(x, y+48, 10, 13);
		g.fillRect(x, y+70, 13, 10);
		g.fillRect(x+70, y+33, 10, 13);
		g.fillRect(x+70, y+58, 10, 13);
		g.fillRect(x+70, y+10, 10, 13);
		g.fillRect(x+25, y+70, 13, 10);
		g.fillRect(x+55, y+70, 13, 10);
		
	}
}

