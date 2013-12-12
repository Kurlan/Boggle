package com.stevehuy.scrabble.solver;

import java.util.ArrayList;
import java.util.List;

import com.stevehuy.scrabble.solver.board.ScrabbleRack;

public class ScrabbleSolver {

	public final ScrabbleRack scrabbleRack;
	
	public ScrabbleSolver(ScrabbleRack scrabbleRack) {
		this.scrabbleRack = scrabbleRack;
	}
	
	public List<String> solve() {
		List<String> solutions = new ArrayList<String>();
		
		return solutions;
	}
}
