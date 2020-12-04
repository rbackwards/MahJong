
public class RankTile extends Tile{

		protected int rank;
		
		public RankTile(int rank) {
			this.rank = rank;
		}
		
		public boolean matches(Tile other) {
			
			if(super.matches(other)) {
				String rnk = rank+"";
				String rnk1 = other.toString();
	
				char ch = rnk1.charAt(rnk1.length()-1);
				
				String str = Character.toString(ch);
				
					if(rnk.equals(str)) {
						
						return true;
					}
			}

			return false;
		}
}
