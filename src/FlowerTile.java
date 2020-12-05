
public class FlowerTile extends PictureTile{
	private String name;
	
	public FlowerTile(String name) {
		super(name);
		this.name = name;
	}
	
	@Override
	public Tile makeCopy() {
		return new FlowerTile(name);
	}

}
