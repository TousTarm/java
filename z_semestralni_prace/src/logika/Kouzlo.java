package logika;

public class Kouzlo {
    private String nazev;
    private String efekt;
    private boolean aktivni; // Stav kouzla: true = aktivní, false = neaktivní

    public Kouzlo(String nazev, String efekt) {
        this.nazev = nazev;
        this.efekt = efekt;
        this.aktivni = false; // Výchozí stav
    }

    public String getNazev() {
        return nazev;
    }

    public String getEfekt() {
        return ", vyčaroval jsi kouzlo: " + nazev +  ", " + efekt;
    }

    public boolean isAktivni() {
        return aktivni;
    }

    public void setAktivni(boolean aktivni) {
        this.aktivni = aktivni;
    }
}
