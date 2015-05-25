package reversi;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.BeforeClass;
import org.junit.Test;

public class BejarTest {
	public Bejar b = new Bejar();;
	public int jatekos1 = 1;
	public int jatekos2 = -1;
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

	@Test
	public void testUresTabla() {
		LinkedList<Kordinata> ll = new LinkedList<Kordinata>();
		for (int i = -1; i < 2; i += 2) {
			assertEquals(ll, b.balFentJobbLent(i, m0));
			assertEquals(ll, b.balJobb(i, m0));
			assertEquals(ll, b.balLentJobbFent(i, m0));
			assertEquals(ll, b.fentLent(i, m0));
			assertEquals(ll, b.jobbBal(i, m0));
			assertEquals(ll, b.jobbFentBalLent(i, m0));
			assertEquals(ll, b.jobbLentBalFent(i, m0));
			assertEquals(ll, b.lentFent(i, m0));
		}

	}

	@Test
	public void testAlaptabla() {
		LinkedList<Kordinata> ll = new LinkedList<Kordinata>();
		assertEquals(ll, b.balFentJobbLent(jatekos1, m1));
		assertEquals(ll, b.balLentJobbFent(jatekos1, m1));
		assertEquals(ll, b.jobbLentBalFent(jatekos1, m1));
		assertEquals(ll, b.jobbFentBalLent(jatekos1, m1));
		ll.add(new Kordinata(4, 5));
		assertEquals(ll, b.balJobb(jatekos1, m1));
		ll.clear();
		ll.add(new Kordinata(3, 2));
		assertEquals(ll, b.jobbBal(jatekos1, m1));
		ll.clear();
		ll.add(new Kordinata(5, 4));
		assertEquals(ll, b.fentLent(jatekos1, m1));
		ll.clear();
		ll.add(new Kordinata(2, 3));
		assertEquals(ll, b.lentFent(jatekos1, m1));

	}

	@Test
	public void testRandomTabla() {
		LinkedList<Kordinata> ll = new LinkedList<Kordinata>();
		ll.add(new Kordinata(6, 5));
		ll.add(new Kordinata(4, 5));
		ll.add(new Kordinata(4, 6));
		
		assertEquals(ll, b.balFentJobbLent(jatekos2, m2));
		 ll.clear();
		 ll.add(new Kordinata(2, 6));
		 ll.add(new Kordinata(2,5));
		 assertEquals(ll,b.balLentJobbFent(jatekos2, m2));
		
		 ll.clear();
		 assertEquals(ll,b.jobbLentBalFent(jatekos2, m2));
		 ll.clear();
		 ll.add(new Kordinata(4,2));
		 assertEquals(ll,b.jobbFentBalLent(jatekos2, m2));
		 ll.clear();
		 ll.add(new Kordinata(4, 5));ll.add(new Kordinata(5, 5));
		 assertEquals(ll,b.balJobb(jatekos2, m2));
		 ll.clear();
		 ll.add(new Kordinata(2,1));
		 assertEquals(ll,b.jobbBal(jatekos2, m2));
		 ll.clear();
		 ll.add(new Kordinata(6,4));
		 assertEquals(ll,b.fentLent(jatekos2, m2));
		 ll.clear();
		 assertEquals(ll,b.lentFent(jatekos2, m2));

	}
}
