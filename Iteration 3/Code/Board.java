import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Board {

	private ArrayList<Square> squares;
	private ArrayList<Card> cards;
	private int jIndex;
	private int cIndex;
	private ArrayList<String> colors;
	private int[] colorArr;
	//private int[] houseBuildingPrices;
	//private int[] hotelBuildingPrices;

	@SuppressWarnings("resource")
	public Board(int numberOfTaxSquares, int numberOfGotoJailSquares, int taxAmount, int jAmount, int goAmount,
			int numberOfCardSquare, int taxCardNum, int luckCardNum, int goToJailCardNum, int taxCardAmount,
			int luckCardAmount, int roadSquareNum) throws FileNotFoundException {
		Scanner in = new Scanner(new File("input2.txt"));
		Scanner in2 = new Scanner(new File("input3.txt"));
		
		//houseBuildingPrices=new int[5];
		//hotelBuildingPrices=new int[5];
		
		squares = new ArrayList<Square>();

		colors = new ArrayList<String>();
		colors.add("pink");
		colors.add("blue");
		colors.add("red");
		colors.add("yellow");
		colors.add("green");
		
		colorArr = new int[5];
		for (int a = 0;  a < 5; a++) {
			//System.out.println(colors.get(a));
		}
		// int pNum,bNum,rNum,yNum,gNum;
		int rand;
		int locationSquareNum = 40 - numberOfTaxSquares - numberOfGotoJailSquares - numberOfCardSquare - roadSquareNum - 2;
		squares.add(0, new GoSquare(goAmount));
		int div = locationSquareNum / 5;
		for (int i = 0; i < 5; i++) {
			colorArr[i] = div;
		}
		int mod = locationSquareNum % 5;
		int col = 0;
		while (mod > 0) {
			colorArr[col]++;
			mod--;
			col++;
		}
		/*
		for(int h=0;h<5;h++) {
			System.out.println("* "+colArr[h]);
		}
		*/
		LocationSquare locnSquare=new LocationSquare(null, 0, null, 0);
		col = 0;
		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < colorArr[col]; i++) {

				if (j != 0) {
					rand = (int) (Math.random() * (colorArr[col]) + 1);
				} else {
					rand = i;
				}
				String name=in.next();
				int rentAmount=in.nextInt();
				locnSquare=new LocationSquare(name, rentAmount, colors.get(j), j);
				locnSquare.setHouseBuildingPrice(rentAmount);
				locnSquare.setHotelBuildingPrice(rentAmount*2);
				squares.add(rand, locnSquare);
				//houseBuildingPrices[j]+=rentAmount;
			}
			/*
			houseBuildingPrices[j]/=colorArr[col];
			locnSquare.setHouseBuildingPrice((int)houseBuildingPrices[j]);
			
			hotelBuildingPrices[j]=3*houseBuildingPrices[j];
			locnSquare.setHotelBuildingPrice((int)hotelBuildingPrices[j]);
			*/
			col++;
		}

		
		for (int i = 0; i < roadSquareNum; i++) {
			rand = (int) (Math.random() * (locationSquareNum-1)  + 1);
			squares.add(rand, new RoadSquare(in2.next(), in2.nextInt()));
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
		/*
		for (int j = 0; j < squares.size(); j++) {
			System.out.println(squares.get(j).getSquareType());
		}
		*/
		
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
	
	public ArrayList<String> getColors() {
		return this.colors;
	}

	public void setColors(ArrayList<String> colors) {
		this.colors = colors;
	}

	public int[] getColorArr() {
		return this.colorArr;
	}

	public void setColArr(int[] colArr) {
		this.colorArr = colArr;
	}
	
	public Card getACard() {
		return this.cards.get(cIndex++ % cards.size());
	}

	public void setACard(Card card, int index) {
		this.cards.set(index, card);
	}



}
