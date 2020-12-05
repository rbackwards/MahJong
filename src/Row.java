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
		if(index >= 0 && index < row.size()) {
			return row.get(index);
		}
		return null;
	}
	
	public int getIndexOf(Tile t) {
		return row.indexOf(t);
	}
	
	public int size() {
		return row.size();
	}
	public int getLayer() {
		return layerNum;
	}
	
	public boolean isOpen(Tile tile) {
        int index = row.indexOf(tile);
        if (index == 0 || index == row.size() - 1) {
            return true;
        }		
        	Tile left = row.get(index - 1);
        	Tile right = row.get(index + 1);
        return !left.isVisible() || !right.isVisible();
   }
}
