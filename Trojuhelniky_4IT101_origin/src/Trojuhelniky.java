import java.util.ArrayList;
/**
 * Základní třída aplikace Trouhelniky - zobrazuje nabídku, na základě vybrané varianty se zeptá na příslušné parametry
 * a poté zobrazí informace o trojúhelníku.
 * 
 * @author  Luboš Pavlíček
 * @version 1.0 srpen 2004
 */
public class Trojuhelniky {

    private ArrayList<Varianta> varianty;   // pole obsahující jednotlivé varianty
    private CteniZKonsole vstup;            // třída pro vstup z konzole

    /**
     * Vytváří instanci třídy Trojuhelniky
     */
    public Trojuhelniky() {
        varianty = new ArrayList<Varianta>();
        varianty.add(new Varianta(TypTrojuhelnika.PRAVOUHLY_A_B, "Pravoúhlý trojúhelník, známy strany A a B", 
                "délka strany A", "délka strany B", null));
        varianty.add(new Varianta(TypTrojuhelnika.PRAVOUHLY_A_C, "Pravoúhlý trojúhelník, známy strany A a C", 
                "délka strany A", "délka strany C", null));
        varianty.add(new Varianta(TypTrojuhelnika.ROVNOSTRANNY, "Rovnostranný trojuhelník",
                "délka strany", null,null));
        vstup = new CteniZKonsole();
    }
    
    /**
     * Metoda zobrazí nabídku z pole variant a přidá volbu Konec.
     */
    private void zobrazNabidku() {
        for (int i = 0; i< varianty.size(); i++) {
            System.out.printf("%2d. %s%n",i,varianty.get(i).getPopis());
        }
        System.out.println("-1. Konec");
    }
    
    /**
     * Metoda pro přístušnou volbu načte potřebné parametry, vytvoří Trojuhelnik a
     * zobrazí informace o trojúhelniku.
     * 
     * @param volba  - zvolená varianta z pole varianty
     */
    private void zobrazVysledky(int volba) {
        if ((volba < 0) | (volba >= varianty.size())) {  
            System.out.println("tuto volbu neznam");
            return;
        }
        Varianta var = varianty.get(volba);
        String dotaz1=var.getDotaz1();
        String dotaz2=var.getDotaz2();
        String dotaz3=var.getDotaz3();
        double [] parametry = new double[var.getPocetParametru()];
        if (dotaz1 != null) {
            parametry[0] = vstup.getDouble(dotaz1);
        }
        if (dotaz2 != null) {
            parametry[1] = vstup.getDouble(dotaz2);
        }
        if (dotaz3 != null) {
            parametry[2] = vstup.getDouble(dotaz3);
        }
        Trojuhelnik troj = Trojuhelnik.getTrojuhelnik(var.getTyp(), parametry);
        if (troj == null) {
            System.out.println("!!! metoda getTrojuhelnik nevratila pro zadane parametry trojuhelnik !!!!");
            System.out.println("\t typ: " + var.getTyp());
            for (int i=0; i < parametry.length; i++) {
                System.out.printf("\t parametry[%d] : %f%n",i,parametry[i]);
            }   
        }
        else {
            System.out.println("=== parametry trojuhelniku ===");
            System.out.printf("  strany: a=%14f  b=%14f  c=%14f%n",troj.getStranaA(),troj.getStranaB(),troj.getStranaC());
            System.out.printf("  uhly:   alfa=%11f  beta=%11f  gama=%11f%n",troj.getAlfa(),troj.getBeta(),troj.getGama());
            System.out.printf("  obvod:  %f%n",troj.obvod());
            System.out.printf("  obsah:  %f%n%n",troj.obsah());
        }
    }
    
    /**
     * Metoda přečte volbu uživatele. Neprovádí se kontrola přípustnosti vstupu.
     * 
     * @return volba uživatele
     */
    private int nactiVolbu() {
        return vstup.getInt("zadej volbu");
    }

    /**      
     * Metoda zajišťuje základní cyklus aplikace. Tj. 
     * <UL>
     *  <LI>zobrazení menu
     *  <LI>načtení volby od uživatele
     *  <LI>načtení potřebných parametrů
     *  <LI>zobrazení informací o trojúhelníku
     * </UL>
     * Toto pořadí se opakuje do té doby, než uživatel zvolí volbu Konec.
     */
    public void zakladniCyklus() {
        int volba = 0;
        zobrazNabidku();
        volba = nactiVolbu();
        while (volba != -1) {
            zobrazVysledky(volba);
            zobrazNabidku();
            volba = nactiVolbu();
        }
        System.out.println("Konec programu");
    }
    
    public static void main (String [] args) {
        Trojuhelniky troj = new Trojuhelniky();
        troj.zakladniCyklus();
    }
            
}
