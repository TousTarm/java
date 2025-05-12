package logika;

/**
 * Třída Hra implementuje rozhraní IHra a reprezentuje herní logiku. Zpracovává příkazy, kontroluje stav hry,
 * interaguje s herním plánem a poskytuje zpětnou vazbu pro hráče.
 */
public class Hra implements IHra {
    // Seznam platných příkazů, které hráč může zadávat
    private SeznamPrikazu platnePrikazy;

    // Herní plán obsahující prostory a další herní elementy
    private HerniPlan herniPlan;

    // Stav ukončení hry
    private boolean konecHry = false;

    // Text epilogu, který je zobrazen na konci hry
    private String epilog = "Dík, že jste si zahráli.";

    // Konstruktor třídy Hra, který inicializuje herní plán a příkazy
    public Hra() {
        herniPlan = new HerniPlan();  // Vytvoření herního plánu
        platnePrikazy = new SeznamPrikazu();  // Inicializace seznamu příkazů

        // Vložení jednotlivých příkazů do seznamu
        platnePrikazy.vlozPrikaz(new PrikazNapoveda(platnePrikazy));
        platnePrikazy.vlozPrikaz(new PrikazJdi(this));
        platnePrikazy.vlozPrikaz(new PrikazKonec(this));
        platnePrikazy.vlozPrikaz(new PrikazSeber(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazPoloz(herniPlan));

        platnePrikazy.vlozPrikaz(new PrikazMluv(herniPlan, this));
        platnePrikazy.vlozPrikaz(new PrikazHledej(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazSkryjSe(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazVycaruj(herniPlan, this));
        platnePrikazy.vlozPrikaz(new PrikazUtok(herniPlan, this));
    }

    // Stavy související s drakem, kouzlem a odolností proti ohni
    private boolean dragonAlive = true;
    private boolean swordEnchanted = false;
    private boolean fireResistanceActive = false;

    // Metody pro získání a nastavení stavu draka, meče a odolnosti proti ohni
    public boolean isDragonAlive() { return dragonAlive; }
    public boolean isSwordEnchanted() { return swordEnchanted; }
    public boolean hasFireResistance() { return fireResistanceActive; }

    public void setDragonAlive(boolean state) { dragonAlive = state; }
    public void setSwordEnchanted(boolean state) { swordEnchanted = state; }
    public void setFireResistanceActive(boolean state) { this.fireResistanceActive = state; }

    /**
     * Vrátí úvodní zprávu pro hráče, obsahující základní popis aktuálního prostoru a výstupy.
     *
     * @return Text úvodní zprávy.
     */
    public String vratUvitani() {
        return "Vítejte!\n" +
                "Toto je příběh o skolení zlého draka.\n" +
                "Napište 'napoveda', pokud si nevíte rady, jak hrát dál.\n" +
                "\n" +
                herniPlan.getAktualniProstor().normalniPopis() + // Popis aktuálního prostoru
                herniPlan.getAktualniProstor().dlouhyPopis() +  // Dlouhý popis aktuálního prostoru
                "\n" + herniPlan.getAktualniProstor().popisVychodu();  // Popis možných východů
    }

    /**
     * Vrátí epilog, který je zobrazen na konci hry.
     *
     * @return Text epilogu.
     */
    public String vratEpilog() {
        return epilog;
    }

    /**
     * Nastaví nový text epilogu.
     *
     * @param epilog Nový text epilogu.
     */
    public void setEpilog(String epilog) {
        this.epilog = epilog;
    }

    /**
     * Vrátí stav hry, zda je hra ukončena.
     *
     * @return True, pokud je hra ukončena, jinak false.
     */
    public boolean konecHry() {
        return konecHry;
    }

    /**
     * Zpracuje příkaz zadaný hráčem, rozparsuje ho a provede odpovídající akci.
     *
     * @param radek Příkaz zadaný hráčem.
     * @return Odpověď na zadaný příkaz.
     */
    public String zpracujPrikaz(String radek) {
        String[] slova = radek.split("[ \t]+");  // Rozdělení příkazu na slova
        String slovoPrikazu = slova[0];  // První slovo je příkaz
        String[] parametry = new String[slova.length - 1];

        // Získání parametrů příkazu
        for (int i = 0; i < parametry.length; i++) {
            parametry[i] = slova[i + 1];
        }

        String textKVypsani;

        // Pokud je příkaz platný, provede se jeho akce
        if (platnePrikazy.jePlatnyPrikaz(slovoPrikazu)) {
            IPrikaz prikaz = platnePrikazy.vratPrikaz(slovoPrikazu);

            String response = prikaz.provedPrikaz(parametry);

            textKVypsani = herniPlan.getAktualniProstor().normalniPopis();  // Popis aktuálního prostoru
            textKVypsani += response;  // Přidání odpovědi na příkaz

            textKVypsani += "\n" + herniPlan.getAktualniProstor().popisVychodu();  // Popis východů

            if ("utok".equals(slovoPrikazu)) {  // Speciální zpracování pro útok
                textKVypsani = response;
            }
        } else {
            textKVypsani = "Nevím co tím myslíš? Tento příkaz neznám.";  // Pokud je příkaz neznámý
        }

        return textKVypsani;
    }

    /**
     * Nastaví stav ukončení hry.
     *
     * @param konecHry Nový stav ukončení hry.
     */
    void setKonecHry(boolean konecHry) {
        this.konecHry = konecHry;
    }

    /**
     * Vrátí herní plán.
     *
     * @return Herní plán.
     */
    public HerniPlan getHerniPlan() {
        return herniPlan;
    }
}
