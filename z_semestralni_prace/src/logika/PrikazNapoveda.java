/**
 * Třída implementující příkaz 'pomoc' pro zobrazení nápovědy ke hře.
 * Zobrazí základní informace o hře a seznam dostupných příkazů.
 */
package logika;

public class PrikazNapoveda implements IPrikaz {

    /** Název příkazu používaný pro jeho vyvolání */
    private static final String NAZEV = "pomoc";

    /** Seznam platných příkazů pro zobrazení v nápovědě */
    private SeznamPrikazu platnePrikazy;

    /**
     * Konstruktor třídy
     *
     * @param platnePrikazy instance třídy obsahující seznam dostupných příkazů
     */
    public PrikazNapoveda(SeznamPrikazu platnePrikazy) {
        this.platnePrikazy = platnePrikazy;
    }

    /**
     * Provede příkaz 'pomoc' - zobrazí úvodní nápovědu a seznam příkazů.
     *
     * @param parametry parametry příkazu (nejsou využity)
     * @return textová nápověda obsahující popis hry a seznam příkazů
     */
    @Override
    public String provedPrikaz(String... parametry) {
        return "Tvým úkolem je dovést Červenou Karkulku z domečku\n"
                + "až k babičce, která bydlí v chaloupce za lesem.\n"
                + "\n"
                + "Můžeš zadat tyto příkazy:\n"
                + platnePrikazy.vratNazvyPrikazu();
    }

    /**
     * Vrací název příkazu
     *
     * @return název příkazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
}