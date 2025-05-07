import java.io.*;
/**
 * Třída má zjednodušit pro uživatele čtení z konzole - třída odstiňuje chybové stavy.
 * V případě čísel a booleovských proměnných též provádí konverzi na příslušný primitivní
 * datový typ.V případě chyby se opakuje požadavek na čtení.
 * <P>Třída podporuje čtení:
 * <UL>
 *    <LI>čísel typu int - metoda readInt
 *    <LI>čísel typu long - metoda readLong
 *    <LI>čísel typu double - metoda readDouble
 *    <LI>booleovský konstat true a false - metoda readBoolean
 *    <LI>řetězců (String) - metoda readString
 * </UL>
 *    
 * 
 * @author  Lubos Pavlicek
 * @version 1.0, srpen 2004
 */
public class CteniZKonsole
{

    /**
     * Vytvoření instance třídy CteniZKonsole
     */
    public CteniZKonsole() {
        // není, co by se sem umístilo, tj. je prázdný konstruktor (nemusel by být ani
        // uveden)
    }


    /**
     * Načtení celého čísla z klávesnice.
     * Pokud uživatel nezadá přípustný vstup, požadavek se opakuje.
     * 
     * @return načtené celé číslo
     */
    public int getInt() {
        return getInt("celé číslo");
    }
    
    /**
     * Načtení celého čísla z klávesnice. Před čtením se na začátku řádky vypíše zadaný prompt.
     * Pokud uživatel nezadá přípustný vstup, požadavek se opakuje.
     * 
     * @param  prompt  textový řetězec, který se vypíše na začátku řádky před vstupem
     * @return načtené celé číslo
     */
    public int getInt(String prompt) {
        int cislo = 0;
        String radek;
        while (true) {
            try {
                BufferedReader vstup = new BufferedReader(new InputStreamReader(System.in));
                System.out.print(prompt+": ");
                radek = vstup.readLine();
                cislo = Integer.parseInt(radek);
                return cislo;
            }
            catch (IOException e) {
                System.out.println(e);
            }
            catch (NumberFormatException e) {
                System.out.println("chyba: nebylo vloženo celé číslo");
            }
        }
    }

    /**
     * Načtení celého čísla z klávesnice.
     * Pokud uživatel nezadá přípustný vstup, požadavek se opakuje.
     * 
     * @return načtené reálné číslo
     */
    public long getLong() {
        // put your code here
        return getLong("celé číslo");
    }
    
    /**
     * Načtení celého čísla z klávesnice. Před čtením se na začátku řádky vypíše zadaný prompt.
     * Pokud uživatel nezadá přípustný vstup, požadavek se opakuje.
     * 
     * @param  prompt  textový řetězec, který se vypíše na začátku řádky před vstupem
     * @return načtené celé číslo
     */
    public long getLong(String prompt) {
        long cislo = 0;
        String radek;
        while (true) {
            try {
                BufferedReader vstup = new BufferedReader(new InputStreamReader(System.in));
                System.out.print(prompt+": ");
                radek = vstup.readLine();
                cislo = Long.parseLong(radek);
                return cislo;
            }
            catch (IOException e) {
                System.out.println(e);
            }
            catch (NumberFormatException e) {
                System.out.println("chyba: nebylo vloženo celé číslo");
            }
        }
    }

    /**
     * Načtení reálného čísla z klávesnice.
     * Pokud uživatel nezadá přípustný vstup, požadavek se opakuje.
     * 
     * @return načtené reálné číslo
     */
    public double getDouble() {
        return getDouble("reálné číslo");
    }

    /**
     * Načtení reálného čísla z klávesnice. Před čtením se na začátku řádky vypíše zadaný prompt.
     * Pokud uživatel nezadá přípustný vstup, požadavek se opakuje.
     * 
     * @param  prompt  textový řetězec, který se vypíše na začátku řádky před vstupem
     * @return načtené reálné číslo
     */
    public double getDouble(String prompt) {
        double cislo=0;
        String radek;
        while (true) {
            try {
                BufferedReader vstup = new BufferedReader(new InputStreamReader(System.in));
                System.out.print(prompt+": ");
                radek = vstup.readLine();
                cislo = Double.parseDouble(radek);
                return cislo;
            }
            catch (IOException e) {
                System.out.println(e);
            }
            catch (NumberFormatException e) {
                System.out.println("chyba: nebylo vloženo reálné číslo");
            }
        }
    }
    
    /**
     * Načtení řetězce z klávesnice.
     * 
     * @return načtený řetězec (může být i prázdný).
     */
    public String getString() {
        return getString("řetězec");
    }
    
    /**
     * Načtení řetězce z klávesnice. Před čtením se na začátku řádky vypíše zadaný prompt.
     * 
     * @param  prompt  textový řetězec, který se vypíše na začátku řádky před vstupem
     * @return načtený řetězec (může být i prázdný)
     */
    public String getString(String prompt) {
        String radek;
        while (true) {
            try {
                BufferedReader vstup = new BufferedReader(new InputStreamReader(System.in));
                System.out.print(prompt+": ");
                radek = vstup.readLine();
                return radek;
            }
            catch (IOException e) {
                System.out.println(e);
            }
        }
    }
    
