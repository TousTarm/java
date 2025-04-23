package logika;

public class PrikazSkryj_se implements IPrikaz {
    private static final String NAZEV = "skryj_se";
    private static boolean odhalen = true;

    @Override
    public String provedPrikaz(String... parametry) {
        odhalen = false;
        return "Úspěšně ses skryl. Nyní jsi neviditelný pro NPC.";
    }

    public static boolean jeOdhalen() {
        return odhalen;
    }

    public static boolean odhalit() {
        if (!odhalen) {
            odhalen = true;
            return true;
        }
        return false;
    }

    // Add this static method
    public static String getNazevStatic() {
        return NAZEV;
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}