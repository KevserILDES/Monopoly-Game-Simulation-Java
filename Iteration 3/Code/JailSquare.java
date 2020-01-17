
public class JailSquare extends Square {

	private int jailMoney;

	public JailSquare(int jAmount) {
		this.squareType = "JailSquare";
		jailMoney = jAmount;
	}

	public int getJailMoney() {
		return this.jailMoney;
	}

	public void setJailMoney(int jailMoney) {
		this.jailMoney = jailMoney;
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
		// TODO Auto-generated method stub
		System.out.println("This is a JAIL square!");
		p.setJail(true);
	}

}
