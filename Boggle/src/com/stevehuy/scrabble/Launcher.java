package com.stevehuy.scrabble;

import java.util.List;

import com.stevehuy.dictionary.Dictionary;
import com.stevehuy.scrabble.solver.ScrabblePlay;
import com.stevehuy.scrabble.solver.ScrabbleSolver;
import com.stevehuy.scrabble.solver.board.ScrabbleRack;
import com.stevehuy.scrabble.solver.board.ScrabbleRackFactory;

public class Launcher {

	public static void main(String[] args) {
		ScrabbleRack rack = ScrabbleRackFactory.randomRack();
		System.out.println(rack);
		System.out.println("-----");
		ScrabbleSolver solver = new ScrabbleSolver(rack, new Dictionary());
		List<ScrabblePlay> solutions = solver.solve();
		
		for (ScrabblePlay play: solutions) {
			System.out.println(play);
		}
		System.out.println("-----");
		System.out.println(rack);
	}

}
