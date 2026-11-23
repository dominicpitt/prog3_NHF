package nhf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
/**
 * A StartGombListener osztály felelős a játék indításáért és megállításáért.
 * Az "Start" gombbal elindítja a játékot, míg a "Stop" gombbal megállítja azt.
 */
public class StartGombListener implements ActionListener {
	/**Játék, amit majd elindítunk*/
	private JatekSzabalyzo jsz;
	/**
     * Konstruktor, amely inicializálja a játékot, amit elindítunk.
     * @param cjsz A JatekSzabalyzo objektum, amelyet elindítunk vagy megállítunk.
     */
	public StartGombListener(JatekSzabalyzo cjsz) {
		jsz=cjsz;	//Játék, amit indítunk
	}
	 /**
     * A metódus, amely elindítja vagy megállítja a játékot a gombnyomás alapján.
     * Ha a játék nem fut, akkor engedélyezi a cellák módosíthatóságát és elindítja az időzítőt az adott sebességgel,
     * Ha a játék fut, átállítja a gomb feliratátá,
     * és letítlja a cellák módosítását.
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton StartButton=(JButton) e.getSource();
		if(!jsz.getFut())
		{
			jsz.getIdozito().setDelay(jsz.getSebesseg());	//sebesség beállítása
			for (int i = 0; i < 32; i++) {
				for (int j = 0; j < 32; j++) {
					jsz.getJatekTerulet().getCellak()[i][j].setEnabled(false);	//futásközben nem lehet cellák állapotát állítani
				}
			}
		
		StartButton.setText("Stop");	//Stop lesz a gomb felirata
		jsz.setFut(true);	//Fut igaz lesz
		jsz.getIdozito().start();	//játék időzítő indítása
		}
		else {
			jsz.getIdozito().stop();	//játék időzítőjét leálítjuk
			StartButton.setText("Start");	//Start lesz a gomb felirata
			for (int i = 0; i < 32; i++) {
				for (int j = 0; j < 32; j++) {
					jsz.getJatekTerulet().getCellak()[i][j].setEnabled(true); //cellák nyohatóvá tétele
				}
			}
			jsz.setFut(false);	//futás hamis lesz
		}
	}
	
}
