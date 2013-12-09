package com.stevehuy.boggle.solver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.stevehuy.boggle.board.BoggleBoard;
import com.stevehuy.boggle.board.BoggleTile;
import com.stevehuy.dictionary.Dictionary;

//  Represents a potential play in boggle
public class BogglePlay {

	private final BoggleBoard board;
	private final Dictionary dictionary;
	private final Set<BoggleTile> visited;
	private final List<BoggleTile> played;

	public BogglePlay(BoggleBoard board, Dictionary dictionary) {
		this.board = board;
		this.dictionary = dictionary;
		this.visited = new HashSet<BoggleTile>();
		this.played = new ArrayList<BoggleTile>();
	}

	public BogglePlay(BogglePlay clone) {
		this.board = clone.board;
		this.dictionary = clone.dictionary;
		this.visited = new HashSet<BoggleTile>(clone.visited);
		this.played = new ArrayList<BoggleTile>(clone.played);
	}

	@Override
	public String toString() {
		StringBuilder returnString = new StringBuilder();
		for (BoggleTile t : played) {
			returnString.append(t.getValue());
		}
		return returnString.toString();
	}

	public void addBoggleTile(BoggleTile tile) {
		played.add(tile);
		visited.add(tile);
	}

	public BoggleTile getLast() {
		return played.get(played.size() - 1);
	}

	public Set<BoggleTile> removeVisited(Set<BoggleTile> neighbors) {
		Set<BoggleTile> notVisited = new HashSet<BoggleTile>(neighbors);
		notVisited.removeAll(visited);
		return notVisited;
	}

	public boolean isValidWord() {
		return dictionary.isWord(toString());
	}

	public boolean isValidPrefix() {
		return dictionary.isPrefix(toString());
	}

}
