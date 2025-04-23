package logika;

import java.util.function.Consumer;

public class Npc {
    private String jmeno;
    private String zprava;
    private String prostor;
    private Consumer<Hra> action;

    public Npc(String jmeno, String zprava, String prostor) {
        this(jmeno, zprava, prostor, null); // Default: no action
    }

    public Npc(String jmeno, String zprava, String prostor, Consumer<Hra> action) {
        this.jmeno = jmeno;
        this.zprava = zprava;
        this.prostor = prostor;
        this.action = action;
    }

    public Consumer<Hra> getAction() {
        return action;
    }

    public String getZprava() {
        return getJmeno() + ": " + zprava;
    }

    public String getJmeno() {
        return jmeno;
    }
}
