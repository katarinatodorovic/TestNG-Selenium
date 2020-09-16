import java.util.Date;

/*
# Menadzer [P]
        Menadzer je `Zaposleni` koji ima naziv odeljenja koje vodi. naziv moze da se dohvati i postavi
*/
public class Menadzer extends Zaposleni {
    private String nazivOdeljenja;

    public Menadzer(String naziv, int godRodjenja, Date datumZap) {
        super(naziv, godRodjenja, datumZap);
        oznaka='M';
    }

    public String getNazivOdeljenja() {
        return nazivOdeljenja;
    }

    public void setNazivOdeljenja(String nazivOdeljenja) {
        this.nazivOdeljenja = nazivOdeljenja;
    }


}