    /**
     * Načtení booleovské hodnoty z klávesnice. Přípustné vstupy pro hodnotu true:<br>
     * true, yes, ano, t, y, a.
     * <p>
     * Přípustné vstupy pro hodnotu false:<br>
     * false, no, ne, f, n
     * <p>
     * U výše uvedených hodnot nezávisí na velikosti písmen. Též nezáleží na počátečních
     * a koncových mezerách.
     * <p>
     * Jakýkoliv jiný vstup od uživatele znamená opakování dotazu.
     * 
     * @return booleovská hodnota (true/false) zadaná uživatelem
     */
    public boolean getBoolean() {
        return getBoolean("logická hodnota");
    }
    
    /**
     * Metoda zjištuje, zda parametr obsahuje řetězec vyjadřující hodnotu true.
     * Před porovnáním se parametr převádí na malá písmena a odřezávají se počáteční
     * a koncové mezery.
     * 
     * @param    retezec
     * @return   true, pokud retezec obsahuje text vyjadrující hodnotu true (viz metoda getBoolean())
     */
    private boolean isTrue(String retezec) {
        String lower = retezec.toLowerCase().trim();
        return (   lower.equals("a")
                || lower.equals("ano")
                || lower.equals("y")
                || lower.equals("yes")
                || lower.equals("t")
                || lower.equals("true")
                );
    }

    /**
     * Metoda zjištuje, zda parametr obsahuje řetězec vyjadřující hodnotu false.
     * Před porovnáním se parametr převádí na malá písmena a odřezávají se počáteční
     * a koncové mezery.
     * 
     * @param    retezec
     * @return   true, pokud retezec obsahuje text vyjadrující hodnotu false (viz metoda getBoolean())
     */
    private boolean isFalse(String radek) {
        String lower = radek.toLowerCase().trim();
        return (   lower.equals("n")
                || lower.equals("ne")
                || lower.equals("no")
                || lower.equals("f")
                || lower.equals("false")
                );
    }

    /**
     * Načtení booleovské hodnoty z klávesnice. Před čtením hodnoty se na začátku
     * řádky zobrazí uvedený prompt. Přípustné vstupy pro hodnotu true:<br>
     * true, yes, ano, t, y, a.
     * <p>
     * Přípustné vstupy pro hodnotu false:<br>
     * false, no, ne, f, n
     * <p>
     * U výše uvedených hodnot nezávisí na velikosti písmen. Též nezáleží na počátečních
     * a koncových mezerách.
     * <p>
     * Jakýkoliv jiný vstup od uživatele znamená opakování dotazu.
     * 
     * @param  prompt  textový řetězec, který se vypíše na začátku řádky před vstupem
     * @return booleovská hodnota (true/false) zadaná uživatelem
     */
    public boolean getBoolean(String prompt) {
        String radek;
        while (true) {
            try {
                BufferedReader vstup = new BufferedReader(new InputStreamReader(System.in));
                System.out.print(prompt+" [yes/no true/false ano/ne]: ");
                radek = vstup.readLine();
                if (isTrue(radek)) {
                    return true;
                }
                if (isFalse(radek)) {
                    return false;
                }
                System.out.println("chyba: nepripustna hodnota");
            }
            catch (IOException e) {
                System.out.println(e);
            }
        }
    }
    
    /**
     * Načtení booleovské hodnoty z klávesnice. Před čtením hodnoty se na začátku
     * řádky zobrazí uvedený prompt. Přípustné vstupy pro hodnotu true:<br>
     * true, yes, ano, t, y, a.
     * <p>
     * Přípustné vstupy pro hodnotu false:<br>
     * false, no, ne, f, n
     * <p>
     * U výše uvedených hodnot nezávisí na velikosti písmen. Též nezáleží na počátečních
     * a koncových mezerách. Pokud uživatel vrátí prázdný řádek (tj. rovnou stiskne 
     * klávesu Enter), tak se vrátí hodnota uvedená v parametru def.
     * <p>
     * Jakýkoliv jiný vstup od uživatele znamená opakování dotazu.
     * 
     * @param  prompt  textový řetězec, který se vypíše na začátku řádky před vstupem
     * @param  def     defaultní hodnota, která se vrátí, pokud uživatel vrátí prázdný
     *                 řádek
     * @return booleovská hodnota (true/false) zadaná uživatelem
     */
    public boolean getBoolean(String prompt, boolean def) {
        String radek;
        while (true) {
            try {
                BufferedReader vstup = new BufferedReader(new InputStreamReader(System.in));
                System.out.print(prompt+" [yes/no true/false ano/ne, default:"+def+"]: ");
                radek = vstup.readLine();
                if (radek.trim().equals("")) {
                    return def;
                }
                if (isTrue(radek)) {
                    return true;
                }
                if (isFalse(radek)) {
                    return false;
                }
                System.out.println("chyba: nepripustna hodnota");
            }
            catch (IOException e) {
                System.out.println(e);
            }
        }
    }

}
