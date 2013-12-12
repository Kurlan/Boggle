package com.stevehuy.scrabble.solver.board;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ScrabbleRackFactory {
	public static final Integer DEFAULT_SIZE = 7;

	public static ScrabbleRack randomRack() {
		Set<ScrabbleTile> tiles = new HashSet<ScrabbleTile>();
		
		for (int i = 0; i < DEFAULT_SIZE; i++) {
			tiles.add(getRandomTile());
		}
		ScrabbleRack returnRack = new ScrabbleRack(DEFAULT_SIZE, tiles);
		
		return returnRack;
	}
	
	public static ScrabbleTile getRandomTile() {
		Random generator = new Random();
		int randomInt = generator.nextInt('Z' - 'A' + 1) + 'A';
		char randomChar =  (char)randomInt;
		ScrabbleTile returnTile = new ScrabbleTile(String.valueOf(randomChar));
		return returnTile;
	}
}
