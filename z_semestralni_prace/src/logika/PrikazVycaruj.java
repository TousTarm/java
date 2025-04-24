package logika;

public class PrikazVycaruj implements IPrikaz {
    private static final String NAZEV = "vycaruj";
    private HerniPlan plan;

    public PrikazVycaruj(HerniPlan plan) {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "Musíš zadat jméno kouzla, které chceš vyčarovat.";
        }

        String jmenoKouzla = parametry[0];
        for (Kouzlo kouzlo : plan.getKouzla()) {
            if (kouzlo.getNazev().equals(jmenoKouzla)) {
                if (!kouzlo.isAktivni()) {
                    kouzlo.setAktivni(true);
                    return "Vyčaroval jsi kouzlo: " + kouzlo.getNazev() + "!\n" + kouzlo.getEfekt();
                } else {
                    return "Kouzlo " + kouzlo.getNazev() + " už je aktivní.";
                }
            }
        }

        return "Nemáš kouzlo s názvem " + jmenoKouzla + ".";
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
