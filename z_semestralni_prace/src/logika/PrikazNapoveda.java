package logika;

public class PrikazNapoveda implements IPrikaz {
    
    private static final String NAZEV = "pomoc";
    private SeznamPrikazu platnePrikazy;

    public PrikazNapoveda(SeznamPrikazu platnePrikazy) {
        this.platnePrikazy = platnePrikazy;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        return "Tvým úkolem je dovést Červenou Karkulku z domečku\n"
        + "až k babičce, která bydlí v chaloupce za lesem.\n"
        + "\n"
        + "Můžeš zadat tyto příkazy:\n"
        + platnePrikazy.vratNazvyPrikazu();
    }

    @Override
      public String getNazev() {
        return NAZEV;
     }

}
