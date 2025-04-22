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
            return "Co mám položit? Musíš zadat jméno věci";
        }

        if(parametry.length > 1){
            return "Každá věc je jednoslovná a ty jsi toho zadal moc";
        }

        String nazevVeci = parametry[0];

        if(!batoh.obsahujeVec(nazevVeci)){
            return "Toto není v batohu";
        }

        //todo - zbytek metody

        return "";
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
