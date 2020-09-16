
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Date;

public class ZaposleniTest {

        @BeforeClass()
        public void preKlase(){
            System.out.println("Ovo ide pre klase.");
        }

        @AfterClass()
        public void posleKlase(){
            System.out.println("Ovo ide posle klase.");
        }

        @BeforeGroups(groups = "Testiranje klasa Zaposleni")
        public void preGrupe()
        {
            System.out.println("Pre grupe Testiranje klase Zaposleni.");
        }

        @Test(groups = " Testiranje klasa Zaposleni")
        public void testKonstruktora(){
            Date datum = new Date();
            Zaposleni zaposleni = new Zaposleni("Stevan", 1988, datum);
            Assert.assertEquals(zaposleni.getNaziv(), "Stevan");
            Assert.assertEquals(zaposleni.getGodRodjenja(), 1988);
            Assert.assertEquals(zaposleni.getDatumZap(), datum);
        }

        @Test(groups=" Testiranje klasa Zaposleni")
        public void testSetNaziv(){
            Zaposleni zaposleni = new Zaposleni("Paja", 1968, new Date(2012, 3, 25));
            zaposleni.setNaziv("Djordje");
            Assert.assertEquals(zaposleni.getNaziv(), "Djordje");
            Assert.assertEquals(zaposleni.getDatumZap(), new Date(2012, 3, 25));
        }
        @AfterGroups(groups = "Testiranje klase Zaposleni")
        public void posleGrupe () {
            System.out.println("Zavrsena grupa.");
        }
    }






