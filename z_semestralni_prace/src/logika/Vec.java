package logika;

public class Vec {
    private String nazev;
    private boolean prenositelna;
    private boolean hidden; // atribut pro skrytí věci
    private boolean zbran;  // nový atribut pro označení zbraně

    public Vec(String nazev, boolean prenositelna, boolean hidden, boolean zbran) {
        this.nazev = nazev;
        this.prenositelna = prenositelna;
        this.hidden = hidden;
        this.zbran = zbran;
    }

    public String getNazev() {
        return nazev;
    }

    public boolean jePrenositelna() {
        return prenositelna;
    }

    public boolean jeSkryta() {
        return hidden;
    }

    public void setSkryta(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean jeZbran() {
        return zbran;
    }
}
