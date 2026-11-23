package nhf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * A ResetListener osztály felelős a játék újraindításáért.
 * Ha a játék fut, akkor leállítja, majd visszaállítja az összes cellát az alapállapotba.
 */
public class ResetListener implements ActionListener {
	/**Jaték, amit reszetelünk*/
	private JatekSzabalyzo reset;
	 /**
     * Konstruktor, amely inicializálja a resetelni kívánt játékot.
     * @param cjsz A resetelni kívánt JatekSzabalyzo objektum.
     */
	public ResetListener(JatekSzabalyzo cjsz) {
		reset=cjsz;
	}
	/**
     * A metódus, amely leállítja a játékot, ha az éppen fut,
     * valamint visszaállítja az összes cellát az alapállapotba,
     * @param e Az esemény, ami a gombnyomás hatására keletkezik
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(reset.getFut())	//Ha fut, akkor leállítjuk
		{
			reset.setFut(false);
		}
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < 32; j++) {
				Cella c=reset.getJatekTerulet().getCellak()[i][j];
				c.setEloszomszed();		//cellák reset-elése
				c.halottlesz();
			}
		}
		reset.getJatekTerulet().resetElok();	//elő cellák 0-ra állítása
	}
}