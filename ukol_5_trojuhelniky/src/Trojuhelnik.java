public class Trojuhelnik
{
    private double stranaA;
    private double stranaB;
    private double stranaC;

    private Trojuhelnik(double stranaA, double stranaB, double stranaC)
    {
        this.stranaA = stranaA;
        this.stranaB = stranaB;
        this.stranaC = stranaC;
    }

    public static Trojuhelnik getPravouhlyAB(double stranaA, double stranaB) {
        if (stranaA <= 0 || stranaB <= 0) {
            return null;
        }
        return new Trojuhelnik(stranaA, stranaB, Math.sqrt(stranaA*stranaA + stranaB*stranaB));
    }

    public static Trojuhelnik getPravouhlyAC (double stranaA, double stranaC) {
        if (stranaC <= stranaA) {
            return null;
        }
        else {
            return new Trojuhelnik(stranaA, Math.sqrt(stranaC*stranaC - stranaA*stranaA), stranaC);
        }
    }

    public static Trojuhelnik getTrojuhelnik (TypTrojuhelnika typ, double [] parametry) {
        if (typ == TypTrojuhelnika.PRAVOUHLY_A_B) {
            if (parametry.length < 2) {
                return null;
            }
            return getPravouhlyAB(parametry[0], parametry[1]);
        }
        if (typ == TypTrojuhelnika.PRAVOUHLY_A_C) {
            if (parametry.length < 2) {
                return null;
            }
            return getPravouhlyAC(parametry[0], parametry[1]);
        }
        return null;
    }

    public double getStranaA() {
        return stranaA;
    }

    public double getStranaB() {
        return stranaB;
    }

    public double getStranaC() {
        return stranaC;
    }

    public double getAlfa() {
        return Math.toDegrees(Math.acos( (stranaB*stranaB + stranaC*stranaC - stranaA*stranaA)
                /(2*stranaB*stranaC)));
    }

    public double getBeta() {
        return Math.toDegrees(Math.acos( (stranaA*stranaA + stranaC*stranaC - stranaB*stranaB)
                /(2*stranaA*stranaC)));
    }

    public double getGama() {
        return Math.toDegrees(Math.acos( (stranaB*stranaB + stranaA*stranaA - stranaC*stranaC)
                /(2*stranaB*stranaA)));
    }

    public double obvod () {
        return (stranaA + stranaB + stranaC);
    }

    public double obsah () {
        double polObvod=obvod()/2;
        return Math.sqrt(polObvod*(polObvod-stranaA) *(polObvod-stranaB) * (polObvod - stranaC));
    }

    public static Trojuhelnik getObecnyABC(double a, double b, double c) {
        if (!isValidTriangle(a, b, c)) {
            return null;
        }
        return new Trojuhelnik(a, b, c);
    }

    public static Trojuhelnik getObecnyABAlfa(double a, double b, double alfa) {
        if (alfa >= 180) return null;
        double c = Math.sqrt(a*a + b*b - 2*a*b*Math.cos(Math.toRadians(alfa)));
        return getObecnyABC(a, b, c);
    }

    public static Trojuhelnik getObecnyAlfaBetaA(double alfa, double beta, double a) {
        if (alfa + beta >= 180) return null;
        double gama = 180 - alfa - beta;
        double b = a * Math.sin(Math.toRadians(beta)) / Math.sin(Math.toRadians(alfa));
        double c = a * Math.sin(Math.toRadians(gama)) / Math.sin(Math.toRadians(alfa));
        return getObecnyABC(a, b, c);
    }

    private static boolean isValidTriangle(double a, double b, double c) {
        return a > 0 && b > 0 && c > 0 &&
                a + b > c && a + c > b && b + c > a;
    }

    public static Trojuhelnik getRovnostranny(double a) {
        // Ensure the side length is positive
        if (a <= 0) {
            return null; // Invalid equilateral triangle
        }
        return new Trojuhelnik(a, a, a); // Create and return the equilateral triangle
    }
}
