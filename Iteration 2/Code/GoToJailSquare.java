
public class GoToJailSquare extends Square {

	private String squareType;

	public GoToJailSquare() {
	}

	@Override
	public String getSquareType() {
		// TODO Auto-generated method stub
		return this.squareType;
	}

	@Override
	public void setSquareType(String squareType) {
		// TODO Auto-generated method stub
		this.squareType = squareType;
	}

	@Override
	public void landedOn(Player p) {
		// TODO Auto-generated method stub
		System.out.println("This is a GoToJail square!");
	}

}
