package nhf;

/**
 * A program belépési pontja. Itt indul el az alkalmazás.
 * A Main osztály felelős a Főmenü (Fomenu) ablak megnyitásáért.
 */
public class Main {
	/**Default konstruktor*/
	Main(){}
	/**
     * A program main metódusa, amely elindítja az alkalmazást.
     * Létrehozza és megjeleníti a Főmenü ablakot.
     * @param args A parancssori argumentumok.
     */
	public static void main(String[] args) {
		Fomenu Fomenu=new Fomenu();
		Fomenu.setVisible(true);	//megnyitjuk a Főmenüt
	}

}
