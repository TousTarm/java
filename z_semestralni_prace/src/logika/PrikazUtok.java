package logika;

public class PrikazUtok implements IPrikaz {
    private static final String NAZEV = "utok";
    private HerniPlan herniPlan;
    private Hra hra;

    public PrikazUtok(HerniPlan herniPlan, Hra hra) {
        this.herniPlan = herniPlan;
        this.hra = hra;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        // Check if player has sword
        if (!herniPlan.getBatoh().obsahujeVec("mec")) {
            return "Nemůžeš útočit bez meče!";
        }

        String aktualniProstor = herniPlan.getAktualniProstor().getNazev();

        // Dragon's Lair - Attack the dragon
        if (aktualniProstor.equals("draci_sal")) {
            if (parametry.length == 0) {
                return "Na koho chceš zaútočit?\nDostupné cíle: drak";
            }

            if (parametry[0].equalsIgnoreCase("drak")) {
                if (hra.isSwordEnchanted()) {
                    hra.setDragonAlive(false);
                    herniPlan.getDraciDoupe().setPopis(", jen o vlásek jsi utekl z dračího sálu, který se celý zřítil a draka zaživa pohřbil. Goblini se vrací zpět zjistit co se stalo.");
                    herniPlan.getLesniCesta().setPopis(", goblini si všimli tvého útoku a běží směrem k tobě, je jich ale příliš mnoho.");
                    return "Drakova hlava dopadá na zem po jednom hbitém zásahu. Celá místnost se začala třást, jeskyně se může zřítit.";
                } else {
                    return "Tvůj obyčejný meč draka neporanil! Potřebuješ magické vylepšení!";
                }
            }
            return "Neplatný cíl.";
        }

        // Dragon's Den - Attack the lock
        if (aktualniProstor.equals("draci_doupe")) {
            if (parametry.length == 0) {
                return "Na koho chceš zaútočit?\nDostupné cíle: zamek";
            }

            if (parametry[0].equalsIgnoreCase("zamek")) {
                herniPlan.openDragonsDoor();
                return "Rychlým švihem jsi zámek přesek vejpůl a dveře se rozletěly.";
            }
            return "Neplatný cíl.";
        }

        return "Zde není na koho útočit.";
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}