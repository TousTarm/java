package logika;

/**
 * Třída implementující příkaz 'utok' pro útok na nepřátele a překážky ve hře.
 * Umožňuje hráči útočit na specifické cíle v určitých prostorech.
 * Vyžaduje, aby hráč vlastnil meč.
 */
public class PrikazUtok implements IPrikaz {
    /** Název příkazu používaný pro jeho vyvolání */
    private static final String NAZEV = "utok";

    /** Odkaz na herní plán pro přístup k aktuálnímu prostoru a batohu */
    private HerniPlan herniPlan;

    /** Odkaz na hru pro manipulaci herního stavu */
    private Hra hra;

    /**
     * Konstruktor třídy
     *
     * @param herniPlan herní plán obsahující informace o prostorách
     * @param hra instance hry pro změnu herního stavu
     */
    public PrikazUtok(HerniPlan herniPlan, Hra hra) {
        this.herniPlan = herniPlan;
        this.hra = hra;
    }

    /**
     * Provede příkaz 'utok' - útok na specifické cíle v aktuálním prostoru.
     *
     * @param parametry cíl útoku (očekává se jeden parametr)
     * @return textový výsledek provedení příkazu
     */
    @Override
    public String provedPrikaz(String... parametry) {
        // Kontrola, zda hráč vlastní meč
        if (!herniPlan.getBatoh().obsahujeVec("mec")) {
            return "Nemůžeš útočit bez meče!";
        }

        String aktualniProstor = herniPlan.getAktualniProstor().getNazev();

        // Speciální logika pro dračí sál
        if ("draci_sal".equals(aktualniProstor)) {
            if (parametry.length == 0) {
                return "Na koho chceš zaútočit?\nDostupné cíle: drak";
            }

            if ("drak".equalsIgnoreCase(parametry[0])) {
                if (hra.isSwordEnchanted()) {
                    // Úspěšný útok na draka
                    hra.setDragonAlive(false);
                    herniPlan.getDraciDoupe().setPopis(
                            ", jen o vlásek jsi utekl z dračího sálu, " +
                                    "který se celý zřítil a draka zaživa pohřbil. " +
                                    "Goblini se vrací zpět zjistit co se stalo.");
                    herniPlan.getLesniCesta().setPopis(
                            ", goblini si všimli tvého útoku a běží směrem k tobě, " +
                                    "je jich ale příliš mnoho.");
                    return "Drakova hlava dopadá na zem po jednom hbitém zásahu. " +
                            "Celá místnost se začala třást, jeskyně se může zřítit.";
                } else {
                    return "Tvůj obyčejný meč draka neporanil! Potřebuješ magické vylepšení!";
                }
            }
            return "Neplatný cíl.";
        }

        // Speciální logika pro dračí doupě
        if ("draci_doupe".equals(aktualniProstor)) {
            if (parametry.length == 0) {
                return "Na koho chceš zaútočit?\nDostupné cíle: zamek";
            }

            if ("zamek".equalsIgnoreCase(parametry[0])) {
                herniPlan.openDragonsDoor();
                return "Rychlým švihem jsi zámek přesek vejpůl a dveře se rozletěly.";
            }
            return "Neplatný cíl.";
        }

        return "Zde není na koho útočit.";
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