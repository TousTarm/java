package logika;

public class PrikazSeber implements IPrikaz {
    private static final String NAZEV = "seber";

    private HerniPlan herniPlan;

    public PrikazSeber(HerniPlan herniPlan) {
        this.herniPlan = herniPlan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "Co mám sebrat? Musíš zadat jméno věci";
        }

        if (parametry.length > 1) {
            return "Každá věc je jednoslovná a ty jsi toho zadal moc";
        }

        String nazevVeci = parametry[0];
        Prostor aktualniProstor = herniPlan.getAktualniProstor();

        if (aktualniProstor.obsahujeVec(nazevVeci)) {
            Vec pozadovanaVec = aktualniProstor.vyberVec(nazevVeci);
            if (pozadovanaVec == null) {
                return nazevVeci + " nedá se přenést";
            } else {
                boolean povedloSeVlozit = herniPlan.getBatoh().vlozitDoBatohu(pozadovanaVec);
                if (povedloSeVlozit) {
                    // Check if the picked-up item is "mapa"
                    if ("mapa".equalsIgnoreCase(nazevVeci)) {
                        herniPlan.najdesMapu(); // Unlock the new paths
                    }
                    return "\n" + nazevVeci + " jsi vložil do batohu";
                } else {
                    return nazevVeci + " se nepodařilo vložit do batohu. Je již plný";
                }
            }
        } else {
            return nazevVeci + " není v prostoru";
        }
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
