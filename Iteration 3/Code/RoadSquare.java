
public class RoadSquare extends UtilitySquare {
	private int purchase;
	private int rentAmount;
	private String name;
	private Player owner;

	public RoadSquare(String name, int purchase) {
		this.name = name;
		this.purchase = purchase;
		rentAmount = purchase / 5;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPurchase() {
		return purchase;
	}

	public void setPurchase(int purchase) {
		this.purchase = purchase;
	}

	public int getRentAmount() {
		return rentAmount;
	}

	public void setRentAmount(int rentAmount) {
		this.rentAmount = rentAmount;
	}

	public void setOwner(Player p) {
		owner = p;
		p.get_money().decMoney(purchase);
	}

	public Player getOwner() {
		return owner;
	}

	public void takeRent(Player p) {
		p.get_money().decMoney(rentAmount);
		owner.get_money().incMoney(rentAmount);
		System.out.println(p.get_name() + " gives " + rentAmount + "TL " + "rent amount to " + owner.get_name()
				+ " for " + name + ".");
	}

	@Override
	public String getSquareType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSquareType(String squareType) {
		// TODO Auto-generated method stub

	}

	@Override
	public void landedOn(Player p) {
		if (owner == null) {
			System.out.println(name + " with " + purchase + " TL, is on sale!");
			if (p.get_money().getMoneyAmount() / 2 >= purchase) {
				setOwner(p);
				System.out.println(p.get_name() + " bought " + name);
			} else {
				System.out.println(p.get_name() + " can not satisfy conditions to buy " + name);
			}
		} else {
			if (owner != p)
				takeRent(p);
		}

	}
}
