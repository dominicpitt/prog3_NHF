package nhf;

import java.awt.Color;
import java.io.Serializable;
import javax.swing.JButton;

/**
 * JButton, mert ez egy gomb, és Serializablet implementáljuk, mert kiírjuk
 * fájlba a JátékTerületet és olvassuk is.
 */
public class Cella extends JButton implements Serializable {
	/**serialID*/
	private static final long serialVersionUID = 1L;
	/** Cella adott állapota */
	private Allapot allapot;
	/**Adott JátékTerület, amiben éppen játszunk */
	private JatekTerulet jatekterulet;
	/**eloszomszed:élőszomszédok száma i:függőleges, j:vízszintes */
	private int eloszomszed, i, j;

	/** Cella létrehozása 
	 * @param ci A cella sorindexe.
	 * @param cj A cella oszlopindexe.
	 * @param cjt A játékterület, amelyhez a cella tartozik.
	 */
	public Cella(int ci, int cj, JatekTerulet cjt) {
		allapot = Allapot.HALOTT; // Elején mindig halott
		eloszomszed = 0;
		i = ci;
		j = cj;
		this.setBackground(Color.WHITE); // És halott Cellák fehérek
		this.addActionListener(new SzinValtListener()); // Ránomyunk a Cellára akkor váltakozzon ÉLŐ és HALOTT között
		jatekterulet = cjt;
	}
	/**Halottá válás*/
	public void halottlesz() {
		allapot = Allapot.HALOTT; // Halott lesz a cella
		this.setBackground(Color.WHITE); // Halott cella színe fekete
	}
	/**Feleledes*/
	public void eled() {
		allapot = Allapot.ELO; // ÉLŐ vé válik a Cella
		Cella[][] temp = jatekterulet.getCellak();
		jatekterulet.ElokNo(); // Élő lett, ezért az élők száma nő
		this.setBackground(Color.BLACK); // Élők színe fekete
		Cellafrissit(temp, true); // Szomdékos frissítése
	}
	/**Cellák, amik halványulnak*/
	public void halvanyul() {
		Cella[][] temp = jatekterulet.getCellak();
		jatekterulet.ElokCsokken(); // Halvány nem számít élőnek
		this.setBackground(Color.GRAY); // Halvány színe szürke
		/* Szomdékos frissítése */
		Cellafrissit(temp, false);
	}
	/**Cellák állapotainak változása*/
	public void allapotvaltozas() {
		switch (allapot) {
		case HALOTT: {
			if (jatekterulet.getFeleledes().contains(eloszomszed)) { // Eddig halott volt, de a szabály szerint fel kell
																		// élednie
				allapot = Allapot.FELELED;
			}
			break;
		}
		case ELO: {
			if (!jatekterulet.getTuleles().contains(eloszomszed)) { // Eddig élő volt, de a szabály szerint nem élhet
																	// tovább
				allapot = Allapot.HALVANYUL;
			}
			break;
		}
		case HALVANYUL: {
			if (jatekterulet.getFeleledes().contains(eloszomszed)) { // Ha közben megint fel kéne élednie
				allapot = Allapot.FELELED;
				return;
			}
			allapot = Allapot.MEGHAL; // Ha eddig halvány volt és nem kell felélednie akkor meghal
			break;
		}
		default:
			break;
		}
	}
	/**Játék futásakor a Cellák szín váltásához*/
	public void szinvaltas() {
		if (allapot.equals(Allapot.FELELED)) { // Ha a cella eled, akkor élő lesz
			this.eled();
		} else if (allapot.equals(Allapot.MEGHAL)) { // Ha meghal akkor halott lesz
			this.halottlesz();
		} else if (allapot.equals(Allapot.HALVANYUL)) { // Ha halványul akkor halvány lesz
			this.halvanyul();
		}
	}
	/**Cellák szomszédjainak Frissitése Nővel/Csökkent
	 * @param temp A jelenlegi cellaállapotokat tartalmazó mátrix.
	 * @param Novel Jelzi, hogy növekszik-e az elő cellák száma.
	 * */
	public void Cellafrissit(Cella[][] temp, boolean Novel)
	{
		if (Novel) // Nővel
		{
			if (i != 0 && j != 0) {
				temp[i - 1][j - 1].szomszedNo(); // Bal felső szomszéd
			}
			if (i != 0) {
				temp[i - 1][j].szomszedNo(); // Felső szomszéd
			}
			if (i != 0 && j != 31) {
				temp[i - 1][j + 1].szomszedNo(); // Jobb felső szomszéd
			}
			if (j != 0) {
				temp[i][j - 1].szomszedNo(); // Bal oldali szomszéd
			}
			if (j != 31) {
				temp[i][j + 1].szomszedNo(); // Jobb oldali szomszéd
			}
			if (i != 31 && j != 0) {
				temp[i + 1][j - 1].szomszedNo(); // Bal alsó szomszéd
			}
			if (i != 31) {
				temp[i + 1][j].szomszedNo(); // Alsó szomszéd
			}
			if (i != 31 && j != 31) {
				temp[i + 1][j + 1].szomszedNo(); // Jobb alsó szomszéd
			}
		} else // Csökkent
		{
			if (i != 0 && j != 0) {
				temp[i - 1][j - 1].szomszedCsokken(); // Bal felső
			}
			if (i != 0) {
				temp[i - 1][j].szomszedCsokken(); // Felső
			}
			if (i != 0 && j != 31) {
				temp[i - 1][j + 1].szomszedCsokken(); // Jobb felső
			}
			if (j != 0) {
				temp[i][j - 1].szomszedCsokken(); // Bal oldali
			}
			if (j != 31) {
				temp[i][j + 1].szomszedCsokken(); // Jobb oldali
			}
			if (i != 31 && j != 0) {
				temp[i + 1][j - 1].szomszedCsokken(); // Bal alsó
			}
			if (i != 31) {
				temp[i + 1][j].szomszedCsokken(); // Alsó
			}
			if (i != 31 && j != 31) {
				temp[i + 1][j + 1].szomszedCsokken(); // Jobb alsó
			}
		}
	}
	/**Beolvasáskor frissiti, hogy lehessen Szintváltani*/
	public void frissit()
	{
		this.addActionListener(new SzinValtListener());
	}
	/**Elő szomszédok növelése*/
	public void szomszedNo() { // szomszed Növel
		eloszomszed++;
	}
	/**Élő szomszédok csökkentése*/
	public void szomszedCsokken() { // szomszed csökkent
		eloszomszed--;
	}
	/** Visszaadja az állapotot 
	 * @return cella állapota
	 */
	public Allapot getAllapot() { 
		return allapot;
	}
	/**visszaadja az Élőszomszédok szamat
	 * @return Az élő cellák száma.*/
	public int getEloszomszed() {
		return eloszomszed;
	}
	/**a Resethez élőszomszédokat 0-ra állítja*/
	public void setEloszomszed() {
		eloszomszed = 0;
	}
}