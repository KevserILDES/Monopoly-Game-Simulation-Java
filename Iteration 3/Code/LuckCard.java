
public class LuckCard extends Card {

	private int amount;

	public LuckCard(int amount) {
		this.amount = amount;
	}

	@Override
	public void takenCard(Player p) {
		System.out.println(p.get_name() + " took a luck card and earned " + amount + "TL.");
		p.get_money().incMoney(amount);
	}

}
