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
    public void optimalPlaytroughTest() {
        assertEquals("Vítejte!\n" +
                "Toto je příběh o skolení zlého draka.\n" +
                "Napište 'napoveda', pokud si nevíte rady, jak hrát dál.\n" +
                "\n" +
                "Jsi v mistnosti/prostoru vesnice, kde lidé žijí ve strachu z draka. Na náměstí tam stojí černokněžník.\n" +
                "východy: kovarna hrad knihovna", hra.vratUvitani());
        //1
        assertEquals("Jsi v mistnosti/prostoru hrad, na trůnu zde sedí sám král, v hradu je smutno a král je starý.\n" +
                "východy: vesnice kovarna knihovna",
                hra.zpracujPrikaz("jdi hrad"));
        //2
        assertEquals("Jsi v mistnosti/prostoru hrad, Král: ano, drak nám pálí pole, unáší náš lid. Když ho zabiješ, dám ti půl království. Mé stráže tě odvedou do knihovny pro mapu.\n"+
                "východy: vesnice kovarna knihovna",
                hra.zpracujPrikaz("mluv král"));
        //3
        assertEquals("Jsi v mistnosti/prostoru knihovna, leží tu spousta starých knih.\n" +
                "východy: vesnice kovarna hrad",
                hra.zpracujPrikaz("jdi knihovna"));
        //4
        assertEquals("Jsi v mistnosti/prostoru knihovna\n"+
                "Našel jsi: mapa\n" +
                "východy: vesnice kovarna hrad",
                hra.zpracujPrikaz("hledej"));
        //5
        assertEquals("Jsi v mistnosti/prostoru knihovna\n" +
                "mapa jsi vložil do batohu\n" +
                "východy: vesnice kovarna hrad",
                hra.zpracujPrikaz("seber mapa"));
        //6
        assertEquals("Jsi v mistnosti/prostoru kovarna, stárá kovárna, kovář zrovna dokoval nový meč.\n" +
                "východy: vesnice hrad knihovna",
                hra.zpracujPrikaz("jdi kovarna"));
        //7
        assertEquals("Jsi v mistnosti/prostoru kovarna, Kovář: zde máš meč. Naoplátku mi přines dračí zub.\n" +
                "východy: vesnice hrad knihovna",
                hra.zpracujPrikaz("mluv"));
        //8
        assertEquals("Jsi v mistnosti/prostoru kovarna\n" +
                "mec jsi vložil do batohu\n" +
                "východy: vesnice hrad knihovna",
                hra.zpracujPrikaz("seber mec"));
        //9
        assertEquals("Jsi v mistnosti/prostoru vesnice, kde lidé žijí ve strachu z draka. Na náměstí tam stojí černokněžník.\n" +
                "východy: lesni_cesta kovarna hrad knihovna",
                hra.zpracujPrikaz("jdi vesnice"));
        //10
        assertEquals("Jsi v mistnosti/prostoru vesnice, Černokněžník: drak je nebezpečný, potřebuješ se chránit proti ohni. Kouzlo 'fire_resistance' tě ochrání.\n" +
                "východy: lesni_cesta kovarna hrad knihovna",
                hra.zpracujPrikaz("mluv"));
        //11
        assertEquals("Jsi v mistnosti/prostoru lesni_cesta, plná žlutého listí. Leží tam kámen a stojí monolith. Na konci cesty je jeskyně.\n" +
                "východy: vesnice draci_doupe",
                hra.zpracujPrikaz("jdi lesni_cesta"));
        //12
        assertEquals("Jsi v mistnosti/prostoru draci_doupe, je tam spousta goblinů, až příliš mnoho. Jedna skupinka zrovna k tobě jde, ale nevidí tě.\n" +
                "východy: lesni_cesta",
                hra.zpracujPrikaz("jdi draci_doupe"));
        //13
        assertEquals("Jsi v mistnosti/prostoru draci_doupe\n" +
                "Schoval ses! Goblinové tě přehlédli a odcházejí pryč. Jeden z nich však stihl zamknout dveře k drakovi, možná půjde zámek zničit.\n" +
                "východy: lesni_cesta",
                hra.zpracujPrikaz("skryj_se"));
        //14
        assertEquals("Rychlým švihem jsi zámek přesek vejpůl a dveře se rozletěly.",
                hra.zpracujPrikaz("utok zamek"));
        //15
        assertEquals("Jsi v mistnosti/prostoru draci_sal, drak s obrovskými mocnými křídly a tlustou šupinatou kůží si te všimne a začne se smát. drak: 'Ty mně nikdy neporazíš', začne se zhluboka nadechovat.\n" +
                "východy: draci_doupe",
                hra.zpracujPrikaz("jdi draci_sal"));
        //16
        assertEquals("Jsi v mistnosti/prostoru draci_sal, vyčaroval jsi kouzlo: fire_resistence, jsi teď imuní vůči ohni!\n" +
                "Celé tvé tělo problesklo a hned na to na tebe drak vychrlil jeho ohňivý dech, překvapený, že jsi to přežil.\n" +
                "východy: draci_doupe",
                hra.zpracujPrikaz("vycaruj fire_resistence"));
        //17
        assertEquals("Jsi v mistnosti/prostoru draci_sal, vyčaroval jsi kouzlo: sword_enchant, tvůj meč je teď silnější.\n" +
                "Drak se polekal a začíná tě prosit o smilování.\n" +
                "východy: draci_doupe",
                hra.zpracujPrikaz("vycaruj sword_enchant"));
        //18
        assertEquals("Drakova hlava dopadá na zem po jednom hbitém zásahu. Celá místnost se začala třást, jeskyně se může zřítit.",
                hra.zpracujPrikaz("utok drak"));
        //19
        assertEquals("Jsi v mistnosti/prostoru draci_doupe, jen o vlásek jsi utekl z dračího sálu, který se celý zřítil a draka zaživa pohřbil. Goblini se vrací zpět zjistit co se stalo.\n" +
                "východy: lesni_cesta draci_sal",
                hra.zpracujPrikaz("jdi draci_doupe"));
        //20
        assertEquals("Jsi v mistnosti/prostoru lesni_cesta, goblini si všimli tvého útoku a běží směrem k tobě, je jich ale příliš mnoho.\n" +
                "východy: vesnice draci_doupe",
                hra.zpracujPrikaz("jdi lesni_cesta"));
        //21
        assertEquals("Jsi v mistnosti/prostoru lesni_cesta, vyčaroval jsi kouzlo: fire_ball, objevila se před tebou ohnivá koule, zasáhla strop doupěte a ten zasypal vstup i s gobliny. Království je tak zachráněno!\n" +
                        "východy: vesnice",
                hra.zpracujPrikaz("vycaruj fire_ball"));

        assertTrue(hra.konecHry());
        assertEquals("Drak je poražen, goblini uvězněni a ty jsi zachránil celé království! Hra končí. Díky za hraní", hra.vratEpilog());
    }

    @Test
    public void edgeCaseMluv(){
        assertEquals("Vítejte!\n" +
                "Toto je příběh o skolení zlého draka.\n" +
                "Napište 'napoveda', pokud si nevíte rady, jak hrát dál.\n" +
                "\n" +
                "Jsi v mistnosti/prostoru vesnice, kde lidé žijí ve strachu z draka. Na náměstí tam stojí černokněžník.\n" +
                "východy: kovarna hrad knihovna", hra.vratUvitani());

        assertEquals("Jsi v mistnosti/prostoru knihovna, leží tu spousta starých knih.\n" +
                        "východy: vesnice kovarna hrad",
                hra.zpracujPrikaz("jdi knihovna"));

        assertEquals("Jsi v mistnosti/prostoru knihovna, v místnosti nikdo není, proč mluvíš sám se sebou?\n" +
                        "východy: vesnice kovarna hrad",
                hra.zpracujPrikaz("mluv knihovna"));
    }

    @Test
    public void edgeCaseUtok(){
        assertEquals("Vítejte!\n" +
                "Toto je příběh o skolení zlého draka.\n" +
                "Napište 'napoveda', pokud si nevíte rady, jak hrát dál.\n" +
                "\n" +
                "Jsi v mistnosti/prostoru vesnice, kde lidé žijí ve strachu z draka. Na náměstí tam stojí černokněžník.\n" +
                "východy: kovarna hrad knihovna", hra.vratUvitani());

        assertEquals("Nemůžeš útočit bez meče!",
                hra.zpracujPrikaz("utok"));
    }

    @Test
    public void edgeCaseUtok2(){
        assertEquals("Vítejte!\n" +
                "Toto je příběh o skolení zlého draka.\n" +
                "Napište 'napoveda', pokud si nevíte rady, jak hrát dál.\n" +
                "\n" +
                "Jsi v mistnosti/prostoru vesnice, kde lidé žijí ve strachu z draka. Na náměstí tam stojí černokněžník.\n" +
                "východy: kovarna hrad knihovna", hra.vratUvitani());

        assertEquals("Jsi v mistnosti/prostoru kovarna, stárá kovárna, kovář zrovna dokoval nový meč.\n" +
                        "východy: vesnice hrad knihovna",
                hra.zpracujPrikaz("jdi kovarna"));

        assertEquals("Jsi v mistnosti/prostoru kovarna, Kovář: zde máš meč. Naoplátku mi přines dračí zub.\n" +
                        "východy: vesnice hrad knihovna",
                hra.zpracujPrikaz("mluv"));

        assertEquals("Jsi v mistnosti/prostoru kovarna\n" +
                        "mec jsi vložil do batohu\n" +
                        "východy: vesnice hrad knihovna",
                hra.zpracujPrikaz("seber mec"));

        assertEquals("Zde není na koho útočit.",
                hra.zpracujPrikaz("utok"));
    }

    @Test
    public void edgeCaseSeber(){
        assertEquals("Vítejte!\n" +
                "Toto je příběh o skolení zlého draka.\n" +
                "Napište 'napoveda', pokud si nevíte rady, jak hrát dál.\n" +
                "\n" +
                "Jsi v mistnosti/prostoru vesnice, kde lidé žijí ve strachu z draka. Na náměstí tam stojí černokněžník.\n" +
                "východy: kovarna hrad knihovna", hra.vratUvitani());

        assertEquals("Jsi v mistnosti/prostoru kovarna, stárá kovárna, kovář zrovna dokoval nový meč.\n" +
                        "východy: vesnice hrad knihovna",
                hra.zpracujPrikaz("jdi kovarna"));

        assertEquals("Jsi v mistnosti/prostoru kovarna, Kovář: zde máš meč. Naoplátku mi přines dračí zub.\n" +
                        "východy: vesnice hrad knihovna",
                hra.zpracujPrikaz("mluv"));

        assertEquals("Jsi v mistnosti/prostoru kovarna\n" +
                        "mec jsi vložil do batohu\n" +
                        "východy: vesnice hrad knihovna",
                hra.zpracujPrikaz("seber mec"));

        assertEquals("Jsi v mistnosti/prostoru knihovna, leží tu spousta starých knih.\n" +
                        "východy: vesnice kovarna hrad",
                hra.zpracujPrikaz("jdi knihovna"));

        assertEquals("Jsi v mistnosti/prostoru knihovna\n"+
                        "Našel jsi: mapa\n" +
                        "východy: vesnice kovarna hrad",
                hra.zpracujPrikaz("hledej"));

        assertEquals("Jsi v mistnosti/prostoru knihovna\n" +
                        "mapa jsi vložil do batohu\n" +
                        "východy: vesnice kovarna hrad",
                hra.zpracujPrikaz("seber mapa"));

        assertEquals("Jsi v mistnosti/prostoru vesnice, kde lidé žijí ve strachu z draka. Na náměstí tam stojí černokněžník.\n" +
                        "východy: lesni_cesta kovarna hrad knihovna",
                hra.zpracujPrikaz("jdi vesnice"));

        assertEquals("Jsi v mistnosti/prostoru lesni_cesta, plná žlutého listí. Leží tam kámen a stojí monolith. Na konci cesty je jeskyně.\n" +
                        "východy: vesnice draci_doupe",
                hra.zpracujPrikaz("jdi lesni_cesta"));

        assertEquals("Jsi v mistnosti/prostoru lesni_cesta\n" +
                        "kamen se nepodařilo vložit do batohu. Je již plný\n" +
                        "východy: vesnice draci_doupe",
                hra.zpracujPrikaz("seber kamen"));
    }

    @Test
    public void edgeCaseSeber2(){
        assertEquals("Vítejte!\n" +
                "Toto je příběh o skolení zlého draka.\n" +
                "Napište 'napoveda', pokud si nevíte rady, jak hrát dál.\n" +
                "\n" +
                "Jsi v mistnosti/prostoru vesnice, kde lidé žijí ve strachu z draka. Na náměstí tam stojí černokněžník.\n" +
                "východy: kovarna hrad knihovna", hra.vratUvitani());

        assertEquals("Jsi v mistnosti/prostoru knihovna, leží tu spousta starých knih.\n" +
                        "východy: vesnice kovarna hrad",
                hra.zpracujPrikaz("jdi knihovna"));

        assertEquals("Jsi v mistnosti/prostoru knihovna\n"+
                        "Našel jsi: mapa\n" +
                        "východy: vesnice kovarna hrad",
                hra.zpracujPrikaz("hledej"));

        assertEquals("Jsi v mistnosti/prostoru knihovna\n" +
                        "mapa jsi vložil do batohu\n" +
                        "východy: vesnice kovarna hrad",
                hra.zpracujPrikaz("seber mapa"));

        assertEquals("Jsi v mistnosti/prostoru vesnice, kde lidé žijí ve strachu z draka. Na náměstí tam stojí černokněžník.\n" +
                        "východy: lesni_cesta kovarna hrad knihovna",
                hra.zpracujPrikaz("jdi vesnice"));

        assertEquals("Jsi v mistnosti/prostoru lesni_cesta, plná žlutého listí. Leží tam kámen a stojí monolith. Na konci cesty je jeskyně.\n" +
                        "východy: vesnice draci_doupe",
                hra.zpracujPrikaz("jdi lesni_cesta"));

        assertEquals("Jsi v mistnosti/prostoru lesni_cesta\n" +
                        "monolith nedá se přenést\n" +
                        "východy: vesnice draci_doupe",
                hra.zpracujPrikaz("seber monolith"));
    }

    @Test
    public void edgeCasepoloz(){
        assertEquals("Vítejte!\n" +
                "Toto je příběh o skolení zlého draka.\n" +
                "Napište 'napoveda', pokud si nevíte rady, jak hrát dál.\n" +
                "\n" +
                "Jsi v mistnosti/prostoru vesnice, kde lidé žijí ve strachu z draka. Na náměstí tam stojí černokněžník.\n" +
                "východy: kovarna hrad knihovna", hra.vratUvitani());

        assertEquals("Jsi v mistnosti/prostoru vesnice\n" +
                        "Toto není v batohu\n" +
                        "východy: kovarna hrad knihovna",
                hra.zpracujPrikaz("poloz mapa"));
    }

    @Test
    public void edgeCaseJdi(){
        assertEquals("Vítejte!\n" +
                "Toto je příběh o skolení zlého draka.\n" +
                "Napište 'napoveda', pokud si nevíte rady, jak hrát dál.\n" +
                "\n" +
                "Jsi v mistnosti/prostoru vesnice, kde lidé žijí ve strachu z draka. Na náměstí tam stojí černokněžník.\n" +
                "východy: kovarna hrad knihovna", hra.vratUvitani());

        assertEquals("Jsi v mistnosti/prostoru vesnice\n" +
                        "Tam se odsud jít nedá!\n" +
                        "východy: kovarna hrad knihovna",
                hra.zpracujPrikaz("jdi lesni_cesta"));
    }

    @Test
    public void edgeCaseVycaruj(){
        assertEquals("Vítejte!\n" +
                "Toto je příběh o skolení zlého draka.\n" +
                "Napište 'napoveda', pokud si nevíte rady, jak hrát dál.\n" +
                "\n" +
                "Jsi v mistnosti/prostoru vesnice, kde lidé žijí ve strachu z draka. Na náměstí tam stojí černokněžník.\n" +
                "východy: kovarna hrad knihovna", hra.vratUvitani());

        assertEquals("Jsi v mistnosti/prostoru vesnice\n" +
                        "Neznámé kouzlo: fire_resistence\n" +
                        "východy: kovarna hrad knihovna",
                hra.zpracujPrikaz("vycaruj fire_resistence"));
    }


}
