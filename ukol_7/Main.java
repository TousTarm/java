public class Main {
    public static void main(String[] args) {
        Skola skola = new Skola();

        // Original tests
        skola.vypis(true);
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        skola.vypis(true, 0);
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        skola.vypis2(true, 0);

        // New functionality tests
        System.out.println("\nTesting department search:");
        skola.najdiUtvar("KIT");

        System.out.println("\nTesting person search:");
        skola.najdiOsobu("Hindls Richard");

        System.out.println("\nTesting role-based sorting:");
        skola.vypis2(true, 0);
    }
}