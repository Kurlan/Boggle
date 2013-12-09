package com.stevehuy.boggle;

import org.junit.*;

import com.stevehuy.boggle.board.BoggleBoard;
import com.stevehuy.dictionary.Dictionary;

public class SolverTest {
	
	Solver solver;
	
	@Before
	public void setup() {
		BoggleBoard board = new BoggleBoard(4);
		solver = new Solver(board, new Dictionary());
	}
	


}
