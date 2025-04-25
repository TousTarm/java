package logika;

public class PrikazMluv implements IPrikaz {
    private static final String NAZEV = "mluv";
    private HerniPlan plan;
    private Hra hra;

    public PrikazMluv(HerniPlan plan, Hra hra) {
        this.plan = plan;
        this.hra = hra;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        Prostor aktualniProstor = plan.getAktualniProstor();
        Npc npc = aktualniProstor.getNpc();

        if (npc == null) {
            return ", v místnosti nikdo není, proč mluvíš sám se sebou?";
        }

        // Execute NPC action if it exists
        if (npc.getAction() != null) {
            npc.getAction().accept(hra);
        }

        return npc.getZprava();
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}