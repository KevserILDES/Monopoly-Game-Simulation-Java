
public class RegularSquare extends Square{
	
	private String squareType;
	
	public RegularSquare() {
		this.squareType="RegularSquare";
	}

	@Override
	public void setSquareType(String squareType) {
		// TODO Auto-generated method stub
		this.squareType=squareType;
	}

	@Override
	public String getSquareType() {
		// TODO Auto-generated method stub
		return this.squareType;
	}

}
