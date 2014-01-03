package com.stevehuy.scrabble.solver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.stevehuy.dictionary.Dictionary;
import com.stevehuy.scrabble.solver.board.ScrabbleRack;
import com.stevehuy.scrabble.solver.board.ScrabbleRackFactory;
import com.stevehuy.scrabble.solver.board.ScrabbleTile;

public class ScrabbleSolver {

	public final ScrabbleRack scrabbleRack;
	private final Dictionary dictionary;
	private long startTime;
	private long endTime;

	public ScrabbleSolver(ScrabbleRack scrabbleRack, Dictionary dictionary) {
		this.dictionary = dictionary;
		this.scrabbleRack = scrabbleRack;
	}

	public List<ScrabblePlay> solve() {
		startTimer();
		List<ScrabblePlay> solutions = new ArrayList<ScrabblePlay>();
		LinkedList<ScrabblePlay> workQueue = new LinkedList<ScrabblePlay>();
		workQueue = initializePlays();
		while (workQueue.peek() != null) {
			ScrabblePlay play = workQueue.poll();
			Set<ScrabbleTile> nextTiles = play.getUnusedTiles();
			
			for (ScrabbleTile tile : nextTiles) {
				
				if (tile.isBlank()) {
					for (String s: ScrabbleRackFactory.getAllCharacters()) {
						ScrabblePlay newPlayBlank = new ScrabblePlay(play);
						newPlayBlank.addBlankTile(s, tile);
						if (newPlayBlank.isValidWord()) {
							solutions.add(newPlayBlank);
						}
						if (newPlayBlank.isValidPrefix()) {
							workQueue.offer(newPlayBlank);
						}
					}
				} else {
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
		}
		endTimer();
		return solutions;
	}

	private LinkedList<ScrabblePlay> initializePlays() {
		LinkedList<ScrabblePlay> returnList = new LinkedList<ScrabblePlay>();
		for (ScrabbleTile tile : scrabbleRack.getTiles()) {
			ScrabblePlay play = new ScrabblePlay(scrabbleRack,
					new HashSet<ScrabbleTile>(), dictionary);
			if (tile.isBlank()) {
				for (String s: ScrabbleRackFactory.getAllCharacters()) {
					play.addTile(new ScrabbleTile(s, true));
				}
			} else {
				play.addTile(tile);
			}
			returnList.add(play);
		}

		return returnList;
	}
	

	public void startTimer() {
		startTime = System.currentTimeMillis();
	}

	public void endTimer() {
		endTime = System.currentTimeMillis();
	}

	public long getTiming() {
		return endTime - startTime;
	}
}
