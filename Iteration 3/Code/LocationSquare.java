
public class LocationSquare extends UtilitySquare {
	private int purchase;
	private int rentAmount;
	private String name;
	private Player owner;
	private String colour;
	private int colourIndex;
	private boolean playerPurchasedSameColorGroup;
	private int houseBuildingPrice;
	private int hotelBuildingPrice;
	private boolean isInc;

	public LocationSquare(String name, int purchase, String colour,int cInd) {
		this.name = name;
		this.purchase = purchase;
		this.colour = colour;
		this.colourIndex=cInd;
		rentAmount = purchase / 5;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
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
		return "Location Square";
	}

	@Override
	public void setSquareType(String squareType) {
		// TODO Auto-generated method stub
	}
	
	public void landedOn(Player p) {
		if (owner != null) {
			if (owner.purchasedSameColorGroup(colourIndex) && !isInc) {
				this.setRentAmount(rentAmount+200);
				System.out.println(owner.get_name()+
						" has all " + this.colour + " locations! The rent of " + this.name + " is incremented by 200 TL!");
				isInc=true;
			}
			takeRent(p);
		}else {
			System.out.println(name + " with " + purchase + " TL, is on sale!");
			if (p.get_money().getMoneyAmount() / p.getPurchasingPossibility() >= purchase) {
				setOwner(p);
				System.out.println(p.get_name() + " bought " + name);
				p.incrementNumOfAUtilityBasedOnColor(colourIndex);
				if (p.purchasedSameColorGroup(colourIndex)) {
					this.setRentAmount(rentAmount+200);
					System.out.println(owner.get_name()+
							" has all " + this.colour + " locations! The rent of " + this.name + " is incremented by 200 TL!");
					
					System.out.println(p.get_name()+ " can build an house to "+ colour+ " color group!");
					// if player has enough money, then he/she will build a house
					if (p.get_money().getMoneyAmount() /2 > houseBuildingPrice) {
						p.buildHouse(colourIndex,houseBuildingPrice);
						this.setRentAmount(rentAmount+1000);
						System.out.println(owner.get_name()+
								" builded a " + this.colour + " house! The rent of " + this.colour + " locations are incremented by 1000 TL!");
						
						// if the player has 3 same colored houses he/she can build a hotel
						if (p.getHouses()[colourIndex].size()==3) {
							
							System.out.println(p.get_name()+ " can build an hotel to "+ colour+ " color group!");
							if (p.get_money().getMoneyAmount() /2 > houseBuildingPrice) {
								p.buildHotel(colourIndex,hotelBuildingPrice);
								this.setRentAmount(rentAmount+500);
								System.out.println(owner.get_name()+
										" builded a " + this.colour + " hotel! The rent of " + this.colour + " locations are incremented by 500 TL!");
								
							}else {
								System.out.println(p.get_name()+ " can not satisfy conditions to build a hotel to "+ colour + " color group.");
							}
							
						}
					}else {
						System.out.println(p.get_name()+ " can not satisfy conditions to build a house to "+ colour+ " color group.");
					}
				}
				
			} else {
				System.out.println(p.get_name() + " can not satisfy conditions to buy " + name);
			}
		}
	}

	public int getHouseBuildingPrice() {
		return houseBuildingPrice;
	}

	public void setHouseBuildingPrice(int houseBuildingPrice) {
		this.houseBuildingPrice = houseBuildingPrice;
	}

	public int getHotelBuildingPrice() {
		return hotelBuildingPrice;
	}

	public void setHotelBuildingPrice(int hotelBuildingPrice) {
		this.hotelBuildingPrice = hotelBuildingPrice;
	}

	public boolean isPlayerPurchasedSameColorGroup() {
		return playerPurchasedSameColorGroup;
	}

	public void setPlayerPurchasedSameColorGroup(boolean playerPurchasedSameColorGroup) {
		this.playerPurchasedSameColorGroup = playerPurchasedSameColorGroup;
	}
	
}
