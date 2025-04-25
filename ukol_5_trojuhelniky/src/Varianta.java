
public class Varianta {
    private TypTrojuhelnika typ;            // typ trojuhelniku
    private String popis;       // popis varianty - objevi se v nabidce
    private String dotaz1;      // dotaz na první parametr
    private String dotaz2;      // dotaz na druhý parametr
    private String dotaz3;      // dotaz na třetí parametr

    public Varianta(TypTrojuhelnika typ, String popis, String dotaz1, String dotaz2, String dotaz3)
    {
        // initialise instance variables
        this.typ = typ;
        this.popis = popis;
        this.dotaz1 = dotaz1;
        this.dotaz2 = dotaz2;
        this.dotaz3 = dotaz3;
    }

    public TypTrojuhelnika getTyp() {
        return typ;
    }

    public String getPopis() {
        return popis;
    }

    public String getDotaz1() {
        return dotaz1;
    }

    public String getDotaz2() {
        return dotaz2;
    }

    public String getDotaz3() {
        return dotaz3;
    }

    public int getPocetParametru() {
        if (dotaz3 != null) {
            return 3;
        }
        else {
            if (dotaz2 != null) {
                return 2;
            }
            else {
                if (dotaz1 != null) {
                    return 1;
                }
                else {
                    return 0;
                }
            }
        }
    }


}
