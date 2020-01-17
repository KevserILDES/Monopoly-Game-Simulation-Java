import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MonopolyGame {
	private Board board;
	private ArrayList<Player> players;

	@SuppressWarnings("unused")
	public void play() throws FileNotFoundException {
		System.out.println("Enjoy the game :)\n");

		@SuppressWarnings("resource")
		Scanner in = new Scanner(new File("input.txt"));
		int playerNum = in.nextInt();
		String playerName[] = new String[playerNum];
		int[] playersPurchasingPossibility= new int[playerNum];
		for (int i = 0; i < playerNum; i++) {
			playerName[i] = in.next();
			playersPurchasingPossibility[i] = in.nextInt();
		}
		int playerMoney = in.nextInt();
		int goSquareMoney = in.nextInt();
		int taxSquareNum = in.nextInt();
		int taxMoney = in.nextInt();
		int gotoJailNum = in.nextInt();
		int jailAmount = in.nextInt();
		int taxCardNum = in.nextInt();
		int taxCardAmount = in.nextInt();
		int luckCardNum = in.nextInt();
		int luckCardAmount = in.nextInt();
		int goToJailCardNum = in.nextInt();
		int cardSquareNum = in.nextInt();
		int RoadSquareNum = in.nextInt();
		board = new Board(taxSquareNum, gotoJailNum, taxMoney, jailAmount, goSquareMoney, cardSquareNum, taxCardNum,
				luckCardNum, goToJailCardNum, taxCardAmount, luckCardAmount, RoadSquareNum);

		Dice[] dices = new Dice[2];
		dices[0] = new Dice();
		dices[1] = new Dice();
		players = new ArrayList<Player>();

		int totalDice[][] = new int[playerNum][2];
		int diceArr[] = new int[2];

		for (int i = 0; i < playerNum; i++) {
			players.add(new Player(playerName[i], i, playerMoney, goSquareMoney, 0, null));
			players.get(i).setPurchasingPossibility(playersPurchasingPossibility[i]);
			players.get(i).setNumOfCol(board);
			totalDice[i][0] = i;
			System.out.print("Player: " + players.get(i).get_name() + ". ");
			players.get(i).rollDice(dices);

			totalDice[i][1] = players.get(i).getTotalDice();
			diceArr = players.get(i).getDiceValue();

		}

		// insertion sort
		for (int i = 0; i < playerNum; ++i) {
			int key = totalDice[i][1];

			int j = i - 1;

			while (j >= 0 && totalDice[j][1] > key) {
				totalDice[j + 1][1] = totalDice[j][1];
				int temp = totalDice[j + 1][0];
				totalDice[j + 1][0] = totalDice[j][0];
				totalDice[j][0] = temp;
				j = j - 1;
			}
			totalDice[j + 1][1] = key;
		}

		for (int i = 0, j = playerNum - 1; i < playerNum & j >= 0; i++, j--) {
			players.get(totalDice[j][0]).setPlayerOrder(i);
		}

		// Sort players according to their orders
		Collections.sort(players);

		for (int i = 0; i < players.size(); i++) {
			System.out.print("\nPlayer name: " + players.get(i).get_name() + ". Player's order: "
					+ (players.get(i).get_playerOrder() + 1));
		}

		int cycleCount = 1;

		int isEnd = 1;
		int numberOfPlayers = playerNum;
		int a = -1;

		while (isEnd != numberOfPlayers) {
			System.out.println("\n=========================================================");
			System.out.println("ITERATION: " + cycleCount);

			for (int i = 0; i < /* players.size() */playerNum; i++) {

				System.out.println("---------------------------------------------------------");
				// before dice
				System.out.println("Turn: " + (i + 1) + "\nPlayer: " + players.get(i).get_name()
						+ "\nLocation:\t  Square " + (players.get(i).getCurrentIndex() + 1) + "\nMoney: "
						+ players.get(i).get_money().getMoneyAmount());

				// after dice
				totalDice[i][0] = i;
				players.get(i).rollDice(dices);
				totalDice[i][1] = players.get(i).getTotalDice();
				diceArr = players.get(i).getDiceValue();

				players.get(i).setSquareIndex(board);

				System.out.println("Current money: " + players.get(i).get_money().getMoneyAmount());

				if (players.get(i).get_money().isBankrupt()) {
					System.out.println(players.get(i).get_name() + " is bankrupt. This player is out of game now.");
					a = i;
				}
			}

			if (a != -1) {
				players.remove(a);
				isEnd++;
				playerNum--;
				a = -1;
			}

			cycleCount++;
		}
		String winner = players.get(0).get_name();
		System.out.println("\n\\(^o^)/ \\(^o^)/ The winner of the game is " + winner + ". Congratulations " + winner
				+ ". \\(^o^)/ \\(^o^)/");
		players.get(0).printInfo();
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public Board getBoard() {
		return board;
	}

}
