package nhf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * A SzinValtListener osztály kezeli a cellák állapotának változását kattintásra.
 * Ha egy cella élő, akkor halottá válik, ha halott, akkor élővé, 
 * illetve ha halvány, akkor halottá válik.
 */
public class SzinValtListener implements ActionListener {
	/**Default konstruktor*/
	SzinValtListener(){}
	/**
     * A metódus kezeli a cella állapotának változását. Ha a cella élő, akkor halottá válik,
     * ha halott, akkor élővé, ha halvány, akkor először halványul metódus lefut, majd halottá lesz.
     * @param e Az esemény, amelyet a cella nyomására váltunk ki.
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Cella valt=(Cella)e.getSource();
		if(valt.getAllapot().equals(Allapot.ELO))	//Ha Élő volt halott lesz
		{
			valt.halottlesz();
		}
		else if(valt.getAllapot().equals(Allapot.HALOTT))	//fordítva
		{
			valt.eled();
		}
		else if(valt.getAllapot().equals(Allapot.HALVANYUL))	//ha  halvány volt akkor halott lesz
		{
			valt.halvanyul();
			valt.halottlesz();
		}
	}
}