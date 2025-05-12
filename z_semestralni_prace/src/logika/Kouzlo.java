package logika;

/**
 * Třída Kouzlo reprezentuje kouzlo ve hře, které má název, efekt a stav (aktivní/neaktivní).
 * Každé kouzlo může být aktivováno a jeho účinek je popisován textem efektu.
 */
public class Kouzlo {

    // Název kouzla (např. "fire_ball", "sword_enchant")
    private String nazev;

    // Efekt kouzla, popisuje, co kouzlo dělá (např. "vyčaruje ohnivou kouli")
    private String efekt;

    // Stav kouzla: true = aktivní, false = neaktivní
    private boolean aktivni;

    /**
     * Konstruktor pro vytvoření nového kouzla s názvem a efektem.
     * Kouzlo je při vytváření neaktivní.
     *
     * @param nazev Název kouzla.
     * @param efekt Efekt kouzla.
     */
    public Kouzlo(String nazev, String efekt) {
        this.nazev = nazev;
        this.efekt = efekt;
        this.aktivni = false; // Výchozí stav je neaktivní
    }

    /**
     * Vrátí název kouzla.
     *
     * @return Název kouzla.
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * Vrátí popis efektu kouzla, který obsahuje název kouzla a jeho účinek.
     *
     * @return Popis efektu kouzla.
     */
    public String getEfekt() {
        return ", vyčaroval jsi kouzlo: " + nazev +  ", " + efekt;
    }

    /**
     * Zjistí, zda je kouzlo aktivní.
     *
     * @return true, pokud je kouzlo aktivní, jinak false.
     */
    public boolean isAktivni() {
        return aktivni;
    }

    /**
     * Nastaví stav kouzla na aktivní nebo neaktivní.
     *
     * @param aktivni Nový stav kouzla (true = aktivní, false = neaktivní).
     */
    public void setAktivni(boolean aktivni) {
        this.aktivni = aktivni;
    }
}
