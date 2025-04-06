
/**
 * Tato třída zpřístupňuje grafickému rozhraní slovo, které se má hádat. Slovo je
 * instancí třídy HledaneSlovo a obsahuje vedle vlastního slova i nápovědu,
 * která se zobrazí.
 * Třída dále poskytuje informace o autorovy a o verzi.
 * 
 * @author  Luboš Pavlíček 
 * @version 1.0
 */
public class PoskytovatelSlov {
   
     private HledaneSlovo slovo;
     
    /**
     * konstruktor pro vytvoření instance třídy pro poskytování slov
     */
    public PoskytovatelSlov() {
      slovo = new HledaneSlovo("Praha","hlavni mesto");
    }

    /**
     * Metoda vrací slovo k hádání jako instanci třídy HledaneSlovo (tj. ke
     * slovu je připojena nápověda). Pokud není již další slovo k dispozici, vráti
     * hodnotu null
     * 
     * @return     slovo k hádání
     */
    public HledaneSlovo getSlovo() {
       return slovo;
    }
    
    /**
     * Metoda vrací jméno autora programu - jméno se zobrazuje v grafickém rozhraní
     * 
     * @return     jméno autora, např. "L. Pavlicek"
     */ 
    public String getAutor() {
        return "tomas rindt";
    }
    
    /**
     * Metoda vrací verzi programu - ta se zobrazuje v grafickém rozhraní
     * 
     * @return     verze programu, např. "1.0"
     */ 
    public String getVerze() {
        return "0.2";
    }
   
}
