package com.stevehuy.scrabble.solver.board;

import java.util.Set;

public class ScrabbleRack {
	public final int size;
	public final Set<ScrabbleTile> tiles;
	
	
	public ScrabbleRack(int size, Set<ScrabbleTile> tiles) {
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
	
	public Set<ScrabbleTile> getTiles() {
		return tiles;
	}
}
