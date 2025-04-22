package logika;

public class Vec {
    private String nazev;
    private boolean prenositelna;

    public Vec(String nazev, boolean prenositelna) {
        this.nazev = nazev;
        this.prenositelna = prenositelna;
    }

    public String getNazev() {
        return nazev;
    }

    public boolean jePrenositelna() {
        return prenositelna;
    }
}
