package com.stevehuy.boggle;

import java.util.Set;

public class Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dictionary dictionary = new Dictionary();
		BoggleBoard test = new BoggleBoard();
		test.testBoardSetUp();
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
