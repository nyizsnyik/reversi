package reversi;

/**
 * 
 * @author nyizsnyik A lépéseket ebből az osztályból létrehozott létrehozott
 *         objektumokban tároljuk.
 */
public class Kordinata implements Comparable<Object> {
	/**
	 * A lépés első kordinátája.
	 */
	public int x;
	/**
	 * A lépés második kordinátálya.
	 */
	public int y;

	/**
	 * Ez a metódus álítja elő az objektum hashcode-ját.
	 * 
	 * @return az objectum hashcode-ja.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	/**
	 * Két <code>Kordinata</code> objektumot hasonlít össze.
	 * 
	 * @return ha a két objektum <code>x</code> és <code>y</code> adattagja
	 *         egyenlő akkor <code>true</code> ha nem <code>false</code>.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this.x == ((Kordinata) obj).x)
			if (this.y == ((Kordinata) obj).y)
				return true;
		return false;
	}

	/**
	 * Készít egy <code>Kordinata</code> objectumot és beállítja a
	 * <code>x</code> és <code>y</code> adattagjait.
	 * 
	 * @param x
	 *            ez lesz az objektum <code>x</code> adattag értéke.
	 * @param y
	 *            ez lesz az objektum <code>y</code> adattag értéke.
	 */
	Kordinata(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	/**
	 * Ennek a metódusnak a segítségével lehet meghatározni hogy két
	 * <code>Kordinata</code> objektum közül egy rendezésben melyik van előrébb.
	 */
	public int compareTo(Object o) {
		if (this.x == ((Kordinata) o).x) {
			return this.y - ((Kordinata) o).y;
		} else {
			return this.x - ((Kordinata) o).x;
		}
	}
	/**
	 * Az objektum kiíratásánál megfelelő megjelenésért felel.
	 */
	@Override
	public String toString() {
		return "[" + (x + 1) + ", " + (y + 1) + "] ";
	}

}
