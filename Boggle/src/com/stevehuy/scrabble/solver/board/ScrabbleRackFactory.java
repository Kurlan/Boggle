package com.stevehuy.scrabble.solver.board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ScrabbleRackFactory {
	public static final Integer DEFAULT_SIZE = 7;
	public static final Map<String, Integer> tileDistribution;
	private static final String WILD_CARD_CHARACTER = "*";
	
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
		
		tileDistribution.put(WILD_CARD_CHARACTER, 2);
	}

	public static ScrabbleRack randomRack() {
		Set<ScrabbleTile> tiles = new HashSet<ScrabbleTile>();
		ArrayList<ScrabbleTile> bag = new ArrayList<ScrabbleTile>(getTileBag());
		Collections.shuffle(bag);

		for (int i = 0; i < DEFAULT_SIZE; i++) {
			tiles.add(bag.get(i));
		}
		ScrabbleRack returnRack = new ScrabbleRack(DEFAULT_SIZE, tiles);
		
		return returnRack;
	}
	
	public static ScrabbleRack randomRackWithWildCard() {
		Set<ScrabbleTile> tiles = new HashSet<ScrabbleTile>();
		ArrayList<ScrabbleTile> bag = new ArrayList<ScrabbleTile>(getTileBagNoWildCard());
		Collections.shuffle(bag);
		for (int i = 0; i < DEFAULT_SIZE - 1; i++) {
			tiles.add(bag.get(i));
		}
		tiles.add(new ScrabbleTile(WILD_CARD_CHARACTER));
		ScrabbleRack returnRack = new ScrabbleRack(DEFAULT_SIZE, tiles);
		
		return returnRack;
	}
	
	public static ScrabbleRack randomRackWithTwoWildCard() {
		Set<ScrabbleTile> tiles = new HashSet<ScrabbleTile>();
		ArrayList<ScrabbleTile> bag = new ArrayList<ScrabbleTile>(getTileBagNoWildCard());
		Collections.shuffle(bag);
		for (int i = 0; i < DEFAULT_SIZE - 2; i++) {
			tiles.add(bag.get(i));
		}
		tiles.add(new ScrabbleTile(WILD_CARD_CHARACTER));
		tiles.add(new ScrabbleTile(WILD_CARD_CHARACTER));
		ScrabbleRack returnRack = new ScrabbleRack(DEFAULT_SIZE, tiles);
		
		return returnRack;
	}
	
	private static Set<ScrabbleTile> getTileBagNoWildCard() {
		Set<ScrabbleTile >tileBag = new HashSet<ScrabbleTile>();
		
		for (Entry<String, Integer> keyValue : tileDistribution.entrySet()) {
			if (!keyValue.getValue().equals(WILD_CARD_CHARACTER)) {
				for (int i = 0; i < keyValue.getValue(); i++ ) {
					tileBag.add(new ScrabbleTile(keyValue.getKey()));
				}
			}
		}
		
		assert(tileBag.size() == 98);
		return tileBag;
	}
	
	private static Set<ScrabbleTile> getTileBag() {
		Set<ScrabbleTile >tileBag = new HashSet<ScrabbleTile>();
		
		for (Entry<String, Integer> keyValue : tileDistribution.entrySet()) {
			for (int i = 0; i < keyValue.getValue(); i++ ) {
				tileBag.add(new ScrabbleTile(keyValue.getKey()));
			}
		}
		
		assert(tileBag.size() == 100);
		return tileBag;
	}
	
	public static List<String> getAllCharacters() {
		Set<String> allCharacters = tileDistribution.keySet();
		allCharacters.remove(WILD_CARD_CHARACTER);
		return new ArrayList<String>(allCharacters);
	}
}
