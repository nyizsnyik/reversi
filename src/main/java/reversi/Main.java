package reversi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * 
 * @author nyizsnyik
 * Ez az osztály tartalmazza a <code>main</code> metódust.
 */
public class Main {
	/**
	 * Eldönti hogy ki nyerte a jástmát ha egyáltalán nyert valaki.
	 * @param eredmeny egy egész szán amiszerint dönt a metódus.
	 * @return egy <code>String</code>-el tér vissza amiven a nyertes szerepel.
	 */
	public static String kiNyert(int eredmeny){
		String s="";
		if (eredmeny > 0)
			s="1. játékos nyert!";
		else if (eredmeny < 0)
			s="2. játékos nyert!";
		else
			s="Döntetlen!";
		return s;
	}
	private static Logger logger = LoggerFactory.getLogger(Main.class);
	public static void main(String[] args) {
		logger.debug("Main elindult.");
		Vezerlo v = new Vezerlo(1, 8);
		logger.debug("Vezerlo objektunk létrehozva.");
		int eredmeny = v.Play();
		logger.debug("játék vége eredmény kiértékelése kezdődik.");
		System.out.println(kiNyert(eredmeny));
		logger.debug("Kiértékelés megtörtént.");
		System.out.println("Köszönjük hogy ezt a játékot választotta, ne felejtse el támodatni a készítőt :D.");
		logger.debug("Program leáll.");
	}
}
