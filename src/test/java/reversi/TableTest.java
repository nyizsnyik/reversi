package reversi;

import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.Test;

public class TableTest {

	String s = "  1 2 3 4 5 6 7 8 \n1 - - - - - - - - \n2 - - - - - - - - \n3 - - - - - - - - \n4 - - - O X - - - \n5 - - - X O - - - \n6 - - - - - - - - \n7 - - - - - - - - \n8 - - - - - - - - \n";
	String s1 = "  1 2 3 4 5 6 7 8 \n1 X - - - - - - - \n2 - - - - - - - - \n3 - - - - - - - - \n4 - - - O X - - - \n5 - - - X O - - - \n6 - - - - - - - - \n7 - - - - - - - - \n8 - - - - - - - - \n";
	String s2 = "  1 2 3 4 5 6 7 8 \n1 I - - - - - - - \n2 - - - - - - - - \n3 - - - - - - - - \n4 - - - O X - - - \n5 - - - X O - - - \n6 - - - - - - - - \n7 - - - - - - - - \n8 - - - - - - - - \n";
	public int[][] m0 = { { 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 } };
	@Test
	public void testgetTable() {
		Table t = new Table(8);
		assertEquals(t.getTable(), t.table);
	}

	@Test
	public void testtoString() {
		Table t = new Table(8);
		assertEquals(s, t.toString());
		t.table[0][0]=1;
		assertEquals(s1, t.toString());
		t.table[0][0]=2;
		assertEquals(s2, t.toString());
	}
	
	@Test
	public void testlehetLepes() {
		Table t = new Table(8);
		TreeSet<Kordinata> ts = new TreeSet<Kordinata>();
		ts.add(new Kordinata(0, 0));
		t.lehetsegesLesesek(ts);
		assertEquals(2, t.table[0][0]);
		ts.add(new Kordinata(1, 1));
		t.lehetsegesLesesek(ts);
		assertEquals(2, t.table[1][1]);
		t.lehetsegesLesesekEltuntet();
		assertEquals(0, t.table[0][0]);
		assertEquals(0, t.table[1][1]);
		
	}
	@Test
	public void testlep() {
		Table t = new Table(8);
		t.lep(new Kordinata(2, 3), 1);
		assertEquals(1, t.table[3][3]);
		assertEquals(1, t.table[2][3]);
		t.lep(new Kordinata(4, 2), -1);
		assertEquals(-1, t.table[4][2]);
		assertEquals(-1, t.table[4][3]);
		t.lep(new Kordinata(5, 5), 1);
		assertEquals(1, t.table[5][5]);
		assertEquals(1, t.table[4][4]);
		t.lep(new Kordinata(1, 3), -1);
		assertEquals(-1, t.table[3][3]);
		assertEquals(-1, t.table[1][3]);
		t.table=m0;
		t.table[1][1]=1;
		t.table[2][2]=-1;
		t.lep(new Kordinata(0, 0), -1);
		assertEquals(-1, t.table[0][0]);
		assertEquals(-1, t.table[1][1]);
		assertEquals(-1, t.table[2][2]);
		
		t.table=m0;
		t.table[5][5]=1;
		t.table[6][6]=-1;
		t.lep(new Kordinata(7, 7), 1);
		assertEquals(1, t.table[7][7]);
		assertEquals(1, t.table[6][6]);
		assertEquals(1, t.table[5][5]);
	}
}
