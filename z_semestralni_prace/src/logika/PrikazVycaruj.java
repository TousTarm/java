package logika;

import java.util.Locale;

/**
 * Třída implementující příkaz 'vycaruj' pro používání kouzel ve hře.
 * Umožňuje hráči používat různá kouzla s různými efekty v závislosti na aktuálním prostoru.
 */
public class PrikazVycaruj implements IPrikaz {
    /** Název příkazu používaný pro jeho vyvolání */
    private static final String NAZEV = "vycaruj";

    /** Odkaz na herní plán pro přístup k aktuálnímu prostoru a seznamu kouzel */
    private HerniPlan herniPlan;

    /** Odkaz na hru pro manipulaci herního stavu */
    private Hra hra;

    /**
     * Konstruktor třídy
     *
     * @param herniPlan herní plán obsahující informace o prostorách a kouzlech
     * @param hra instance hry pro změnu herního stavu
     */
    public PrikazVycaruj(HerniPlan herniPlan, Hra hra) {
        this.herniPlan = herniPlan;
        this.hra = hra;
    }

    /**
     * Provede příkaz 'vycaruj' - aktivuje zvolené kouzlo s odpovídajícím efektem.
     *
     * @param parametry název kouzla (očekává se jeden parametr)
     * @return textový výsledek provedení kouzla
     */
    @Override
    public String provedPrikaz(String... parametry) {
        // Kontrola existence parametru
        if (parametry.length == 0) {
            return "\nMusíš zadat kouzlo. Dostupná kouzla: " + getDostupnaKouzla();
        }

        // Normalizace vstupu (case-insensitive)
        String jmenoKouzla = parametry[0].toLowerCase(Locale.ROOT);
        Prostor aktualni = herniPlan.getAktualniProstor();
        Kouzlo kouzlo = najdiKouzlo(jmenoKouzla);

        // Kontrola existence kouzla
        if (kouzlo == null) {
            return "\nNeznámé kouzlo: " + jmenoKouzla;
        }

        // Kontrola aktivity kouzla
        if (kouzlo.isAktivni()) {
            return "\nKouzlo " + kouzlo.getNazev() + " je již aktivní!";
        }

        // Speciální interakce v dračím sále
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

                default:
                    return "Toto kouzlo zde nemůžeš použít.";
            }
        }

        // Speciální interakce na lesní cestě
        if ("lesni_cesta".equals(aktualni.getNazev()) && "fire_ball".equals(jmenoKouzla)) {
            if (!hra.isDragonAlive()) {
                herniPlan.zablokujVchod();
                hra.setKonecHry(true);
                hra.setEpilog("Drak je poražen, goblini uvězněni a ty jsi zachránil celé království! Hra končí. Díky za hraní");
                return kouzlo.getEfekt() + ", zasáhla strop doupěte a ten zasypal vstup i s gobliny. Království je tak zachráněno!";
            }
            return "Nejprve musíš porazit draka!";
        }

        // Obecná aktivace kouzla
        kouzlo.setAktivni(true);
        return kouzlo.getEfekt();
    }

    /**
     * Vrátí seznam dostupných kouzel jako řetězec
     *
     * @return řetězec obsahující názvy dostupných kouzel oddělené čárkami
     */
    private String getDostupnaKouzla() {
        StringBuilder sb = new StringBuilder();
        herniPlan.getKouzla().forEach(k -> sb.append(k.getNazev()).append(", "));
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "žádná kouzla";
    }

    /**
     * Najde kouzlo podle názvu (case-insensitive)
     *
     * @param nazev název hledaného kouzla
     * @return nalezené kouzlo nebo null, pokud kouzlo neexistuje
     */
    private Kouzlo najdiKouzlo(String nazev) {
        for (Kouzlo k : herniPlan.getKouzla()) {
            if (k.getNazev().equalsIgnoreCase(nazev)) {
                return k;
            }
        }
        return null;
    }

    /**
     * Vrací název příkazu
     *
     * @return název příkazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
}