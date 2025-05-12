/**
 * Třída implementující příkaz 'poloz' pro pokládání předmětů z batohu do aktuálního prostoru.
 */
package logika;

public class PrikazPoloz implements IPrikaz {
    /** Název příkazu používaný pro jeho vyvolání */
    private static final String NAZEV = "poloz";

    /** Odkaz na herní plán pro manipulaci s prostory a batohu */
    private HerniPlan herniPlan;

    /**
     * Konstruktor třídy
     *
     * @param herniPlan herní plán obsahující informace o prostorách a batohu
     */
    public PrikazPoloz(HerniPlan herniPlan) {
        this.herniPlan = herniPlan;
    }

    /**
     * Provede příkaz 'poloz' - pokládá předmět z batohu do aktuálního prostoru.
     *
     * @param parametry jméno pokládaného předmětu (očekává se jeden parametr)
     * @return textový výsledek provedení příkazu
     */
    @Override
    public String provedPrikaz(String... parametry) {
        Batoh batoh = herniPlan.getBatoh();

        // Kontrola počtu parametrů
        if(parametry.length == 0) {
            return "\nCo mám položit? Musíš zadat jméno věci";
        }

        if(parametry.length > 1) {
            return "\nKaždá věc je jednoslovná a ty jsi toho zadal moc";
        }

        String nazevVeci = parametry[0];

        // Kontrola existence předmětu v batohu
        if(!batoh.obsahujeVec(nazevVeci)) {
            return "\nToto není v batohu";
        }

        // Odebrání předmětu z batohu
        Vec vec = batoh.odeberZBatohu(nazevVeci);

        // Vložení předmětu do aktuálního prostoru
        herniPlan.getAktualniProstor().vlozVec(vec);

        return "\nPoložil jsi " + nazevVeci + " do prostoru " + herniPlan.getAktualniProstor().getNazev();
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