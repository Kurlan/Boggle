package com.stevehuy.boggle.board;

import java.util.HashSet;
import java.util.Set;

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
	
	public boolean isInBounds(int col, int row) {
		if (col < 0 || row < 0 || col > size - 1 || row > size - 1) {
			return false;
		}
		
		return true;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public Set<BoggleTile> getNeighbors(int col, int row) {
		return getNeighbors(get(col, row));
	}
	
	public Set<BoggleTile> getNeighbors(BoggleTile tile) {
		Set<BoggleTile> returnSet = new HashSet<BoggleTile>();
		int initialCol = tile.getLocation().x;
		int initialRow = tile.getLocation().y;
		for (int i = initialCol - 1 ; i < initialCol + 2; i++) {
			for (int j = initialRow - 1; j < initialRow + 2; j++) {
				if (i == initialCol && j == initialRow) {
					continue;
				}
				if (isInBounds(i, j)) {
					returnSet.add(board[i][j]);
				}
			}
		}
		
		return returnSet;
	}

}
