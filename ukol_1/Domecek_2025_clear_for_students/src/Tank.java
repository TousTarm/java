import java.awt.*;
import java.awt.geom.*;

public class Tank
{
    private int xPozice;
    private int yPozice;
    private String barvaKaroserie;

    public Tank()
    {
        this(0,0);
    }

    /**
     * vytvoreni noveho auta s moznosti zadani pozice umisteni, pro kresleni se
     * pouzije defaultni barva karoserie (modra)
     *
     * @param xPozice  hodnota osy X pozice pro umisteni auta
     * @param yPozice  hodnota osy Y pozice pro umisteni auta
     */

    public Tank(int xPozice, int yPozice)
    {
        this.xPozice = xPozice;
        this.yPozice = yPozice;
        barvaKaroserie = "zelena";
        kresli();
    }

    public void posunVpravo()
    {
        posunHorizontalne(20);
    }
    public void posunVlevo()
    {
        posunHorizontalne(-20);
    }
    public void posunNahoru()
    {
        posunVertikalne(-20);
    }
    public void posunDolu()
    {
        posunVertikalne(20);
    }
    public void posunHorizontalne(int vzdalenost) {
        vymaz();
        xPozice += vzdalenost;
        kresli();
    }
    public void posunVertikalne(int vzdalenost) {
        vymaz();
        yPozice += vzdalenost;
        kresli();
    }
    public void pomaluPosunHorizontalne(int vzdalenost) {
        int delta;

        if(vzdalenost < 0)
        {
            delta = -1;
            vzdalenost = -vzdalenost;
        }
        else
        {
            delta = 1;
        }

        for(int i = 0; i < vzdalenost; i++)
        {
            vymaz();
            xPozice += delta;
            kresli();
        }
    }
    public void pomaluPosunVertikalne(int vzdalenost) {
        int delta;

        if(vzdalenost < 0)
        {
            delta = -1;
            vzdalenost = -vzdalenost;
        }
        else
        {
            delta = 1;
        }

        for(int i = 0; i < vzdalenost; i++)
        {
            vymaz();
            yPozice += delta;
            kresli();
        }
    }

    public void zmenBarvu(String novaBarva)
    {
        barvaKaroserie = novaBarva;
        kresli();
    }

    private void kresli() {
        Platno platno = Platno.getPlatno();

        int x = xPozice - 15;
        int y = yPozice + 40;

        platno.setBarvaPopredi(barvaKaroserie);
        platno.vybarvi(new Rectangle(x - 15, y - 10, 100, 20)); //tělo u pasu
        platno.vybarvi(new Ellipse2D.Double(x - 15, y + 5, 10, 10)); //levy smooth u pasu
        platno.vybarvi(new Ellipse2D.Double(x + 75, y + 5, 10, 10)); //pravy smooth u pasu
        platno.vybarvi(new Rectangle(x, y - 27, 50, 15)); //krk
        platno.vybarvi(new Rectangle(x + 5, y - 15, 40, 10)); //turret
        platno.vybarvi(new Rectangle(x + 50, y - 22, 60, 5)); //dělo
        platno.vybarvi(new Rectangle(x + 110, y - 24, 5, 10)); //dělo hlaven

        platno.setBarvaPopredi("cerna");
        platno.vybarvi(new Ellipse2D.Double(x - 10, y, 20, 20)); //levy pas smooth
        platno.vybarvi(new Ellipse2D.Double(x + 60, y, 20, 20)); //pravy pas smooth
        platno.vybarvi(new Rectangle(x, y, 70, 20)); //hlavni pas

        platno.wait(10);
    }

    private void vymaz() {
        Platno platno = Platno.getPlatno();
        int x = xPozice - 15;
        int y = yPozice + 40;

        platno.vymaz(new Rectangle(x - 15, y - 10, 100, 20));
        platno.vymaz(new Ellipse2D.Double(x - 15, y + 5, 10, 10));
        platno.vymaz(new Ellipse2D.Double(x + 75, y + 5, 10, 10));
        platno.vymaz(new Rectangle(x, y - 27, 50, 15));
        platno.vymaz(new Rectangle(x + 5, y - 15, 40, 10));
        platno.vymaz(new Rectangle(x + 50, y - 22, 60, 5));
        platno.vymaz(new Rectangle(x + 110, y - 24, 5, 10));

        platno.vymaz(new Ellipse2D.Double(x - 10, y, 20, 20));
        platno.vymaz(new Ellipse2D.Double(x + 60, y, 20, 20));
        platno.vymaz(new Rectangle(x, y, 70, 20));
    }

}
