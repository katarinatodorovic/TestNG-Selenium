import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CardsTest {
@BeforeTest
    public Cards object(){
    Cards cards = new Cards();
    return cards;
}
   @Test
    public void winner1(){
        int[]player1 ={10,10,10,10,11};
        int[]player2={5,12,12,12};
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(object().whoIsTheWinner(player1,player2),"Player 1 wins.");
    }
    @Test
    public void winner2(){
        int[]player1 ={4,5,6,6,9};
        int[]player2={5,12,12,12};
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(object().whoIsTheWinner(player1,player2),"Player 2 wins.");
    }
    @Test
    public void tie(){
        int[]player1 ={10,10,10};
        int[]player2={5,12,12,12};
        Assert.assertEquals(object().whoIsTheWinner(player1,player2),"It's a tie.");
    }

}
