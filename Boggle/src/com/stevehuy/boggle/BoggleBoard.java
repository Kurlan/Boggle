package com.stevehuy.boggle;

public class BoggleBoard {
	public static final Integer SIZE = 4;
	String [][] board = new String[SIZE][SIZE];
	
	public void set(int col, int row, String letter) {
		board[col][row] = letter;
	}
	
	public String get(int col, int row) {
		if (col < 0 || row < 0 || col >= SIZE || row >= SIZE) {
			return null;
		}
		return board[col][row];
	}
	
	public void testBoardSetUp() {
		set(0,0,"S");
		set(0,1,"E");
		set(0,2,"O");
		set(0,3,"R");
		set(1,0,"W");
		set(1,1,"N");
		set(1,2,"Y");
		set(1,3,"E");
		set(2,0,"T");
		set(2,1,"R");
		set(2,2,"E");
		set(2,3,"M");
		set(3,0,"T");
		set(3,1,"N");
		set(3,2,"T");
		set(3,3,"E");
	}
	
	public BoggleBoard() {


	}
}
