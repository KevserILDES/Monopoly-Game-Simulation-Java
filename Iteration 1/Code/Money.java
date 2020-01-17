public class Money {
	
        private int money;
	
	public Money() {
	    money=1500;
	}
	
	public Money(int amount) {
            if(amount > 0)
                money = amount;
            else
                money=1500;
	}
	
	public void setMoney(int amount) {
            if(amount > 0)
                money = amount;
	}

	public int getMoney() {
	    return money;
	}
	
	public void incMoney(int incAmount) {
    	    money += incAmount;
	}
	
	public void decMoney(int decAmount) {
	    money -= decAmount;
	}
	
	public boolean isBankrupt() {
            if(money < 0 || money == 0)
                return true;
            else    
                return false;
	}
	
}