package com.stevehuy.boggle.solver;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.stevehuy.boggle.board.BoggleBoard;
import com.stevehuy.boggle.board.BoggleTile;
import com.stevehuy.dictionary.Dictionary;

public class Solver {
	private final BoggleBoard board;
	private final Dictionary dictionary;

	public Solver(BoggleBoard board, Dictionary dictionary) {
		this.board = board;
		this.dictionary = dictionary;
	}

	// Returns a list of plays initialized to the starting tile.
	public LinkedList<BogglePlay> initializeSolutions() {
		LinkedList<BogglePlay> solutions = new LinkedList<BogglePlay>();
		for (BoggleTile tile : board.getAllTiles()) {
			BogglePlay play = new BogglePlay(board, dictionary);
			play.addBoggleTile(tile);
			solutions.add(play);
		}

		return solutions;
	}

	public List<BogglePlay> solve() {
		LinkedList<BogglePlay> workQueue = initializeSolutions();
		List<BogglePlay> solutions = new LinkedList<BogglePlay>();

		while (workQueue.peek() != null) {
			
			BogglePlay play = workQueue.poll();
			Set<BoggleTile> neighbors = board.getNeighbors(play.getLast());
			Set<BoggleTile> tilesToCheck = play.removeVisited(neighbors);
			for (BoggleTile tile : tilesToCheck) {
				BogglePlay newPlay = new BogglePlay(play);
				newPlay.addBoggleTile(tile);
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
}
