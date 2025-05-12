/**
 * Třída implementující příkaz 'skryj_se' pro skrytí postavy ve hře.
 * Umožňuje hráči skrýt se před nepřáteli a spouští speciální události v určitých prostorech.
 * Obsahuje statické metody pro správu stavu viditelnosti postavy.
 */
package logika;

public class PrikazSkryjSe implements IPrikaz {
    /** Název příkazu používaný pro jeho vyvolání */
    private static final String NAZEV = "skryj_se";

    /** Statický indikátor stavu viditelnosti postavy (true = viditelný, false = skrytý) */
    private static boolean odhalen = true;

    /** Odkaz na herní plán pro přístup k aktuálnímu prostoru a jeho vlastnostem */
    private HerniPlan herniPlan;

    /**
     * Konstruktor třídy
     *
     * @param herniPlan herní plán obsahující informace o aktuálním prostoru
     */
    public PrikazSkryjSe(HerniPlan herniPlan) {
        this.herniPlan = herniPlan;
    }

    /**
     * Provede příkaz 'skryj_se' - skryje postavu a spouští případné speciální události.
     *
     * @param parametry parametry příkazu (nejsou využity)
     * @return textový výsledek provedení příkazu
     */
    @Override
    public String provedPrikaz(String... parametry) {
        odhalen = false;

        // Speciální událost v prostoru "draci_doupe" s aktivním gobliním eventem
        if ("draci_doupe".equals(herniPlan.getAktualniProstor().getNazev()) &&
                herniPlan.getAktualniProstor().isGoblinEventActive()) {
            herniPlan.getAktualniProstor().resolveGoblinEvent();
            return "\nSchoval ses! Goblinové tě přehlédli a odcházejí pryč. " +
                    "Jeden z nich však stihl zamknout dveře k drakovi, možná půjde zámek zničit.";
        }

        return "Úspěšně ses skryl. Nyní jsi neviditelný.";
    }

    /**
     * Vrací aktuální stav viditelnosti postavy
     *
     * @return true pokud je postava viditelná, false pokud je skrytá
     */
    public static boolean jeOdhalen() {
        return odhalen;
    }

    /**
     * Odhalí skrytou postavu
     *
     * @return true pokud byla postava skrytá a nyní byla odhalena, 
     *         false pokud již byla viditelná
     */
    public static boolean odhalit() {
        if (!odhalen) {
            odhalen = true;
            return true;
        }
        return false;
    }

    /**
     * Statická metoda vracející název příkazu
     *
     * @return název příkazu
     */
    public static String getNazevStatic() {
        return NAZEV;
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