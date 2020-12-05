
public class SeasonTile extends PictureTile{
		private String name;
		
		public SeasonTile(String name) {
			super(name);
			this.name = name;
		}

		@Override
		public Tile makeCopy() {
			return new SeasonTile(name);
		}
}
