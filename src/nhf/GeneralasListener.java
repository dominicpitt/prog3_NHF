package nhf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
/**
 * Az új játék szabályait validáló és alkalmazó eseménykezelő osztály.
 * Ezt az osztályt akkor használjuk, amikor a felhasználó megadja a játékszabályokat,
 * és azok alapján a játékot generálni szeretnénk.
 * A szabályokat a felhasználó egy szövegdobozba adja meg.
 */
public class GeneralasListener implements ActionListener {
	/**ablak amit bezárunk*/
	private UjjatekMenu bezar;
	/**szabály, ami alapján a játék futni fog*/
	private JTextField szabaly;
	/**
     * Konstruktor, amely beállítja a bezárandó ablakot és a szabály szövegdobozt.
     * @param ujm Az a főmenü ablak, amelyet be kell zárni
     * @param text A szövegdoboz, amelyben a felhasználó megadja a szabályokat
     */
	public GeneralasListener(UjjatekMenu ujm, JTextField text) {
		bezar=ujm;
		szabaly=text;
	}
	/**
     * Az eseménykezelő metódus, amely akkor hajtódik végre, amikor a felhasználó megnyomja a gombot.
     * Ha helytelen a formátum, vagy a szabály nem felel meg, akkor a szövegdoboz üresre kerül.
     * Ha helyesek a szabályok, új játékot indít. 
     * @param ae Az esemény, ami a gombnyomás hatására keletkezik
     */
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(szabaly.getText().contains("0")||szabaly.getText().contains("9"))	//Ellenőrizzük a megadott szabályt
		{
			szabaly.setText("");
		}
		else
		{
			try
			{
				
				String[] reszek = szabaly.getText().split("/"); // Elválasztjuk az 'B'-t és 'S'-t a '/' karakter alapján
				int feleled= Integer.parseInt(reszek[0].substring(1)); // B után lévő szám
				int tulel = Integer.parseInt(reszek[1].substring(1)); // S után lévő szám
				bezar.setVisible(false);
				JatekSzabalyzo jsz= new JatekSzabalyzo(new JatekTerulet(feleled, tulel));	//Ujjatek létrehozása
				jsz.setVisible(true);	//Újjáték megnyitása
			}
			catch (NumberFormatException ae1) {
				szabaly.setText("");	//Gebasz esetén újra meg kell adni a szabályt
			}
			
		}
	}
}
