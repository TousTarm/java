
/**
 * Tato trida reprezentuje jednoduchy obrazek. Obrazek se nakresli po zavolani
 * metody kresli. Obrazek muze byt zmenen - muzete ho upravit na cernobily
 * a zpet na barevny.
 * Proti tride Obrazek z projektu "Obrazek" je zde predpripravena metoda prujezdAuta,
 * kterou maji studenti na cviceni doplnit.
 *
 * Tato trida je napsana jako jeden z prvnich prikladu pro vyuku Javy v BlueJ.
 * 
 * @author	Michael Kolling
 * @author  Lubos Pavlicek
 * @version 1.0  (15 July 2000)
 * @version 1.1cz (30 July 2004)
 * 
 */
public class Obrazek
{
	private Ctverec zed;
	private Ctverec okno;
	private Ctverec bg;
	private Trojuhelnik strecha;
	private Auto auto;
	private Tank tank1;
	private Tank tank2;

	/**
	 * Konstruktor pro vytvoreni instance tridy Obrazek
	 */
	public Obrazek()
	{
		bg = new Ctverec();
		bg.zmenVelikost(100);
		bg.zmenBarvu("cervena");

		auto = new Auto(-100,250);
		auto.zmenBarvu("zluta");

		tank1 = new Tank(30,40);
		tank2 = new Tank(-100,230);
		tank2.zmenBarvu("modra");

	}

	/**
	 * Nakresli obrazek.
	 */
	public void kresli()
	{
		/*
		zed = new Ctverec();
		zed.posunVertikalne(80);
		zed.zmenVelikost(100);

		okno = new Ctverec();
		okno.zmenBarvu("cerna");
		okno.posunHorizontalne(20);
		okno.posunVertikalne(100);

		strecha = new Trojuhelnik();
		strecha.zmenVelikost(50, 140);
		strecha.posunHorizontalne(60);
		strecha.posunVertikalne(70);
		 */
	}

	/**
	 * zmeni obrazek na cernobily
	 */
	public void setCernoBily()
	{
		if (zed != null)   // pouze pokud je jiz nakreslen...
		{
			zed.zmenBarvu("cerna");
			okno.zmenBarvu("bila");
			strecha.zmenBarvu("cerna");
		}
	}

	/**
	 * zmeni obrazek zpet na barevny
	 */
	public void setBarevny()
	{
		if (zed != null)   // pouze pokud je jiz nakreslen domecek...
		{
			zed.zmenBarvu("cervena");
			okno.zmenBarvu("cerna");
			strecha.zmenBarvu("zelena");
		}
	}
	
	/**
	 * pri zavolani teto metody by melo pred domeckem projet auto
	 */
	public void prujezdAuta() {
	    if (zed != null) {    // pouze pokud je jiz nakreslen domecek...
	        // ZDE DOPLNIT PRISLUSNY KOD
	    }
	}

	// NOVA METODA 1
	public void prijezdAuta(){
		auto.pomaluPosunHorizontalne(150);
	}

	// NOVA METODA 2
	public void odjezdAuta(){
		auto.pomaluPosunHorizontalne(250);
	}

	//NOVA METODA TANKU 1
	public void prijezdTanku(){
		tank2.pomaluPosunHorizontalne(150);
	}

	//NOVA METODA TANKU 2
	public void odjezdTanku(){
		tank2.pomaluPosunHorizontalne(350);
	}
}
