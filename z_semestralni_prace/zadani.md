# Textová adventura

## Úvod
Vytvořte textovou adventuru, ve které hráč prozkoumává prostředí, sbírá předměty, řeší jednoduché logické úkoly a snaží se dosáhnout definovaného cíle.

## Popis hry
Hra se odehrává v omezeném prostoru (např. několik místností nebo oblastí), kde hráč interaguje s prostředím pomocí textových příkazů. Hráč má omezenou kapacitu inventáře a některé předměty nelze přenášet.

## Požadavky na implementaci

1. **Herní mechaniky**
    - Hráč se může pohybovat mezi místnostmi pomocí příkazů (např. `jdi sever`).
    - Hráč může sbírat a pokládat předměty (např. `seber klíč`, `polož klíč`).
    - Některé předměty jsou nepřenositelné (např. stůl, dveře).
    - Hra má definovaný konec, kdy hráč splní cíl (např. unikne z místnosti nebo nasbírá určité předměty).

2. **Ovládání hry**
    - Hra přijímá textové příkazy, např.:
        - `jdi <směr>`: Pohyb hráče.
        - `seber <předmět>`: Sebrání předmětu.
        - `polož <předmět>`: Položení předmětu.
        - `inventář`: Zobrazení aktuálního inventáře.
        - `prozkoumej <předmět>`: Zobrazení podrobností o předmětu.
        - `nápověda`: Zobrazení dostupných příkazů.
        - `konec`: Ukončení hry.

3. **Testy**
    - Otestujte, že hráč může hru vyhrát.
    - Ověřte, že hráč unese omezený počet věcí.
    - Zajistěte, že není možné sebrat nepřenositelné předměty.
    - Zahrňte testy scénáře, který bude součástí zadání.

4. **Technické požadavky**
    - Kód musí být napsán v jazyce Java.
    - Dodržujte standardní programátorské konvence.
    - Kód musí být otestován a upraven tak, aby neobsahoval chyby detekované nástrojem PMD (verze 6.23).

5. **Výstupy projektu**
    - Spustitelný archiv ve formátu `.jar`, který lze spustit příkazem:
      ```bash
      java -jar jmenoArchivu.jar
      ```
    - Uživatelská příručka obsahující:
        - Popis ovládání hry.
        - Cíl hry.
    - Soubor README s:
        - Stručným popisem hry.
        - Jménem autora.
        - Označením verze.
        - Poznámkami pro obhajobu (např. problémy při vývoji nebo poznámky k výstupům PMD).
    - Výstup z nástroje PMD ve formátu HTML.

## Návrh scénáře hry
1. Hráč se probudí v zamčené místnosti.
2. Místnost obsahuje stůl, židli a klíč.
3. Klíč je potřeba použít k odemčení dveří a opuštění místnosti.
4. K dispozici je další místnost s předměty, které mohou nebo nemusí být užitečné k dosažení cíle.
5. Úkolem hráče je uniknout z prostředí pomocí interakce s předměty a plnění logických úkolů.
