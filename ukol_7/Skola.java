
/**
 * Tato třída je součástí projektu Skola a obsahuje základní třídu pro školu. V konstruktoru je i inicializace
 * organizační struktury školy.
 *
 * @author     Luboš Pavlíček
 * @version    1.0, srpen 2004
 */
public class Skola {

    private Utvar skola;
    
    /**
     * Konstruktor pro objekty tridy Skola
     */
    public Skola() {
        //Inicializujte atributy instance
        skola = new Utvar("VŠE","Vysoká škola ekonomická");
        Utvar fak1 = new Utvar("F1","Fakulta financí a účetnictví");
        Utvar fak2 = new Utvar("F2","Fakulta mezinárodních vztahů");
        Utvar fak3 = new Utvar("F3","Fakulta podnikohospodářská");
        Utvar fak4 = new Utvar("F4","Fakulta informatiky a statistiky");
        Utvar fak5 = new Utvar("F5","Fakulta národohospodářská");
        Utvar fak6 = new Utvar("F6","Fakulta managementu");
        skola.pridej(fak1);
        skola.pridej(fak2);
        skola.pridej(fak3);
        skola.pridej(fak4);
        skola.pridej(fak5);
        skola.pridej(fak6);
        fak4.pridej(new Utvar("KMAT","katedra matematiky"));
        Utvar kstp = new Utvar("KSTP","katedra statistiky");
        fak4.pridej(new Utvar("KEST","katedra ekonomické statistiky"));
        fak4.pridej(new Utvar("KDEM","katedra demografie"));
        fak4.pridej(new Utvar("KEKO","katedra ekonometrie"));
        fak4.pridej(new Utvar("KSA","katedra systémové analýzy"));
        fak4.pridej(new Utvar("KIZI","katedra informačního a znalostního inženýrství"));
        fak4.pridej(new Utvar("KFIL","katedra filosofie"));
        Utvar kit = new Utvar("KIT","katedra informačních technologii");
        fak4.pridej(kit);
        fak4.pridej(kstp);
        skola.pridej(new Osoba("Durčáková Jaroslava", "Doc. Ing.", "CSc."));
        Osoba dekan = new Osoba ("Hindls Richard", "Prof. Ing.", "CSc.");
        fak4.pridej(dekan);
        kstp.pridej(dekan);
        kit.pridej(new Osoba("Voříšek Jiří","Prof. Ing.", "CSc."));
        kit.pridej(new Osoba("Buchalcevová Alena", "Ing.","PhD."));
        kit.pridej(new Osoba("Pavlíčková Jarmila", "Ing.",""));
        kit.pridej(new Osoba("Pavlíček Luboš","Ing.",""));
        kit.pridej(new Osoba("Šimůnek Milan", "Ing.","PhD."));
        kit.pridej(new Osoba("Tichý Vladimír", "RNDr.",""));
    }
    
    /**
     * Metoda vypíše organizační strukturu
     *
     * @param vcetneOsob zda vypsat i osoby přiřazené do jednotlivých útvarů
     */
    public void vypis(boolean vcetneOsob) {
        skola.vypis(vcetneOsob);
    }

    /**
     * Metoda vypíše organizační strukturu
     *
     * @param vcetneOsob zda vypsat i osoby přiřazené do jednotlivých útvarů
     * @param uroven
     */
    public void vypis(boolean vcetneOsob, int uroven) {
        skola.vypis(vcetneOsob, uroven);
    }

    public void vypis2(boolean vcetneOsob,int uroven) {
        skola.vypis2(vcetneOsob, uroven);
    }


}
