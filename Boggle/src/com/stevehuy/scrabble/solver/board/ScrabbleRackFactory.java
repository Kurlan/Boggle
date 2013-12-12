package com.stevehuy.scrabble.solver.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ScrabbleRackFactory {
	public static final Integer DEFAULT_SIZE = 7;

	public static ScrabbleRack randomRack() {
		List<ScrabbleTile> tiles = new ArrayList<ScrabbleTile>();
		
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
