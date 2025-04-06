public class CD implements Polozka {
    private String titul;
    private String umelec;
    private int pocetSkladeb;
    private int delka;
    private boolean vlastnim;
    private String komentar;

    public CD(String titul, String umelec, int pocetSkladeb, int delka) {
        this.titul = titul;
        this.umelec = umelec;
        this.pocetSkladeb = pocetSkladeb;
        this.delka = delka;
        this.vlastnim = false;
        this.komentar = "<Bez komentáře>";
    }

    @Override
    public String getTitul() {
        return titul;
    }

    @Override
    public String getTyp() {
        return "CD";  // Vrátí typ jako "CD"
    }

    public void print() {
        System.out.print("CD: " + titul + " (" + delka + " min)");
        if (vlastnim) {
            System.out.println("*");
        } else {
            System.out.println();
        }
        System.out.println("    " + umelec);
        System.out.println("    počet skladeb: " + pocetSkladeb);
        System.out.println("    " + komentar);
    }
}
