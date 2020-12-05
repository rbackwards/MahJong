import java.util.HashMap;

import javax.swing.*;
import java.awt.*;


public class CharacterTile extends Tile{

		protected char symbol;
		static HashMap<Character, Character> symbolMap = new HashMap<Character, Character>();
		
		static {
			symbolMap.put('1', '\u4E00');
			symbolMap.put('2', '\u4E8C');
			symbolMap.put('3', '\u4E09');
			symbolMap.put('4', '\u56DB');
			symbolMap.put('5', '\u4E94');
			symbolMap.put('6', '\u516D');
			symbolMap.put('7', '\u4E03');
			symbolMap.put('8', '\u516B');
			symbolMap.put('9', '\u4E5D');
			symbolMap.put('N', '\u5317');
			symbolMap.put('E', '\u6771');
			symbolMap.put('W', '\u897F');
			symbolMap.put('S', '\u5357');
			symbolMap.put('C', '\u4E2D');
			symbolMap.put('F', '\u767C');
		}
			
	
		public CharacterTile(char symbol) {
			this.symbol = symbol;	
		}
		
		public boolean matches(Tile other) {
			
			if(super.matches(other)) {
				return symbol == ((CharacterTile) other).getSymbol();
			}
			return false;
		}
		
		@Override
		public Tile makeCopy() {
			return new CharacterTile(symbol);
		}
		
		public char getSymbol() {
			return symbol;
		}
		
		public String toChinese() {
			return symbolMap.get(symbol)+"";
		}
		
		public String toString() {
			
			switch(symbol) {
			case 'N':
				return "North Wind";
			case 'E':
				return "East Wind";
			case 'W':
				return "West Wind";
			case 'S':
				return "South Wind";
			case 'C':
				return "Red Dragon";
			case 'F':
				return "Green Dragon";
			default:
				return "Character " + symbol;
			}
			
			
			//return symbol+"";
		}
		
		public void paintComponent(Graphics g) {
			Color darkGreen = new Color(34, 139, 34);
			super.paintComponent(g);
						
			g.setColor(Color.red);
			g.drawString(symbol+"", 105, 20);
			
			
			
			if(symbol != 'N' && symbol != 'E' && symbol != 'W' && symbol != 'S' && symbol != 'C' && symbol != 'F') {
				g.setFont(new Font("TimesRoman", Font.PLAIN, 35));
				g.setColor(Color.black);
				g.drawString(symbolMap.get(symbol)+"", 50, 38);
				
				g.setColor(Color.red);
				g.drawString('\u842C'+"", 50, 87);
			}
			
			else if(symbol == 'N' || symbol == 'E' || symbol == 'W' || symbol == 'S') {
				g.setColor(Color.black);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 63));
				g.drawString(symbolMap.get(symbol)+"", 36, 75);
			}
			
			else if(symbol == 'C') {
				g.setColor(Color.red);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 63));
				g.drawString(symbolMap.get(symbol)+"", 36, 75);
			}
			else {
				g.setColor(darkGreen);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 63));
				g.drawString(symbolMap.get(symbol)+"", 36, 75);
			}
		
			
			
		}
	
	
}
