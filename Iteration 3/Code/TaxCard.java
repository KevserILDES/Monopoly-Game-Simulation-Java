
public class TaxCard extends Card{

	private int amount; 
	
	public TaxCard(int amount) {
		this.amount = amount;
	}
	
	@Override
	public void takenCard(Player p) {
		System.out.println(p.get_name() + " took a tax card and lost " + amount + "TL.");
		p.get_money().decMoney(amount);
		
	}

}
