public class Kalkulator
{

    private int hodnotaZobrazeni;
    private int prvniOperant;
    private int druhyOperant;
    private int last_action = 0;
    private int last_vysledek = 0;
    private char operator;
    private boolean noveCislo = true;

    private final int ZADNA_OPERACE = 0;
    private final int OPERACE_PLUS = 1;
    private final int OPERACE_MINUS = 2;



    /**
     *  konstruktor třídy
     */
    public Kalkulator () {
        hodnotaZobrazeni = 0;
    }

    /**
     * Metoda vrací hodnotu, která se má zobrazit na displayi kalkulacky. Tato metoda
     * se obvykle volá po zavolání metody odpovídající stisku tlačítka.
     *
     * @return   hodnota k zobrazení
     */

    public int getHodnotaKZobrazeni() {
        return hodnotaZobrazeni;
    }

    /**
     * metoda se volá při stisknutí tlačítka s číslicí na kalkulačce. Parametrem
     * je hodnota na stisknuté klávese.
     *
     * @param hodnota    hodnota na stisknutém tlačítku, hodnota je v rozsahu
     *                   od 0 do 9
     */
    public void cislice(int hodnota) {
        if (noveCislo) {
            hodnotaZobrazeni = hodnota;
            noveCislo = false;
        } else {
            // Check for overflow before updating the display value
            if (hodnotaZobrazeni <= (Integer.MAX_VALUE - hodnota) / 10) {
                hodnotaZobrazeni = (hodnotaZobrazeni * 10) + hodnota;
            } else {
                // Overflow case: Do nothing to prevent further input
                System.out.println("Přetečení rozsahu int! Další číslice nejsou povoleny.");
            }
        }
    }


    /**
     * metoda se volá při stisknutí tlačítka "+" (plus) na kalkulačce
     */
    public void plus() {
        prvniOperant = hodnotaZobrazeni;
        operator = OPERACE_PLUS;
        noveCislo = true;
    }


    /**
     * metoda se volá při stisknutí tlačítka "-" (minus) na kalkulačce
     */
    public void minus() {
        prvniOperant = hodnotaZobrazeni;
        operator = OPERACE_MINUS;
        noveCislo = true;
    }

    /**
     * metoda se volá při stisknutí tlačítka "=" (rovná se) na kalkulačce
     */
    public void rovnaSe() {
        if (hodnotaZobrazeni == 0) { // A + =
            druhyOperant = prvniOperant;
            switch (operator) {
                case OPERACE_PLUS -> {
                    hodnotaZobrazeni = prvniOperant + druhyOperant;
                    last_action = druhyOperant;
                }
                case OPERACE_MINUS -> {
                    hodnotaZobrazeni = prvniOperant - druhyOperant;
                    last_action = -druhyOperant;
                }
            }
        } else {
            if (hodnotaZobrazeni == last_vysledek && prvniOperant == 0) { // OPAKUJEME
                hodnotaZobrazeni = hodnotaZobrazeni + last_action;
            } else {
                druhyOperant = hodnotaZobrazeni;
                switch (operator) {
                    case OPERACE_PLUS -> {
                        hodnotaZobrazeni = prvniOperant + druhyOperant;
                        last_action = druhyOperant;
                    }
                    case OPERACE_MINUS -> {
                        hodnotaZobrazeni = prvniOperant - druhyOperant;
                        last_action = -druhyOperant;
                    }
                }
            }
        }
        last_vysledek = hodnotaZobrazeni;
        prvniOperant = 0;
        druhyOperant = 0;
        operator = ZADNA_OPERACE;
        noveCislo = true;
    }


    /**
     * metoda se volá při stisknutí tlačítka "C" (clear) na kalkulačce
     */
    public void vymaz() {
        hodnotaZobrazeni = 0;
        operator = ZADNA_OPERACE;
        noveCislo = true;
        prvniOperant = 0;
    }

    /**
     * metoda vrací jméno autora, např. "autor: Jan Novák"
     *
     * @return   řetězec se jménem autora
     */
    public String getAutor() {
        return "Tomas Rindt";
    }

    /**
     * metoda vrací označení verze, např. "verze 1.0.3"
     *
     * @return   řetězec s verzí programu
     */
    public String getVerze() {
        return "0.cyka.blyat";
    }

}