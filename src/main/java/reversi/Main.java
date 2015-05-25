package reversi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * 
 * @author nyizsnyik
 * Ez az osztály tartalmazza a <code>main</code> metódust.
 */
public class Main {
	private static Logger logger = LoggerFactory.getLogger(Main.class);
	public static void main(String[] args) {
		logger.debug("Main elindult.");
		Vezerlo v = new Vezerlo(1, 8);
		logger.debug("Vezerlo objektunk létrehozva.");
		int eredmeny = v.Play();
		logger.debug("játék vége eredmény kiértékelése kezdődik.");
		if (eredmeny > 0)
			System.out.println("1. játékos nyert!");
		else if (eredmeny < 0)
			System.out.println("2. játékos nyert!");
		else
			System.out.println("Döntetlen!");
		logger.debug("Kiértékelés megtörtént.");
		System.out
				.println("Köszönjük hogy ezt a játékot választotta, ne felejtse el támodatni a készítőt :D.");
		logger.debug("Program leáll.");

	}

}
