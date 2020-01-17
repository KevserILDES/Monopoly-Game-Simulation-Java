public class Player implements Comparable {

	private String name;
	private Piece piece;
	private Money money;
	private int playerNum;
	private int playerOrder;
	private int turn;
	private int[] diceValue;
	private int currentIndex = 0;
	private int passMoneyAmount;

	public Player() {

	}

	public Player(String name, int playerNum, int moneyAmount, int passMoneyAmount, int turn, Piece piece) {
		this.name = name;
		this.playerNum = playerNum;
		this.turn = turn;
		this.passMoneyAmount = passMoneyAmount;
		money = new Money(moneyAmount);
		piece = new Piece(this.playerNum);
		diceValue = new int[2];
	}

	public void withdraw(int amount) {
		this.money.decMoney(amount);
	}

	public Piece get_piece() {
		return piece;
	}

	public String get_name() {
		return name;
	}

	public int get_turn() {
		return turn;
	}

	public void set_turn(int turn) {
		this.turn = turn;
	}

	public Money get_money() {
		return this.money;
	}

	public void set_money(int money) {
		this.money.setMoney(money);
	}

	public int get_playerOrder() {
		return playerOrder;
	}

	public void setPlayerOrder(int playerOrder) {
		this.playerOrder = playerOrder;
	}

	public int getCurrentIndex() {
		return currentIndex;
	}

	public int setSquareIndex(int diceValue) {

		int newCurrentIndex = (currentIndex + diceValue) % 40;

		if (newCurrentIndex < currentIndex) { // if the new index is less than the old index
												// then this means the user passed from the go square
			this.money.incMoney(passMoneyAmount);
			System.out.println(this.name + " has passed from the GO square");

		}
		currentIndex = newCurrentIndex;
		return currentIndex;
	}

	public int[] getDiceValue() {
		return diceValue;
	}

	public int rollDice(Dice[] dice) {
		diceValue[0] = dice[0].getFaceValue();
		diceValue[1] = dice[1].getFaceValue();
		return diceValue[0] + diceValue[1];
	}

	@Override
	public int compareTo(Object comparedPlayer) {
		int compareOrder = ((Player) comparedPlayer).get_playerOrder();
		/* For Ascending order */
		return this.playerOrder - compareOrder;
	}

	public void printInfo() {
		System.out.println("The name of the player is: " + name);
		System.out.println("The amount of money: " + money.getMoney());
		System.out.println("The square index of the user: " + this.getCurrentIndex());
	}

}
