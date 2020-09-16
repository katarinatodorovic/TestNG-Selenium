import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class BankTest {
    /*Potrebno je napraviti test za ispravnost klase Bank. Za sve testove potrebno
je napraviti jedinstvenu banku koja se na početku testa resetuje. Smatrati da
 ova banka ne može da ima nalog kod kojeg je stanje negativno. Ako se na osnovu
  testova nađe neka greška u kodu potrebno jej da se popravi originalni kod.

Potrebno je ispitati da li adekvatno radi otvaranje naloga, tako što će se
 ubaciti 5 naloga i zatim ispitati da li se ti nalozi mogu dohvatiti.
Proveriti da li dobro radi metoda za uplatu novca.
Proveriti da li dobro radi metoda za transfer novca.
Proveriti da li dobro radi metoda za računanje ukupnog novca u banci (getSumMoney).
*/
    private Bank myBank;
    @BeforeClass

    public void init() {
    myBank = new Bank();
    }

    @BeforeMethod
    public void resetBeforeEveryTestCase() {
        myBank.reset();

    }
    @Test
    public void getSume(){
        double sum = myBank.getSumMoney();
        Assert.assertEquals(sum,0);
    }
    @Test
    public void openAccountFive(){
        Account[] accounts = new Account[5];
        for (int i =0;i<5;i++){
            Account a = myBank.openAccount("New accounts"+i);
            accounts[i]=a;
        }

        for (int j = 0;j<accounts.length;j++){
            if (accounts[j].getNumber().equals(myBank.getAccount(accounts[j].getNumber()))){
                System.out.println("Get account");
            }
        }
    }
    @Test
    public void sumTotal(){
        Account  a = myBank.openAccount("Ana");
        Account c = myBank.openAccount("Milica");
        Account e = myBank.openAccount("Ljubica");
        a.setAmount(1000.0);
        c.setAmount(2000.0);
        e.setAmount(3000.0);

        double sum =6000;//
        double sumTotal = myBank.getSumMoney();
        Assert.assertEquals(sumTotal,sum);
        Assert.assertEquals((Object) myBank.getSumMoney(),(Object) 6000.0);

        /* SoftAssert sa = new SoftAssert();
        sa.assertEquals(myBank.getSumMoney(),6000.0);
        sa.assertAll();*/
    }
    @Test
    public void payInMoney(){
        Account account1 = myBank.openAccount("MIle");
        String accountNumberFrom= myBank.getAccount(account1.getNumber()).getNumber();
        myBank.payInMoney(accountNumberFrom,9000.0);


        Account account2 = myBank.openAccount("Paja");
        String accountNumberTo= myBank.getAccount(account2.getNumber()).getNumber();
        myBank.payInMoney(accountNumberTo,57000.0);

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(account1.getAmount(),9000.0);
        sa.assertEquals(account2.getAmount(),57000.0);
        sa.assertAll();

    }
   @Test
    public void transferMoney(){
        Account from = myBank.openAccount("Djordje");
        String accountNumberFrom= myBank.getAccount(from.getNumber()).getNumber();
        myBank.payInMoney(accountNumberFrom,10000.0);


        Account to = myBank.openAccount("Ljubisa");
        String accountNumberTo= myBank.getAccount(to.getNumber()).getNumber();
        myBank.payInMoney(accountNumberTo,5000.0);

       myBank.transferMoney(accountNumberFrom,accountNumberTo,5000.0);

       SoftAssert sa = new SoftAssert();
       sa.assertEquals(from.getAmount(),5000.0);
       sa.assertEquals(to.getAmount(),10000.0);
       sa.assertAll();


    }
    @Test
    public void open100Accounts(){

        Account[] accounts = new Account[100];
    //    ArrayList<Account> racuni =new ArrayList<>();//moze sa nizom
        for (int i = 0;i<accounts.length;i++){
            Account a = myBank.openAccount("Mica" +i);
           accounts[i] = a;
        }
        boolean isJednako=true;
        for (int j = 0;j<accounts.length-1;j++){//bolje da sa 2 petlje za svaki sluvaj da proverava svaki sa svakim
            if (accounts[j]==accounts[j+1]){
                isJednako =false;
            }
        }
        Assert.assertEquals(isJednako,true);
    }
}

