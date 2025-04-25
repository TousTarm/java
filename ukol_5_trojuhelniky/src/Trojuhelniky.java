import java.util.ArrayList;

public class Trojuhelniky {

    private ArrayList<Varianta> varianty;   // pole obsahující jednotlivé varianty
    private CteniZKonsole vstup;            // třída pro vstup z konzole

    public Trojuhelniky() {
        varianty = new ArrayList<Varianta>();
        varianty.add(new Varianta(TypTrojuhelnika.PRAVOUHLY_A_B,
                "Right-angled triangle (sides A and B)",
                "side A length", "side B length", null));
        varianty.add(new Varianta(TypTrojuhelnika.PRAVOUHLY_A_C,
                "Right-angled triangle (side A and hypotenuse C)",
                "side A length", "hypotenuse C length", null));
        varianty.add(new Varianta(TypTrojuhelnika.ROVNOSTRANNY,
                "Equilateral triangle",
                "side length", null, null));
        varianty.add(new Varianta(TypTrojuhelnika.OBECNY_ABC,
                "General triangle (three sides)",
                "side A length", "side B length", "side C length"));
        varianty.add(new Varianta(TypTrojuhelnika.OBECNY_AB_ALFA,
                "General triangle (two sides and included angle)",
                "side A length", "side B length", "angle α (degrees)"));
        varianty.add(new Varianta(TypTrojuhelnika.OBECNY_ALFA_BETA_A,
                "General triangle (two angles and side)",
                "angle α (degrees)", "angle β (degrees)", "side A length"));

        vstup = new CteniZKonsole();
    }

    private void zobrazNabidku() {
        for (int i = 0; i < varianty.size(); i++) {
            System.out.printf("%2d %s%n", i+1, varianty.get(i).getPopis());
        }
        System.out.println(" 0 Konec");
    }

    private void zobrazVysledky(int volba) {
        int index = volba - 1;

        if (index < 0 || index >= varianty.size()) {
            System.out.println("Invalid choice");
            return;
        }
        Varianta var = varianty.get(index);
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

    private int nactiVolbu() {
        return vstup.getInt("zadej volbu");
    }

    public void zakladniCyklus() {
        int volba;
        do {
            zobrazNabidku();
            volba = nactiVolbu();
            if (volba != 0) {  // Changed from -1 to 0
                zobrazVysledky(volba);
            }
        } while (volba != 0);  // Changed from -1 to 0
        System.out.println("Konec programu");
    }
    
    public static void main (String [] args) {
        Trojuhelniky troj = new Trojuhelniky();
        troj.zakladniCyklus();
    }
            
}
