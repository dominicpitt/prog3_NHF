package nhf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * A KilepesListener osztály amely a kilépéshez szükséges eseménykezelőt valósít meg.
 * Az esemény bekövetkezésekor a program leállítja a futást.
 */
public class KilepesListener implements ActionListener {
	/**Default konstruktor*/
	KilepesListener(){}
	/**
     * A kilépési esemény kezelése, system.exit(0)val kilép.
     * @param e Az esemény, ami a gombnyomás hatására keletkezik
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}