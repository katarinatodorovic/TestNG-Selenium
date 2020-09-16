import org.testng.Assert;
import org.testng.annotations.Test;

public class AccauntTest {
    @Test
    public void constructorTwoArgument(){
        Account a = new Account("Pera","12345");
        Assert.assertEquals(a.getName(),"Pera");
        Assert.assertEquals(a.getNumber(),"12345");
    }
    @Test
    public void constructorOneArgument(){
        Account a = new Account("Mile");
        Assert.assertEquals(a.getName(),"Mile");
    }
    @Test
    public void testToString(){
        Account a = new Account("Pera","123");
        a.setAmount(555.5);
        Assert.assertEquals(a.toString(),"123 Pera 555,50");}

    @Test
    public void setAmmount(){
        Account a = new Account("Rade");
        a.setAmount(15000.0);
        double amount = a.getAmount();
        Assert.assertEquals(amount,15000.0);
    }


}
