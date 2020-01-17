import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Board {

	private ArrayList<Square> squares;
	private ArrayList<Card> cards;
	private int jIndex;
	private int cIndex;

	@SuppressWarnings("resource")
	public Board(int numberOfTaxSquares, int numberOfGotoJailSquares, int taxAmount, int jAmount, int goAmount,
			int numberOfCardSquare, int taxCardNum, int luckCardNum, int goToJailCardNum, int taxCardAmount,
			int luckCardAmount) throws FileNotFoundException {
		Scanner in = new Scanner(new File("utilities.txt"));

		squares = new ArrayList<Square>();
		int rand;

		squares.add(0, new GoSquare(goAmount));
		for (int i = 1; i < (40 - numberOfTaxSquares - numberOfGotoJailSquares - numberOfCardSquare - 1); i++) {
			squares.add(i, new UtilitySquare(in.next(), in.nextInt()));
		}

		for (int i = 0; i < numberOfTaxSquares; i++) {
			rand = (int) (Math.random() * (40 - numberOfTaxSquares - numberOfGotoJailSquares - numberOfCardSquare - 1)
					+ 1);
			squares.add(rand, new TaxSquare(taxAmount));
		}

		for (int i = 0; i < numberOfGotoJailSquares; i++) {
			rand = (int) (Math.random() * (40 - numberOfGotoJailSquares - numberOfCardSquare - 1) + 1);
			squares.add(rand, new GoToJailSquare());
		}

		for (int i = 0; i < numberOfCardSquare; i++) {
			rand = (int) (Math.random() * (40 - numberOfCardSquare - 1) + 1);
			squares.add(rand, new CardSquare());
		}

		rand = (int) (Math.random() * 40 + 1);
		jIndex = rand;
		squares.add(rand, new JailSquare(jAmount));

		cards = new ArrayList<Card>();

		for (int i = 0; i < taxCardNum; i++) {
			cards.add(i, new TaxCard(taxCardAmount));
		}

		for (int i = 0; i < luckCardNum; i++) {
			rand = (int) (Math.random() * taxCardNum + 1);
			cards.add(i, new LuckCard(luckCardAmount));
		}

		for (int i = 0; i < goToJailCardNum; i++) {
			rand = (int) (Math.random() * (luckCardNum + taxCardNum) + 1);
			cards.add(i, new GoToJailCard());
		}

	}

	public int getJailIndex() {
		return jIndex;
	}

	public int getCardIndex() {
		return cIndex;
	}

	public ArrayList<Square> getSquares() {
		return this.squares;
	}

	public void setSquares(ArrayList<Square> squares) {
		this.squares = squares;
	}

	public Square getASquare(int index) {
		return this.squares.get(index);
	}

	public void setASquare(Square square, int index) {
		this.squares.set(index, square);
	}

	public ArrayList<Card> getCards() {
		return this.cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

	public Card getACard() {
		return this.cards.get(cIndex++ % cards.size());
	}

	public void setACard(Card card, int index) {
		this.cards.set(index, card);
	}

}
