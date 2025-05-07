------------------------------------------------------------------------
Projekt 'Trojuhelniky'
------------------------------------------------------------------------

Copyright (c) Lubos Pavlicek, 2004
              VSE Praha

Toto je jednoduchy projekt, ktery je urcen pro vyuku v uvodnim kursu objektove
orientovaneho programovani v Jave v prostedi BlueJ.

Projekt predstavuje zaklad textove aplikace pro vypocet zakladnich parametru
trouhelniku - strany, uhly, obvod a obsah. Aplikace zobrazi nabidku podporovanych
typu trojuhelniku, uzivatel si vybere konkretni typ, doplni parametry a aplikace
zbyvajici udaje dopocte.

Postup spusteni aplikace je nasledujici:
- vytvoreni instance tridy Trojuhelniky
- zavolani metody zakladniCyklus, ktera zajistuje zakladni cyklus prubehu aplikace:
   - zobrazeni nabidky,
   - precteni volby uzivatele,
   - precteni prislusnych parametru,
   - zobrazeni udaju o trojuhelniku.
   
Aplikace v soucasnem stavu podporuje dva typy pravouhlych trojuhelniku, ukolem studentu
je ji doplnit o dalsi typy, napr.
- rovnostranny trojuhelnik,
- obecny trojuhelnik, u ktere jsou znamy velikost vsech tri stran,
- pravouhly trojuhelnik, u ktereho je znama velikost prepony a úhlu mezi preponou
  a odvesnou a,

Tento projekt ma nasledujici cile:
- ukazat aplikaci s textovym rozhranim,
- ukazat navrh statickych metod pro ziskani instance tridy,
- deklarace a pouzivani ciselnych konstant (bez zajisteni typove kontroly),
- vytvoreni pomocne tridy pro uchovani atributu jednotlivych variant,
- jednoduchy zpusob provazani variant s prislusnymi metodami pomoci konstant
   (typove bezpecne varianty propojeni datovych atributu s metodami jsou mimo
   moznosti v teto fazi vyuky),
