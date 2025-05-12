package logika;

import java.util.ArrayList;
import java.util.List;

/**
 * Třída Batoh reprezentuje batoh, do kterého je možné ukládat a z něj odebírat předměty.
 * Batoh má omezenou kapacitu, která je definována při jeho vytvoření.
 */
public class Batoh {

    // Seznam předmětů, které jsou uloženy v batohu
    private List<Vec> seznamVeci;

    // Maximální kapacita batohu
    private final int omezeniBatohu;

    /**
     * Konstruktor třídy Batoh, který inicializuje kapacitu batohu a seznam předmětů.
     *
     * @param omezeniBatohu Maximální počet předmětů, které může batoh obsahovat.
     */
    public Batoh(int omezeniBatohu) {
        this.omezeniBatohu = omezeniBatohu;
        this.seznamVeci = new ArrayList<>();
    }

    /**
     * Vypíše seznam předmětů v batohu. Pokud je batoh prázdný, vrátí zprávu o prázdném batohu.
     *
     * @return Řetězec obsahující seznam předmětů v batohu.
     */
    public String vypisBatohu() {
        // Pokud je batoh prázdný, vrátí odpovídající zprávu
        if (seznamVeci.isEmpty()) {
            return "Tvůj batoh je prázdný.";
        }
        // Používáme StringBuilder pro efektivní vytváření řetězce
        StringBuilder vypis = new StringBuilder("Máš v batohu: ");
        // Pro každý předmět v seznamu přidáme jeho název do výsledného řetězce
        for (Vec vec : seznamVeci) {
            vypis.append(vec.getNazev()).append(" ");
        }
        // Odstraní případné nadbytečné mezery na konci řetězce
        return vypis.toString().trim();
    }

    /**
     * Zkontroluje, zda batoh obsahuje předmět s daným názvem.
     *
     * @param nazevVeci Název předmětu, který hledáme v batohu.
     * @return true pokud batoh obsahuje předmět, jinak false.
     */
    public boolean obsahujeVec(String nazevVeci) {
        // Používáme stream pro efektivní hledání předmětu podle názvu
        return seznamVeci.stream().anyMatch(vec -> vec.getNazev().equals(nazevVeci));
    }

    /**
     * Pokusí se vložit předmět do batohu, pokud není překročena jeho kapacita.
     *
     * @param vec Předmět, který chceme vložit do batohu.
     * @return true pokud byl předmět úspěšně vložen, jinak false.
     */
    public boolean vlozitDoBatohu(Vec vec) {
        // Pokud není batoh plný, přidáme předmět
        if (seznamVeci.size() < omezeniBatohu) {
            seznamVeci.add(vec);
            return true;
        }
        // Pokud je batoh plný, vrátíme false
        return false;
    }

    /**
     * Odebere předmět z batohu na základě jeho názvu.
     *
     * @param nazevVeci Název předmětu, který chceme odebrat.
     * @return Odebraný předmět, nebo null pokud předmět nebyl nalezen.
     */
    public Vec odeberZBatohu(String nazevVeci) {
        // Procházíme seznam a hledáme předmět s odpovídajícím názvem
        for (Vec vec : seznamVeci) {
            if (vec.getNazev().equals(nazevVeci)) {
                seznamVeci.remove(vec);
                return vec;
            }
        }
        // Pokud předmět nenajdeme, vrátíme null
        return null;
    }
}