package logika;

/**
 * Třída představuje příkaz 'jdi', který umožňuje hráči pohybovat se mezi prostory v herním světě.
 */
public class PrikazJdi implements IPrikaz {

    // Název příkazu
    private static final String NAZEV = "jdi";

    // Herní plán, který obsahuje aktuální prostor
    private HerniPlan plan;

    // Reference na instanci hry
    Hra hra;

    /**
     * Konstruktor pro inicializaci příkazu s odkazem na instanci hry.
     *
     * @param hra Instanci hry, kterou příkaz používá pro manipulaci s herním plánem.
     */
    public PrikazJdi(Hra hra) {
        this.hra = hra;
        plan = hra.getHerniPlan();
    }

    /**
     * Provede pohyb hráče do sousedního prostoru podle zadaného směru.
     * Pokud je směrový parametr platný, hráč se přesune do sousedního prostoru, jinak se zobrazí chybová zpráva.
     *
     * @param parametry Parametry příkazu, které obsahují název směru, kam má hráč jít (např. "východ", "západ").
     * @return Zpráva o výsledku pohybu nebo chybová zpráva, pokud není zadán platný směr.
     */
    @Override
    public String provedPrikaz(String... parametry) {
        // Pokud není zadán žádný směr, vrátíme chybovou zprávu
        if (parametry.length == 0) {
            return "\nKam mám jít? Musíš zadat jméno východu";
        }

        String smer = parametry[0];

        // Získáme sousední prostor podle zadaného směru
        Prostor sousedniProstor = plan.getAktualniProstor().vratSousedniProstor(smer);

        // Pokud není sousední prostor k dispozici, vrátíme chybovou zprávu
        if (sousedniProstor == null) {
            return "\nTam se odsud jít nedá!";
        }

        // Nastavíme nový aktuální prostor (pohyb hráče)
        plan.setAktualniProstor(sousedniProstor);

        // Pokud hráč vstupuje do "draci_doupe", vyvoláme událost s gobliny
        if ("draci_doupe".equals(sousedniProstor.getNazev())) { // Literal placed first
            sousedniProstor.triggerGoblinEvent();

            // Vytvoříme zprávu o popisu nového prostoru
            StringBuilder sb = new StringBuilder();
            sb.append(sousedniProstor.dlouhyPopis());
            return sb.toString();
        }

        // Pokud není vstup do "draci_doupe", vrátíme standardní popis prostoru
        return sousedniProstor.dlouhyPopis();
    }

    /**
     * Vrátí název příkazu.
     *
     * @return Název příkazu 'jdi'.
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
}
