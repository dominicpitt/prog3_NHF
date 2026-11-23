package test;

import static org.junit.Assert.*;

import org.junit.*;

import nhf.*;
/** Cella osztály tesztelése*/
public class CellaTest {
	Cella cella;
	JatekTerulet jt;
	/**Üres konstruktor*/
	CellaTest(){}
	 /**
     * Teszt előtti inicializálás: Létrehozza a játéktér objektumot
     * és kivesz egy cellát a közepéről.
     */
	@Before
	public void letrehoz() {
		jt = new JatekTerulet(3, 23);
		cella = jt.getCellak()[10][10];
	}
	/**
     * Teszteli, hogy a cella alapértelmezett állapota HALOTT-e.
     */
	@Test
	public void getAllapotTest() {
		assertEquals(Allapot.HALOTT, cella.getAllapot()); // Konstruktor, getAllapot. Alap járaton halott
	}
	 /**
     * Teszteli, hogy a cella szomszédos élő celláinak száma alaphelyzetben 0.
     */
	@Test
	public void getEloszomszedTest() {
		assertEquals(0, cella.getEloszomszed());
	}
	/**
     * Teszteli, hogy a szomszéd növelése után a szomszédok száma 1 lesz-e.
     */
	@Test
	public void szomszedNoTest() {
		cella.szomszedNo();
		assertTrue(cella.getEloszomszed()==1);
	}
	/**
     * Teszteli, hogy a szomszéd csökkentése után a szomszédok száma -1 lesz-e.
     */
	@Test
	public void szomszedCsokkenTest() {
		cella.szomszedCsokken();
		assertEquals(-1, cella.getEloszomszed());
	}
	 /**
     * Teszteli, hogy a cella életre keltése után az állapota ÉLŐ-e.
     */
	@Test
	public void feleledTest1() {	//Élő lesz-e
		cella.eled();
		assertEquals(Allapot.ELO, cella.getAllapot());
	}
	/**
     * Teszteli, hogy egy cella életre keltése után a szomszédos cellák szomszédszáma növekedett-e.
     */
	@Test
	public void feleledTest2() {	//Szomszed mit lát
		cella.eled();
		assertEquals(1, jt.getCellak()[9][9].getEloszomszed());
	}
}
