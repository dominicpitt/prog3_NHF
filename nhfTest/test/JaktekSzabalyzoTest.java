package test;

import static org.junit.Assert.*;

import org.junit.*;

import nhf.JatekSzabalyzo;
import nhf.JatekTerulet;
/**
 * Tesztosztály JatekSzabalyzo osztály működésének ellenőrzésére.
 */
public class JaktekSzabalyzoTest {
	JatekSzabalyzo jsz;
	/**Üres konstruktor*/
	JaktekSzabalyzoTest(){}
	/**
     * Teszt előtti inicializálás: Létrehozza a játéktér objektumot
     * és egy szabályozót hozzárendel hozzá.
     */
	@Before
	public void letrehoz() {
		JatekTerulet jt=new JatekTerulet(3, 23); 	//Használjuk itt a Conwoy féle életjátékot
		jsz=new JatekSzabalyzo(jt);
	}
	/**
     * Teszteli, hogy az alapértelmezett állapotban a játékmenet nem fut
     * (azaz  getFut() hamisat ad vissza).
     */
	@Test
	public void getFutTest() {
		assertFalse(jsz.getFut()==true);		//konstruktor és getFut tesztje
	}
	/**
     * Teszteli, hogy a szabályozó alapértelmezett sebessége 500 ms
     * (a két futás közötti késleltetés).
     */
	@Test
	public void getSebessegTest() {
		int sebesseg=jsz.getSebesseg();		//Kettő lefutás közötti késleltetés (500 ms)
		assertEquals(500, sebesseg);
	}
	/**
     * Teszteli, hogy a setFut() metódus megfelelően változtatja-e
     * a futási állapotot.
     */
	@Test
	public void setFutTest() {
		jsz.setFut(true);
		assertTrue(jsz.getFut());
	}
}
