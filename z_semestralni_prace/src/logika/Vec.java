package logika;

public class Vec {
    private String nazev;
    private boolean prenositelna;

    /**
     *  Vytvoří předmět se zadaným názvem a definováním zda může být či nemůže být přenesena z prostoru
     * @param nazev Jméno věci. Jednoznačný identifikátor. Pokud možno jedno slovo
     * @param prenositelna Parametr určuje zda se dá (true) nebo nedá odnést (false)
     */
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
