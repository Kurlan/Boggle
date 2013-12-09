package com.stevehuy.boggle.board;


import java.util.Set;

import com.stevehuy.boggle.board.BoggleBoard;
import com.stevehuy.boggle.board.BoggleBoardFactory;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;


public class BoggleBoardTest {
	public BoggleBoard board;
	
	@Before
	public void setup() {
		board = BoggleBoardFactory.getTestBoard();
	}
	
	@Test
	public void testTopCornerNeighbors() {
		Set<BoggleTile> neighbors = board.getNeighbors(0, 0);
		assertTrue(neighbors.size() == 3);
		assertTrue(neighbors.contains(new BoggleTile(new Point(0, 1), "E")));
		assertTrue(neighbors.contains(new BoggleTile(new Point(1, 1), "N")));
		assertTrue(neighbors.contains(new BoggleTile(new Point(1, 0), "W")));
	}
	
	@Test
	public void testBottomCornerNeighbors() {
		Set<BoggleTile> neighbors = board.getNeighbors(3, 3);
		assertTrue(neighbors.size() == 3);
		assertTrue(neighbors.contains(new BoggleTile(new Point(3, 2), "T")));
		assertTrue(neighbors.contains(new BoggleTile(new Point(2, 3), "M")));
		assertTrue(neighbors.contains(new BoggleTile(new Point(2, 2), "E")));
	}

	@Test
	public void testMiddleNeighbor() {
		Set<BoggleTile> neighbors = board.getNeighbors(1, 1);
		assertTrue(neighbors.size() == 8);
		assertTrue(neighbors.contains(new BoggleTile(new Point(0, 1), "E")));
		assertTrue(neighbors.contains(new BoggleTile(new Point(2, 0), "T")));
		assertTrue(neighbors.contains(new BoggleTile(new Point(1, 0), "W")));
		assertTrue(neighbors.contains(new BoggleTile(new Point(0, 0), "S")));
		assertTrue(neighbors.contains(new BoggleTile(new Point(2, 1), "R")));
		assertTrue(neighbors.contains(new BoggleTile(new Point(1, 2), "Y")));
		assertTrue(neighbors.contains(new BoggleTile(new Point(2, 2), "E")));
		assertTrue(neighbors.contains(new BoggleTile(new Point(0, 2), "O")));
	}
}
