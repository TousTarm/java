package logika;

import java.util.HashMap;
import java.util.Map;

public class SeznamPrikazu {
    // mapa pro uložení přípustných příkazů
    private  Map<String,IPrikaz> mapaSPrikazy;

    public SeznamPrikazu() {
        mapaSPrikazy = new HashMap<>();
    }

    public void vlozPrikaz(IPrikaz prikaz) {
        mapaSPrikazy.put(prikaz.getNazev(),prikaz);
    }

    public IPrikaz vratPrikaz(String retezec) {
        if (mapaSPrikazy.containsKey(retezec)) {
            return mapaSPrikazy.get(retezec);
        }
        else {
            return null;
        }
    }

    public boolean jePlatnyPrikaz(String retezec) {
        return mapaSPrikazy.containsKey(retezec);
    }

    public String vratNazvyPrikazu() {
        String seznam = "";
        for (String slovoPrikazu : mapaSPrikazy.keySet()){
            seznam += slovoPrikazu + " ";
        }
        return seznam;
    }
    
}

