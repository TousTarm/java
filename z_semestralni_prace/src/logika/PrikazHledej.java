package logika;

/**
 * Třída představuje příkaz 'hledej', který umožňuje hráči hledat skryté předměty v aktuálním prostoru.
 */
public class PrikazHledej implements IPrikaz {

    // Název příkazu
    private static final String NAZEV = "hledej";

    // Herní plán, který obsahuje aktuální prostor
    private HerniPlan herniPlan;

    /**
     * Konstruktor pro inicializaci příkazu s odkazem na herní plán.
     *
     * @param herniPlan Herní plán, který obsahuje aktuální prostor.
     */
    public PrikazHledej(HerniPlan herniPlan) {
        this.herniPlan = herniPlan;
    }

    /**
     * Provede hledání skrytých předmětů v aktuálním prostoru.
     * Prohledá seznam věcí v daném prostoru a pokud najde nějaké skryté věci, odhalí je.
     *
     * @param parametry Parametry příkazu (nepoužívají se v tomto příkazu, ale musí být přítomny pro implementaci IPrikaz).
     * @return Výsledek hledání. Pokud něco najde, vrátí názvy skrytých věcí. Pokud nic nenajde, vrátí zprávu, že není nic skrytého.
     */
    @Override
    public String provedPrikaz(String... parametry) {
        Prostor aktualniProstor = herniPlan.getAktualniProstor();
        StringBuilder vysledek = new StringBuilder();
        boolean naselNeco = false;

        // Procházení seznamu věcí v aktuálním prostoru
        for (Vec vec : aktualniProstor.getSeznamVeci()) {
            // Pokud je věc skrytá, odhalíme ji
            if (vec.jeSkryta()) {
                vec.setSkryta(false);
                naselNeco = true;
                vysledek.append("\nNašel jsi: ").append(vec.getNazev());

                // Pokud jde o zbraň, přidáme označení
                if (vec.jeZbran()) {
                    vysledek.append(" (zbraň)");
                }
                // Pokud není přenositelná, přidáme informaci
                else if (!vec.jePrenositelna()) {
                    vysledek.append(" (nepřenositelná)");
                }
            }
        }

        // Pokud něco bylo nalezeno, vrátíme seznam, jinak informaci, že nic skrytého není
        return naselNeco ? vysledek.toString() : "V této místnosti není nic skrytého.";
    }

    /**
     * Vrátí název příkazu.
     *
     * @return Název příkazu 'hledej'.
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
}
