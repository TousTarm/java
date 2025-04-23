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

        platnePrikazy.vlozPrikaz(new PrikazMluv(herniPlan,this));
        platnePrikazy.vlozPrikaz(new PrikazHledej(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazSkryj_se());
    }

    public String vratUvitani() {
        return "Vítejte v epickém dobrodružství o zabití draka!\n" +
                "Vaším úkolem je porazit hrozivého draka, který terorizuje okolní krajinu.\n" +
                "Na své cestě navštívíte různé prostory, setkáte se s nebezpečnými nepřáteli i užitečnými spojenci,\n" +
                "a budete sbírat předměty, které vám mohou pomoci v boji s drakem.\n" +
                "Napište 'nápověda', pokud potřebujete poradit, jak pokračovat.\n" +
                "\n" +
                herniPlan.getAktualniProstor().dlouhyPopis();
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
            textKVypsani = prikaz.provedPrikaz(parametry);

            // Always append the full room description
            textKVypsani += "\n" + herniPlan.getAktualniProstor().dlouhyPopis();
            // Only reveal if the command wasn't "skryj_se"
            if (!slovoPrikazu.equals(PrikazSkryj_se.getNazevStatic())) {
                if (PrikazSkryj_se.odhalit()) {
                    textKVypsani += "\nTato akce tě odhalila!";
                }
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

