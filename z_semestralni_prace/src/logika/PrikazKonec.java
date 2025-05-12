/**
 * Třída implementující příkaz pro ukončení hry.
 * Tento příkaz ukončí hru bez dalších parametrů.
 */
package logika;

public class PrikazKonec implements IPrikaz {

    /** Název příkazu - konstantní, používá se pro identifikaci příkazu */
    private static final String NAZEV = "konec";

    /** Odkaz na hlavní logiku hry pro možnost ukončení */
    private Hra hra;

    /**
     * Konstruktor třídy
     *
     * @param hra instance hry, kterou bude příkaz ukončovat
     */
    public PrikazKonec(Hra hra) {
        this.hra = hra;
    }

    /**
     * Provádí příkaz "konec".
     * Pokud jsou zadány parametry, vrátí chybové hlášení.
     * Jinak ukončí hru.
     *
     * @param parametry parametry příkazu (očekává se prázdné pole)
     * @return textová odpověď hry
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length > 0) {
            return "Ukončit co? Nechápu, proč jste zadal druhé slovo.";
        }
        else {
            hra.setKonecHry(true);
            return "hra ukončena příkazem konec";
        }
    }

    /**
     * Vrací název příkazu
     *
     * @return název příkazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
}