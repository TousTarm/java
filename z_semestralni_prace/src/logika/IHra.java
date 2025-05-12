package logika;

/**
 * Rozhraní IHra definuje základní metody, které musí implementovat třída představující hru.
 * Toto rozhraní obsahuje metody pro interakci s hrou, jako je zobrazení uvítací zprávy, epilogu,
 * zpracování příkazů a kontrolu stavu hry.
 */
public interface IHra {

    /**
     * Vrátí uvítací zprávu pro hráče, která je zobrazena při začátku hry.
     *
     * @return Text uvítací zprávy.
     */
    String vratUvitani();

    /**
     * Vrátí epilog, který je zobrazen na konci hry.
     *
     * @return Text epilogu.
     */
    String vratEpilog();

    /**
     * Kontroluje, zda hra skončila.
     *
     * @return True, pokud hra skončila, jinak false.
     */
    boolean konecHry();

    /**
     * Zpracuje příkaz zadaný hráčem, provede odpovídající akci a vrátí textovou odpověď.
     *
     * @param radek Příkaz zadaný hráčem.
     * @return Odpověď na příkaz (například změněný stav hry nebo popis prostoru).
     */
    String zpracujPrikaz(String radek);

    /**
     * Vrátí herní plán, který obsahuje všechny herní prostory a objekty.
     *
     * @return Herní plán.
     */
    HerniPlan getHerniPlan();
}
