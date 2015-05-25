package reversi;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {

	@Test
	public void testkiNyert1() {
		for (int i = 1; i <= 40; i++) 
			assertEquals("1. játékos nyert!",Main.kiNyert(i));
	}
	@Test
	public void testkiNyert2() {
		for (int i = -1; i >= -40; i--) 
			assertEquals("2. játékos nyert!",Main.kiNyert(i));
	}
	@Test
	public void testkiNyertD() {
		assertEquals("Döntetlen!",Main.kiNyert(0));
	}

}
