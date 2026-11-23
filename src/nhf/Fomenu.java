package nhf;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
/**
 * Az alapértelmezett főmenü ablakot megjelenítő osztály.
 * Itt választhat a felhasználó új játék indítása, régi játék betöltése, vagy a kilépés között.
 * Az ablak tartalmaz három fő gombot: "Új játék", "Régi játék betöltése" és "Kilépés".
 */
public class Fomenu extends JFrame { // Az első ablak ami a felhasználókat fogadja (MainMenu)
	/**Az ablak létrehozása, a következő gombokkal rendelkezik:
	     * - Új játék: Új játék indítása
	     * - Régi játék betöltése: Korábbi játék betöltése
	     * - Kilépés: Kilépés a programból
	     */
	Fomenu() {
		setTitle("Életjáték"); // Ablak beállításai
		setSize(450, 200);
		setLocation(500, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// kellenek gombok (Új játék, régi betöltése, Kilépés)
		JPanel Kozepre = new JPanel();
		Kozepre.setLayout(new FlowLayout());
		Kozepre.setBorder(new EmptyBorder(55, 0, 0, 0));
		Kozepre.setBackground(Color.ORANGE);
		add(Kozepre, BorderLayout.CENTER);
		JButton ujjatek = new JButton("Új játék");
		ujjatek.addActionListener(new UjjatekListener(this)); // Listener hozzáadása
		ujjatek.setBackground(Color.GREEN);
		JButton betolt = new JButton("Régi Játék Betöltése");
		betolt.addActionListener(new BetoltListener(this)); // Listener implementálása a gombhoz
		betolt.setBackground(Color.CYAN);
		JButton kilepes = new JButton("Kilépés!"); // Kilépés beállításai
		kilepes.addActionListener(new KilepesListener());
		kilepes.setBackground(Color.RED);
		Kozepre.add(ujjatek); // Gombok hozzáadása
		Kozepre.add(betolt);
		Kozepre.add(kilepes);
	}
}