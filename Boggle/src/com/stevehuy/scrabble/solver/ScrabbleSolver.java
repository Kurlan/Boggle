package com.stevehuy.scrabble.solver;

import java.util.List;

public interface ScrabbleSolver {
	
	public List<String> solve();
	public long getTiming();
	public long getNumberOfLookups();
}
