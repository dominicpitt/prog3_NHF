package nhf;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
/**
 * Fájl beolvasásáért felelős eseménykezelő osztály.
 * A felhasználó által megadott fájlt dolgozza fel, 
 * és a fájlban található szabályok alapján indítja el a játékot.
 *
 * A fájlnak tartalmaznia kell a játékszabályokat, például "B10/S5" formátumban.
 */
public class FajlbolListener implements ActionListener {
	/**Bezárandó ablak*/
	private UjjatekMenu bezar;	
	/**A fájlneve amiből majd olvassuk a faszbályt*/
	JTextField fajlnev;
	/**Ablak, amin bekérjük a file nevét*/
	JFrame beolvasas;		
	/**
     * Konstruktor, amely beállítja a bezárandó ablakot.
     * @param ujm az UjjatekMenu, amit bezárunk.
     */
	public FajlbolListener(UjjatekMenu ujm) {
		bezar = ujm;
	}
	/**
     * Eseménykezelő metódus, amely elindítja a fájlbeolvasást.
     * Bezárja a jelenlegi ablakot, és megjelenít egy új ablakot a fájlnév megadására.
     * A fájl feldolgozása után elindítja a játékot a fájlban szereplő szabályokkal.
     * @param e Az esemény, ami a gombnyomás hatására keletkezik
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		bezar.setVisible(false); // Fájjl beolvasáshoz egy ablak
		beolvasas = new JFrame("Fájl beolvasás"); // Ablak beállításai
		beolvasas.setSize(350, 125);
		beolvasas.setLocation(500, 500);
		beolvasas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel illesztes = new JPanel();
		illesztes.setBorder(new EmptyBorder(20, 0, 0, 0));
		illesztes.setBackground(Color.CYAN);
		JLabel info = new JLabel("Adja meg a .txt fájl nevét.");
		fajlnev = new JTextField(15);
		JButton kilepes = new JButton("Kilépés!");
		kilepes.addActionListener(new KilepesListener());
		kilepes.setBackground(Color.RED);
		JButton tovabb = new JButton("Tovább!");
		tovabb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int tuleles = 0;
				int feleledes = 0;
				// feldolgozzuk a felhasználóáltal megadott txt-t
				try (BufferedReader br = new BufferedReader(new FileReader(fajlnev.getText()))) {
					String sor = br.readLine();
					if (sor == null) {
						System.out.println("A fájl üres.");
						return; // Visszatérünk, ha üres a fájl és ezt jelezzük a felhasználónak
					}
					if (sor.contains("B") && sor.contains("S")&& sor.contains("/")) {
						String[] reszek = sor.split("/"); // Elválasztjuk az 'B'-t és 'S'-t a '/' karakter alapján
						feleledes = Integer.parseInt(reszek[0].substring(1)); // B után lévő szám
						tuleles = Integer.parseInt(reszek[1].substring(1)); // S után lévő szám
					}
					JatekSzabalyzo ujjatek = new JatekSzabalyzo(new JatekTerulet(feleledes, tuleles));	//Jatek létrehozása
					ujjatek.setVisible(true);	//jatek megnyitása
				} catch (Exception exception) {
					System.out.println(exception); // Ha bármi baki lenne a művelet közben, azt kiírja a szabványos
													// kimenetre
				}
			}
		});
		tovabb.setBackground(Color.GRAY);
		illesztes.add(info, FlowLayout.LEFT);// Elhelyezések az ablakon
		illesztes.add(fajlnev, FlowLayout.CENTER);
		illesztes.add(tovabb, new FlowLayout());
		illesztes.add(kilepes, new FlowLayout());
		beolvasas.add(illesztes, BorderLayout.CENTER);
		beolvasas.setVisible(true);		//Ablak megnyitása
	}
}
