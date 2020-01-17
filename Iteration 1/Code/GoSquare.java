
public class GoSquare extends Square {

	private String squareType;
	private int passingMoney;

	public GoSquare(int passingMoney) {
		this.passingMoney = passingMoney;
		this.squareType="GoSquare";
	}

	public int get_passingMoney() {
		return passingMoney;
	}

	public void set_passingMoney(int passingMoney) {
		this.passingMoney = passingMoney;
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
