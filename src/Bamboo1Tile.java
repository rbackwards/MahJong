public class Bamboo1Tile extends PictureTile
{
	public Bamboo1Tile()
	{
		super("Sparrow");
	}
	
	@Override
	public Tile makeCopy() {
		return new Bamboo1Tile();
	}

	public String toString()
	{
		return "Bamboo 1";
	}
}

