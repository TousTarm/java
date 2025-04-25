import java.util.HashMap;
import java.util.Map;

public class Osoba {
    private String jmeno;
    private String titulPred;
    private String titulZa;
    private Map<Utvar, Role> roles = new HashMap<>();

    public Osoba(String jmeno, String titulPred, String titulZa) {
        this.jmeno = jmeno;
        this.titulPred = titulPred;
        this.titulZa = titulZa;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getTitulPred() {
        return titulPred;
    }

    public String getTitulZa() {
        return titulZa;
    }

    public void addRole(Utvar utvar, Role role) {
        roles.put(utvar, role);
    }

    public Role getRole(Utvar utvar) {
        return roles.get(utvar);
    }

    @Override
    public String toString() {
        return titulPred + " " + jmeno + " " + titulZa;
    }

    public String toStringWithRole(Utvar utvar) {
        Role role = getRole(utvar);
        String roleStr = (role != null) ? " (" + role + ")" : "";
        return toString() + roleStr;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Osoba) {
            Osoba druha = (Osoba)o;
            return jmeno.equals(druha.getJmeno());
        }
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return jmeno.hashCode();
    }
}