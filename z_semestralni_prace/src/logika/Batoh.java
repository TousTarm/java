package logika;

import java.util.ArrayList;
import java.util.List;

public class Batoh {

    private static List<Vec> seznamVeci;
    private int omezeniBatohu;

    public Batoh(int omezeniBatohu) {
        this.omezeniBatohu = omezeniBatohu;
        seznamVeci = new ArrayList<Vec>();
    }

    public static String vypisBatohu() {
        String vypis = "Máš v batohu: ";
        for (Vec vec : seznamVeci) {
            vypis += vec.getNazev() + " ";
        }
        return vypis.trim(); // trim() odstraní přebytečné mezery na konci
    }


    public boolean obsahujeVec(String nazevVeci){
        for(Vec vec : seznamVeci){
           if (vec.getNazev().equals(nazevVeci)){
               return true;
           }
        }
        return false;
    }

    public boolean vlozitDoBatohu(Vec vec){
        if (seznamVeci.size() < omezeniBatohu){
            seznamVeci.add(vec);
            return true;
        }
        return false;
    }

    public Vec odeberZBatohu(String nazevVec){
        for (Vec vec : seznamVeci){
            if (vec.getNazev().equals(nazevVec)){
                return vec;
            }
        }
        return null;
    }
}
