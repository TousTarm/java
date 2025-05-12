package logika;

import java.util.function.Consumer;

/**
 * Třída Npc představuje nehráčskou postavu (NPC) ve hře.
 * Každá NPC má jméno, zprávu, prostor, ve kterém se nachází, a volitelnou akci,
 * kterou může provést, když je interagováno s danou postavou.
 */
public class Npc {

    // Jméno NPC
    private String jmeno;

    // Zpráva, kterou NPC říká nebo poskytuje
    private String zprava;

    // Prostor, ve kterém se NPC nachází
    String prostor;

    // Akce, kterou může NPC vykonat (volitelná, může být null)
    private Consumer<Hra> action;

    /**
     * Konstruktor pro vytvoření NPC bez akce (akce je nastavena na null).
     *
     * @param jmeno Jméno NPC.
     * @param zprava Zpráva, kterou NPC říká.
     * @param prostor Prostor, ve kterém se NPC nachází.
     */
    public Npc(String jmeno, String zprava, String prostor) {
        this(jmeno, zprava, prostor, null); // Default: no action
    }

    /**
     * Konstruktor pro vytvoření NPC s možností definovat akci, kterou může vykonat.
     *
     * @param jmeno Jméno NPC.
     * @param zprava Zpráva, kterou NPC říká.
     * @param prostor Prostor, ve kterém se NPC nachází.
     * @param action Akce, kterou NPC provede, když dojde k interakci (může být null).
     */
    public Npc(String jmeno, String zprava, String prostor, Consumer<Hra> action) {
        this.jmeno = jmeno;
        this.zprava = zprava;
        this.prostor = prostor;
        this.action = action;
    }

    /**
     * Vrátí akci, kterou NPC provede při interakci.
     *
     * @return Akce NPC nebo null, pokud není žádná akce definována.
     */
    public Consumer<Hra> getAction() {
        return action;
    }

    /**
     * Vrátí zprávu, kterou NPC říká, formátovanou s jejím jménem.
     *
     * @return Formátovaná zpráva NPC.
     */
    public String getZprava() {
        return ", " + getJmeno() + ": " + zprava;
    }

    /**
     * Vrátí jméno NPC.
     *
     * @return Jméno NPC.
     */
    public String getJmeno() {
        return jmeno;
    }
}
