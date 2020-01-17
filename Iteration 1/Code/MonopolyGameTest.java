import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MonopolyGameTest {

	@Test
	void test() throws FileNotFoundException {
		MonopolyGame mnt=new MonopolyGame();
		mnt.play();
		assertEquals(mnt.getBoard().getSquares().size(),40);
		assertSame((Object) mnt.getBoard().getSquares().get(0).getSquareType() ,(Object) new GoSquare(200).getSquareType());
		
		int k=0;
		for(int i=0; i<mnt.getPlayers().size(); i++) {
			if(mnt.getPlayers().get(i).get_money().isBankrupt()) {
				k++;
			}
		}
		Assert.assertEquals(mnt.getPlayers().size()-1, k);
	}

}
