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
		//t.positionTile(x, col, layer);
	}
}
