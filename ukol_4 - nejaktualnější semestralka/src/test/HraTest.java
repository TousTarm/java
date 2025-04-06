import logika.Hra;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HraTest {

    private Hra hra;

    @BeforeEach
    public void setUp() {
        hra = new Hra();
    }

    @Test
    public void testSlayingDragonScenario() {
        // Uvítání - zapnutí hry
        assertEquals("Vítejte!\n" +
                "Toto je příběh o skolení zlého draka.\n" +
                "Napište 'nápověda', pokud si nevíte rady, jak hrát dál.\n" +
                "\n" +
                "Jsi v mistnosti/prostoru vesnice, kde lidé žijí ve strachu z draka. Vesničan ti poví, že král dá půl království komukoliv, kdo zlého draka skolí\n" +
                "východy: knihovna kovárna hrad", hra.vratUvitani());
        //1
        assertEquals("Jsi v mistnosti/prostoru hrad, na trůnu zde sedí sám král, v hradu je smutno a král je starý\n" +
                "východy: vesnice knihovna kovarna",
                hra.zpracujPrikaz("jdi hrad"));
        //2
        assertEquals("Jsi v mistnosti/prostoru hrad, ano, drak nám pálí pole, unáší náš lid. Když ho zabiješ, dám ti půl království. Mé stráže tě odvedou do knihovny pro mapu.\n"+
                "východy: vesnice knihovna kovarna\n",
                hra.zpracujPrikaz("mluv král"));
        //3
        assertEquals("Jsi v mistnosti/prostoru knihovna, kam tě dovedli stráže. Poví ti, že mapa je ztracená a ty ji musíš najít. V knihovně je stará polička, rozbitá skřín a stůl.\n" +
                "východy: vesnice kovarna hrad\n"+
                "prohledání: policka skrin stul",
                hra.zpracujPrikaz("jdi knihovna"));
        //4
        assertEquals("Jsi v mistnosti/prostoru knihovna, pod stolem jsi nahmatal píčku. Ta ti otevřela tajný šuplík ve stolu, kde leží mapa\n"+
                "východy: vesnice kovarna hrad\n"+
                "prohledání: policka skrin",
                hra.zpracujPrikaz("hledej stul"));
        //5
        assertEquals("Jsi v mistnosti/prostoru knihovna, Mapa ti ukázala cestu, která vede lesní cestou z vesnice\n" +
                "východy: vesnice kovarna hrad",
                hra.zpracujPrikaz("seber mapa"));
        //6
        assertEquals("Jsi v mistnosti/prostoru kovarna, kovář ti nabídl meč, když mu zpět přineseš dračí zub\n" +
                "východy: vesnice hrad knihovna",
                hra.zpracujPrikaz("jdi kovarna"));
        //7
        assertEquals("Jsi v mistnosti/prostoru kovarna, kovářovu nabídku jsi přijal a meč jsi si vzal\n" +
                "východy: vesnice hrad knihovna",
                hra.zpracujPrikaz("seber meč"));
        //8
        assertEquals("Jsi v mistnosti/prostoru vesnice, vesničané mají radost že jim pomůžeš, a přejí ti hodně štěstí. V davu však stojí postava v černém plášti [cernokneznik] a kouká přímo na tebe\n" +
                        "východy: hrad knihovna kovarna lesni_cesta",
                hra.zpracujPrikaz("jdi vesnice"));
        //9
        assertEquals("Jsi v mistnosti/prostoru vesnice, cernokneznik ti prozradi kouzlo na ochranu pred ohnem, stačí vycarovat 'fire_resistence'\n" +
                "východy: hrad knihovna kovarna lesni_cesta",
                hra.zpracujPrikaz("mluv cernokneznik"));
        //10
        assertEquals("Jsi v mistnosti/prostoru lesni_cesta, ta však po chvíli narazí na skálu a dál nepokračuje. Cítíš však smrad a v dálce vidíš starou chatrč\n" +
                "východy: vesnice",
                hra.zpracujPrikaz("jdi lesni_cesta"));
        //11
        assertEquals("Jsi v mistnosti/prostoru lesni_cesta, když ho začneš následovat, najdeš vstup do jeskyně\n" +
                "východy: vesnice draci_doupe",
                hra.zpracujPrikaz("hledej smrad"));

        //12
        assertEquals("Jsi v mistnosti/prostoru draci_doupe, je tam spousta goblinů, až příliš mnoho. Jedna skupinka zrovna k tobě jde, ale nevidí tě.\n" +
                "východy: lesni_cesta draci_sal",
                hra.zpracujPrikaz("jdi draci_doupe"));

        //13
        assertEquals("Jsi v mistnosti/prostoru draci_doupe, před gobliny jsi se jen tak tak stihl skovat. Ti najednou uslyší zvon a všichni odběhnou\n" +
                "východy: dračí_doupě",
                hra.zpracujPrikaz("skryj_se"));

        //14
        assertEquals("Jsi v mistnosti/prostoru draci_sal, drak s obrovskými mocnými křídly a tlustou šupinatou kůží si te všimne a začne se smát. drak: 'Ty mně nikdy neporazíš', začne se zhluboka nadechovat\n" +
                "východy: dračí_doupě",
                hra.zpracujPrikaz("jdi draci_sal"));

        //15
        assertEquals("Jsi v mistnosti/prostoru draci_sal, vyčaroval si kouzlo 'fire_resistence'. Celé tvé tělo problesklo a hned na to na tebe drak vychrlil jeho ohňivý dech, překvapený, že jsi to přežil\n" +
                "východy: dračí_doupě", hra.zpracujPrikaz("vycaruj fire_resistence"));

        //17
        assertEquals("Jsi v mistnosti/prostoru draci_sal, tvůj meč se rozzářil světle modrou barvou, drak se polekal a začíná tě prosit o smilování\n" +
                "východy: dračí_doupě", hra.zpracujPrikaz("vycaruj sword_enchant"));

        //18
        assertEquals("Jsi v mistnosti/prostoru draci_sal, drakova hlava dopadá na zem po jednom hbytém zásahu\n" +
                "východy: dračí_doupě", hra.zpracujPrikaz("utok mec"));

        //19
        assertEquals("Jsi v mistnosti/prostoru draci_sal, z hlavy jsi vytrh pár zubů, a hlavu jsi popadl\n" +
                "východy: dračí_doupě", hra.zpracujPrikaz("hledej draci_hlava"));

        //mužu dodělat cestu zpět ale přijde mi zbytečna

        assertTrue(hra.konecHry());
        assertEquals("Drak je poražen, a ty jsi zachránil celé království! Hra končí. Díky za hraní", hra.vratEpilog());
    }
}
