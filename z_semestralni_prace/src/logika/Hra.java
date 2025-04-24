package logika;

public class Hra implements IHra {
    private SeznamPrikazu platnePrikazy;
    private HerniPlan herniPlan;
    private boolean konecHry = false;
    private String epilog = "Dík, že jste si zahráli.";
    private static final String DRAKOUPE = "draci_doupe";
    private int stepOfEntry = -1;
    public Hra() {
        herniPlan = new HerniPlan();
        platnePrikazy = new SeznamPrikazu();
        platnePrikazy.vlozPrikaz(new PrikazNapoveda(platnePrikazy));
        platnePrikazy.vlozPrikaz(new PrikazJdi(this));
        platnePrikazy.vlozPrikaz(new PrikazKonec(this));
        platnePrikazy.vlozPrikaz(new PrikazSeber(herniPlan));

        platnePrikazy.vlozPrikaz(new PrikazMluv(herniPlan,this));
        platnePrikazy.vlozPrikaz(new PrikazHledej(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazSkryj_se());
        platnePrikazy.vlozPrikaz(new PrikazVycaruj(herniPlan));
    }

    public String vratUvitani() {
        return "Vítejte!\n" +
                "Toto je příběh o skolení zlého draka.\n" +
                "Napište 'napoveda', pokud si nevíte rady, jak hrát dál.\n" +
                "\n" +
                herniPlan.getAktualniProstor().normalniPopis() + herniPlan.getAktualniProstor().dlouhyPopis()
                + "\n" + herniPlan.getAktualniProstor().popisVychodu();
    }

    public String vratEpilog() {
        return epilog;
    }

    public void setEpilog(String epilog) {
        this.epilog = epilog;
    }

     public boolean konecHry() {
        return konecHry;
    }

    public String zpracujPrikaz(String radek) {
        String[] slova = radek.split("[ \t]+");
        String slovoPrikazu = slova[0];
        String[] parametry = new String[slova.length-1];

        for(int i=0; i<parametry.length; i++) {
            parametry[i] = slova[i+1];
        }

        String textKVypsani;

        if (platnePrikazy.jePlatnyPrikaz(slovoPrikazu)) {
            IPrikaz prikaz = platnePrikazy.vratPrikaz(slovoPrikazu);

            String response = prikaz.provedPrikaz(parametry);

            textKVypsani = herniPlan.getAktualniProstor().normalniPopis();

            textKVypsani += response;

            textKVypsani += "\n" + herniPlan.getAktualniProstor().popisVychodu();
            /*
            if (!slovoPrikazu.equals(PrikazSkryj_se.getNazevStatic())) {
                if (PrikazSkryj_se.odhalit()) {
                    textKVypsani += "\nTato akce tě odhalila!";
                }
            }
            */
        }
        else {
            textKVypsani = "Nevím co tím myslíš? Tento příkaz neznám.";
        }

        return textKVypsani;
    }

    void setKonecHry(boolean konecHry) {
        this.konecHry = konecHry;
    }

     public HerniPlan getHerniPlan(){
        return herniPlan;
     }
}

