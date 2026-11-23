package nhf;

/** 
 * A cellák lehetséges állapotai
 * */
public enum Allapot {
	/**
	 * Az élő állapot aktív
	 */
	ELO,
	/**
	 * A halott állapot inaktív
	 */
	HALOTT,
	/**  
	 * A meghal állapot.
	 */
	MEGHAL,
	/**
	 * A feleled állapot a cella jelenleg halott, de a következő lépésben életre kel.
	 */
	FELELED,
	/**
	 * a cella átmeneti állapotban van, a halott állapot felé halad.
	 */
	HALVANYUL
	
}
