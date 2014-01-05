package com.stevehuy.scrabble;

import com.stevehuy.dictionary.HybridDictionary;
import com.stevehuy.dictionary.PrefixDictionary;
import com.stevehuy.scrabble.solver.ScrabbleSolver;
import com.stevehuy.scrabble.solver.board.ScrabbleRack;
import com.stevehuy.scrabble.solver.board.ScrabbleRackFactory;

public class Profiler {

	public static final int SAMPLES = 1000;
	
	public static void main(String[] args) {
		
		
		System.out.println("Prefix dictionary with " + SAMPLES + " samples");
		PrefixDictionary prefixDictionary = new PrefixDictionary(2);
		long timing = 0;
		
		for (int i = 0; i < SAMPLES; i++) {
			ScrabbleRack rack = ScrabbleRackFactory.randomRack();
			ScrabbleSolver solver = new ScrabbleSolver(rack, prefixDictionary);
			solver.solve();
			timing += solver.getTiming(); 
		}
		System.out.println("Solved " + SAMPLES + " + racks in: " + timing + " msecs");
		System.out.println("Avg: " + (double)timing/SAMPLES);
		System.out.println("Dictionary queried: " + prefixDictionary.getNumberOfQueries());
		System.out.println("Avg: " + prefixDictionary.getNumberOfQueries() / SAMPLES);
		
		
		System.out.println("Hybrid dictionary with " + SAMPLES + " samples");
		HybridDictionary hybridDictionary = new HybridDictionary(2);
		timing = 0;
		
		for (int i = 0; i < SAMPLES; i++) {
			ScrabbleRack rack = ScrabbleRackFactory.randomRack();
			ScrabbleSolver solver = new ScrabbleSolver(rack, hybridDictionary);
			solver.solve();
			timing += solver.getTiming(); 
		}
		System.out.println("Solved " + SAMPLES + " + racks in: " + timing + " msecs");
		System.out.println("Avg: " + (double)timing/SAMPLES);
		System.out.println("Dictionary queried: " + prefixDictionary.getNumberOfQueries());
		System.out.println("Avg: " + prefixDictionary.getNumberOfQueries() / SAMPLES);
	}

}
