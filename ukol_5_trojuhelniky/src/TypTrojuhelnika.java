public enum TypTrojuhelnika {
    PRAVOUHLY_A_B("Right-angled (a,b)", "Enter side a:", "Enter side b:", null),
    PRAVOUHLY_A_C("Right-angled (a,c)", "Enter side a:", "Enter hypotenuse c:", null),
    ROVNOSTRANNY("Equilateral", "Enter side a:", null, null),
    OBECNY_ABC("General (a,b,c)", "Enter side a:", "Enter side b:", "Enter side c:"),
    OBECNY_AB_ALFA("General (a,b,α)", "Enter side a:", "Enter side b:", "Enter angle α (in degrees):"),
    OBECNY_ALFA_BETA_A("General (α,β,a)", "Enter angle α (in degrees):", "Enter angle β (in degrees):", "Enter side a:");

    private final String description;
    private final String question1;
    private final String question2;
    private final String question3;

    TypTrojuhelnika(String description, String question1, String question2, String question3) {
        this.description = description;
        this.question1 = question1;
        this.question2 = question2;
        this.question3 = question3;
    }

    public String getDescription() {
        return description;
    }

    public String getQuestion1() {
        return question1;
    }

    public String getQuestion2() {
        return question2;
    }

    public String getQuestion3() {
        return question3;
    }

    public int getParameterCount() {
        if (question3 != null) {
            return 3;
        } else if (question2 != null) {
            return 2;
        } else if (question1 != null) {
            return 1;
        } else {
            return 0;
        }
    }
}
