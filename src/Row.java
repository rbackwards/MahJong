import java.awt.*;
import java.util.*;

public class Row {
	private ArrayList<Tile> row = new ArrayList<>();
	private int x;
	private int y;
	private int layerNum;
	
	
	public Row(int x, int y, int layerNum) {
		this.x = x;
		this.y = y;
		this.layerNum = layerNum;
	}
	
	public void addTile(Tile t) {
		row.add(t);
	}
	
	public Tile getTile(int index) {
		if(index >= 0 && index < row.size() - 1) {
			return row.get(index);
		}
		return null;
	}
	
	public int getLayer() {
		return layerNum;
	}
	
	public boolean isOpen(Tile tile) {
        // TODO row 3 and 4 special cases

        int index = row.indexOf(tile);
        if (index == 0 || index == row.size() - 1) {
            return true;
        }		
        	Tile left = row.get(index - 1);
        	Tile right = row.get(index + 1);
        return !left.isVisible() || !right.isVisible();
   }
}
