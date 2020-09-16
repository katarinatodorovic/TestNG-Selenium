import java.util.Date;

/*
  # Magacionar [V]
          Magacioner je `Zaposleni` koji ima naziv magacina u kome radi.  naziv magacina moze da se dohvati i postavi
*/
public class Magacioner extends Zaposleni{
    private String nazivMagacina;

    public Magacioner(String naziv, int godRodjenja, Date datumZap) {
        super(naziv, godRodjenja, datumZap);
        oznaka='G';
    }

    public String getNazivMagacina() {
        return nazivMagacina;
    }

    public void setNazivMagacina(String nazivMagacina) {
        this.nazivMagacina = nazivMagacina;
    }
}
