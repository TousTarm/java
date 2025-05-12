package logika;

import java.util.ArrayList;
import java.util.List;

/**
 * Třída HerniPlan reprezentuje herní plán, který obsahuje jednotlivé prostory, kouzla a batoh.
 * Třída se stará o inicializaci prostorů, předmětů, kouzel a interakcí s NPC.
 */
public class HerniPlan {

    // Seznam kouzel dostupných ve hře
    private List<Kouzlo> kouzla;

    // Aktuální prostor, ve kterém se hráč nachází
    private Prostor aktualniProstor;

    // Batoh, do kterého hráč může ukládat předměty
    public final Batoh batoh;

    // Definice všech prostorů ve hře
    private Prostor vesnice;
    private Prostor lesniCesta;
    private Prostor draciDoupe;
    private Prostor draciSal;

    /**
     * Konstruktor třídy HerniPlan, který inicializuje všechny prostory, předměty, kouzla a NPC.
     */
    public HerniPlan() {
        zalozProstoryHry();  // Nastavení prostorů hry
        zalozVeci();         // Nastavení předmětů ve hře
        this.batoh = new Batoh(2);  // Vytvoření batohu s kapacitou 2 předměty
        this.kouzla = new ArrayList<>();  // Seznam pro kouzla
        zalozKouzla();  // Nastavení kouzel
    }

    /**
     * Inicializuje všechny prostory hry a jejich vzájemné propojení.
     */
    private void zalozProstoryHry() {
        vesnice = new Prostor("vesnice", ", kde lidé žijí ve strachu z draka. Na náměstí tam stojí černokněžník.");
        Prostor hrad = new Prostor("hrad", ", na trůnu zde sedí sám král, v hradu je smutno a král je starý.");
        Prostor knihovna = new Prostor("knihovna", ", leží tu spousta starých knih.");
        Prostor kovarna = new Prostor("kovarna", ", stárá kovárna, kovář zrovna dokoval nový meč.");
        lesniCesta = new Prostor("lesni_cesta", ", plná žlutého listí. Leží tam kámen a stojí monolith. Na konci cesty je jeskyně.");
        draciDoupe = new Prostor("draci_doupe", ", je tam spousta goblinů, až příliš mnoho. Jedna skupinka zrovna k tobě jde, ale nevidí tě.");
        draciSal = new Prostor("draci_sal", ", drak s obrovskými mocnými křídly a tlustou šupinatou kůží si tě všimne a začne se smát. drak: 'Ty mně nikdy neporazíš', začne se zhluboka nadechovat.");

        // Nastavení výchozích směrů pro jednotlivé prostory
        vesnice.setVychod(hrad);
        vesnice.setVychod(knihovna);
        vesnice.setVychod(kovarna);

        hrad.setVychod(vesnice);
        hrad.setVychod(knihovna);
        hrad.setVychod(kovarna);

        kovarna.setVychod(vesnice);
        kovarna.setVychod(hrad);
        kovarna.setVychod(knihovna);

        knihovna.setVychod(vesnice);
        knihovna.setVychod(kovarna);
        knihovna.setVychod(hrad);

        draciDoupe.setVychod(lesniCesta);

        lesniCesta.setVychod(draciDoupe);

        // Počáteční prostor, ve kterém se hráč nachází
        aktualniProstor = vesnice;

        // Vložení předmětu do prostoru
        Vec mapa = new Vec("mapa", true, true, false);
        knihovna.vlozVec(mapa);

        // Vytvoření NPC postav
        Npc kral = new Npc("Král", "ano, drak nám pálí pole, unáší náš lid. Když ho zabiješ, dám ti půl království. Mé stráže tě odvedou do knihovny pro mapu.", "hrad", null);
        hrad.vlozNpc(kral);

        Npc cernokneznik = new Npc("Černokněžník", "drak je nebezpečný, potřebuješ se chránit proti ohni. Kouzlo 'fire_resistance' tě ochrání.", "vesnice", hra -> {
            Kouzlo fireBall = new Kouzlo("fire_resistence", "jsi teď imuní vůči ohni!");
            this.kouzla.add(fireBall);
        });
        vesnice.vlozNpc(cernokneznik);

        Npc kovar = new Npc("Kovář", "zde máš meč. Naoplátku mi přines dračí zub.", "kovarna", hra -> {
            Vec mec = new Vec("mec", true, false, true);
            hra.getHerniPlan().getAktualniProstor().vlozVec(mec);
        });
        kovarna.vlozNpc(kovar);
    }

    /**
     * Inicializuje všechny předměty ve hře a vloží je do příslušných prostorů.
     */
    public void zalozVeci(){
        Vec monolith = new Vec("monolith", false, false, false);
        lesniCesta.vlozVec(monolith);
        Vec kamen = new Vec("kamen", true, false, false);
        lesniCesta.vlozVec(kamen);
    }

    /**
     * Vrátí aktuální prostor, ve kterém se hráč nachází.
     *
     * @return Aktuální prostor.
     */
    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }

    /**
     * Nastaví nový aktuální prostor, ve kterém se hráč nachází.
     *
     * @param prostor Nový prostor.
     */
    public void setAktualniProstor(Prostor prostor) {
        aktualniProstor = prostor;
    }

    /**
     * Vrátí batoh, do kterého si hráč ukládá předměty.
     *
     * @return Batoh.
     */
    public Batoh getBatoh() {
        return batoh;
    }

    /**
     * Inicializuje kouzla dostupná ve hře.
     */
    private void zalozKouzla() {
        Kouzlo swordEnchant = new Kouzlo("sword_enchant", "tvůj meč je teď silnější.");
        this.kouzla.add(swordEnchant);
        Kouzlo fireBall = new Kouzlo("fire_ball", "objevila se před tebou ohnivá koule");
        this.kouzla.add(fireBall);
    }

    /**
     * Vrátí seznam kouzel dostupných ve hře.
     *
     * @return Seznam kouzel.
     */
    public List<Kouzlo> getKouzla() {
        return this.kouzla;
    }

    /**
     * Uvolní cestu do lesa, pokud hráč nalezne mapu.
     */
    public void najdesMapu() {
        vesnice.setVychod(lesniCesta);
        lesniCesta.setVychod(vesnice);
    }

    /**
     * Otevře dveře do Dračího doupěte.
     */
    public void openDragonsDoor() {
        draciDoupe.setVychod(draciSal);
        draciSal.setVychod(draciDoupe);
    }

    /**
     * Vrátí prostor Dračího doupěte.
     *
     * @return Prostor Dračího doupěte.
     */
    public Prostor getDraciDoupe() {
        return draciDoupe;
    }

    /**
     * Vrátí prostor Lesní cesty.
     *
     * @return Prostor Lesní cesty.
     */
    public Prostor getLesniCesta() {
        return lesniCesta;
    }

    /**
     * Zablokuje vchod do Dračího doupěte zasypáním vchodu.
     */
    public void zablokujVchod() {
        lesniCesta.odeberVychod("draci_doupe");
        lesniCesta.setPopis(", plná žlutého listí. Vchod do jeskyně je nyní zasypán ohromnými kameny.");
    }
}