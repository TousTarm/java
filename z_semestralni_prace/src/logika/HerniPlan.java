package logika;

import java.util.ArrayList;
import java.util.List;

public class HerniPlan {

    private List<Kouzlo> kouzla;
    private Prostor aktualniProstor;
    public final Batoh batoh;

    private Prostor vesnice;
    private Prostor lesniCesta;
    private Prostor draciDoupe;
    private Prostor draciSal;

    public HerniPlan() {
        zalozProstoryHry();
        this.batoh = new Batoh(4);
        this.kouzla = new ArrayList<>();
        zalozKouzla();
    }

    private void zalozProstoryHry() {
        vesnice = new Prostor("vesnice", ", kde lidé žijí ve strachu z draka. Na náměstí tam stojí černokněžník.");
        Prostor hrad = new Prostor("hrad", ", na trůnu zde sedí sám král, v hradu je smutno a král je starý.");
        Prostor knihovna = new Prostor("knihovna", ", leží tu spousta starých knih.");
        Prostor kovarna = new Prostor("kovarna", ", stárá kovárna, kovář zrovna dokoval nový meč.");
        lesniCesta = new Prostor("lesni_cesta", ", plná žlutého listí. Na konci cesty je jeskyně.");
        draciDoupe = new Prostor("draci_doupe", ", je tam spousta goblinů, až příliš mnoho. Jedna skupinka zrovna k tobě jde, ale nevidí tě.");
        draciSal = new Prostor("draci_sal", ", drak s obrovskými mocnými křídly a tlustou šupinatou kůží si te všimne a začne se smát. drak: 'Ty mně nikdy neporazíš', začne se zhluboka nadechovat.");

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

        aktualniProstor = vesnice;

        Vec mapa = new Vec("mapa", true, true, false);
        knihovna.vlozVec(mapa);

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

    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }

    public void setAktualniProstor(Prostor prostor) {
        aktualniProstor = prostor;
    }

    public Batoh getBatoh() {
        return batoh;
    }

    private void zalozKouzla() {
        Kouzlo swordEnchant = new Kouzlo("sword_enchant", "tvůj meč je teď silnější.");
        this.kouzla.add(swordEnchant);
        Kouzlo fireBall = new Kouzlo("fire_ball", "objevila se před tebou ohnivá koule");
        this.kouzla.add(fireBall);
    }

    public List<Kouzlo> getKouzla() {
        return this.kouzla;
    }

    public void najdesMapu() {
        vesnice.setVychod(lesniCesta);
        lesniCesta.setVychod(vesnice);
    }

    public void openDragonsDoor() {
        draciDoupe.setVychod(draciSal);
        draciSal.setVychod(draciDoupe);
    }

    public Prostor getDraciDoupe() {
        return draciDoupe;
    }

    public Prostor getLesniCesta() {
        return lesniCesta;
    }
    public void zablokujVchod() {
        lesniCesta.odeberVychod("draci_doupe");
        lesniCesta.setPopis(", plná žlutého listí. Vchod do jeskyně je nyní zasypán ohromnými kameny.");
    }
}
