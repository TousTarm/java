package logika;

import java.util.*;
import java.util.stream.Collectors;

public class Prostor {

    private String nazev;
    private String popis;
    private Set<Prostor> vychody;
    private List<Vec> seznamVeci;
    private Npc npc;

    public Prostor(String nazev, String popis) {
        this.nazev = nazev;
        this.popis = popis;
        vychody = new HashSet<>();
        seznamVeci = new ArrayList<Vec>();
        this.npc = null;
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

    public String normalniPopis(){
        return "Jsi v mistnosti/prostoru " + nazev;
    }

    public String dlouhyPopis() {
        return popis;
    }

    public String popisVychodu() {
        String vracenyText = "východy:";
        for (Prostor sousedni : vychody) {
            vracenyText += " " + sousedni.getNazev();
        }
        return vracenyText;
    }

    public Prostor vratSousedniProstor(String nazevSouseda) {
        List<Prostor>hledaneProstory =
            vychody.stream().filter(sousedni -> sousedni.getNazev().equals(nazevSouseda)).collect(Collectors.toList());
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

    public String seznamVeci() {
        StringBuilder sb = new StringBuilder("seznam věcí:");
        boolean firstItem = true;

        for (Vec vec : seznamVeci) {
            if (!vec.jeSkryta()) {
                if (firstItem) {
                    sb.append(" ");
                    firstItem = false;
                } else {
                    sb.append(" ");
                }
                sb.append(vec.getNazev());
            }
        }

        return sb.toString();
    }

    public List<Vec> getSeznamVeci() {
        return this.seznamVeci;
    }

    public void vlozNpc(Npc npc) {
        this.npc = npc;
    }

    public Npc getNpc() {
        return npc;
    }

    private boolean goblinEventActive = false;
    private boolean goblinEventResolved = false;

    public void triggerGoblinEvent() {
        if (!goblinEventResolved && this.nazev.equals("draci_doupe")) {
            goblinEventActive = true;
        }
    }

    public boolean resolveGoblinEvent() {
        if (goblinEventActive) {
            goblinEventActive = false;
            goblinEventResolved = true;
            return true;
        }
        return false;
    }

    public boolean isGoblinEventActive() {
        return goblinEventActive;
    }

    public void setPopis(String novyPopis) {
        this.popis = novyPopis;
    }

    public boolean odeberVychod(String nazevProstoru) {
        return vychody.removeIf(prostor -> prostor.getNazev().equals(nazevProstoru));
    }
}
