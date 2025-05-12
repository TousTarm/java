package logika;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Třída Prostor představuje jednotlivé prostory (místnosti) ve hře.
 * Každý prostor má název, popis, seznam východů, seznam věcí a může obsahovat NPC.
 */
public class Prostor {

    // Název prostoru (místnosti)
    private String nazev;
    // Popis prostoru
    private String popis;
    // Množina sousedních prostorů (východů)
    private Set<Prostor> vychody;
    // Seznam věcí v prostoru
    private List<Vec> seznamVeci;
    // NPC nacházející se v prostoru (null pokud žádné není)
    private Npc npc;

    /**
     * Konstruktor pro vytvoření prostoru se zadaným názvem a popisem.
     *
     * @param nazev název prostoru (místnosti)
     * @param popis popis prostoru
     */
    public Prostor(String nazev, String popis) {
        this.nazev = nazev;
        this.popis = popis;
        vychody = new HashSet<>();
        seznamVeci = new ArrayList<>();
        this.npc = null;
    }

    /**
     * Přidá východ do sousedního prostoru.
     *
     * @param vedlejsi sousední prostor, který se má přidat jako východ
     */
    public void setVychod(Prostor vedlejsi) {
        vychody.add(vedlejsi);
    }

    /**
     * Porovná tento prostor s jiným objektem.
     *
     * @param o objekt k porovnání
     * @return true pokud jsou prostory stejné nebo mají stejný název, jinak false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Prostor)) {
            return false;
        }
        Prostor druhy = (Prostor) o;
        return Objects.equals(this.nazev, druhy.nazev);
    }

    /**
     * Vypočítá hash code prostoru na základě jeho názvu.
     *
     * @return hash code prostoru
     */
    @Override
    public int hashCode() {
        return 37 * 3 + Objects.hashCode(this.nazev);
    }

    /**
     * Vrátí název prostoru.
     *
     * @return název prostoru
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * Vrátí základní popis prostoru.
     *
     * @return základní popis ve formátu "Jsi v mistnosti/prostoru [název]"
     */
    public String normalniPopis() {
        return "Jsi v mistnosti/prostoru " + nazev;
    }

    /**
     * Vrátí dlouhý popis prostoru.
     *
     * @return dlouhý popis prostoru
     */
    public String dlouhyPopis() {
        return popis;
    }

    /**
     * Vrátí textový popis východů z tohoto prostoru.
     *
     * @return textový řetězec se seznamem východů
     */
    public String popisVychodu() {
        StringBuilder vracenyText = new StringBuilder("východy:");
        for (Prostor sousedni : vychody) {
            vracenyText.append(" ").append(sousedni.getNazev());
        }
        return vracenyText.toString();
    }

    /**
     * Najde a vrátí sousední prostor podle názvu.
     *
     * @param nazevSouseda název hledaného sousedního prostoru
     * @return sousední prostor nebo null, pokud prostor s daným názvem není východem
     */
    public Prostor vratSousedniProstor(String nazevSouseda) {
        return vychody.stream()
                .filter(sousedni -> sousedni.getNazev().equals(nazevSouseda))
                .findFirst()
                .orElse(null);
    }

    /**
     * Vrátí nemodifikovatelnou kolekci východů z tohoto prostoru.
     *
     * @return nemodifikovatelná kolekce východů
     */
    public Collection<Prostor> getVychody() {
        return Collections.unmodifiableCollection(vychody);
    }

    /**
     * Vloží věc do prostoru.
     *
     * @param neco věc, která se má vložit do prostoru
     */
    public void vlozVec(Vec neco) {
        seznamVeci.add(neco);
    }

    /**
     * Zjistí, zda prostor obsahuje věc s daným názvem.
     *
     * @param nazevVeci název hledané věci
     * @return true pokud prostor obsahuje věc s daným názvem, jinak false
     */
    public boolean obsahujeVec(String nazevVeci) {
        return seznamVeci.stream().anyMatch(vec -> vec.getNazev().equals(nazevVeci));
    }

    /**
     * Vybere a odstraní věc z prostoru, pokud je přenositelná.
     *
     * @param nazevVeci název věci, kterou chceme vybrat
     * @return vybranou věc nebo null, pokud věc není přenositelná nebo neexistuje
     */
    public Vec vyberVec(String nazevVeci) {
        for (Vec vec : seznamVeci) {
            if (vec.getNazev().equals(nazevVeci)) {
                if (vec.jePrenositelna()) {
                    seznamVeci.remove(vec);
                    return vec;
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    /**
     * Vrátí textový seznam věcí v prostoru (kromě skrytých věcí).
     *
     * @return textový řetězec se seznamem věcí ve formátu "seznam věcí: [věci]"
     */
    public String seznamVeci() {
        return seznamVeci.stream()
                .filter(vec -> !vec.jeSkryta())
                .map(Vec::getNazev)
                .collect(Collectors.joining(" ", "seznam věcí: ", ""));
    }

    /**
     * Vrátí seznam všech věcí v prostoru.
     *
     * @return seznam věcí v prostoru
     */
    public List<Vec> getSeznamVeci() {
        return this.seznamVeci;
    }

    /**
     * Vloží NPC do prostoru.
     *
     * @param npc NPC, které se má vložit do prostoru
     */
    public void vlozNpc(Npc npc) {
        this.npc = npc;
    }

    /**
     * Vrátí NPC nacházející se v prostoru.
     *
     * @return NPC v prostoru nebo null, pokud žádné není
     */
    public Npc getNpc() {
        return npc;
    }

    // Příznaky pro událost s goblinem
    private boolean goblinEventActive = false;
    private boolean goblinEventResolved = false;

    /**
     * Aktivuje událost s goblinem, pokud se nacházíme v "draci_doupe".
     */
    public void triggerGoblinEvent() {
        if (!goblinEventResolved && "draci_doupe".equals(this.nazev)) {
            goblinEventActive = true;
        }
    }

    /**
     * Vyřeší událost s goblinem.
     *
     * @return true pokud byla událost úspěšně vyřešena, jinak false
     */
    public boolean resolveGoblinEvent() {
        if (goblinEventActive) {
            goblinEventActive = false;
            goblinEventResolved = true;
            return true;
        }
        return false;
    }

    /**
     * Zjistí, zda je aktivní událost s goblinem.
     *
     * @return true pokud je událost aktivní, jinak false
     */
    public boolean isGoblinEventActive() {
        return goblinEventActive;
    }

    /**
     * Nastaví nový popis prostoru.
     *
     * @param novyPopis nový popis prostoru
     */
    public void setPopis(String novyPopis) {
        this.popis = novyPopis;
    }

    /**
     * Odebere východ z prostoru podle názvu.
     *
     * @param nazevProstoru název prostoru, který se má odebrat z východů
     * @return true pokud byl východ úspěšně odebrán, jinak false
     */
    public boolean odeberVychod(String nazevProstoru) {
        return vychody.removeIf(prostor -> prostor.getNazev().equals(nazevProstoru));
    }
}