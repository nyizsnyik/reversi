package reversi;
/**
 * 
 * @author nyizsnyik
 * Ez az osztály tartalmazza a <code>main</code> metódust.
 */
public class Main {

	public static void main(String[] args) {

		Vezerlo v = new Vezerlo(1, 8);
		int eredmeny = v.Play();
		if (eredmeny > 0)
			System.out.println("1. játékos nyert!");
		else if (eredmeny < 0)
			System.out.println("2. játékos nyert!");
		else
			System.out.println("Döntetlen!");
		System.out
				.println("Köszönjük hogy ezt a játékot választotta, ne felejtse el támodatni a készítőt :D.");

	}

}
