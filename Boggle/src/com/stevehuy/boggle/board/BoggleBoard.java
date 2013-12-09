package com.stevehuy.boggle.board;

public class BoggleBoard {
	private final int size;
	private final BoggleTile [][] board;
	
	public BoggleBoard(int size) {
		this.size = size;
		board = new BoggleTile[size][size];
	}
	
	public void set(int col, int row, String letter) {
		board[col][row] = new BoggleTile(new Point(col, row), letter);
	}
	
	public BoggleTile get(int col, int row) {
		return board[col][row];
	}
	
	public int getSize() {
		return this.size;
	}

}
