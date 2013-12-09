package com.stevehuy.boggle;

import java.util.Set;

import com.stevehuy.boggle.board.BoggleBoard;
import com.stevehuy.boggle.board.BoggleBoardFactory;
import com.stevehuy.dictionary.Dictionary;

public class Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dictionary dictionary = new Dictionary();
		BoggleBoard test = BoggleBoardFactory.getTestBoard();
		Solver solver = new Solver(test, dictionary);
		Set<String> list = solver.getAllUniqueWords();
		Integer i=1;
		for (String s: list) {
			System.out.println("WORD " + i + ": " + s);
			i++;
		}
		
		System.out.println("DONE");
	}

}
