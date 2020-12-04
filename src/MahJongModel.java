import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class MahJongModel extends Tile
{
	private MahJongBoard board;

	public MahJongModel(MahJongBoard board)
	{
		this.board = board;
	}
	
	public static JTable makeGame(long game)
	{
		TileDeck	deck = new TileDeck();
		Tile[][]	tiles = new Tile[12][12];
		String[]	cols = new String[12];

		Arrays.fill(cols, "");

		if (game < 0)
			deck.shuffle();
		else
			deck.shuffle(game);

		for (int i = 0; i < 144; i++)
		{
			Tile	tile = deck.deal();
			if (tile == null)
			{
				JOptionPane.showMessageDialog(null, "Empty Deck",
						"Deal Error", JOptionPane.ERROR_MESSAGE);
				System.exit(1);
			}

			tiles[i/12][i%12] = tile;
		}

		return new JTable(tiles, cols);

	}
}