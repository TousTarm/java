package logika;

public class PrikazJdi implements IPrikaz {
    private static final String NAZEV = "jdi";
    private HerniPlan plan;
    private Hra hra;

    public PrikazJdi(Hra hra) {
        this.hra = hra;
        plan = hra.getHerniPlan();
    }

    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "Kam mám jít? Musíš zadat jméno východu";
        }

        String smer = parametry[0];
        Prostor sousedniProstor = plan.getAktualniProstor().vratSousedniProstor(smer);

        if (sousedniProstor == null) {
            return "Tam se odsud jít nedá!";
        }

        // Store current room for event check
        Prostor currentRoom = plan.getAktualniProstor();
        plan.setAktualniProstor(sousedniProstor);

        // Check if entering draci_doupe
        if (sousedniProstor.getNazev().equals("draci_doupe")) {
            sousedniProstor.triggerGoblinEvent();

            StringBuilder sb = new StringBuilder();
            sb.append(sousedniProstor.dlouhyPopis());
            return sb.toString();
        }

        // Standard room entry
        return sousedniProstor.dlouhyPopis();
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }

}
