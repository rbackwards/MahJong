import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Scrollbar;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class MahJongModel extends Tile implements TileListener
{
	private MahJongBoard board;
	private ArrayList<ArrayList<Row>> layers = new ArrayList<>();
	private int gameNum;
	private PlayClip clip = new PlayClip("audio/stone-scraping.wav", true);
	private boolean sound = true;
	private Tile selected;
	private Stack<Tile> undoStack = new Stack();
	private ArrayList<Tile> discardList = new ArrayList<>();
	private	JPanel	discard = null;
	private int tileCount = 144;
	private Fireworks reward;
	private ArrayList<ArrayList<Row>> layerList = new ArrayList<>();
	private JScrollPane scroller = null;
	
	public MahJongModel(MahJongBoard board, int gameNum)
	{
		this.board = board;
		this.gameNum = gameNum;
		makeGame(gameNum);
	}
	
	public int getGameNum() {
		return gameNum;
	}
	
	
	public void makeGame(long game)
	{
		TileDeck	deck = new TileDeck();
		//ArrayList<Row> layers = new ArrayList<>();
		
		if (game < 0)
			deck.shuffle();
		else
			deck.shuffle(game);
		
		
		//draw layers and add them to a list of layers						
		layerList.add(ArrayListOfRow(1, 1, deck, 4));
		layerList.add(ArrayListOfRow(2, 2, deck, 3));
		layerList.add(ArrayListOfRow(4, 4, deck, 2));
		layerList.add(ArrayListOfRow(6, 6, deck, 1));
		layerList.add(MakeBaseLayer(deck));
		
		Collections.reverse(layerList);

	}
	
	public ArrayList ArrayListOfRow(int rowSize, int colSize, TileDeck deck, int layerNum){
		ArrayList<Row> layer = new ArrayList<>();
		for (int j = colSize-1; j >= 0; j--)					// i = row       j = col
		{
			Row row = new Row(50,50*j, layerNum);
			
			for (int i = 0; i < rowSize; i++) {
				Tile	tile = deck.deal();
				if (tile == null)	
				{
					JOptionPane.showMessageDialog(null, "Empty Deck",
							"Deal Error", JOptionPane.ERROR_MESSAGE);
					System.exit(1);
				}
				tile.addTileListener(this);
				tile.positionTile(i, j, layerNum, xOffSet(layerNum), yOffSet(layerNum));
				row.addTile(tile);
				tile.setRow(row);
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
			Row theRow = new Row(50,50*row, 0);
			
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
				tile.addTileListener(this);
				tile.setRow(theRow);
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
	
	public void setSound(boolean b) {
		sound = b;
	}
	
	public void undoPane() {
		if(discard != null) {
			return;
		}
		discard = new JPanel(new FlowLayout());
		
		discard.setBorder(BorderFactory.createRaisedBevelBorder());
		
		discard.setBackground(Color.black);
		
		scroller = new JScrollPane(discard);
		
		scroller.setSize(new Dimension(200, 200));
		scroller.setLocation(board.getWidth()-300, 0);
		scroller.setBackground(Color.black);
		
		board.add(scroller);
	}
	
	public void undo() {
		try {
			Tile tile1 = undoStack.pop();
			Tile tile2 = undoStack.pop();
			tileCount += 2;
			tile1.setVisible(true);
			tile2.setVisible(true);
			board.revalidate();
			board.repaint();
			
			//remove jscroller
			if(discardList.size() > 0) {
				Tile t = discardList.remove(discardList.size()-1);
				discard.remove(t);
			}

		}
		catch(EmptyStackException e) {
			JOptionPane.showMessageDialog(null, "Nothing to undo.");
		}
	}
	
	public boolean hasTileAbove(Tile t) {	
		int layerNumber = t.getRow().getLayer();
		
		if(layerNumber == 4) {
			return false;
		}
		
		if(layerNumber == 3) {
			return layerList.get(4).get(0).getTile(0).isVisible();
		}
		
		int index = t.getRow().getIndexOf(t);
		int rowNumber = layerList.get(layerNumber).indexOf(t.getRow());
		int aboveIndexNum = index-1;
		
		if(layerNumber == 0) {
			switch(rowNumber) {
			case 0:
				return false;
			case 1:
				break;
			case 2:
				aboveIndexNum = index - 2;
				break;
			case 3:
				aboveIndexNum = index - 3;
				break;
			case 4:
				aboveIndexNum = index - 3;
				break;
			case 5:
				aboveIndexNum = index - 2;
				break;
			case 6:
				break;
			case 7: 
				return false;
					
			}
		}
		System.out.println("Index from above " + aboveIndexNum);
		if(aboveIndexNum < 0 || aboveIndexNum > 5) {
			return false;
		}
		
		if(rowNumber == 0 
				|| rowNumber ==  layerList.get(layerNumber).size()-1
				|| index == 0
				|| index == layerList.get(layerNumber).get(rowNumber).size()-1) {
			return false;
		}
		
		ArrayList<Row> aboveLayer = layerList.get(layerNumber+1);
		int aboveRowNum = rowNumber-1;
		
		
		return aboveLayer.get(aboveRowNum).getTile(aboveIndexNum).isVisible();
	
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
	

	@Override
		public void tileClicked(Tile tile) {
			undoPane();
			System.out.println("I was clicked " + tile.toString());
			
			if(selected == tile) {
				tile.setSelected(false);
				selected = null;
				return;
			}
			System.out.println("Has Tile above " + hasTileAbove(tile) + " " + tile);
			if(!tile.getRow().isOpen(tile)){
				return;
			}
			
			if(hasTileAbove(tile)) {
				System.out.println("Has Tile above " + tile.toString());
				return;
			}
			
			int tileLayerNum = tile.getRow().getLayer();
			ArrayList<Row> tileLayer = layerList.get(tileLayerNum);
			
			int rowIndex = tileLayer.indexOf(tile.getRow());
			int index = tile.getRow().getIndexOf(tile);
			
			
			
			System.out.println(layerList.get(0).get(4).getTile(12).toString() + " tile is visible: " + layerList.get(0).get(4).getTile(12).isVisible());
			if(rowIndex == 4 && index == 0 && tileLayerNum == 0 && layerList.get(0).get(3).getTile(0).isVisible()) {
				return;
			}
			
			if(rowIndex == 3 && index == 12 && tileLayerNum == 0 && layerList.get(0).get(4).getTile(12).isVisible()) {
				return;
			}
			
			if(selected != null && tile.matches(selected)) {
				tileCount -= 2;
				tile.setVisible(false);
				selected.setVisible(false);
				selected.setSelected(false);

				Tile selectedCopy = selected.makeCopy();
				discardList.add(selectedCopy);

				discard.add(selectedCopy);
				JScrollBar horizontal = scroller.getHorizontalScrollBar(); 
				horizontal.setValue( horizontal.getMaximum() );
								
				undoStack.push(tile);
				undoStack.push(selected);
				
				selected = null;
				
				if(sound) {
					clip.play(); // when the tiles are removed
				}
				
				if(tileCount == 0){
					reward = new Fireworks(board);
					reward.setSound(sound);
					reward.fire();
				}
				
			}
			
			else if (selected == null) {
				tile.setSelected(true);
				selected = tile;	
			}
			
	}
		
}