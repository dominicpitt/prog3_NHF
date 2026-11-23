package nhf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Az UjjatekListener osztály kezeli az eseményt a főmenüben található
 * "Új játék" gomb megnyomásakor. A főmenüt bezárja, és megnyitja az új játék ablakot.
 */
public class UjjatekListener implements ActionListener {
	/**Bezarjuk ezt az ablakot*/
	private Fomenu bezarjuk;
	/**
     * Konstruktor, amely beállítja a főmenüt, amit bezárunk az új játék indításakor.
     * @param fm A főmenü, amit bezárunk
     */
	public UjjatekListener(Fomenu fm) {
		bezarjuk=fm;
	}
	 /**
     * A metódus végrehajtja az új játék elindítását. Bezárja a főmenüt, majd 
     * megnyitja az új játék létrehozásához az ablakot.
     * @param e Az esemény, amely az "Új játék" gomb megnyomásakor keletkezik
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		bezarjuk.setVisible(false);		//előző ablak bezárása
		UjjatekMenu ujm=new UjjatekMenu();		//Ujjáték ablak létrehozása
		ujm.setVisible(true);	//Ujjáték ablak megnyitása
	}

}
