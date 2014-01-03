package com.stevehuy.scrabble.solver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.stevehuy.dictionary.Dictionary;
import com.stevehuy.scrabble.solver.board.ScrabbleRack;
import com.stevehuy.scrabble.solver.board.ScrabbleTile;

public class ScrabbleSolver {

	public final ScrabbleRack scrabbleRack;
	private final Dictionary dictionary;

	public ScrabbleSolver(ScrabbleRack scrabbleRack, Dictionary dictionary) {
		this.dictionary = dictionary;
		this.scrabbleRack = scrabbleRack;
	}

	public List<ScrabblePlay> solve() {
		List<ScrabblePlay> solutions = new ArrayList<ScrabblePlay>();
		LinkedList<ScrabblePlay> workQueue = new LinkedList<ScrabblePlay>();
		workQueue = initializePlays();
		while (workQueue.peek() != null) {
			ScrabblePlay play = workQueue.poll();
			Set<ScrabbleTile> nextTiles = play.getUnusedTiles();
			
			for (ScrabbleTile tile : nextTiles) {
				ScrabblePlay newPlay = new ScrabblePlay(play);
				newPlay.addTile(tile);
				if (newPlay.isValidWord()) {
					solutions.add(newPlay);
				}
				if (newPlay.isValidPrefix()) {
					workQueue.offer(newPlay);
				}
			}
		}

		return solutions;
	}

	private LinkedList<ScrabblePlay> initializePlays() {
		LinkedList<ScrabblePlay> returnList = new LinkedList<ScrabblePlay>();
		for (ScrabbleTile tile : scrabbleRack.getTiles()) {
			ScrabblePlay play = new ScrabblePlay(scrabbleRack,
					new HashSet<ScrabbleTile>(), dictionary);
			play.addTile(tile);
			returnList.add(play);
		}

		return returnList;
	}
}
