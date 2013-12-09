package com.stevehuy.boggle.solver;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.stevehuy.boggle.board.BoggleBoard;
import com.stevehuy.boggle.board.BoggleBoardFactory;
import com.stevehuy.boggle.board.BoggleTile;
import com.stevehuy.boggle.board.Point;
import com.stevehuy.boggle.solver.BogglePlay;
import com.stevehuy.dictionary.Dictionary;

public class BogglePlayTest {

	private BogglePlay play;
	private BoggleBoard board;
	private Dictionary dictionary;
	
	
	@Before
	public void setup() {
		board = BoggleBoardFactory.getTestBoard();
		play = new BogglePlay(board, dictionary);
	}
	
	@Test
	public void testToString() {
		play.addBoggleTile(new BoggleTile(new Point(0,0), "A"));
		play.addBoggleTile(new BoggleTile(new Point(1,0), "S"));
		play.addBoggleTile(new BoggleTile(new Point(1,1), "S"));
		assertEquals(play.toString(), "ASS");
	}
	
	@Test
	public void testRemoveVisited() {
		play.addBoggleTile(board.get(0, 0));
		play.addBoggleTile(board.get(0, 1));
		Set<BoggleTile> neighbors = board.getNeighbors(play.getLast());
		Set<BoggleTile> toCheck = play.removeVisited(neighbors);
		assertTrue(!toCheck.contains(board.get(0,0)));
		assertTrue(toCheck.contains(board.get(1,1)));
		
	}
}
