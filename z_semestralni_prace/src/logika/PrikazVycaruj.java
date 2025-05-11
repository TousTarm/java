package logika;

public class PrikazVycaruj implements IPrikaz {
    private static final String NAZEV = "vycaruj";
    private HerniPlan herniPlan;
    private Hra hra;

    public PrikazVycaruj(HerniPlan herniPlan, Hra hra) {
        this.herniPlan = herniPlan;
        this.hra = hra;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "\nMusíš zadat kouzlo. Dostupná kouzla: " + getDostupnaKouzla();
        }

        String jmenoKouzla = parametry[0].toLowerCase();
        Prostor aktualni = herniPlan.getAktualniProstor();
        Kouzlo kouzlo = najdiKouzlo(jmenoKouzla);

        if (kouzlo == null) {
            return "\nNeznámé kouzlo: " + jmenoKouzla;
        }

        // Check if the spell is already active
        if (kouzlo.isAktivni()) {
            return "\nKouzlo " + kouzlo.getNazev() + " je již aktivní!";
        }

        // Special dragon fight interactions
        if ("draci_sal".equals(aktualni.getNazev())) {
            switch (jmenoKouzla) {
                case "fire_resistence":
                    kouzlo.setAktivni(true);
                    hra.setFireResistanceActive(true);
                    return kouzlo.getEfekt() + "\nCelé tvé tělo problesklo a hned na to na tebe drak vychrlil jeho ohňivý dech, překvapený, že jsi to přežil.";

                case "sword_enchant":
                    if (!herniPlan.getBatoh().obsahujeVec("mec")) {
                        return "Nemáš meč k očarování!";
                    }
                    kouzlo.setAktivni(true);
                    hra.setSwordEnchanted(true);
                    return kouzlo.getEfekt() + "\nDrak se polekal a začíná tě prosit o smilování.";
            }
        }

        // Goblin cave interaction
        if ("lesni_cesta".equals(aktualni.getNazev()) && "fire_ball".equals(jmenoKouzla)) {
            if (!hra.isDragonAlive()) {
                herniPlan.zablokujVchod();
                hra.setKonecHry(true);
                hra.setEpilog("Drak je poražen, goblini uvězněni a ty jsi zachránil celé království! Hra končí. Díky za hraní");
                return kouzlo.getEfekt() + ", zasáhla strop doupěte a ten zasypal vstup i s gobliny. Království je tak zachráněno!";
            }
            return "Nejprve musíš porazit draka!";
        }

        // Default spell activation for other scenarios
        kouzlo.setAktivni(true);
        return kouzlo.getEfekt();
    }

    private String getDostupnaKouzla() {
        StringBuilder sb = new StringBuilder();
        herniPlan.getKouzla().forEach(k -> sb.append(k.getNazev()).append(", "));
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "žádná kouzla";
    }

    private Kouzlo najdiKouzlo(String nazev) {
        for (Kouzlo k : herniPlan.getKouzla()) {
            if (k.getNazev().equalsIgnoreCase(nazev)) {
                return k;
            }
        }
        return null;
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
