package reversi;

import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.Test;

public class VezerloTest {
	public int[][] m0 = { { 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 } };

	public int[][] m1 = { { 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, -1, 1, 0, 0, 0 }, { 0, 0, 0, 1, -1, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 } };

	public int[][] m2 = { { 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 1, -1, -1, 0, 0, 0 },
			{ 0, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, -1, 1, 0, 0, 0 },
			{ 0, 0, 0, -1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 } };
	public int[][] m3 = { { 1, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 } };
	public int[][] m4 = { { 1, -1, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 } };
	public int[][] m5 = { { 0, -1, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 } };
	
	@Test
	public void testgetN() {
		Vezerlo v = new Vezerlo(1,8);
		assertEquals(8, v.getN());
	}
	@Test
	public void testlehetLepesek() {
		Vezerlo v = new Vezerlo(1,8);
		TreeSet<Kordinata> ts = new TreeSet<Kordinata>();
		assertEquals(v.lehetLepesek(1, m0), ts);
		assertEquals(v.lehetLepesek(-1, m0), ts);
		ts.add(new Kordinata(2, 3));
		ts.add(new Kordinata(3, 2));
		ts.add(new Kordinata(5, 4));
		ts.add(new Kordinata(4, 5));
		assertEquals(v.lehetLepesek(1, m1), ts);
		ts.clear();
		ts.add(new Kordinata(2, 1));
		ts.add(new Kordinata(2, 5));
		ts.add(new Kordinata(2, 6));
		ts.add(new Kordinata(4, 2));
		ts.add(new Kordinata(4, 5));
		ts.add(new Kordinata(4, 6));
		ts.add(new Kordinata(5, 5));
		ts.add(new Kordinata(6, 4));
		ts.add(new Kordinata(6, 5));
		assertEquals(v.lehetLepesek(-1, m2), ts);
	}
	@Test
	public void testpontok() {
		Table t = new Table(8);
		Vezerlo v = new Vezerlo(1,t);
		assertEquals(0, v.pontok(1, m0));
		assertEquals(0, v.pontok(-1, m0));
		assertEquals(2, v.pontok(1, m1));
		assertEquals(2, v.pontok(-1, m1));
		assertEquals(7, v.pontok(1, m2));
		assertEquals(4, v.pontok(-1, m2));
	}
	@Test
	public void testvegeE() {
		Table t = new Table(8);
		Vezerlo v = new Vezerlo(1,t);
		assertEquals(true, v.vegeE(m0));
		assertEquals(false, v.vegeE(m1));
		assertEquals(false, v.vegeE(m2));
		assertEquals(true, v.vegeE(m3));
		assertEquals(false, v.vegeE(m4));
		assertEquals(true, v.vegeE(m5));
	}
	
	@Test
	public void testjatekos() {
		Vezerlo v = new Vezerlo(1,8);
		assertEquals(1, v.jatekos(1));
		assertEquals(2, v.jatekos(-1));
	}
	@Test
	public void testplay() {
		Vezerlo v = new Vezerlo(1,8);
		v.table.table=m0;
		assertEquals(0, v.Play());
		v.table.table=m3;
		assertEquals(2, v.Play());
		v.table.table=m5;
		assertEquals(-1, v.Play());
	}
}
