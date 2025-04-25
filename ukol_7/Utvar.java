import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Sem napiste popis teto tridy.
 *
 * @author     Luboš Pavlíček
 * @version    1.0, srpen 2004
 */
public class Utvar implements Comparable<Utvar> {

    private String nazev;
    private String zkratka;

    private Set<Utvar> podrizene;
    private Set<Osoba> osoby;

    
    /**
     * Konstruktor pro objekty tridy Utvar
     */
    public Utvar(String zkratka, String nazev) {
        this.zkratka = zkratka;
        this.nazev = nazev;
        this.podrizene = new TreeSet<Utvar>();
        this.osoby = new HashSet<Osoba>();
    }
    
    /**
     * Metoda vrací název útvaru
     * 
     * @return název útvaru
     */
    public String getNazev() { 
        return nazev;
    }
    
    /**
     * Metoda vrací zkratku útvaru
     * 
     * @return zkratka útvaru
     */
    public String getZkratka() {
        return zkratka;
    }
    
    /**
     * Metoda vloží osobu, která je členem útvaru
     * 
     * @param osoba osoba, která je členem útvaru
     */
    public void pridej (Osoba osoba) {
        osoby.add(osoba);
    }
    
    /**
     * Metoda vloží další podřízený útvar do aktuálního útvaru
     *
     * @param utvar podřízený útvar
     */
    public void pridej (Utvar utvar) {
        podrizene.add(utvar);
    }
    
    /**
     * Metoda vypíše organizační strukturu útvaru
     * 
     * @param vcetneOsob  zda vypsat i osoby přiřazené do útvaru a do podřízených útvarů
     */
    public void vypis(boolean vcetneOsob) {
        System.out.println(zkratka +" " + nazev);
        for (Utvar utvar : podrizene) {
            utvar.vypis(vcetneOsob);
        }
    }

    public void vypis(boolean vcetneOsob, int uroven) {
        for (int i = 0; i < uroven; i++) {
            System.out.print("   ");
        }
        System.out.println(zkratka +" " + nazev);
        for (Utvar utvar : podrizene) {
            utvar.vypis(vcetneOsob, uroven+1 );
        }
    }

    public void vypis2(boolean vcetneOsob, int uroven) {
        odsadit(uroven*3);
        System.out.println(zkratka +" - " + nazev);
        if (vcetneOsob) {
            for (Osoba osoba : osoby) {
                odsadit((uroven+1)*3);
                System.out.println("- " + osoba.toString());
            }
        }
        for (Utvar utvar : podrizene) {
            utvar.vypis2(vcetneOsob, uroven+1);
        }
    }

    private void odsadit(int pocetMezer){
        for (int i = 0; i < pocetMezer; i++) {
            System.out.print(" ");
        }
    }
    
    /**
     * Metoda equals pro porovnání s další instancí třídy Utvar (obecně s jakýmkoliv
     * objektem). Podrobný popis této metody je u třídy Object.
     * Dvě instance třídy Utvar jsou stejné, pokud mají
     * stejnou zkratku (tj. nezáleží na názvu útvaru). 
     *
     * @param o   druhý útvar/Object, se kterým se má aktuální instance porovnat
     * @return    true, pokud jsou instance stejné - pokud obsahují stejnou zkratku (název se 
     *                neporovnává).
     */
    public boolean equals(Object o) {
        if (o instanceof Utvar) {
            Utvar druha = (Utvar)o;
            return zkratka.equals(druha.getZkratka());
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
        return zkratka.hashCode();
    }


    @Override
    public int compareTo(Utvar o) {
        return zkratka.compareTo(o.getZkratka());
    }
}
