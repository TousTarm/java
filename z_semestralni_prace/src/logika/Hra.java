package logika;

public class Hra implements IHra {
    private SeznamPrikazu platnePrikazy;
    private HerniPlan herniPlan;
    private boolean konecHry = false;
    private String epilog = "Dík, že jste si zahráli.";
    public Hra() {
        herniPlan = new HerniPlan();
        platnePrikazy = new SeznamPrikazu();
        platnePrikazy.vlozPrikaz(new PrikazNapoveda(platnePrikazy));
        platnePrikazy.vlozPrikaz(new PrikazJdi(this));
        platnePrikazy.vlozPrikaz(new PrikazKonec(this));
        platnePrikazy.vlozPrikaz(new PrikazSeber(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazPoloz(herniPlan));

        platnePrikazy.vlozPrikaz(new PrikazMluv(herniPlan,this));
        platnePrikazy.vlozPrikaz(new PrikazHledej(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazSkryj_se(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazVycaruj(herniPlan,this));
        platnePrikazy.vlozPrikaz(new PrikazUtok(herniPlan,this));
    }
    private boolean dragonAlive = true;
    private boolean swordEnchanted = false;
    private boolean fireResistanceActive = false;

    public boolean isDragonAlive() { return dragonAlive; }
    public boolean isSwordEnchanted() { return swordEnchanted; }
    public boolean hasFireResistance() { return fireResistanceActive; }

    public void setDragonAlive(boolean state) { dragonAlive = state; }
    public void setSwordEnchanted(boolean state) { swordEnchanted = state; }
    public void setFireResistanceActive(boolean state) {this.fireResistanceActive = state;}


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

            if (slovoPrikazu.equals("utok")) {
                textKVypsani = response;
            }
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

