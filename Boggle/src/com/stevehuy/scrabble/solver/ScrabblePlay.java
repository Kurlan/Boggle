package com.stevehuy.scrabble.solver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.stevehuy.scrabble.solver.board.ScrabbleRack;
import com.stevehuy.scrabble.solver.board.ScrabbleTile;

public class ScrabblePlay {
	public final ScrabbleRack scrabbleRack;
	public final Set<ScrabbleTile> usedTiles;
	
	public final List<ScrabbleTile> play;
	
	public ScrabblePlay(ScrabbleRack scrabbleRack, Set<ScrabbleTile> usedTiles) {
		this.scrabbleRack = scrabbleRack;
		this.usedTiles = usedTiles;
		this.play = new ArrayList<ScrabbleTile>();
	}
	
	public ScrabblePlay(ScrabblePlay copy) {
		this.scrabbleRack = copy.scrabbleRack;
		this.usedTiles = new HashSet<ScrabbleTile>(copy.usedTiles);
		this.play = new ArrayList<ScrabbleTile>(copy.play);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(); 
		for (ScrabbleTile tile : play) {
			builder.append(tile.getValue());
		}
		
		return builder.toString();
	}
	
	public void addTile(ScrabbleTile tile) {
		play.add(tile);
		usedTiles.add(tile);
	}
}
