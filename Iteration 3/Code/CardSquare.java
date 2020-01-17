
public class CardSquare extends Square {

	public CardSquare() {
		this.squareType = "Card Square";
	}

	@Override
	public String getSquareType() {
		// TODO Auto-generated method stub
		return squareType;
	}

	@Override
	public void setSquareType(String squareType) {
		// TODO Auto-generated method stub
		this.squareType = squareType;

	}

	@Override
	public void landedOn(Player p) {
		// TODO Auto-generated method stub
		System.out.println("This is a CARD square. Take a card!");

	}

}
