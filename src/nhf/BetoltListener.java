package nhf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Betoltés végre hajtásához létrehozott Listener
 */
public class BetoltListener implements ActionListener {
	/**Ablak amit bezárunk*/
	private Fomenu bezar;
	/**
     * Konstruktor, amely beállítja a bezárandó ablakot.
     * @param fm Az a főmenü ablak, amelyet be kell zárni.
     */
	public BetoltListener(Fomenu fm) {
		bezar=fm;
	}
	/**Fomenüt bezárjuk
	 * Betöltjük a mentett állást
	 * Ha gebasz van akkor jelez és kiírja mi a probléma
	 * @param e Az esemény, ami a gombnyomás hatására keletkezik
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		bezar.setVisible(false);	
		try {
			File betolt=new File("Mentes.txt"); //File amiből betöltjük a mentett állást
			FileInputStream fis=new FileInputStream(betolt);
			ObjectInputStream ois=new ObjectInputStream(fis);
			JatekTerulet betoltott=(JatekTerulet) ois.readObject(); //JatekTerület, amit betöltünk
			JatekSzabalyzo ujjatek=new JatekSzabalyzo(betoltott); //Új játékot létrehozzuk
			ujjatek.setVisible(true);	//Újjátékot megnyitjuk
			for (int i = 0; i < 32; i++) {
	            for (int j = 0; j < 32; j++) {
	                betoltott.getCellak()[i][j].frissit(); // Frissítjük a cellákat
	            }
	        }
			ois.close();	//ObjecInputStream-et bezárjuk*/
		} catch (Exception ex) {
		System.out.println(ex);  //Ha gebasz van akkor jelez és kiírja mi a probléma
		}

	}

}
