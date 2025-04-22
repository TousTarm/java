package logika;

import java.util.*;
import java.util.stream.Collectors;

public class Prostor {

    private String nazev;
    private String popis;
    private Set<Prostor> vychody;   // obsahuje sousední místnosti
    private List<Vec> seznamVeci;

    public Prostor(String nazev, String popis) {
        this.nazev = nazev;
        this.popis = popis;
        vychody = new HashSet<>();
        seznamVeci = new ArrayList<Vec>();
    }

    public void setVychod(Prostor vedlejsi) {
        vychody.add(vedlejsi);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Prostor)) {
            return false;
        }
        Prostor druhy = (Prostor) o;
       return (java.util.Objects.equals(this.nazev, druhy.nazev));
    }

    @Override
    public int hashCode() {
        int vysledek = 3;
        int hashNazvu = java.util.Objects.hashCode(this.nazev);
        vysledek = 37 * vysledek + hashNazvu;
        return vysledek;
    }

    public String getNazev() {
        return nazev;       
    }

    public String dlouhyPopis() {
        return "Jsi v mistnosti/prostoru " + popis + ".\n"
                + popisVychodu() + "\n"
                + seznamVeci();
    }

    private String popisVychodu() {
        String vracenyText = "východy:";
        for (Prostor sousedni : vychody) {
            vracenyText += " " + sousedni.getNazev();
        }
        return vracenyText;
    }

    public Prostor vratSousedniProstor(String nazevSouseda) {
        List<Prostor>hledaneProstory = 
            vychody.stream()
                   .filter(sousedni -> sousedni.getNazev().equals(nazevSouseda))
                   .collect(Collectors.toList());
        if(hledaneProstory.isEmpty()){
            return null;
        }
        else {
            return hledaneProstory.get(0);
        }
    }

    public Collection<Prostor> getVychody() {
        return Collections.unmodifiableCollection(vychody);
    }

    public void vlozVec(Vec neco){
        seznamVeci.add(neco);
    }

    public boolean obsahujeVec(String nazevVeci){
        for(Vec vec : seznamVeci){
            if(vec.getNazev().equals(nazevVeci)){
                return true;
            }
        }
        return false;
    }

    public Vec vyberVec(String nazevVeci){
        Vec vybranaVec = null;
        for (Vec vec : seznamVeci){
            if(vec.getNazev().equals(nazevVeci)){
                vybranaVec = vec;
            }
        }
        if (vybranaVec != null) {
            if (vybranaVec.jePrenositelna()){
                seznamVeci.remove(vybranaVec);
            } else {
              vybranaVec = null;
            }
        }
        return vybranaVec;
    }

    private String seznamVeci(){
        String seznam = "Seznam věcí: ";
        for (Vec vec : seznamVeci){
            seznam += vec.getNazev() + " ";
        }
        return seznam;
    }
}
