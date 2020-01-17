import java.util.ArrayList;

public class Board {

	private ArrayList<Square> squares;

	public Board(int numberOfTaxSquares, int taxAmount, int goAmount) {

		squares = new ArrayList<Square>();

		squares.add(0, new GoSquare(goAmount));

		for (int i = 1; i < 40 - numberOfTaxSquares; i++) {
			squares.add(i, new RegularSquare());
		}

		for (int i = 0; i < numberOfTaxSquares; i++) {
			int rand = (int) (Math.random() * (40 - numberOfTaxSquares) + 1);
			squares.add(rand, new TaxSquare(taxAmount));
		}

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

}
