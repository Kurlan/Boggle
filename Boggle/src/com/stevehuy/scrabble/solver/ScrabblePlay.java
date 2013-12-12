package com.stevehuy.scrabble.solver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.stevehuy.scrabble.solver.board.ScrabbleRack;
import com.stevehuy.scrabble.solver.board.ScrabbleTile;

public class ScrabblePlay {
	public final ScrabbleRack scrabbleRack;
	public final Set<ScrabbleTile> usedTiles;
	
	public final List<String> play;
	
	public ScrabblePlay(ScrabbleRack scrabbleRack, Set<ScrabbleTile> usedTiles) {
		this.scrabbleRack = scrabbleRack;
		this.usedTiles = usedTiles;
		this.play = new ArrayList<String>();
	}
}
