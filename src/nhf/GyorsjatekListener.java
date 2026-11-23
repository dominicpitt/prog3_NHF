package nhf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**Ez az osztály felelős a gyors életjáték indításáért, amely a Conway féle életjáték
 * klasszikus szabályaival fut, egy előre meghatározott szabállyal (3, 23).
 */
public class GyorsjatekListener implements ActionListener {
	/**bezárandó ablak*/
	private UjjatekMenu bezar;
	/**
     * Konstruktor, amely beállítja a bezárandó ablakot.
     * @param ujm Az a főmenü ablak, amelyet be kell zárni
     */
	public GyorsjatekListener(UjjatekMenu ujm) {
		bezar=ujm;
	}
	/**
	 * Az eseménykezelő a gyors játék indításához.
	 * @param e Az esemény, ami a gombnyomás hatására keletkezik
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		bezar.setVisible(false);
		JatekSzabalyzo gyorsjatek=new JatekSzabalyzo(new JatekTerulet(3,23));	//létrehozunk egy Conway féle klasszikus életjátékot
		gyorsjatek.setVisible(true);	//megnyitjuk
	}

}
