
public abstract class UtilitySquare extends Square {

	public abstract String getName();

	public abstract void setName(String name);

	public abstract int getPurchase();

	public abstract void setPurchase(int purchase);

	public abstract int getRentAmount();

	public abstract void setRentAmount(int rentAmount);

	public abstract void setOwner(Player p);

	public abstract Player getOwner();

	public abstract void takeRent(Player p);

	@Override
	public abstract void landedOn(Player p);
}
