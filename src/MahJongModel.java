import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class MahJongModel extends Tile
{
	private MahJongBoard board;

	public MahJongModel(MahJongBoard board)
	{
		this.board = board;
		makeGame(-1);
	}
	
	public void makeGame(long game)
	{
		TileDeck	deck = new TileDeck();
		//ArrayList<Row> layers = new ArrayList<>();
		
		if (game < 0)
			deck.shuffle();
		else
			deck.shuffle(game);
		
		
		//draw layers
		//ArrayListOfRow(1, 1, deck, 4);
		//ArrayListOfRow(2, 2, deck, 3);
		//ArrayListOfRow(4, 4, deck, 2);
		//ArrayListOfRow(6, 6, deck, 1);
		MakeBaseLayer(deck);
		

	}
	
	public ArrayList ArrayListOfRow(int rowSize, int colSize, TileDeck deck, int layerNum){
		ArrayList<Row> layer = new ArrayList<>();
		for (int i = 0; i < rowSize; i++)						// i = row       j = col
		{
			Row row = new Row(50,50*i);
			
			for (int j = colSize-1; j >= 0; j--) {
				Tile	tile = deck.deal();
				if (tile == null)
				{
					JOptionPane.showMessageDialog(null, "Empty Deck",
							"Deal Error", JOptionPane.ERROR_MESSAGE);
					System.exit(1);
				}
				tile.positionTile(i, j, 0, xOffSet(layerNum), yOffSet(layerNum));
				row.addTile(tile);
				board.add(tile);
			}
			
			layer.add(row);
		}
		return layer;
	}
	
	public ArrayList MakeBaseLayer(TileDeck deck){
		ArrayList<Row> layer = new ArrayList<>();
		//make layoutgrid tiles
		for (int row = 7; row >= 0; row--)						// i = col       j = row
		{
			Row theRow = new Row(50,50*row);
			
			int colNum = 12;
			if (row == 3) {
				colNum = 14;
			}
			if (row == 4) {
				colNum = 13;
			}
			
			
			for (int col = 0; col < colNum; col++){				
				// Skip 2 on rows 1 and 6
				if ((row == 1 || row == 6) && (col < 2 || col > 9)) {
					continue;
				}
				// Skip 1 on rows 2 and 5
				if ((row == 2 || row == 5) && (col < 1 || col > 10)) {
					continue;
				}
				if(row == 4) {
					
				}
												
			
				Tile	tile = deck.deal();
				if (tile == null)
				{
					JOptionPane.showMessageDialog(null, "Empty Deck",
							"Deal Error", JOptionPane.ERROR_MESSAGE);
					System.exit(1);
				}
				
				// handle special cases
				int margin = 18;
				if (row == 4) {
					if (col == 0) {
						tile.setLocation(-SIZE.width + margin + xOffSet(0), row * (SIZE.height - margin) - 50);
					} else {
						tile.setLocation((col - 1) * (SIZE.width - margin) + xOffSet(0), row * (SIZE.height - margin) + yOffSet(0));
					}
				} else if (row == 3 && col > 11) {
						tile.setLocation(col * (SIZE.width - margin) + xOffSet(0), row * (SIZE.height - margin) + 50);
				} else {
					tile.setLocation(col * (SIZE.width - margin) + xOffSet(0), row * (SIZE.height - margin) + yOffSet(0));
				
					
				}
				theRow.addTile(tile);
				board.add(tile);
			}
			
			layer.add(theRow);
		}
		
		//make special Cases
		
		return layer;
	}
	
	private int xOffSet(int layer) {
		switch(layer) {
			case(0):
				return 200;
			case(1):
				return 520;
			case(2):
				return 635;
			case(3):
				return 750;
			case(4):
				return 820;
			default:
				return 0;
		}
	}
	
	private int yOffSet(int layer) {
		switch(layer) {
			case(0):
				return 10;
			case(1):
				return 100;
			case(2):
				return 190;
			case(3):
				return 280;
			case(4):
				return 320;
			default:
				return 0;
		}
	}
}