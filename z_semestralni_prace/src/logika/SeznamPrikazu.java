package logika;

import java.util.HashMap;
import java.util.Map;

/**
 * Třída SeznamPrikazu spravuje seznam všech dostupných příkazů ve hře.
 * Umožňuje přidávání příkazů, jejich vyhledávání a ověřování platnosti.
 */
public class SeznamPrikazu {
    // Mapa pro ukládání příkazů, kde klíčem je název příkazu
    private Map<String, IPrikaz> mapaSPrikazy;

    /**
     * Konstruktor vytvoří nový seznam příkazů.
     * Inicializuje prázdnou mapu pro ukládání příkazů.
     */
    public SeznamPrikazu() {
        mapaSPrikazy = new HashMap<>();
    }

    /**
     * Vloží nový příkaz do seznamu příkazů.
     *
     * @param prikaz instance příkazu implementující rozhraní IPrikaz
     */
    public void vlozPrikaz(IPrikaz prikaz) {
        mapaSPrikazy.put(prikaz.getNazev(), prikaz);
    }

    /**
     * Vrátí příkaz podle zadaného názvu.
     *
     * @param retezec název hledaného příkazu
     * @return instance příkazu nebo null, pokud příkaz neexistuje
     */
    public IPrikaz vratPrikaz(String retezec) {
        if (mapaSPrikazy.containsKey(retezec)) {
            return mapaSPrikazy.get(retezec);
        } else {
            return null;
        }
    }

    /**
     * Ověří, zda zadaný řetězec je platným názvem příkazu.
     *
     * @param retezec testovaný název příkazu
     * @return true pokud příkaz existuje, jinak false
     */
    public boolean jePlatnyPrikaz(String retezec) {
        return mapaSPrikazy.containsKey(retezec);
    }

    /**
     * Vrátí textový řetězec obsahující všechny názvy dostupných příkazů.
     *
     * @return řetězec s mezerami oddělenými názvy příkazů
     */
    public String vratNazvyPrikazu() {
        String seznam = "";
        for (String slovoPrikazu : mapaSPrikazy.keySet()) {
            seznam += slovoPrikazu + " ";
        }
        return seznam;
    }
}