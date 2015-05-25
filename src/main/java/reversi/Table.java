package reversi;

import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * @author nyizsnyik
 * Ez az osztály tartalmatta a játékhoz szükséges táblát és a tábla módosítására és lehérdezésére használható metódusokat.
 */
public class Table {
	
	private static Logger logger = LoggerFactory.getLogger(Table.class);
	/**
	 * Maga a tábla
	 */
	public int[][] table;
	/**
	 * Létrehoz egy <code>Table</code> objectumost és beállítja a tábla kézdő helyzetét.
	 * @param n megadja hányszor hanyas legyen a tábla.
	 */
	public Table(int n) {
		logger.debug("konstruktor meghívva.");
		this.table = new int[n][n];
		for (int[] is : table) {
			for (int j = 0; j < is.length; j++) {
				is[j] = 0;
			}
		}
		this.table[3][3] = -1;
		this.table[4][4] = -1;
		this.table[3][4] = 1;
		this.table[4][3] = 1;
	}
	/**
	 * Ezzel a metódussal kérhető le a tábla.
	 * @return a táblával.
	 */
	public int[][] getTable() {
		logger.debug("getTable metódus meghívva.");
		return this.table;
	}
	/**
	 * Az adott játékos lépését hajtja végre.
	 * @param lepes	ez egy <code>Kordinata</code> objektum ez tartalmazza a lépés kordinátáit.
	 * @param lepesx x tengelyen milyen irányba és menyit lépjükn.
	 * @param lepesy y tengelyen milyen irányban és menyit lépjünk.
	 * @param jatekos az a játékos aki lép.
	 */
	public void lep(Kordinata lepes, int lepesx, int lepesy, int jatekos) {
		logger.debug("lep metódus meghívva.");
		TreeSet<Kordinata> ts = new TreeSet<Kordinata>();
		logger.debug("Halmaz létrehozva meghívva.");
		if (lepesx == 0 && lepesy == 0)
			this.table[lepes.x][lepes.y] = jatekos;
		else {
			logger.debug("Átírandó kordináták gyüjtése.");
			for (int i = lepes.x + lepesx, j = lepes.y + lepesy; i >= 0
					&& i < this.table.length && j >= 0 && j < this.table.length
					&& this.table[i][j] == jatekos * -1; i += lepesx, j += lepesy) {
				ts.add(new Kordinata(i, j));
				if (i + lepesx < this.table.length
						&& j + lepesy < this.table.length && i + lepesx >= 0
						&& j + lepesy >= 0
						&& this.table[i + lepesx][j + lepesy] == jatekos) {
					logger.debug("Kordináták átírása.");
					for (Kordinata k : ts) {
						table[k.x][k.y] = jatekos;
					}
				}
			}
		}
	}
	/**
	 * A paraméterként megkapott halmaz által tartalmazott kordinátákat értékét írja át 2-re. 
	 * @param t egy <code>Kordinata</code> objektumokat tartalmazó rendezett halmaz.
	 */
	public void lehetsegesLesesek(TreeSet<Kordinata> t) {
		logger.debug("lehetLepesek metódus meghívva.");
		logger.debug("Lehetséges lépések ábrázolása a táblába.");
		for (Kordinata kordinata : t) {
			this.table[kordinata.x][kordinata.y] = 2;
		}
	}
	/**
	 * Eltünteti a táblából a 2-es értéketet.
	 */
	public void lehetsegesLesesekEltuntet() {
		logger.debug("lehetLepesekEltuntet metódus meghívva.");
		logger.debug("Lehetséges lépések eltüntetése a táblából.");
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table.length; j++) {
				if (this.table[i][j] == 2)
					this.table[i][j] = 0;
			}
		}
	}
	/**
	 * Az objektum kiíratásánál megfelelő megjelenésért felel.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("  ");
		for (int i = 1; i <= this.table.length; i++) {
			sb.append(i + " ");
		}
		sb.append("\n");
		for (int j = 1; j <= this.table.length; j++) {
			sb.append(j + " ");
			for (int i : this.table[j - 1]) {
				if (i == 0)
					sb.append("- ");
				else if (i == 1)
					sb.append("X ");
				else if (i == -1)
					sb.append("O ");
				else
					sb.append("I ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

}
