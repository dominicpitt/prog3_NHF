package nhf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
/**
 * A MentesListener osztály a játék állapotának mentéséért felelős.
 * A felhasználó egy gombnyomással elmentheti a játék aktuális állapotát egy fájlba.
 */
public class MentesListener implements ActionListener {
	/**Kimentendő játék*/
	private JatekTerulet kiment;
	/**
     * Konstruktor, amely inicializálja a kimentendő játékot.
     * @param jt A kimentendő JatekTerulet objektum.
     */
	public MentesListener(JatekTerulet jt) {
		kiment=jt;
	}
	/**
	 * A játék aktuális mentése egy bináris formátumban történik, és az "Mentes.txt" fájlban tárolódik.
	 * @param e Az esemény, ami a gombnyomás hatására keletkezik
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			File mentes=new File("Mentes.txt");		//Létrehozzuk a Mentes.txt filet
			FileOutputStream fos=new FileOutputStream(mentes);	//FileOutputStream
			ObjectOutputStream oos=new ObjectOutputStream(fos); //ObjectOutputStream a FileOutputStreamhez
			oos.writeObject(kiment);	//Kiírjuk a fileba
			oos.close();	//Becsukjuk az ObjectOutputStreamet
		} catch (Exception ex) {
			System.out.println(ex);	//Baki esetén kiírjuk a problémát
		}

	}

}
