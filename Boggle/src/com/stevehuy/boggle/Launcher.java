package com.stevehuy.boggle;

import java.util.List;

import com.stevehuy.boggle.board.BoggleBoard;
import com.stevehuy.boggle.board.BoggleBoardFactory;
import com.stevehuy.boggle.solver.BogglePlay;
import com.stevehuy.boggle.solver.Solver;
import com.stevehuy.dictionary.PrefixDictionary;

public class Launcher {

	// Uses a test board and prints out solutions
	public static void main(String[] args) {
		PrefixDictionary dictionary = new PrefixDictionary(3);
		BoggleBoard board = BoggleBoardFactory.getRandomBoard();
		Solver solver = new Solver(board, dictionary);
		List<BogglePlay> plays = solver.solve();

		for (BogglePlay play : plays) {
			System.out.println(play);
		}
		System.out.println("Board solved in: " + solver.getTiming() + " msecs");
		board.print();
	}

}
