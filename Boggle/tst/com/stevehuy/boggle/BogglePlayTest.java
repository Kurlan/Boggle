package com.stevehuy.boggle;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BogglePlayTest {

	BogglePlay play;
	
	@Before
	public void setup() {
		BoggleBoard board = new BoggleBoard();
		board.testBoardSetUp();
		play = new BogglePlay(board);
	}
	
	@Test
	public void possiblePlaysNoPlay() {
		assertTrue(play.possiblePlays().size() == BoggleBoard.SIZE * BoggleBoard.SIZE);
	}
}
