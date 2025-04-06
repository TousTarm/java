import java.awt.*;
import java.awt.geom.*;
/**
 * Obrazek auta, ktere se samo nakresli na platno a se kterym je mozne manipulovat.
 * 
 * @author   Lubos Pavlicek 
 * @version  1.0 (30 July 2004)
 */
public class Auto
{
    // datove atributy
    
    private int xPozice;
    private int yPozice;
    private String barvaKaroserie;


    /**
     * vytvoreni noveho auta na defaultni pozici (60,40) s defaultni barvou 
     * karoserie (modra)
     */
    public Auto()
    {
        this(60,40);
    }

    /**
     * vytvoreni noveho auta s moznosti zadani pozice umisteni, pro kresleni se
     * pouzije defaultni barva karoserie (modra)
     * 
     * @param xPozice  hodnota osy X pozice pro umisteni auta
     * @param yPozice  hodnota osy Y pozice pro umisteni auta 
     */
    public Auto(int xPozice, int yPozice)
    {
        this.xPozice = xPozice;
        this.yPozice = yPozice;
        barvaKaroserie = "modra";
        kresli();
    }
    
    
    /**
     * Posune auto o nekolik (o 20) bodu vpravo.
     */
    public void posunVpravo()
    {
        posunHorizontalne(20);
    }

    /**
     * Posune auto o nekolik (o 20) bodu vlevo.
     */
    public void posunVlevo()
    {
        posunHorizontalne(-20);
    }

    /**
     * Posune auto o nekolik (o 20) bodu nahoru.
     */
    public void posunNahoru()
    {
        posunVertikalne(-20);
    }

    /**
     * Posune auto o nekolik (o 20) bodu dolu.
     */
    public void posunDolu()
    {
        posunVertikalne(20);
    }

    /**
     * Posune auto horizontalne o zadanou vzdalenost. Kladna hodnota znamena posun vpravo,
     * zaporna hodnota posun vlevo.
     */

    public void posunHorizontalne(int vzdalenost) {
        vymaz();
		xPozice += vzdalenost;
		kresli();
    }
    
    /**
     * Posune auto vertikalne o zadanou vzdalenost. Kladna hodnota znamena posun dolu,
     * zaporna hodnota posun nahoru.
     */   
    public void posunVertikalne(int vzdalenost) {
        vymaz();
		yPozice += vzdalenost;
		kresli();
    }
    
    /**
     * Pomalu (animovane) posune auto horizontalne o zadanou vzdalenost. Kladna hodnota znamena
     * posun vpravo, zaporna hodnota posun vlevo.
     */
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
    
    /**
     * Pomalu (animovane) posune auto vertikalne o zadanou vzdalenost. Kladna hodnota znamena
     * posun dolu, zaporna hodnota posun nahoru.
     */
    
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

    /**
     * Zmeni barvu karoserie auta. Pripustne hodnoty jsou:
     * "cervena", "cerna", "modra", "zluta", "zelena", "fialova", "ruzova", "seda"
     * a "bila". Pri zadani jine hodnoty se pouzije "cerna".
     */
    public void zmenBarvu(String novaBarva)
    {
        barvaKaroserie = novaBarva;
        kresli();
    }

    /*
     * Nakresli auto s aktualnimi parametry na platne.
     */
    private void kresli() {
		Platno platno = Platno.getPlatno();
		platno.setBarvaPopredi(barvaKaroserie);
		// vzadu
		platno.vybarvi(new Rectangle(xPozice, yPozice+10, 20, 20));
		// uprostred
		platno.vybarvi(new Rectangle(xPozice+20, yPozice, 30, 30));
		// vpredu
		platno.vybarvi(new Rectangle(xPozice+50, yPozice+10, 20, 20));
		// kolo predni
		platno.setBarvaPopredi("cerna");
		platno.vybarvi(new Ellipse2D.Double(xPozice+50, yPozice+20, 20, 20));
		// kolo zadni
		platno.vybarvi(new Ellipse2D.Double(xPozice, yPozice+20, 20, 20));
		platno.wait(10);        
    }
    
    /*
     * Vymaze auto na platne.
     */
    private void vymaz () {
		Platno platno = Platno.getPlatno();
		// vzadu
		platno.vymaz(new Rectangle(xPozice, yPozice+10, 20, 20));
		// uprostred
		platno.vymaz(new Rectangle(xPozice+20, yPozice, 30, 30));
		// vpredu
		platno.vymaz(new Rectangle(xPozice+50, yPozice+10, 20, 20));
		// kolo predni
		platno.vymaz(new Ellipse2D.Double(xPozice+50, yPozice+20, 20, 20));
		// kolo zadni
		platno.vymaz(new Ellipse2D.Double(xPozice, yPozice+20, 20, 20));
    }
}
