package reversi;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author nyizsnyik Ez az osztány tartalmazza a játékk logikáját és a játék
 *         menet számára nélkülözhetetlen metódusokat.
 */
public class Vezerlo {

	private static Logger logger = LoggerFactory.getLogger(Vezerlo.class);
	/**
	 * Az aktuális játékost tartalmazza.
	 */
	public int aktJatekos;
	/**
	 * A játék tábláját tartalmazó objektum.
	 */
	public Table table;
	/**
	 * A tábla vizsgálatához szükséges osztály.
	 */
	public Bejar bejar;
	/**
	 * Azt tároljuk ebben a constasban hogy hányszor hanyas a tábla.
	 */
	final private int n;

	/**
	 * Ezzel tudjuk lekérdezni az az n-et.
	 * 
	 * @return hányszor hanyas a tábla mérete.
	 */
	public int getN() {
		logger.debug("getN meghíva.");
		return n;
	}

	/**
	 * Létrehoz egy {@code Vezerlo} objektumot úgy hogy ő példányosítja a tábla
	 * objectumost is.
	 * 
	 * @param aktJatekos
	 *            kezdő játékos.
	 * @param n
	 *            tábla mérete.
	 */
	public Vezerlo(int aktJatekos, int n) {
		logger.debug("Konstruktor meghíva.");
		this.n = n;
		this.aktJatekos = aktJatekos;
		this.table = new Table(n);
		this.bejar = new Bejar();
	}

	/**
	 * Létrehoz egy {@code Vezerlo} objektumot kapott tábla objektum
	 * felhasználásával.
	 * 
	 * @param aktJatekos
	 *            kezdő játékos.
	 * @param table
	 *            játék táblája.
	 */
	public Vezerlo(int aktJatekos, Table table) {
		logger.debug("Konstruktor meghíva.");
		this.n = table.getTable().length;
		this.aktJatekos = aktJatekos;
		this.table = table;
		this.bejar = new Bejar();
	}

	/**
	 * A játék menetet tartalmazza és vissza tér a nyertessel.
	 * 
	 * @return a két játékos pontjainak külömbségével ez alapján lehet eldönteni
	 *         ki nyert.
	 */
	public int Play() {
		logger.debug("Play metódus meghíva.");
		Scanner sc = new Scanner(System.in);

		while (!(vegeE(this.table.getTable()))) {
			TreeSet<Kordinata> ts = lehetLepesek(aktJatekos,
					this.table.getTable());
			table.lehetsegesLesesek(ts);
			System.out.println(table);
			logger.debug("Tábla kiírva.");
			table.lehetsegesLesesekEltuntet();
			System.out.println("1. játékos pontjai: "
					+ pontok(1, this.table.getTable()));
			System.out.println("2. játékos pontjai: "
					+ pontok(-1, this.table.getTable()));
			logger.debug("Játékosok pontjai kiírva.");
			System.out.println(jatekos(aktJatekos) + ". játékos következik.");
			logger.debug("Aktuális játékos kiírva.");
			System.out.print("Lehetséges lépések: ");
			for (Kordinata k : ts) {
				System.out.print(k);
			}
			logger.debug("Lehetséges lépések kiírva.");
			System.out.print("\nKérem adja meg a lépését: ");
			String s = sc.nextLine();
			Scanner sc2 = new Scanner(s);
			logger.debug("Input bekérve kiértékelés megkezdése.");
			try {
				Kordinata k = new Kordinata(sc2.nextInt() - 1,
						sc2.nextInt() - 1);
				logger.debug("Szintaktikailag megfelelő input.");

				if (!ts.isEmpty()) {
					logger.debug("Lehetséges lépések halmaza nem üres.");
					if (ts.contains(k)) {
						logger.debug("Szemantikailag megfelelő lépés.");
						for (int i = -1; i < 2; i++) {
							for (int j = -1; j < 2; j++) {
								table.lep(k, i, j, aktJatekos);
								logger.debug("Lépés elvégezve.");
							}
						}
						if (!lehetLepesek(aktJatekos * -1, table.getTable())
								.isEmpty()) {
							aktJatekos = aktJatekos * -1;
							logger.debug("Játékos váltás.");
						}
					} else {
						System.out.println("\nLépés nem lehetséges.");
						logger.debug("Szemantikailag helytelen lépés.");
					}
				}

			} catch (NumberFormatException | ArrayIndexOutOfBoundsException
					| NoSuchElementException e) {
				logger.debug("Szintaktikailga helytelen lépés.");
				System.out.println();
				System.out
						.println("Kérem két darab egész számot adjon meg szóközzel leválasztva.");
			}

			sc2.close();
			logger.debug("sc2 bezárása megtörtént.");
		}
		sc.close();
		logger.debug("sc bezárása megtörtént.");
		System.out.println(this.table.getTable());
		System.out.println("1. játékos pontjai: "
				+ pontok(1, this.table.getTable()));
		System.out.println("2. játékos pontjai: "
				+ pontok(-1, this.table.getTable()));
		logger.debug("Játékosok pontjainak kiszámítása és végeredmény elészítése.");
		return pontok(1, this.table.getTable())
				- pontok(-1, this.table.getTable());

	}

