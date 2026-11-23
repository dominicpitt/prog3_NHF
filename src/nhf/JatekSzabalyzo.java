package nhf;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/**Az életjáték szabályozására szolgáló ablakot tartalmazza,
* amely lehetővé teszi a játék indítását, leállítását, sebesség beállítását, resetelését és mentését.
* Ez az ablak biztosítja a játékmenet kezelését és vezérlését a felhasználó számára.
*/
public class JatekSzabalyzo extends JFrame{
	/**jateék terület*/
	private JatekTerulet jatekterulet;
	/**fut-e a játék*/
	private boolean fut;
	/**Időzítő a játékhoz*/
	private Timer idozito;
	/**Sebesség legördülő menü*/
	private JComboBox<String> sebesseg;
	/**
     * Konstruktor, amely inicializálja a játék ablakot és beállítja az összes gombot és vezérlőt.
     * @param j A játék területet tartalmazó objektum, amelyet a játékhoz használnak.
     */
	public JatekSzabalyzo(JatekTerulet j) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//ablak alap beállításai
		setTitle("Életjáték");
		setSize(1000,1000);
		jatekterulet=j;
		fut=false;		//elején még nem fut
		//Gombok
		JButton StartStop = new JButton("Start");	//Játékindításához gomb
		StartStop.addActionListener(new StartGombListener(this));
		StartStop.setBackground(Color.YELLOW);
		JButton reset = new JButton("Reset");	//Cellákhoz reset gomb
		reset.addActionListener(new ResetListener(this));
		reset.setBackground(Color.MAGENTA);
		JButton kilepes=new JButton("Kilépés!");
		kilepes.addActionListener(new KilepesListener());	//Kilepes gomb
		kilepes.setBackground(Color.RED);
		JButton mentes=new JButton("MENTÉS");	//mentéshez gomb
		mentes.addActionListener(new MentesListener(jatekterulet));
		mentes.setBackground(Color.GREEN);
		//Sebesseg JcomboBox lehetséges értékeinek beállítása
		String[] temp=new String[4];
		temp[0]="1x sebesseg";
		temp[1]="2x sebesseg";
		temp[2]="0.5x sebesseg";
		temp[3]="0.25x sebesseg";
		sebesseg=new JComboBox<String>(temp);
		sebesseg.setBackground(new Color(232, 196, 53));
		idozito=new Timer(500, new ActionListener() {	//Időzítő, ami mindig végig megy a Cellákon és kezeli azt
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < 32; i++){
                    for(int k = 0; k < 32; k++){
                        jatekterulet.getCellak()[i][k].allapotvaltozas();  //ciklus az állapotok változtatására
                    }
                }
                for(int i = 0; i < 32; i++){
                    for(int k = 0; k < 32; k++){
                        jatekterulet.getCellak()[i][k].szinvaltas();     //ciklus az állapotok színváltása
                    }
                }
                if(jatekterulet.getElok() == 0){   //Ha nincs egy élő cella, akkor leáll
                    idozito.stop();
                    StartStop.setText("Start"); //StartStop gombbal újra el lehet indítani
                    fut = false;    //A futás hamisra állítjuk
                    for(int i = 0; i < 32; i++){
                        for(int j = 0; j < 32; j++){
                            jatekterulet.getCellak()[i][j].setEnabled(true);    //Cellák nyomhatók lehessenek
                        }
                    }
                }
			}
		});
		JPanel alsoresz=new JPanel();	//Gombok+JComboBox elrendezése
		alsoresz.add(StartStop);
		alsoresz.add(reset);
		alsoresz.add(sebesseg);
		alsoresz.add(mentes);
		alsoresz.add(kilepes);
		add(alsoresz,BorderLayout.SOUTH);
		add(jatekterulet);
	
	}
	//Getterek és Setterek
	/**
     * A futó állapot lekérése.
     * @return Igaz, ha a játék fut, hamis, ha nem.
     */
	public boolean getFut()
	{
		return fut;
	}
	/**
     * A futó állapot beállítása.
     * @param uj Az új állapot, amit beállítunk a játék futásához.
     */
	public void setFut(boolean uj){
        fut = uj;
    }
	/**
     * Az időzítő lekérése.
     * @return Az időzítő objektum.
     */
	public Timer getIdozito()
	{
		return idozito;
	}
	/**
     * A játék területének lekérése.
     * @return A játék területet tartalmazó objektum.
     */
	public JatekTerulet getJatekTerulet(){
        return jatekterulet;
    }
	/**
     * A sebesség beállítása a választott opció szerint.
     * @return A sebesség értéke milliszekundumban, amely az időzítő intervallumát szabályozza.
     */
	public int getSebesseg() {
		if (sebesseg.getSelectedItem().equals("1x sebesseg")) {
			return 500;
		}
		else if (sebesseg.getSelectedItem().equals("2x sebesseg")) {
			return 250;
		}
		else if (sebesseg.getSelectedItem().equals("0,5x sebesseg")) {
			return 1000;
		}
		else
			return 2000;
	}
}
