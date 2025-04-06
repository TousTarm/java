package logika;

import java.util.ArrayList;
import java.util.List;

public class Batoh {
    private List<Vec> seznamVeci;
    private int omezeniBatohu;

    public Batoh(int omezeniBatohu) {
        this.omezeniBatohu = omezeniBatohu;
        seznamVeci = new ArrayList<Vec>();
    }

    public String dlouhyPopis(){
        return "V batohu je:" ;
    }

    private String vypisBatohu(){
        String vypis = "";
        for (Vec vec : seznamVeci) {
            vypis += vec.getNazev() + " ";
        }
        return vypis;
    }

    public boolean vlozitDoBatohu(Vec vec){
        if (seznamVeci.size()<omezeniBatohu) {
            seznamVeci.add(vec);
            return true;
        }
        return false;
    }

    public Vec odeberZBatohu(String nazevVec){
        for (Vec vec : seznamVeci) {
            if (vec.getNazev().equals(nazevVec)) {
                return vec;
            }
        }
        return null;
    }
}
