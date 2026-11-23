package nhf;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.Serializable;
import java.util.*;
import javax.swing.*;
/**
 * A JatekTerulet osztály felelős az életjáték területének kezeléséért, ahol a cellák
 * a játékszabályok szerint frissülnek.
 * Ez az osztály tartalmazza a cellákat, valamint az életjáték túlélés és születés szabályait.
 */
public class JatekTerulet extends JPanel implements Serializable{
	/**SerialID*/
	private static final long serialVersionUID = 1L;
	/**Túlélés szabályai*/
	private List<Integer>tuleles=new ArrayList<Integer>();
	/**Születés szabályai*/
	private List<Integer>feleledes= new ArrayList<Integer>();
	/**Életjáték Cellái*/
	private Cella[][] cellak=new Cella[32][32];
	/**Élő cellál száma*/
	private int elok;
	/**
     * Konstruktor, amely inicializálja a JatekTeruletet és beállítja a játékos által megadott
     * születés és túlélés szabályokat. Létrehozza a cellákat, és beállítja a grid layoutot.
     * @param born A születés szabályát tartalmazó szám.
     * @param survive A túlélés szabályát tartalmazó szám.
     */
	public JatekTerulet(int born, int survive) {
		while (born>0) {
			feleledes.add(born%10);		//B utáni számok feldarabolása és tárolása.	(Born szabály mentése)
			born/=10;
		}
		while (survive>0) {
			tuleles.add(survive%10);	//Survive szabályainak tárolása listába
			survive/=10;
		}
		this.setLayout(new GridLayout(32,32));
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < 32; j++) {
				Cella temp=new Cella(i, j, this);	//Cellák létrehozása
				temp.setPreferredSize(new Dimension(20,20));	//Cellák méretének beállítása
				cellak[i][j]=temp;	//játékhoz hozzáadás
				this.add(cellak[i][j]);	//Framere illesztés
			}
		}
		elok=0; //elején még nicnsenek élők
	}
	/**
	 * Élők számának frissítése csökkent
	 */
	public void ElokCsokken() {
		this.elok--;
	}
	/**
	 * Élők számának frissítése növel
	 */
	public void ElokNo() {
		this.elok++;
	}
	//Getterek
	/**
     * A túlélés szabályok listájának lekérése.
     * @return A túlélés szabályait tartalmazó lista.
     */
	public List<Integer> getTuleles() {
		return tuleles;
	}
	/**
     * A születés szabályok listájának lekérése.
     * @return A születés szabályait tartalmazó lista.
     */
	public List<Integer> getFeleledes() {
		return feleledes;
	}
	/**
     * Az összes cella lekérése.
     * @return A cellák kétdimenziós tömbje.
     */
	public Cella[][] getCellak() {
		return cellak;
	}
	/**
     * Az élő cellák számának lekérése.
     * @return Az élő cellák száma.
     */
	public int getElok() {
		return elok;
	}
	//Setter a resethez
	 /**
     * A játék állapotának visszaállítása, az élő cellák számának nullázása.
     */
	public void resetElok()
	{
		elok=0;
	}
}
