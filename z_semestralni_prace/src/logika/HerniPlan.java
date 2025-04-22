package logika;

public class HerniPlan {
    
    private Prostor aktualniProstor;
    private final Batoh batoh;

    public HerniPlan() {
        zalozProstoryHry();
        this.batoh  = new Batoh(4);
    }

    private void zalozProstoryHry() {
        // vytvoří prostory
        Prostor domecek = new Prostor("domeček","domeček, ve kterém bydlí Karkulka");
        Prostor zahradka = new Prostor("zahrádka","zahrádka, u domečku");
        Prostor chaloupka = new Prostor("chaloupka", "chaloupka, ve které bydlí babička Karkulky");
        Prostor jeskyne = new Prostor("jeskyně","stará plesnivá jeskyně");
        Prostor les = new Prostor("les","les s jahodami, malinami a pramenem vody");
        Prostor hlubokyLes = new Prostor("hluboký_les","temný les, ve kterém lze potkat vlka");

        //vytvoří východy z prostorů
        domecek.setVychod(zahradka);
        zahradka.setVychod(les);
        les.setVychod(zahradka);
        les.setVychod(hlubokyLes);
        hlubokyLes.setVychod(les);
        hlubokyLes.setVychod(jeskyne);
        hlubokyLes.setVychod(chaloupka);
        jeskyne.setVychod(hlubokyLes);
        chaloupka.setVychod(hlubokyLes);
                
        aktualniProstor = domecek;  // hra začíná v domečku
    }

    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }

    public void setAktualniProstor(Prostor prostor) {
       aktualniProstor = prostor;
    }

    public Batoh getBatoh(){
        return batoh;
    }
}
