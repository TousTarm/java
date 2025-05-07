
/**
 * Třída popisuje trojúhelník. Pro získání instance existuje větší množství statických
 * metod, které vytvářejí trojúhelník na základě jednotlivých známých parametrů.
 * 
 * @author  Luboš Pavlíček 
 * @version 1.0 srpen 2004
 */
public class Trojuhelnik
{
    // datové atributy trojúhelníku
    private double stranaA;
    private double stranaB;
    private double stranaC;

    /**
     * Vytvoření trojúhelníku při znalosti všech tří stran.
     */
    
    private Trojuhelnik(double stranaA, double stranaB, double stranaC) throws IllegalArgumentException
    {
        if ((stranaA <= 0) | (stranaB <= 0) | (stranaC <= 0)) {
            throw new IllegalArgumentException("Strana nesmi byt zaporna");
        }
        if ((stranaA + stranaB > stranaC || stranaA + stranaC > stranaB || stranaB + stranaC > stranaA)) {
            throw new IllegalArgumentException("součet dvou menších stran musí být větší než strana třetí");
        }

        this.stranaA = stranaA;
        this.stranaB = stranaB;
        this.stranaC = stranaC;
    }
    
    /**
     * Statická metoda pro získání instance pravoúhlého trojúhelníku (tj. úhel
     * gama je 90°) při zadání velikosti strany A a strany B (tj. obou odvěsen).
     * 
     * @param  stranaA  délka strany A
     * @param  stranaB  délka strany B
     * @return instance třídy Trojuhelnik, která má úhel gama 90° a zadanou délku strany
     *                  A a strany B
     */
    public static Trojuhelnik getPravouhlyAB (double stranaA, double stranaB) {
        return new Trojuhelnik(stranaA, stranaB, Math.sqrt(stranaA*stranaA + stranaB*stranaB));
        
    }
    
    /**
     * Statická metoda pro získání instance pravoúhlého trojúhelníku (tj. úhel
     * gama je 90°) při zadání velikosti strany A a strany C (tj. jedné odvěsny a přepony).
     * 
     * @param  stranaA  délka strany A (odvěsna)
     * @param  stranaC  délka strany C (přepona)
     * @return instance třídy Trojuhelnik, která má úhel gama 90° a zadanou délku strany
     *                  A a strany C
     */
    
    public static Trojuhelnik getPravouhlyAC (double stranaA, double stranaC) throws IllegalArgumentException {
        if (stranaC <= stranaA) {
            return null;
        }
        else {
            return new Trojuhelnik(stranaA, Math.sqrt(stranaC*stranaC - stranaA*stranaA), stranaC);
        }
    }

    public static Trojuhelnik getRovnoramenny (double strana) {
        return new Trojuhelnik(strana, strana, strana);
    }

    /**
     * Obecná statická metoda pro získání instance trojúhelníku, kdy je zadán typ trojúhelníku
     * (viz konstanty v této třídě) a pole s potřebnými parametry.
     * 
     * @param  typ      typ trojúhelníku
     * @param  parametry pole s parametry pro příslušný typ trojúhelníku
     * @return instance třídy Trojuhelnik příslušného typu a odpovídající zadaným parametrům
     */
    
    public static Trojuhelnik getTrojuhelnik (TypTrojuhelnika typ, double [] parametry) {
        if (typ == TypTrojuhelnika.PRAVOUHLY_A_B) {
            if (parametry.length < 2) {
                return null;
            }
            return getPravouhlyAB(parametry[0], parametry[1]);
        }
        if (typ == TypTrojuhelnika.PRAVOUHLY_A_C) {
            if (parametry.length < 2) {
                return null;
            }
            return getPravouhlyAC(parametry[0], parametry[1]);
        }
        if (typ == TypTrojuhelnika.ROVNOSTRANNY) {
            if (parametry.length < 1) {
                return null;
            }
            return getRovnoramenny(parametry[0]);
        }
        return null;

    }
    
    /**
     * Vrací délku strany A trojúhelníku
     * 
     * @return  délka strany A trojúhelníku
     */
    public double getStranaA() {
        return stranaA;
    }
    
    /**
     * Vrací délku strany B trojúhelníku
     * 
     * @return  délka strany B trojúhelníku
     */
    public double getStranaB() {
        return stranaB;
    }
    
    /**
     * Vrací délku strany C trojúhelníku
     * 
     * @return  délka strany C trojúhelníku
     */
    public double getStranaC() {
        return stranaC;
    }
    
    /**
     * Vrací velikost úhlu alfa (proti straně A) trojúhelníku ve stupních
     * 
     * @return  velikost úhlu alfa trojúhelníku.
     */
    public double getAlfa() {
        return Math.toDegrees(Math.acos( (stranaB*stranaB + stranaC*stranaC - stranaA*stranaA)
                /(2*stranaB*stranaC)));
    }
    
    /**
     * Vrací velikost úhlu beta (proti straně B) trojúhelníku ve stupních
     * 
     * @return  velikost úhlu beta trojúhelníku.
     */
    public double getBeta() {
        return Math.toDegrees(Math.acos( (stranaA*stranaA + stranaC*stranaC - stranaB*stranaB)
                /(2*stranaA*stranaC)));
    }
    
    /**
     * Vrací velikost úhlu gama (proti straně C) trojúhelníku ve stupních
     * 
     * @return  velikost úhlu gama trojúhelníku.
     */
    public double getGama() {
        return Math.toDegrees(Math.acos( (stranaB*stranaB + stranaA*stranaA - stranaC*stranaC)
                /(2*stranaB*stranaA)));
    }

    /**
     * Vypočte obvod trojúhelníku.
     * 
     * @return obvod trojúhelníku
     */
    public double obvod () {
        return (stranaA + stranaB + stranaC);
    }

    /**
     * Vypočte obsah trojúhelníku.
     * 
     * @return obsah trojúhelníku
     */
    public double obsah () {
        double polObvod=obvod()/2;
        return Math.sqrt(polObvod*(polObvod-stranaA) *(polObvod-stranaB) * (polObvod - stranaC));
    }
}
