package reversi;

import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author nyizsnyik 
 * Tábla bejáró és vizsgáló metódusokat tartalmaz.
 */
public class Bejar {
	private static Logger logger = LoggerFactory.getLogger(Bejar.class);
	/**
	 * A <code>flag1</code> akkor igaz ha meghíváskor a metódus a paraméterként
	 * kapott játékos korongját találja meg.
	 */
	private Boolean flag1 = false;
	/**
	 * A <code>flag2</code> akkor igat ha a paraméterként kapott játékos
	 * ellenfelének korongját találta meg és előtte volt e játékos korongja úhy
	 * hogy a két korong között nem volt olyan hely ahol nem volt korong.
	 */
	private Boolean flag2 = false;
	/**
	 * Itt zajlik a korong vizsgálata. 
	 * @param aktertek korong értéke.
	 * @param jatekos játékos akinek a szemszögéből vizsgálni kell a korongot.
	 * @return ha a korong megfelel az elvárásoknak akkor <code>true</code> ha nem akkor <code>false</code>
	 */
	private boolean vizsgal(int aktertek, int jatekos) {
		logger.debug("vizsgál metódus meghívása megtörtént.");
		if (aktertek == jatekos || flag1) {
			flag1 = true;
			if (aktertek == (jatekos * -1) || flag2) {
				flag2 = true;
				if (aktertek == 0) {
					flag1 = false;
					flag2 = false;
					return true;
				} else if (aktertek == jatekos) {
					flag2 = false;
				}
			} else if (aktertek == 0) {
				flag1 = false;
				flag2 = false;
			}
		}
		return false;
	}
	
