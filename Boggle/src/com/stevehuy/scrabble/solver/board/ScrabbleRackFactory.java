package com.stevehuy.scrabble.solver.board;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class ScrabbleRackFactory {
	public static final Integer DEFAULT_SIZE = 7;
	public static final Map<String, Integer> tileDistribution;
	
	static {
		tileDistribution = new HashMap<String, Integer>();
		tileDistribution.put("E", 12);
		tileDistribution.put("A", 9);
		tileDistribution.put("I", 9);
		tileDistribution.put("O", 8);
		tileDistribution.put("N", 6);
		tileDistribution.put("R", 6);
		tileDistribution.put("T", 6);
		tileDistribution.put("L", 4);
		tileDistribution.put("S", 4);
		tileDistribution.put("U", 4);
		tileDistribution.put("D", 4);
		tileDistribution.put("G", 3);
		
		tileDistribution.put("B", 2);
		tileDistribution.put("C", 2);
		tileDistribution.put("M", 2);
		tileDistribution.put("P", 2);
		tileDistribution.put("F", 2);
		tileDistribution.put("H", 2);
		tileDistribution.put("V", 2);
		tileDistribution.put("W", 2);
		tileDistribution.put("Y", 2);
		
		tileDistribution.put("K", 1);
		tileDistribution.put("J", 1);
		tileDistribution.put("X", 1);
		tileDistribution.put("Q", 1);
		tileDistribution.put("Z", 1);
	}

	public static synchronized ScrabbleRack randomRack() {
		Set<ScrabbleTile> tiles = new HashSet<ScrabbleTile>();
		LinkedList<ScrabbleTile> bag = new LinkedList<ScrabbleTile>(getTileBag());
		
		Random random = new Random();
		
		for (int i = 0; i < DEFAULT_SIZE; i++) {
			int index = random.nextInt(bag.size()); 
			tiles.add(bag.get(index));
			bag.remove(index);
		}
		ScrabbleRack returnRack = new ScrabbleRack(DEFAULT_SIZE, tiles);
		
		return returnRack;
	}
	
	private static Set<ScrabbleTile> getTileBag() {
		Set<ScrabbleTile >tileBag = new HashSet<ScrabbleTile>();
		
		for (Entry<String, Integer> keyValue : tileDistribution.entrySet()) {
			for (int i = 0; i < keyValue.getValue(); i++ ) {
				tileBag.add(new ScrabbleTile(keyValue.getKey()));
			}
		}
		
		assert(tileBag.size() == 98);
		return tileBag;
	}
}
