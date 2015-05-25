package reversi;

import static org.junit.Assert.*;

import org.junit.Test;

public class KordinataTest {

	@Test
	public void testhash() {
		assertEquals(961, new Kordinata(0, 0).hashCode());
		assertEquals(993, new Kordinata(1, 1).hashCode());
		assertEquals(1182, new Kordinata(7, 4).hashCode());
		assertEquals(1092, new Kordinata(4, 7).hashCode());
	}
	@Test
	public void testequals() {
		Kordinata k = new Kordinata(1, 2);
		assertEquals(true, k.equals(new Kordinata(1, 2)));
		assertEquals(false, k.equals(new Kordinata(2, 1)));
		assertEquals(false, k.equals(new Kordinata(0, 0)));
		Kordinata k1 = new Kordinata(3, 2);
		assertEquals(true, k1.equals(new Kordinata(3, 2)));
		assertEquals(false, k1.equals(new Kordinata(3, 1)));
	}
	
	@Test
	public void testtostring() {
		Kordinata k = new Kordinata(1, 2);
		assertEquals("[2, 3] ", k.toString());
		Kordinata k1 = new Kordinata(6, 4);
		assertEquals("[7, 5] ", k1.toString());
	}
	
	
	

}
