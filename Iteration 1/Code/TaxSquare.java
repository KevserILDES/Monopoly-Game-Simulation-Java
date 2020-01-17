
public class TaxSquare extends Square {

	private String squareType;
	private int taxAmount;

	public TaxSquare(int taxAmount) {
		this.taxAmount = taxAmount;
		this.squareType="TaxSquare";
	}

	public int getTaxAmount() {
		return this.taxAmount;
	}

	public void setTaxAmount(int taxAmount) {
		this.taxAmount = taxAmount;
	}

	@Override
	public void setSquareType(String squareType) {
		// TODO Auto-generated method stub
		this.squareType=squareType;
	}

	@Override
	public String getSquareType() {
		// TODO Auto-generated method stub
		return this.squareType;
	}

}
