package com.stevehuy.boggle.board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoggleBoardFactory {
	public static final List<BoardCubes> cubes;

	static {
		cubes = new ArrayList<BoardCubes>();
		cubes.add(new BoardCubes(new ArrayList<String>() {
			{
				add("B");
				add("O");
				add("A");
				add("J");
				add("O");
				add("B");
			}
		}));

		cubes.add(new BoardCubes(new ArrayList<String>() {
			{
				add("E");
				add("N");
				add("S");
				add("I");
				add("E");
				add("U");
			}
		}));
		
		cubes.add(new BoardCubes(new ArrayList<String>() {
			{
				add("V");
				add("T");
				add("H");
				add("R");
				add("W");
				add("E");
			}
		}));
		
		cubes.add(new BoardCubes(new ArrayList<String>() {
			{
				add("T");
				add("R");
				add("E");
				add("T");
				add("L");
				add("Y");
			}
		}));
		
		cubes.add(new BoardCubes(new ArrayList<String>() {
			{
				add("C");
				add("T");
				add("U");
				add("I");
				add("M");
				add("O");
			}
		}));
		
		cubes.add(new BoardCubes(new ArrayList<String>() {
			{
				add("P");
				add("O");
				add("H");
				add("C");
				add("A");
				add("S");
			}
		}));
		
		cubes.add(new BoardCubes(new ArrayList<String>() {
			{
				add("D");
				add("S");
				add("Y");
				add("I");
				add("T");
				add("T");
			}
		}));
		
		cubes.add(new BoardCubes(new ArrayList<String>() {
			{
				add("E");
				add("A");
				add("N");
				add("A");
				add("E");
				add("G");
			}
		}));
		
		cubes.add(new BoardCubes(new ArrayList<String>() {
			{
				add("T");
				add("T");
				add("O");
				add("A");
				add("O");
				add("W");
			}
		}));
		
		cubes.add(new BoardCubes(new ArrayList<String>() {
			{
				add("E");
				add("V");
				add("L");
				add("R");
				add("D");
				add("Y");
			}
		}));
		
		cubes.add(new BoardCubes(new ArrayList<String>() {
			{
				add("E");
				add("I");
				add("T");
				add("S");
				add("S");
				add("O");
			}
		}));
		
		cubes.add(new BoardCubes(new ArrayList<String>() {
			{
				add("H");
				add("W");
				add("E");
				add("G");
				add("N");
				add("E");
			}
		}));
		
		cubes.add(new BoardCubes(new ArrayList<String>() {
			{
				add("P");
				add("K");
				add("A");
				add("F");
				add("F");
				add("S");
			}
		}));
		
		cubes.add(new BoardCubes(new ArrayList<String>() {
			{
				add("R");
				add("N");
				add("Z");
				add("N");
				add("L");
				add("H");
			}
		}));
		
		cubes.add(new BoardCubes(new ArrayList<String>() {
			{
				add("N");
				add("QU");
				add("I");
				add("M");
				add("U");
				add("H");
			}
		}));
		
		cubes.add(new BoardCubes(new ArrayList<String>() {
			{
				add("I");
				add("X");
				add("R");
				add("D");
				add("L");
				add("E");
			}
		}));
	}
	
	public static BoggleBoard getRandomBoard() {
		BoggleBoard board = new BoggleBoard(4);
		Collections.shuffle(cubes);
		board.set(0, 0, cubes.get(0).randomValue());
		board.set(0, 1, cubes.get(1).randomValue());
		board.set(0, 2, cubes.get(2).randomValue());
		board.set(0, 3, cubes.get(3).randomValue());
		board.set(1, 0, cubes.get(4).randomValue());
		board.set(1, 1, cubes.get(5).randomValue());
		board.set(1, 2, cubes.get(6).randomValue());
		board.set(1, 3, cubes.get(7).randomValue());
		board.set(2, 0, cubes.get(8).randomValue());
		board.set(2, 1, cubes.get(9).randomValue());
		board.set(2, 2, cubes.get(10).randomValue());
		board.set(2, 3, cubes.get(11).randomValue());
		board.set(3, 0, cubes.get(12).randomValue());
		board.set(3, 1, cubes.get(13).randomValue());
		board.set(3, 2, cubes.get(14).randomValue());
		board.set(3, 3, cubes.get(15).randomValue());
		return board;
	}

	public static BoggleBoard getTestBoard() {
		BoggleBoard board = new BoggleBoard(4);
		board.set(0, 0, "S");
		board.set(0, 1, "E");
		board.set(0, 2, "O");
		board.set(0, 3, "R");
		board.set(1, 0, "W");
		board.set(1, 1, "N");
		board.set(1, 2, "Y");
		board.set(1, 3, "E");
		board.set(2, 0, "T");
		board.set(2, 1, "R");
		board.set(2, 2, "E");
		board.set(2, 3, "M");
		board.set(3, 0, "T");
		board.set(3, 1, "N");
		board.set(3, 2, "T");
		board.set(3, 3, "E");
		return board;
	}
}
