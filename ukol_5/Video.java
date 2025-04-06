public class Video implements Polozka {
    private String titul;
    private String reziser;
    private int delka;
    private boolean vlastnim;
    private String komentar;

    public Video(String titul, String reziser, int delka) {
        this.titul = titul;
        this.reziser = reziser;
        this.delka = delka;
        this.vlastnim = false;
        this.komentar = "<bez komentáře>";
    }

    @Override
    public String getTitul() {
        return titul;
    }

    @Override
    public String getTyp() {
        return "Video";  // Vrátí typ jako "Video"
    }

    public void print() {
        System.out.print("video: " + titul + " (" + delka + " min)");
        if (vlastnim) {
            System.out.println("*");
        } else {
            System.out.println();
        }
        System.out.println("    " + reziser);
        System.out.println("    " + komentar);
    }
}
