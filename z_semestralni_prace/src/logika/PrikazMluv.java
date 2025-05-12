/**
 * Implementace příkazu 'mluv' pro komunikaci s postavami (NPC) v aktuální místnosti.
 * Tento příkaz umožňuje interakci s nehratelnými postavami v prostoru.
 */
package logika;

public class PrikazMluv implements IPrikaz {
    /** Název příkazu - používá se pro identifikaci */
    private static final String NAZEV = "mluv";

    /** Odkaz na herní plán pro získání aktuálního prostoru */
    private HerniPlan plan;

    /** Odkaz na hru pro možnost ovlivnění herního stavu */
    private Hra hra;

    /**
     * Konstruktor třídy
     *
     * @param plan herní plán obsahující prostory s NPC
     * @param hra instance hry pro možnost spouštění akcí NPC
     */
    public PrikazMluv(HerniPlan plan, Hra hra) {
        this.plan = plan;
        this.hra = hra;
    }

    /**
     * Provede příkaz mluv - komunikuje s NPC v aktuální místnosti.
     * Pokud v místnosti není žádné NPC, vrátí chybové hlášení.
     * Jinak spustí akci NPC (pokud existuje) a vrátí jeho zprávu.
     *
     * @param parametry parametry příkazu (nejsou využity)
     * @return výsledek provedení příkazu - zpráva NPC nebo chybové hlášení
     */
    @Override
    public String provedPrikaz(String... parametry) {
        Prostor aktualniProstor = plan.getAktualniProstor();
        Npc npc = aktualniProstor.getNpc();

        // Kontrola přítomnosti NPC v místnosti
        if (npc == null) {
            return ", v místnosti nikdo není, proč mluvíš sám se sebou?";
        }

        // Spuštění akce NPC, pokud je definována
        if (npc.getAction() != null) {
            npc.getAction().accept(hra);
        }

        return npc.getZprava();
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