
/**
 * Sem napiste popis teto tridy.
 *
 * @author     Luboš Pavlíček
 * @version    1.0, srpen 2004
 */
public class Osoba {

    private String jmeno;        // jméno osoby
    private String titulPred;    // titul před jménem
    private String titulZa;      // titul za jménem
    
    /**
     * Konstruktor pro objekty tridy Osoba.
     * 
     * @param jmeno     jméno osoby
     * @param titulPred titul před jménem
     * @param titulZa   titul za jménem
     */
    public Osoba(String jmeno, String titulPred, String titulZa) {
        this.jmeno = jmeno;
        this.titulPred = titulPred;
        this.titulZa = titulZa;
    }
    
    
    /**
     * Metoda vrací jméno osoby
     *
     * @return     vrací jméno osoby
     */
    public String getJmeno() { 
        return jmeno;
    }
    
    /**
     * Metoda vrací titul před jménem
     * 
     * @return    vrací titul před jménem
     */
    public String getTitulPred() {
        return titulPred;
    }
    
    /**
     * Metoda vrací titul za jménem.
     * 
     * @return vrací titul za jménem
     */
    public String getTitulZa() {
        return titulZa;
    }
    
    /**
     * Metoda překrývá metodu toString() třídy Object a vypisuje základní informace o instanci.
     * 
     * @return   základní informace o instanci
     */
    public String toString() {
        return titulPred+" "+jmeno+" "+titulZa;
    }
    
    /**
     * metoda equals pro porovnání s další instancí třídy Osoba (obecně s jakýmkoliv
     * objektem). Podrobný popis této metody je u třídy Object.
     * Dvě instance třídy Osoba jsou stejné, pokud obsahují
     * stejné jméno (tj. nezáleží na titulech). 
     *
     * @param o   druhá osoba/Object, se kterým se má aktuální instance porovnat
     * @return    true, pokud jsou instance stejné - pokud obsahují stejné jméno (tituly se 
     *                neporovnávají).
     */
    public boolean equals(Object o) {
        if (o instanceof Osoba) {
            Osoba druha = (Osoba)o;
            return jmeno.equals(druha.getJmeno());
        }
        else {
            return false;
        }
    }
    
    /**
     * Metoda vrací číselnou hodnotu vyjadřující konkrétní instanci. Používá se pro optimalizaci
     * v dynamických datových strukturách. Bližší popis viz třída Object.
     * 
     * @return číselný kód vyjadřující instanci
     */
    public int hashCode() {
        return jmeno.hashCode();
    }
    
}
