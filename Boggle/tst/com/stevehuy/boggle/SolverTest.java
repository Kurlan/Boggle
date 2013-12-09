package com.stevehuy.boggle;

import org.junit.*;

import com.stevehuy.dictionary.Dictionary;

public class SolverTest {
	
	Solver solver;
	
	@Before
	public void setup() {
		BoggleBoard board = new BoggleBoard();
		solver = new Solver(board, new Dictionary());
	}
	


}
