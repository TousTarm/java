
/**
 * Vyctovy typ TypTrojuhelnika ... představuje jednotlivé typy trojúhelníků,
 * se kterými umí pracovat třídy aplikace Trojuhelniky.
 *
 * @author     Jarmila Pavlíčková
 * @version    1.0, duben 2005
 */
public enum TypTrojuhelnika {
    PRAVOUHLY_A_B("Right-angled (a,b)"),
    PRAVOUHLY_A_C("Right-angled (a,c)"),
    ROVNOSTRANNY("Equilateral"),
    OBECNY_ABC("General (a,b,c)"),
    OBECNY_AB_ALFA("General (a,b,α)"),
    OBECNY_ALFA_BETA_A("General (α,β,a)");

    private final String description;

    TypTrojuhelnika(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
