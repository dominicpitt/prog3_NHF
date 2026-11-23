package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

import nhf.JatekTerulet;
/**
 * Tesztosztály a JatekTerulet osztály működésének ellenőrzésére.
 */
public class JatekTeruletTest {
	JatekTerulet jt;
	/**Üres konstruktor*/
	JatekTeruletTest(){}
	/**
     * Teszt előtti inicializálás: létrehoz egy játéktér példányt.
     */
	@Before
	public void letrehoz() {
		jt=new JatekTerulet(3, 23); //Használjuk itt a Conwoy féle életjátékot
	}
	/**
     * Teszteli, hogy az élő cellál száma kezdetben 0.
     */
	public void getElokTest() {
		assertEquals(0,jt.getElok());	//Elején 0-nak kell lennie nem történt semmi
	}
	/**
     * Teszteli, hogy az élő cellák száma növekszik-e, ha a ElokNo() metódust hívjuk.
     */
	@Test
	public void getElokNovelTest() {
		jt.ElokNo();
		assertEquals(1,jt.getElok());	//Növeli-e a elő cellák számát
	}
	 /**
     * Teszteli, hogy az élő sejtek száma csökken-e, ha a ElokCsokken() metódust hívjuk.
     */
	@Test
	public void getElokCsokkenTest() {
		jt.ElokCsokken();
		assertTrue(jt.getElok()==-1);		//Csökkenti-e az élő cellák számát, azzért assertTrue, hogy más teszt is szerepeljen
	}
	/**
     * Teszteli, hogy a felelést meghatározó szabályok megfelelően inicializálódnak-e.
     */
	@Test
	public void getFeleledesTest() {
		ArrayList<Integer> feleledes=new ArrayList<Integer>();
		feleledes.add(3);
		assertEquals(feleledes, jt.getFeleledes());			//Konstruktor és a getter tesztje a feleledes szabályához
	}
	/**
     * Teszteli, hogy a túlélést meghatározó szabályok megfelelően inicializálódnak-e.
     */
	public void getTulelesTest() {
		ArrayList<Integer> tuleles=new ArrayList<Integer>();
		tuleles.add(2);
		tuleles.add(3);
		assertEquals(tuleles, jt.getTuleles());			//Konstruktor és a getter tesztje a túlélés szabályához
	}
	 /**
     * Teszteli, hogy az élő sejtek száma alaphelyzetbe állítódik-e a resetElok() metódussal.
     */
	@Test
	public void resetElokTest()
	{
		jt.ElokNo();
		jt.ElokNo();
		jt.ElokNo();
		jt.ElokNo();
		jt.resetElok();
		assertEquals(0,jt.getElok());		//Azért assertFalse, hogy más test-et is lássunk.
	}
}
