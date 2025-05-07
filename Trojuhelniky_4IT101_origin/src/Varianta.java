
/**
 * Toto je pomocná třída aplikace Trojuhelniky pro uložení parametrů jednotlivých variant
 * nabídky. V každé variantě je potřeba zadat typ trojúhelníku (viz třída Trojuhelnik), popis
 * do menu a dotazy na jednotlivé parametry.
 * <p>
 * Příklady variant:
<pre> 
     new Varianta(Trojuhelnik.PRAVOUHLY_A_B, "Pravoúhlý trojúhelník, zadávají se strany A a B", 
                "délka strany A", "délka strany B", null);
     new Varianta(Trojuhelnik.ROVNOSTRANNY, "Rovnoramenný trojúhelník, všechny strany stejně dlouhé", 
                "délka strany", null, null);
</pre>
 * 
 * @author  Luboš Pavlíček 
 * @version 1.0, srpen 2004
 */
public class Varianta {
    private TypTrojuhelnika typ;            // typ trojuhelniku
    private String popis;       // popis varianty - objevi se v nabidce
    private String dotaz1;      // dotaz na první parametr
    private String dotaz2;      // dotaz na druhý parametr
    private String dotaz3;      // dotaz na třetí parametr

    /**
     * Vytvoření jedné varianty nabídky.
     * 
     * @param typ       typ trojúhelníku, viz emun TypTrojuhelnika
     * @param popis     popis varianty - objeví se v menu
     * @param dotaz1    řetězec s dotazem na první parametr či hodnota null, pokud není 
     *                  potřeba první parametr (a tím pádem ani dotaz)
     * @param dotaz2    řetězec s dotazem na druhý parametr či hodnota null, pokud není
     *                  potřeba druhý parametr (a tudíž ani dotaz)
     * @param dotaz3    řetězec s dotazem na třetí parametr či hodnota null, pokud není
     *                  potřeba třetí parametr (a tudíž ani dotaz)
     */
    public Varianta(TypTrojuhelnika typ, String popis, String dotaz1, String dotaz2, String dotaz3)
    {
        // initialise instance variables
        this.typ = typ;
        this.popis = popis;
        this.dotaz1 = dotaz1;
        this.dotaz2 = dotaz2;
        this.dotaz3 = dotaz3;
    }

    /**
     * Vrací typ trojuhelníku
     * 
     * @return typ trojúhelníku, jednotlivé typy jsou definovány ve třídě Trojuhelnik
     */
    public TypTrojuhelnika getTyp() {
        return typ;
    }

    /**
     * Vrací popis varianty.
     * 
     * @return popis varianty.
     */
    public String getPopis() {
        return popis;
    }
    
    /**
     * Vrací dotaz na první parametr.
     * Pokud není potřeba první parametr (což je velmi neobvyklé), vrací hodnotu null.
     * 
     * @return dotaz (prompt) na první parametr či hodnota null, pokud není potřeba.
     */
    public String getDotaz1() {
        return dotaz1;
    }
    
    /**
     * Vrací dotaz na druhý parametr.
     * Pokud není potřeba druhý parametr (např. u rovnoramenného trojúhelníku),
     * vrací hodnotu null.
     * 
     * @return dotaz (prompt) na druhý parametr či hodnota null, pokud není potřeba.
     */
    public String getDotaz2() {
        return dotaz2;
    }
    
    /**
     * Vrací dotaz na třetí parametr.
     * Pokud není potřeba třetí parametr, vrací hodnotu null
     * 
     * @return dotaz (prompt) na třetí parametr či hodnota null, pokud není potřeba
     */
    public String getDotaz3() {
        return dotaz3;
    }
    
    /**
     * Vrací počet parametrů.
     * @return počet parametrů varianty - závisí na počtu definovaných dotazů
     */
    public int getPocetParametru() {
        if (dotaz3 != null) {
            return 3;
        }
        else {
            if (dotaz2 != null) {
                return 2;
            }
            else {
                if (dotaz1 != null) {
                    return 1;
                }
                else {
                    return 0;
                }
            }
        }
    }

}
