package nhf;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Az UjjatekMenu osztály a játék új szabályok szerinti létrehozásához tartozó
 * felhasználói felületet biztosít. Itt lehet a szabályokat megadni,
 * valamint elindítani egy gyorsjátékot.
 */
public class UjjatekMenu extends JFrame{
	/**
     * Konstruktor, amely inicializálja az új játék létrehozásához szükséges 
     * komponenseket és beállítja az ablakot.
     */
	public UjjatekMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//ablak alap adatainak beállítása
		setResizable(false);
		setTitle("Uj játék létrehozása");
		setSize(700,175);
		setLocation(500,500);
		setBackground(Color.GREEN);
		JPanel felso=new JPanel();	//Rendezéshez panelek
		JPanel kozepso=new JPanel();
		JPanel also=new JPanel();
		felso.setBackground(Color.RED);
		kozepso.setBackground(Color.WHITE);
		also.setBackground(Color.GREEN);
		//Gombok
		JButton kilepes=new JButton("Kilépés!");	//kilépés gomb
		kilepes.addActionListener(new KilepesListener());
		kilepes.setBackground(Color.RED);
		JButton gyorsjatek=new JButton("Gyorsjáték (játékszábly: B3/S23)");	//gyorsjáték gomb Conwoy féle életjáték
		gyorsjatek.setPreferredSize(new Dimension(550,27));
		gyorsjatek.addActionListener(new GyorsjatekListener(this));
		gyorsjatek.setBackground(Color.ORANGE);
		
		
		JButton fajbol=new JButton("Szabály fájlból");
		fajbol.addActionListener(new FajlbolListener(this));
		fajbol.setBackground(new Color(196, 73, 227));
		
		//Uj szabaly megadasa
		JTextField szabaly=new JTextField(20);
		JLabel szabalylabel=new JLabel("Adja meg a kívánt szabályt, 0 és 9 nem szerepelhet benne (pl:B123/S123):");
		JLabel fajlbollabel=new JLabel("Ha txt fájból kíván szabályt beolvasni (txt tartalma csak a szabály lehet pl:B123/S123): ");
		JButton generalas=new JButton("Generálás");		//szabály alapján megadott játék generálása
		generalas.addActionListener(new GeneralasListener(this,szabaly));
		generalas.setBackground(Color.YELLOW);
		//hozzáadás és rendezések
		felso.add(gyorsjatek);

		kozepso.add(szabalylabel,FlowLayout.LEFT);
		kozepso.add(szabaly,FlowLayout.CENTER);
		kozepso.add(fajlbollabel,new FlowLayout());
		kozepso.add(fajbol,new FlowLayout());
		
		also.add(generalas);
		also.add(kilepes);
		
		add(felso,BorderLayout.NORTH);
		add(kozepso, BorderLayout.CENTER);
		add(also, BorderLayout.SOUTH);
	}
}
