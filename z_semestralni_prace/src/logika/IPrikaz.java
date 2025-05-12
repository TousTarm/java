package logika;

/**
 * Rozhraní IPrikaz definuje základní metody, které musí implementovat všechny příkazy ve hře.
 * Každý příkaz by měl být schopen provést nějakou akci a vrátit textovou odpověď,
 * a také poskytovat název příkazu, který je používán k jeho identifikaci.
 */
interface IPrikaz {

    /**
     * Provede akci spojenou s tímto příkazem. Metoda může přijmout parametry,
     * které jsou předány příkazem a vrátit textovou odpověď, která popisuje výsledek.
     *
     * @param parametry Parametry příkazu, které mohou být použity pro specifikaci akce.
     * @return Textová odpověď na provedení příkazu (např. výsledek akce, popis změn ve hře).
     */
    String provedPrikaz(String... parametry);

    /**
     * Vrátí název příkazu, který je používán pro jeho identifikaci.
     *
     * @return Název příkazu.
     */
    String getNazev();
}
