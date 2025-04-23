package logika;

public interface IHra {
    public String vratUvitani();

    public String vratEpilog();

    public boolean konecHry();

    public String zpracujPrikaz(String radek);

    public HerniPlan getHerniPlan();
}
