import java.util.ArrayList;
import java.util.List;

public class Skola {
    private Utvar skola;

    public Skola() {
        skola = new Utvar("VŠE","Vysoká škola ekonomická");
        Utvar fak1 = new Utvar("F1","Fakulta financí a účetnictví");
        Utvar fak2 = new Utvar("F2","Fakulta mezinárodních vztahů");
        Utvar fak3 = new Utvar("F3","Fakulta podnikohospodářská");
        Utvar fak4 = new Utvar("F4","Fakulta informatiky a statistiky");
        Utvar fak5 = new Utvar("F5","Fakulta národohospodářská");
        Utvar fak6 = new Utvar("F6","Fakulta managementu");

        skola.pridej(fak1);
        skola.pridej(fak2);
        skola.pridej(fak3);
        skola.pridej(fak4);
        skola.pridej(fak5);
        skola.pridej(fak6);

        // Add departments to F4
        fak4.pridej(new Utvar("KMAT","katedra matematiky"));
        Utvar kstp = new Utvar("KSTP","katedra statistiky");
        fak4.pridej(new Utvar("KEST","katedra ekonomické statistiky"));
        fak4.pridej(new Utvar("KDEM","katedra demografie"));
        fak4.pridej(new Utvar("KEKO","katedra ekonometrie"));
        fak4.pridej(new Utvar("KSA","katedra systémové analýzy"));
        fak4.pridej(new Utvar("KIZI","katedra informačního a znalostního inženýrství"));
        fak4.pridej(new Utvar("KFIL","katedra filosofie"));
        Utvar kit = new Utvar("KIT","katedra informačních technologii");
        fak4.pridej(kit);
        fak4.pridej(kstp);

        // Add people with roles
        Osoba rektor = new Osoba("Novák Jan", "Prof. Ing.", "DrSc.");
        skola.pridej(rektor);
        rektor.addRole(skola, Role.REKTOR);

        Osoba dekan = new Osoba("Hindls Richard", "Prof. Ing.", "CSc.");
        fak4.pridej(dekan);
        dekan.addRole(fak4, Role.DEAN);
        kstp.pridej(dekan);
        dekan.addRole(kstp, Role.DEPARTMENT_HEAD);

        Osoba kitHead = new Osoba("Voříšek Jiří", "Prof. Ing.", "CSc.");
        kit.pridej(kitHead);
        kitHead.addRole(kit, Role.DEPARTMENT_HEAD);

        Osoba deputyHead = new Osoba("Buchalcevová Alena", "Ing.", "PhD.");
        kit.pridej(deputyHead);
        deputyHead.addRole(kit, Role.DEPUTY_HEAD);

        kit.pridej(new Osoba("Pavlíčková Jarmila", "Ing.", ""));
        kit.pridej(new Osoba("Pavlíček Luboš","Ing.",""));

        Osoba professor = new Osoba("Šimůnek Milan", "Ing.", "PhD.");
        kit.pridej(professor);
        professor.addRole(kit, Role.PROFESSOR);

        Osoba student = new Osoba("Tichý Vladimír", "RNDr.", "");
        kit.pridej(student);
        student.addRole(kit, Role.DOCTORAL_STUDENT);
    }

    public void vypis(boolean vcetneOsob) {
        skola.vypis(vcetneOsob);
    }

    public void vypis(boolean vcetneOsob, int uroven) {
        skola.vypis(vcetneOsob, uroven);
    }

    public void vypis2(boolean vcetneOsob, int uroven) {
        skola.vypis2(vcetneOsob, uroven);
    }

    public void najdiUtvar(String zkratka) {
        Utvar found = findUtvarRecursive(skola, zkratka);
        if (found != null) {
            printHierarchy(found);
        } else {
            System.out.println("Department not found: " + zkratka);
        }
    }

    private Utvar findUtvarRecursive(Utvar current, String zkratka) {
        if (current.getZkratka().equalsIgnoreCase(zkratka)) {
            return current;
        }
        for (Utvar podrizeny : current.getPodrizene()) {
            Utvar found = findUtvarRecursive(podrizeny, zkratka);
            if (found != null) return found;
        }
        return null;
    }

    private void printHierarchy(Utvar utvar) {
        if (utvar == skola) {
            System.out.println(utvar.getZkratka() + " - " + utvar.getNazev());
            return;
        }
        printHierarchy(findParent(skola, utvar));
        System.out.println(utvar.getZkratka() + " - " + utvar.getNazev());
    }

    private Utvar findParent(Utvar current, Utvar child) {
        if (current.getPodrizene().contains(child)) {
            return current;
        }
        for (Utvar podrizeny : current.getPodrizene()) {
            Utvar parent = findParent(podrizeny, child);
            if (parent != null) return parent;
        }
        return null;
    }

    public void najdiOsobu(String jmeno) {
        List<Utvar> departments = findPersonDepartments(skola, jmeno);
        if (!departments.isEmpty()) {
            System.out.println("Person found in departments:");
            for (Utvar utvar : departments) {
                System.out.println(utvar.getZkratka() + " - " + utvar.getNazev());
                utvar.getOsoby().stream()
                        .filter(o -> o.getJmeno().equalsIgnoreCase(jmeno))
                        .findFirst()
                        .ifPresent(o -> {
                            Role role = o.getRole(utvar);
                            System.out.println("   Role: " + (role != null ? role : "Member"));
                        });
            }
        } else {
            System.out.println("Person not found: " + jmeno);
        }
    }

    private List<Utvar> findPersonDepartments(Utvar current, String jmeno) {
        List<Utvar> result = new ArrayList<>();
        if (current.getOsoby().stream().anyMatch(o -> o.getJmeno().equalsIgnoreCase(jmeno))) {
            result.add(current);
        }
        for (Utvar podrizeny : current.getPodrizene()) {
            result.addAll(findPersonDepartments(podrizeny, jmeno));
        }
        return result;
    }
}