	/**
	 * A megkapott táblát átvizsgálja a kapott játékos szemszögéből és visszadja
	 * milyen lépési lehetőségei vannak.
	 * 
	 * @param aktJatekos
	 *            melyik játékos szemszögéből vizsgáljuk a <code>table</code> t.
	 * @param table
	 *            az a tábla amit vizsgál a metódus.
	 * @return lehetséges lépések az <code>aktJatekos</code> szemszögéből.
	 */
	public TreeSet<Kordinata> lehetLepesek(int aktJatekos, int[][] table) {
		logger.debug("lehetLepesek metódus meghíva.");
		TreeSet<Kordinata> ts = new TreeSet<Kordinata>();
		logger.debug("ts halmaz létrehozva.");
		logger.debug("Részhalmaz előálítása.");
		ts.addAll(bejar.balFentJobbLent(aktJatekos, table));
		logger.debug("Részhalmaz előálítása.");
		ts.addAll(bejar.balJobb(aktJatekos, table));
		logger.debug("Részhalmaz előálítása.");
		ts.addAll(bejar.balLentJobbFent(aktJatekos, table));
		logger.debug("Részhalmaz előálítása.");
		ts.addAll(bejar.fentLent(aktJatekos, table));
		logger.debug("Részhalmaz előálítása.");
		ts.addAll(bejar.jobbBal(aktJatekos, table));
		logger.debug("Részhalmaz előálítása.");
		ts.addAll(bejar.jobbFentBalLent(aktJatekos, table));
		logger.debug("Részhalmaz előálítása.");
		ts.addAll(bejar.jobbLentBalFent(aktJatekos, table));
		logger.debug("Részhalmaz előálítása.");
		ts.addAll(bejar.lentFent(aktJatekos, table));
		logger.debug("Halmaz sikeresen elkészítve.");
		return ts;
	}

	/**
	 * Megszámolja hogy az adott játékosnak hány pontja van az adott táblán.
	 * 
	 * @param jatekos
	 *            melyik játékos pontjaira vagyunk kíványcsiak.
	 * @param table
	 *            a tabla amelyikben meg kell számolni az adott játékos
	 *            pontjait.
	 * @return a <code>jatekos</code> pontjai a <code>table</code> táblán.
	 */
	public int pontok(int jatekos, int[][] table) {
		logger.debug("pontok metódus meghívval.");
		int pont = 0;
		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.n; j++) {
				if (table[i][j] == jatekos)
					pont++;
			}
		}
		logger.debug("pontok kiszámítva.");
		return pont;
	}

	/**
	 * A játékosok kódolását emberi nyelvre fordítja.
	 * 
	 * @param jatekos
	 *            melyik játékos kódját akarjul lefordítani.
	 * @return ha a <code>jatekos</code> egyenő 1-el akkor 1-el tér vissza ha
	 *         <code>jatekos</code> egyenlő -1 akkor 2-vel tér vissza.
	 */
	public int jatekos(int jatekos) {
		logger.debug("jatekos metódus meghívva.");
		if (jatekos == 1)
			return 1;
		else
			return 2;
	}

	/**
	 * Megvizsgálja a táblát és eldönti hogy vége van e a játéknak.
	 * 
	 * @param table
	 *            az a tábla amit meg kell vizsgálni.
	 * @return <code>true</code> a vége a játéknak és <code>false</code> ha nem.
	 */
	public boolean vegeE(int[][] table) {
		logger.debug("vegeE metódus meghívva.");
		if (lehetLepesek(aktJatekos, table).isEmpty())
			if (lehetLepesek(aktJatekos * -1, table).isEmpty()) {
				logger.debug("Vége a játéknak.");
				return true;
			}

		return false;
	}

}
