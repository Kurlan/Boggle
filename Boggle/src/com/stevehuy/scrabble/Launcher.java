package com.stevehuy.scrabble;

import java.util.List;

import com.stevehuy.dictionary.HashDictionary;
import com.stevehuy.dictionary.HybridDictionary;
import com.stevehuy.dictionary.PrefixDictionary;
import com.stevehuy.scrabble.solver.PermutationScrabbleSolver;
import com.stevehuy.scrabble.solver.PrefixScrabbleSolver;
import com.stevehuy.scrabble.solver.board.ScrabbleRack;
import com.stevehuy.scrabble.solver.board.ScrabbleRackFactory;

public class Launcher {

	public static void main(String[] args) {
		ScrabbleRack rack = ScrabbleRackFactory.randomRackWithTwoWildCard();
		System.out.println(rack);
		System.out.println("-----");
		PrefixScrabbleSolver prefixSolver = new PrefixScrabbleSolver(rack, new HybridDictionary(2));
		PermutationScrabbleSolver permutationsSolver = new PermutationScrabbleSolver(rack, new HashDictionary(2));
		List<String> prefixSolutions = prefixSolver.solve();
		List<String> permutationsSolutions = permutationsSolver.solve();
		
		
		System.out.println("# of prefix solutions: " + prefixSolutions.size());
		System.out.println("# of lookups: " + prefixSolver.getNumberOfLookups());
		System.out.println("Time: " + prefixSolver.getTiming());
		System.out.println("# of permutation solutions: " + permutationsSolutions.size());
		System.out.println("# of lookups: " + permutationsSolver.getNumberOfLookups());
		System.out.println("Time: " + permutationsSolver.getTiming());
		
	}

}
