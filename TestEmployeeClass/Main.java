import java.util.Date;

public class Main {
    public static void main(String[] args) {
        /*
            Napraviti sistem klasa koji opisuje jednu firmu:

            # Zaposleni [P]
            Zaposleni ima naziv( string - ime i prezime ), godinu rodjenja i datum kada se zaposlio.
            Naziv se zadaje prilikom kreiranaj i mogucega je dohvatiti i naknadno postaviti.
            Godina rodjenja se zadaje prilikom kreiranja i moguce je samo dohvatiti.
            Datum kada se zaposlio se zadaje prilikom kreiranja i moguce ga je samo dohvatiti.

            # Menadzer [P]
            Menadzer je `Zaposleni` koji ima naziv odeljenja koje vodi. naziv moze da se dohvati i postavi

            # Magacioner [V]
            Magacioner je `Zaposleni` koji ima naziv magacina u kome radi.  naziv magacina moze da se dohvati i postavi

            #

         */

        Date d1= new Date();
        Menadzer men1= new Menadzer("Pera Peric",1997,d1);
        System.out.println(men1.getNaziv());
        Magacioner mag1 = new Magacioner("Jovan Jovanovic",1900,d1);
        mag1.setNazivMagacina("Beorol");
        System.out.println(mag1.getNazivMagacina());
    }
}