package logika;

/**
 * Třída Vec reprezentuje předměty ve hře.
 * Každý předmět má název, může být přenositelný, skrytý a/nebo může být zbraní.
 *
 * @author     [Autor]
 * @version    [Verze]
 */
public class Vec {
    /** Název předmětu */
    private final String nazev;

    /** Příznak určující, zda je předmět přenositelný */
    private final boolean prenositelna;

    /** Příznak určující, zda je předmět skrytý (neviditelný pro hráče) */
    private boolean hidden;

    /** Příznak určující, zda je předmět zbraní */
    private final boolean zbran;

    /**
     * Konstruktor pro vytvoření instance předmětu se všemi atributy.
     *
     * @param nazev         název předmětu
     * @param prenositelna  true, pokud je předmět přenositelný
     * @param hidden        true, pokud je předmět skrytý
     * @param zbran         true, pokud je předmět zbraní
     */
    public Vec(String nazev, boolean prenositelna, boolean hidden, boolean zbran) {
        this.nazev = nazev;
        this.prenositelna = prenositelna;
        this.hidden = hidden;
        this.zbran = zbran;
    }

    /**
     * Vrátí název předmětu.
     *
     * @return název předmětu
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * Zjišťuje, zda je předmět přenositelný.
     *
     * @return true, pokud je předmět přenositelný
     */
    public boolean jePrenositelna() {
        return prenositelna;
    }

    /**
     * Zjišťuje, zda je předmět skrytý.
     *
     * @return true, pokud je předmět skrytý
     */
    public boolean jeSkryta() {
        return hidden;
    }

    /**
     * Nastavuje viditelnost předmětu.
     *
     * @param hidden true pro skrytí předmětu, false pro zobrazení
     */
    public void setSkryta(boolean hidden) {
        this.hidden = hidden;
    }

    /**
     * Zjišťuje, zda je předmět zbraní.
     *
     * @return true, pokud je předmět zbraní
     */
    public boolean jeZbran() {
        return zbran;
    }

    /**
     * Vrátí textovou reprezentaci předmětu (jeho název).
     *
     * @return název předmětu
     */
    @Override
    public String toString() {
        return nazev;
    }
}