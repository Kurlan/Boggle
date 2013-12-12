package com.stevehuy.scrabble.solver.board;

import java.util.List;

public class ScrabbleRack {
	public final int size;
	public final List<ScrabbleTile> tiles;
	
	
	public ScrabbleRack(int size, List<ScrabbleTile> tiles) {
		this.size = size;
		this.tiles = tiles;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (ScrabbleTile tile : tiles) {
			builder.append(tile.getValue());
		}
		return builder.toString();
	}
}
