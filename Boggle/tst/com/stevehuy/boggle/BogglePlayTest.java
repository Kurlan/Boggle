package com.stevehuy.boggle;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.stevehuy.boggle.board.BoggleBoard;
import com.stevehuy.boggle.board.BoggleBoardFactory;

public class BogglePlayTest {

	BogglePlay play;
	BoggleBoard board;
	
	@Before
	public void setup() {
		board = BoggleBoardFactory.getTestBoard();
		play = new BogglePlay(board);
	}
	
	@Test
	public void possiblePlaysNoPlay() {
		assertTrue(play.possiblePlays().size() == board.getSize() *  board.getSize());
	}
}
