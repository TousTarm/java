import java.util.*;

public class Utvar implements Comparable<Utvar> {
    private String nazev;
    private String zkratka;
    private Set<Utvar> podrizene;
    private Set<Osoba> osoby;

    public Utvar(String zkratka, String nazev) {
        this.zkratka = zkratka;
        this.nazev = nazev;
        this.podrizene = new TreeSet<Utvar>();
        this.osoby = new HashSet<Osoba>();
    }

    public String getNazev() {
        return nazev;
    }

    public String getZkratka() {
        return zkratka;
    }

    public Set<Utvar> getPodrizene() {
        return podrizene;
    }

    public Set<Osoba> getOsoby() {
        return osoby;
    }

    public void pridej(Osoba osoba) {
        osoby.add(osoba);
    }

    public void pridej(Utvar utvar) {
        podrizene.add(utvar);
    }

    public void vypis(boolean vcetneOsob) {
        System.out.println(zkratka + " " + nazev);
        if (vcetneOsob) {
            for (Osoba osoba : osoby) {
                System.out.println("  " + osoba);
            }
        }
        for (Utvar utvar : podrizene) {
            utvar.vypis(vcetneOsob);
        }
    }

    public void vypis(boolean vcetneOsob, int uroven) {
        for (int i = 0; i < uroven; i++) {
            System.out.print("   ");
        }
        System.out.println(zkratka + " " + nazev);
        if (vcetneOsob) {
            for (Osoba osoba : osoby) {
                for (int i = 0; i < uroven + 1; i++) {
                    System.out.print("   ");
                }
                System.out.println(osoba);
            }
        }
        for (Utvar utvar : podrizene) {
            utvar.vypis(vcetneOsob, uroven + 1);
        }
    }

    public void vypis2(boolean vcetneOsob, int uroven) {
        odsadit(uroven * 3);
        System.out.println(zkratka + " - " + nazev);
        if (vcetneOsob) {
            List<Osoba> sortedOsoby = new ArrayList<>(osoby);
            sortedOsoby.sort((o1, o2) -> {
                Role r1 = o1.getRole(this);
                Role r2 = o2.getRole(this);
                return Integer.compare(
                        r1 != null ? r1.ordinal() : Integer.MAX_VALUE,
                        r2 != null ? r2.ordinal() : Integer.MAX_VALUE
                );
            });

            for (Osoba osoba : sortedOsoby) {
                odsadit((uroven + 1) * 3);
                System.out.println("- " + osoba.toStringWithRole(this));
            }
        }
        for (Utvar utvar : podrizene) {
            utvar.vypis2(vcetneOsob, uroven + 1);
        }
    }

    private void odsadit(int pocetMezer) {
        for (int i = 0; i < pocetMezer; i++) {
            System.out.print(" ");
        }
    }

    public boolean equals(Object o) {
        if (o instanceof Utvar) {
            Utvar druha = (Utvar)o;
            return zkratka.equals(druha.getZkratka());
        }
        else {
            return false;
        }
    }

    public int hashCode() {
        return zkratka.hashCode();
    }

    @Override
    public int compareTo(Utvar o) {
        return zkratka.compareTo(o.getZkratka());
    }
}