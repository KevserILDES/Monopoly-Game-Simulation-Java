public class Piece {

	private String[] pieceArr = { "cat", "dog", "car", "ship", "hat", "ball", "bee", "train" };
	private String pieceName;

	public Piece() {

	}

	public Piece(int pieceNum) {
		this.pieceName = pieceArr[pieceNum];
	}

	public String getPieceName() {
		return pieceName;
	}

	public void setPieceName(int pieceNum) {
		this.pieceName = pieceArr[pieceNum];
	}

}