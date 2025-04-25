import java.io.*;
public class CteniZKonsole
{
    public CteniZKonsole() {
        // není, co by se sem umístilo, tj. je prázdný konstruktor (nemusel by být ani
        // uveden)
    }

    public int getInt() {
        return getInt("celé číslo");
    }

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

    public long getLong() {
        // put your code here
        return getLong("celé číslo");
    }

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

    public double getDouble() {
        return getDouble("reálné číslo");
    }

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

    public String getString() {
        return getString("řetězec");
    }

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

    public boolean getBoolean() {
        return getBoolean("logická hodnota");
    }

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

    private boolean isFalse(String radek) {
        String lower = radek.toLowerCase().trim();
        return (   lower.equals("n")
                || lower.equals("ne")
                || lower.equals("no")
                || lower.equals("f")
                || lower.equals("false")
                );
    }

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
