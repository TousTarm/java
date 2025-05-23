/**
 * Třída implementující příkaz 'seber' pro sbírání předmětů z aktuálního prostoru do batohu.
 * Umožňuje hráči sebrat předmět z místnosti, pokud je přenositelný a batoh má volnou kapacitu.
 * Speciální případ: při sebrání mapy odemkne nové cesty ve hře.
 */
package logika;

public class PrikazSeber implements IPrikaz {
    /** Název příkazu používaný pro jeho vyvolání */
    private static final String NAZEV = "seber";

    /** Odkaz na herní plán pro manipulaci s prostory a batohu */
    private HerniPlan herniPlan;

    /**
     * Konstruktor třídy
     *
     * @param herniPlan herní plán obsahující informace o prostorách a batohu
     */
    public PrikazSeber(HerniPlan herniPlan) {
        this.herniPlan = herniPlan;
    }

    /**
     * Provede příkaz 'seber' - pokusí se sebrat předmět z aktuálního prostoru do batohu.
     *
     * @param parametry jméno sbíraného předmětu (očekává se jeden parametr)
     * @return textový výsledek provedení příkazu
     */
    @Override
    public String provedPrikaz(String... parametry) {
        // Kontrola počtu parametrů
        if (parametry.length == 0) {
            return "\nCo mám sebrat? Musíš zadat jméno věci";
        }

        if (parametry.length > 1) {
            return "\nKaždá věc je jednoslovná a ty jsi toho zadal moc";
        }

        String nazevVeci = parametry[0];
        Prostor aktualniProstor = herniPlan.getAktualniProstor();

        // Kontrola existence předmětu v prostoru
        if (aktualniProstor.obsahujeVec(nazevVeci)) {
            Vec pozadovanaVec = aktualniProstor.vyberVec(nazevVeci);

            // Kontrola přenositelnosti předmětu
            if (pozadovanaVec == null) {
                return "\n" + nazevVeci + " nedá se přenést";
            } else {
                // Pokus o vložení do batohu
                boolean povedloSeVlozit = herniPlan.getBatoh().vlozitDoBatohu(pozadovanaVec);

                if (povedloSeVlozit) {
                    // Speciální akce pro sebrání mapy
                    if ("mapa".equalsIgnoreCase(nazevVeci)) {
                        herniPlan.najdesMapu(); // Odemkne nové cesty
                    }
                    return "\n" + nazevVeci + " jsi vložil do batohu";
                } else {
                    return "\n" + nazevVeci + " se nepodařilo vložit do batohu. Je již plný";
                }
            }
        } else {
            return "\n" + nazevVeci + " není v prostoru";
        }
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