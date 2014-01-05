package com.stevehuy.scrabble.solver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import com.stevehuy.dictionary.HashDictionary;
import com.stevehuy.scrabble.solver.board.ScrabbleRack;
import com.stevehuy.scrabble.solver.board.ScrabbleRackFactory;
import com.stevehuy.scrabble.solver.board.ScrabbleTile;

public class PermutationScrabbleSolver implements ScrabbleSolver {

	private final ScrabbleRack scrabbleRack;
	private final HashDictionary dictionary;
	private final AtomicLong numberOfLookups;
	
	public PermutationScrabbleSolver(ScrabbleRack scrabbleRack, HashDictionary dictionary) {
		this.scrabbleRack = scrabbleRack;
		this.dictionary = dictionary;
		numberOfLookups = new AtomicLong();
	}

	private long startTime;
	private long endTime;
	
	@Override
	public List<String> solve() {
		startTimer();
		Set<String> returnSet = new HashSet<String>();
		
		Set<String> permutiations = generatePermutations();
		
		for (String p : permutiations) {
			String sortedWord = dictionary.sortWord(p);
			numberOfLookups.incrementAndGet();
			if (dictionary.hasSortedWordKey(sortedWord)) {
				returnSet.addAll(dictionary.getSortedWordList(sortedWord));
			}
		}
		endTimer();
		return new ArrayList<String>(returnSet);
	}

	private Set<String> generatePermutations() {
		Set<ScrabbleTile> tiles = scrabbleRack.getTiles();
		List<String> letters = new ArrayList<String>();
		Set<String> permutations = new HashSet<String>();
		int numBlank = 0;
		for (ScrabbleTile t:  tiles) {
			if (t.isBlank()) {
				numBlank++;
			} else {
				letters.add(t.getValue());
			}
		}
		
		if (numBlank == 0) {
			for (int i = 1 ; i <  (int) Math.pow(2, letters.size()); i++ ) {
				String p = getPermutation(i, letters);
				if (p.length() > 1) {
					permutations.add(p);
				}
			}
		}
		else if (numBlank == 1) {
			for (int i = 1 ; i <  (int) Math.pow(2, letters.size()); i++ ) {
				String p = getPermutation(i, letters);
				if (p.length() > 1) {
					permutations.add(p);

				}
				if (p.length() > 0) {
					for (String s: ScrabbleRackFactory.getAllCharacters()) {
						permutations.add(p + s);
					}
				}
			}
			
		} else if (numBlank == 2) {
			for (int i = 0 ; i <  (int) Math.pow(2, letters.size()); i++ ) {
				String p = getPermutation(i, letters);
				if (p.length() > 1) {
					permutations.add(p);

				}
				if (p.length() > 0) {
					for (String s: ScrabbleRackFactory.getAllCharacters()) {
						permutations.add(p + s);
					}
				}
				for (String blank1: ScrabbleRackFactory.getAllCharacters()) {
					for (String blank2: ScrabbleRackFactory.getAllCharacters()) {
						permutations.add(p + blank1 + blank2);
					}
				}
			}
		}
		
		return permutations;
	}

	private String getPermutation(int i, List<String> letters) {
		int mask = 1;
		int index = 0;
		StringBuilder returnString = new StringBuilder();
		while (i != 0) {
			if ((i & mask) == 1) {
				returnString.append(letters.get(index));
			}
			index++;
			i = i >> 1;
		}
		return returnString.toString();
	}

	@Override
	public long getTiming() {
		return endTime - startTime;
	}

	public void startTimer() {
		startTime = System.currentTimeMillis();
	}

	public void endTimer() {
		endTime = System.currentTimeMillis();
	}

	@Override
	public long getNumberOfLookups() {
		return numberOfLookups.get();
	}
}
