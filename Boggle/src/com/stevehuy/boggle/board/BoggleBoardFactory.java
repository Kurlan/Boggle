package com.stevehuy.boggle.board;

public class BoggleBoardFactory {
	public static BoggleBoard getTestBoard() {
		BoggleBoard board = new BoggleBoard(4);
		board.set(0,0,"S");
		board.set(0,1,"E");
		board.set(0,2,"O");
		board.set(0,3,"R");
		board.set(1,0,"W");
		board.set(1,1,"N");
		board.set(1,2,"Y");
		board.set(1,3,"E");
		board.set(2,0,"T");
		board.set(2,1,"R");
		board.set(2,2,"E");
		board.set(2,3,"M");
		board.set(3,0,"T");
		board.set(3,1,"N");
		board.set(3,2,"T");
		board.set(3,3,"E");
		return board;
	}
}
