package com.stevehuy.boggle.solver;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.*;

import com.stevehuy.boggle.board.BoggleBoard;
import com.stevehuy.boggle.board.BoggleBoardFactory;
import com.stevehuy.boggle.solver.Solver;
import com.stevehuy.dictionary.PrefixDictionary;

public class SolverTest {

	private Solver solver;
	private BoggleBoard board;

	@Before
	public void setup() {
		board = BoggleBoardFactory.getTestBoard();
		solver = new Solver(board, new PrefixDictionary(3));
	}

	@Test
	public void testInitializer() {
		List<BogglePlay> plays = solver.initializeSolutions();
		assertTrue(plays.size() == board.getSize() * board.getSize());
	}

}
