package com.stevehuy.scrabble.solver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import com.stevehuy.scrabble.solver.board.ScrabbleRack;
import com.stevehuy.scrabble.solver.board.ScrabbleTile;

public class ScrabbleSolver {

	public final ScrabbleRack scrabbleRack;
	
	public ScrabbleSolver(ScrabbleRack scrabbleRack) {
		this.scrabbleRack = scrabbleRack;
	}
	
	public List<ScrabblePlay> solve() {
		List<ScrabblePlay> solutions = new ArrayList<ScrabblePlay>();		
		LinkedList<ScrabblePlay> workQueue = new LinkedList<ScrabblePlay>();
		
		workQueue = initializePlays();
		
		while(workQueue.peek() != null) {
			
		}
		
		return solutions;
	}
	
	private LinkedList<ScrabblePlay> initializePlays() {
		LinkedList<ScrabblePlay>returnList = new LinkedList<ScrabblePlay>();
		for (ScrabbleTile tile : scrabbleRack.getTiles()) {
			ScrabblePlay play = new ScrabblePlay(scrabbleRack, new HashSet<ScrabbleTile>());
			play.addTile(tile);
			returnList.add(play);
		}
		
		return returnList;
	}
}
