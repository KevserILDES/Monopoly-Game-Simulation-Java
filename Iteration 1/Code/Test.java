import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		Board board;
		ArrayList<Player> players;

		Scanner in = new Scanner(new File("input.txt"));
		int playerNum = in.nextInt();
		String playerName[] = new String[playerNum];
		for (int i = 0; i < playerNum; i++) {
			playerName[i] = in.next();
		}
		int playerMoney = in.nextInt();
		int goSquareMoney = in.nextInt();
		int taxSquareNum = in.nextInt();
		int taxMoney = in.nextInt();
		
		System.out.println(playerNum + " " + playerName[0]+ " "  + playerName[1] + " " + playerName[2] + " " + playerMoney + " "
				+ goSquareMoney + " " + taxSquareNum + " " + taxMoney);
		

		board = new Board(taxSquareNum, taxMoney,goSquareMoney);
		
		Dice[] dices = new Dice[2];
		dices[0] = new Dice();
		dices[1] = new Dice();
		players = new ArrayList<Player>();

		int totalDice[][] = new int[playerNum][2];
		int diceArr[] = new int[2];
		
		for (int i = 0; i < playerNum; i++) {
			// String name, int playerNum, int moneyAmount, int goSquareMoney, int turn, Piece piece
			players.add(new Player(playerName[i], i, playerMoney, goSquareMoney, 0, null));
			totalDice[i][0] = i;
			totalDice[i][1] = players.get(i).rollDice(dices);
			diceArr = players.get(i).getDiceValue();
			System.out.println("Dice values are: " + diceArr[0] + ", " + diceArr[1] + " . Total : " + totalDice[i][1]);
		}

		for (int i = 0; i < playerNum; ++i) {
			int key = totalDice[i][1];
			System.out.println("key :"+ key);
			
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
		
		for (int i = 0; i < playerNum; ++i) {
			players.get(i).setPlayerOrder(totalDice[i][0]);
			System.out.println(totalDice[i][0] + "  " + totalDice[i][1]);
		}
		
		
		
		for (int i = 0; i < players.size(); i++) {
			System.out.println("Player name: "+ players.get(i).get_name()+ " Player's order: "+ players.get(i).get_playerOrder());
		}
		
		// Sort players according to their orders
		Collections.sort(players);
		
		for (int i = 0; i < players.size(); i++) {
			System.out.println("Player name: "+ players.get(i).get_name()+ " Player's order: "+ players.get(i).get_playerOrder());
		}
		
		int cycleCount = 1;
		int ix=0;
		
		int isEnd = 1;
		int numberOfPlayers=playerNum;
		int a=-1;
		while (isEnd != numberOfPlayers) {
			System.out.println("=========================================================");
			System.out.println("ITERATION: " + cycleCount);

			for (int i = 0; i < /*players.size()*/playerNum; i++) {
				
				System.out.println("---------------------------------------------------------");
				// before dice
				System.out.println("Turn: " + (i + 1) + "\nPlayer: " + players.get(i).get_name() + "\nLocation:\t  Square "
						+ players.get(i).getCurrentIndex() + "\nmoney: "  + players.get(i).get_money().getMoney());
				
				
				// after dice
				totalDice[i][0] = i;//????????? buradaki amaç nedir?
				totalDice[i][1] = players.get(i).rollDice(dices);
				diceArr = players.get(i).getDiceValue();
				
				
				//if the square that the current user came is a tax square withdraw money from him/her
				if(board.getASquare(players.get(i).setSquareIndex(totalDice[i][1])) instanceof TaxSquare) {
					players.get(i).withdraw(taxMoney);
				}
				
				System.out.println("Dice values are: " + diceArr[0] + " " + diceArr[1] + "\nTotal: " + totalDice[i][1]
						+ "\nCurrent location: Square " + players.get(i).getCurrentIndex() + "\nmoney: "  + players.get(i).get_money().getMoney());
				
				if (players.get(i).get_money().isBankrupt()) {
					System.out.println(players.get(i).get_name()+" is bankrupt. This player is out of game now.");
					a=i;
					
				}
			}
			if(a!=-1) {
			players.remove(a);
			isEnd++;
			playerNum--;
			a=-1;
			}

			cycleCount++;
			ix++;
		}
		String winner=players.get(0).get_name();
		System.out.println("\n\\(^o^)/ \\(^o^)/ The winner of the game is " + winner + ". Congratulations " + winner+". \\(^o^)/ \\(^o^)/");
		players.get(0).printInfo();
	}
}
