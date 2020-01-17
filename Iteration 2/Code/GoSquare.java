
public class GoSquare extends Square {

	private int passingMoney;

	public GoSquare(int passingMoney) {
		this.passingMoney = passingMoney;
		this.squareType = "GoSquare";
	}

	public int get_passingMoney() {
		return passingMoney;
	}

	public void set_passingMoney(int passingMoney) {
		this.passingMoney = passingMoney;
	}

	@Override
	public String getSquareType() {
		return this.squareType;
	}

	@Override
	public void setSquareType(String squareType) {
		this.squareType = squareType;
	}

	@Override
	public void landedOn(Player p) {
	}

}
