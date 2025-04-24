package logika;

public class PrikazHledej implements IPrikaz {
    private static final String NAZEV = "hledej";
    private HerniPlan herniPlan;

    public PrikazHledej(HerniPlan herniPlan) {
        this.herniPlan = herniPlan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        Prostor aktualniProstor = herniPlan.getAktualniProstor();
        StringBuilder vysledek = new StringBuilder();
        boolean naselNeco = false;

        // Directly access seznamVeci since there's no getter
        for (Vec vec : aktualniProstor.getSeznamVeci()) {
            if (vec.jeSkryta()) {
                vec.setSkryta(false);
                naselNeco = true;
                vysledek.append("\nNašel jsi: ").append(vec.getNazev());

                if (vec.jeZbran()) {
                    vysledek.append(" (zbraň)");
                } else if (!vec.jePrenositelna()) {
                    vysledek.append(" (nepřenositelná)");
                }
            }
        }

        return naselNeco ? vysledek.toString() : "V této místnosti není nic skrytého.";
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}