import java.awt.*;
import java.util.*;

public class Row {
	private ArrayList<Tile> row = new ArrayList<>();
	private int x;
	private int y;
	
	public Row(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void addTile(Tile t) {
		row.add(t);
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
