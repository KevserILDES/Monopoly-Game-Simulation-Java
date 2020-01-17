
public abstract class Building extends Square{
	private int purchase;
	private int rentAmount;
	private String name;
	private Player owner;
	private String color;

	
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
		System.out.println(
				p.get_name() + " gives " + rentAmount + "TL " + "rent amount to " + owner.get_name() + " for " + name  + "." );
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
