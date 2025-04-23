package logika;

public class HerniPlan {
    
    private Prostor aktualniProstor;
    public final Batoh batoh;

    public HerniPlan() {
        zalozProstoryHry();
        this.batoh  = new Batoh(4);
    }

    private void zalozProstoryHry() {
        Prostor vesnice = new Prostor("vesnice", "vesnice, kde lidé žijí ve strachu z draka");
        Prostor hrad = new Prostor("hrad", "hrad, na trůnu zde sedí sám král, v hradu je smutno a král je starý");
        Prostor knihovna = new Prostor("knihovna", "knihovna, kde lze nalézt staré knihy");
        Prostor kovarna = new Prostor("kovarna", "kovárna, kde kovář nabízí meč výměnou za dračí zub");
        Prostor lesniCesta = new Prostor("lesni_cesta", "lesní cesta, která vede k tajemnému místu");
        Prostor draciDoupe = new Prostor("draci_doupe", "jeskyně plná goblinů a nebezpečí");
        Prostor draciSal = new Prostor("draci_sal", "obrovský sál, kde sídlí zlý drak");

        vesnice.setVychod(hrad);
        vesnice.setVychod(knihovna);
        vesnice.setVychod(kovarna);
        vesnice.setVychod(lesniCesta);

        hrad.setVychod(vesnice);
        hrad.setVychod(knihovna);
        hrad.setVychod(kovarna);

        kovarna.setVychod(vesnice);
        kovarna.setVychod(hrad);
        kovarna.setVychod(knihovna);

        knihovna.setVychod(vesnice);
        knihovna.setVychod(kovarna);
        knihovna.setVychod(hrad);

        lesniCesta.setVychod(vesnice);
        lesniCesta.setVychod(draciSal);

        draciDoupe.setVychod(lesniCesta);
        draciDoupe.setVychod(draciSal);

        draciSal.setVychod(draciSal);

        aktualniProstor = vesnice;

        Vec mapa = new Vec("mapa", true,true,false);
        knihovna.vlozVec(mapa);
        Npc kral = new Npc("Král", "Ano, drak nám pálí pole, unáší náš lid. Když ho zabiješ, dám ti půl království. Mapu najdeš v knihovně.", "hrad",null);
        hrad.vlozNpc(kral);
        Npc cernokneznik = new Npc("Černokněžník", "Stačí vyčarovat 'fire_resistence' pro ochranu před ohněm.", "vesnice");
        vesnice.vlozNpc(cernokneznik);
        Npc kovar = new Npc("Kovář", "Zde máš meč. Naoplátku mi přines dračí zub.", "kovarna",hra -> {
            Vec mec = new Vec("mec", true,false,true);
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

    public Batoh getBatoh(){
        return batoh;
    }
}
