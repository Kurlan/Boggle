package com.stevehuy.boggle.board;

import com.stevehuy.boggle.board.BoggleTile;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoggleTileTest {
	@Test
	public void testEquality() {
		BoggleTile tile1 = new BoggleTile(new Point(0,0), "B");
		BoggleTile tile2 = new BoggleTile(new Point(0,0), "B");
		assertTrue(tile1.equals(tile1));
		assertTrue(tile1.equals(tile2));		
	}
	
	@Test
	public void testNoNEquality() {
		BoggleTile tile1 = new BoggleTile(new Point(0,0), "B");
		BoggleTile tile2 = new BoggleTile(new Point(1,0), "B");
		BoggleTile tile3 = new BoggleTile(new Point(0,0), "C");
		assertFalse(tile1.equals(tile2));
		assertFalse(tile1.equals(tile3));
		assertFalse(tile2.equals(tile1));
		assertFalse(tile2.equals(tile3));
		assertFalse(tile3.equals(tile2));
		assertFalse(tile3.equals(tile1));
	}
}
