public class Dice {

	private int faceValue;

	public Dice() {
	}

	public int getFaceValue() {
		// creating random numbers between 1 and 6 (included)
		faceValue = (int) (Math.random() * 6 + 1);
		return faceValue;
	}

}
