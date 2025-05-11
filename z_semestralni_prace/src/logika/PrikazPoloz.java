package logika;

public class PrikazPoloz implements IPrikaz{
    private static final String NAZEV = "poloz";
    private HerniPlan herniPlan;

    public PrikazPoloz(HerniPlan herniPlan) {
        this.herniPlan = herniPlan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        Batoh batoh = herniPlan.getBatoh();
        if(parametry.length == 0){
            return "\nCo mám položit? Musíš zadat jméno věci";
        }

        if(parametry.length > 1){
            return "\nKaždá věc je jednoslovná a ty jsi toho zadal moc";
        }

        String nazevVeci = parametry[0];

        if(!batoh.obsahujeVec(nazevVeci)){
            return "\nToto není v batohu";
        }

        // Remove the item from the backpack and get it
        Vec vec = batoh.odeberZBatohu(nazevVeci);

        // Add the item to the current room
        herniPlan.getAktualniProstor().vlozVec(vec);

        return "\nPoložil jsi " + nazevVeci + " do prostoru " + herniPlan.getAktualniProstor().getNazev();
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