	/**
	 * A sorokat ballról jobbra vizsgálja.
	 * @param jatekos az a játékos akinek a szemszögéből vizsgálni kell a <code>table</code> táblát.
	 * @param table aza  tábla amit vizsgálunk.
	 * @return <code>jatekos</code>szeszögéből a <code>table</code> táblán lehetséges lépések listája.
	 */
	public LinkedList<Kordinata> balJobb(int jatekos, int[][] table) {
		logger.debug("metódus meghívása metörtént.");
		flag1 = false;
		flag2 = false;
		LinkedList<Kordinata> list = new LinkedList<Kordinata>();
		for (int i = 0; i < table.length; i++) {
			flag1 = false;
			flag2 = false;
			for (int j = 0; j < table.length; j++) {
				if (vizsgal(table[i][j], jatekos)) {
					list.add(new Kordinata(i, j));
				}
			}
		}
		return list;
	}
	/**
	 * A sorokat jobbról ballra vizsgálja.
	 * @param jatekos az a játékos akinek a szemszögéből vizsgálni kell a <code>table</code> táblát.
	 * @param table aza  tábla amit vizsgálunk.
	 * @return <code>jatekos</code>szeszögéből a <code>table</code> táblán lehetséges lépések listája.
	 */
	public LinkedList<Kordinata> jobbBal(int jatekos, int[][] table) {
		logger.debug("metódus meghívása metörtént.");
		flag1 = false;
		flag2 = false;
		LinkedList<Kordinata> list = new LinkedList<Kordinata>();
		for (int i = 0; i < table.length; i++) {
			flag1 = false;
			flag2 = false;
			for (int j = table.length - 1; j >= 0; j--) {
				if (vizsgal(table[i][j], jatekos)) {
					list.add(new Kordinata(i, j));
				}
			}
		}
		return list;
	}
	/**
	 * Az oszlopokat fentről lefelé vizsgálja.
	 * @param jatekos az a játékos akinek a szemszögéből vizsgálni kell a <code>table</code> táblát.
	 * @param table aza  tábla amit vizsgálunk.
	 * @return <code>jatekos</code>szeszögéből a <code>table</code> táblán lehetséges lépések listája.
	 */
	public LinkedList<Kordinata> fentLent(int jatekos, int[][] table) {
		logger.debug("metódus meghívása metörtént.");
		flag1 = false;
		flag2 = false;
		LinkedList<Kordinata> list = new LinkedList<Kordinata>();
		for (int i = 0; i < table.length; i++) {
			flag1 = false;
			flag2 = false;
			for (int j = 0; j < table.length; j++) {
				if (vizsgal(table[j][i], jatekos)) {
					list.add(new Kordinata(j, i));
				}
			}
		}
		return list;
	}
	/**
	 * Az oszlopokat lentről felfelé vizsgálja vizsgálja.
	 * @param jatekos az a játékos akinek a szemszögéből vizsgálni kell a <code>table</code> táblát.
	 * @param table aza  tábla amit vizsgálunk.
	 * @return <code>jatekos</code>szeszögéből a <code>table</code> táblán lehetséges lépések listája.
	 */
	public LinkedList<Kordinata> lentFent(int jatekos, int[][] table) {
		logger.debug("metódus meghívása metörtént.");
		flag1 = false;
		flag2 = false;
		LinkedList<Kordinata> list = new LinkedList<Kordinata>();
		for (int i = 0; i < table.length; i++) {
			flag1 = false;
			flag2 = false;
			for (int j = table.length - 1; j >= 0; j--) {
				if (vizsgal(table[j][i], jatekos)) {
					list.add(new Kordinata(j, i));
				}
			}
		}
		return list;
	}
	/**
	 * Az átlókat bal-fentről jobb-lefelé vizsgálja.
	 * @param jatekos az a játékos akinek a szemszögéből vizsgálni kell a <code>table</code> táblát.
	 * @param table aza  tábla amit vizsgálunk.
	 * @return <code>jatekos</code>szeszögéből a <code>table</code> táblán lehetséges lépések listája.
	 */
	public LinkedList<Kordinata> balFentJobbLent(int jatekos, int[][] table) {
		logger.debug("metódus meghívása metörtént.");
		flag1 = false;
		flag2 = false;
		LinkedList<Kordinata> list = new LinkedList<Kordinata>();
		for (int i = table.length - 3; i >= 0; i--) {
			flag1 = false;
			flag2 = false;
			for (int k = i, j = 0; k < table.length; k++, j++) {
				if (vizsgal(table[k][j], jatekos)) {
					list.add(new Kordinata(k, j));
				}
			}
		}
		for (int i = 1; i < table.length - 2; i++) {
			flag1 = false;
			flag2 = false;
			for (int j = i, k = 0; j < table.length; j++, k++) {
				if (vizsgal(table[k][j], jatekos)) {
					list.add(new Kordinata(k, j));
				}
			}
		}
		return list;
	}
	/**
	 * Az átlókat jobb-fentről  bal-lefelé vizsgálja.
	 * @param jatekos az a játékos akinek a szemszögéből vizsgálni kell a <code>table</code> táblát.
	 * @param table aza  tábla amit vizsgálunk.
	 * @return <code>jatekos</code>szeszögéből a <code>table</code> táblán lehetséges lépések listája.
	 */
	public LinkedList<Kordinata> jobbFentBalLent(int jatekos, int[][] table) {
		logger.debug("metódus meghívása metörtént.");
		flag1 = false;
		flag2 = false;
		LinkedList<Kordinata> list = new LinkedList<Kordinata>();
		for (int i = 2; i < table.length; i++) {
			flag1 = false;
			flag2 = false;
			for (int j = i, k = 0; j >= 0; j--, k++) {
				if (vizsgal(table[k][j], jatekos)) {
					list.add(new Kordinata(k, j));
				}
			}
		}
		for (int i = 1; i < table.length - 2; i++) {
			flag1 = false;
			flag2 = false;
			for (int j = table.length - 1, k = i; k < table.length; j--, k++) {
				if (vizsgal(table[k][j], jatekos)) {
					list.add(new Kordinata(k, j));
				}
			}
		}
		return list;
	}
	/**
	 * Az átlókat bal-lentről  job-felfelé vizsgálja.
	 * @param jatekos az a játékos akinek a szemszögéből vizsgálni kell a <code>table</code> táblát.
	 * @param table aza  tábla amit vizsgálunk.
	 * @return <code>jatekos</code>szeszögéből a <code>table</code> táblán lehetséges lépések listája.
	 */
	public LinkedList<Kordinata> balLentJobbFent(int jatekos, int[][] table) {
		logger.debug("metódus meghívása metörtént.");
		flag1 = false;
		flag2 = false;
		LinkedList<Kordinata> list = new LinkedList<Kordinata>();
		for (int i = table.length - 3; i >= 0; i--) {
			flag1 = false;
			flag2 = false;
			for (int j = i, k = table.length - 1; j < table.length; j++, k--) {
				if (vizsgal(table[k][j], jatekos)) {
					list.add(new Kordinata(k, j));
				}
			}
		}
		for (int i = table.length - 2; i > 1; i--) {
			flag1 = false;
			flag2 = false;
			for (int j = 0, k = i; k >= 0; j++, k--) {
				if (vizsgal(table[k][j], jatekos)) {
					list.add(new Kordinata(k, j));
				}
			}
		}
		return list;
	}
	/**
	 * Az átlókat jobb-letről bal-felfelé vizsgálja.
	 * @param jatekos az a játékos akinek a szemszögéből vizsgálni kell a <code>table</code> táblát.
	 * @param table aza  tábla amit vizsgálunk.
	 * @return <code>jatekos</code>szeszögéből a <code>table</code> táblán lehetséges lépések listája.
	 */
	public LinkedList<Kordinata> jobbLentBalFent(int jatekos, int[][] table) {
		logger.debug("metódus meghívása metörtént.");
		flag1 = false;
		flag2 = false;
		LinkedList<Kordinata> list = new LinkedList<Kordinata>();
		for (int i = 2; i < table.length; i++) {
			flag1 = false;
			flag2 = false;
			for (int j = table.length - 1, k = i; k >= 0; j--, k--) {
				if (vizsgal(table[k][j], jatekos)) {
					list.add(new Kordinata(k, j));
				}
			}
		}
		for (int i = table.length - 2; i > 1; i--) {
			flag1 = false;
			flag2 = false;
			for (int j = i, k = table.length - 1; j >= 0; j--, k--) {
				if (vizsgal(table[k][j], jatekos)) {
					list.add(new Kordinata(k, j));
				}
			}
		}
		return list;
	}
}
