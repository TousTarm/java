package logika;

public class PrikazSkryj_se implements IPrikaz {
    private static final String NAZEV = "skryj_se";
    private static boolean odhalen = true;
    private HerniPlan herniPlan;

    public PrikazSkryj_se(HerniPlan herniPlan) {
        this.herniPlan = herniPlan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        odhalen = false;

        // Special handling for draci_doupe goblin event
        if (herniPlan.getAktualniProstor().getNazev().equals("draci_doupe") &&
                herniPlan.getAktualniProstor().isGoblinEventActive()) {
            herniPlan.getAktualniProstor().resolveGoblinEvent();
            return "\nSchoval ses! Goblinové tě přehlédli a odcházejí pryč. Jeden z nich však stihl zamknout dveře k drakovi, možná půjde zámek zničit.";
        }

        return "Úspěšně ses skryl. Nyní jsi neviditelný.";
    }

    public static boolean jeOdhalen() {
        return odhalen;
    }

    public static boolean odhalit() {
        if (!odhalen) {
            odhalen = true;
            return true;
        }
        return false;
    }

    public static String getNazevStatic() {
        return NAZEV;
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}