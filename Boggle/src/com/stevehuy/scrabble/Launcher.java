package com.stevehuy.scrabble;

import com.stevehuy.scrabble.solver.board.ScrabbleRack;
import com.stevehuy.scrabble.solver.board.ScrabbleRackFactory;

public class Launcher {

	public static void main(String[] args) {
		ScrabbleRack rack = ScrabbleRackFactory.randomRack();
		
		
		
		System.out.println(rack);
	}

}
