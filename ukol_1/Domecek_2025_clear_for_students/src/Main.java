public class Main {
    public static void main(String[] args) throws InterruptedException {
        Obrazek obrazek = new Obrazek();
        obrazek.kresli();

        obrazek.prijezdAuta();
        Thread.sleep(500);
        obrazek.odjezdAuta();
        obrazek.prijezdTanku();
        Thread.sleep(500);
        obrazek.odjezdTanku();
    }
}
