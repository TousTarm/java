import java.util.ArrayList;
import java.util.Arrays;

public class Trojuhelniky {

    private ArrayList<TypTrojuhelnika> varianty; // List of triangle types
    private CteniZKonsole vstup;                // Console input handler

    public Trojuhelniky() {
        varianty = new ArrayList<>(Arrays.asList(TypTrojuhelnika.values())); // Load all triangle types
        vstup = new CteniZKonsole();
    }

    private void zobrazNabidku() {
        for (int i = 0; i < varianty.size(); i++) {
            System.out.printf("%2d %s%n", i + 1, varianty.get(i).getDescription());
        }
        System.out.println(" 0 Konec");
    }

    private void zobrazVysledky(int volba) {
        int index = volba - 1;

        if (index < 0 || index >= varianty.size()) {
            System.out.println("Invalid choice");
            return;
        }

        TypTrojuhelnika typ = varianty.get(index);
        String dotaz1 = typ.getQuestion1();
        String dotaz2 = typ.getQuestion2();
        String dotaz3 = typ.getQuestion3();
        double[] parametry = new double[typ.getParameterCount()];

        if (dotaz1 != null) {
            parametry[0] = vstup.getDouble(dotaz1);
        }
        if (dotaz2 != null) {
            parametry[1] = vstup.getDouble(dotaz2);
        }
        if (dotaz3 != null) {
            parametry[2] = vstup.getDouble(dotaz3);
        }

        Trojuhelnik troj = Trojuhelnik.getTrojuhelnik(typ, parametry);
        if (troj == null) {
            System.out.println("!!! metoda getTrojuhelnik nevratila pro zadane parametry trojuhelnik !!!!");
            System.out.println("\t typ: " + typ);
            for (int i = 0; i < parametry.length; i++) {
                System.out.printf("\t parametry[%d] : %f%n", i, parametry[i]);
            }
        } else {
            System.out.println("=== parametry trojuhelniku ===");
            System.out.printf("  strany: a=%14f  b=%14f  c=%14f%n", troj.getStranaA(), troj.getStranaB(), troj.getStranaC());
            System.out.printf("  uhly:   alfa=%11f  beta=%11f  gama=%11f%n", troj.getAlfa(), troj.getBeta(), troj.getGama());
            System.out.printf("  obvod:  %f%n", troj.obvod());
            System.out.printf("  obsah:  %f%n%n", troj.obsah());
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
            if (volba != 0) {
                zobrazVysledky(volba);
            }
        } while (volba != 0);
        System.out.println("Konec programu");
    }

    public static void main(String[] args) {
        Trojuhelniky troj = new Trojuhelniky();
        troj.zakladniCyklus();
    }
}
