package com.stevehuy.scrabble;

import com.stevehuy.dictionary.HashDictionary;
import com.stevehuy.dictionary.HybridDictionary;
import com.stevehuy.dictionary.PrefixDictionary;
import com.stevehuy.scrabble.solver.PermutationScrabbleSolver;
import com.stevehuy.scrabble.solver.PrefixScrabbleSolver;
import com.stevehuy.scrabble.solver.board.ScrabbleRack;
import com.stevehuy.scrabble.solver.board.ScrabbleRackFactory;

public class Profiler {

	public static final int SAMPLES = 100;
	
	public static void main(String[] args) {
		
		
		System.out.println("Prefix dictionary with " + SAMPLES + " samples, prefix solver");
		PrefixDictionary prefixDictionary = new PrefixDictionary(2);
		long timing = 0;
		
		for (int i = 0; i < SAMPLES; i++) {
			ScrabbleRack rack = ScrabbleRackFactory.randomRack();
			PrefixScrabbleSolver solver = new PrefixScrabbleSolver(rack, prefixDictionary);
			solver.solve();
			timing += solver.getTiming(); 
		}
		System.out.println("Solved " + SAMPLES + " + racks in: " + timing + " msecs");
		System.out.println("Avg: " + (double)timing/SAMPLES);
		System.out.println("Dictionary queried: " + prefixDictionary.getNumberOfQueries());
		System.out.println("Avg: " + prefixDictionary.getNumberOfQueries() / SAMPLES);
		
		
		System.out.println("Hybrid dictionary with " + SAMPLES + " samples, prefix solver");
		HybridDictionary hybridDictionary = new HybridDictionary(2);
		timing = 0;
		
		for (int i = 0; i < SAMPLES; i++) {
			ScrabbleRack rack = ScrabbleRackFactory.randomRack();
			PrefixScrabbleSolver solver = new PrefixScrabbleSolver(rack, hybridDictionary);
			solver.solve();
			timing += solver.getTiming(); 
		}
		System.out.println("Solved " + SAMPLES + " + racks in: " + timing + " msecs");
		System.out.println("Avg: " + (double)timing/SAMPLES);
		System.out.println("Dictionary queried: " + prefixDictionary.getNumberOfQueries());
		System.out.println("Avg: " + hybridDictionary.getNumberOfQueries() / SAMPLES);
		
		System.out.println("Hybrid dictionary with " + SAMPLES + " samples, permutations solver");
		
		HashDictionary hashDictionary = new HashDictionary(2);
		timing = 0;
		long lookups = 0;
		
		for (int i = 0; i < SAMPLES; i++) {
			ScrabbleRack rack = ScrabbleRackFactory.randomRack();
			PermutationScrabbleSolver solver = new PermutationScrabbleSolver(rack, hashDictionary);
			solver.solve();
			timing += solver.getTiming(); 
			lookups += solver.getNumberOfLookups();
		}
		System.out.println("Solved " + SAMPLES + " + racks in: " + timing + " msecs");
		System.out.println("Avg: " + (double)timing/SAMPLES);
		System.out.println("Dictionary queried: " + lookups);
		System.out.println("Avg: " + lookups / SAMPLES);
	}

}
