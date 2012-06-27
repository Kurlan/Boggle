package com.stevehuy.boggle;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solver {
	BoggleBoard board;
	Dictionary dictionary;
	
	public Solver(BoggleBoard board, Dictionary dictionary) {
		this.board = board;
		this.dictionary = dictionary;
	}
	
	public Set<String>getAllUniqueWords() {
		return new HashSet<String>(getAllPlays());
	}
	
	public List<String> getAllPlays() {
		List<String> words = new LinkedList<String>();
		BogglePlay play = new BogglePlay(board);
		List<BogglePlay> plays = play.possiblePlays();
		LinkedList<BogglePlay> playQueue = new LinkedList<BogglePlay>(plays);
		while (playQueue.peek() != null) {
			BogglePlay bp = playQueue.poll();
			String word = bp.getPlay();
			if (word.equals("RE")) {
				System.out.println("TESTING: " + word);
			}
			if (dictionary.isPrefix(word)) {
				playQueue.addAll(bp.possiblePlays());
			}
			if (dictionary.isWord(word)) {
				words.add(word);
			}
		}
		return words;
	}
}
