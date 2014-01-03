package com.stevehuy.scrabble.solver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.stevehuy.dictionary.Dictionary;
import com.stevehuy.scrabble.solver.board.ScrabbleRack;
import com.stevehuy.scrabble.solver.board.ScrabbleTile;

public class ScrabblePlay {
	public final ScrabbleRack scrabbleRack;
	public final Set<ScrabbleTile> usedTiles;
	private final Dictionary dictionary;
	
	public final List<ScrabbleTile> play;
	
	public ScrabblePlay(ScrabbleRack scrabbleRack, Set<ScrabbleTile> usedTiles, Dictionary dictionary) {
		this.scrabbleRack = scrabbleRack;
		this.usedTiles = usedTiles;
		this.dictionary = dictionary;
		this.play = new ArrayList<ScrabbleTile>();
	}
	
	public ScrabblePlay(ScrabblePlay copy) {
		this.scrabbleRack = copy.scrabbleRack;
		this.usedTiles = new HashSet<ScrabbleTile>(copy.usedTiles);
		this.dictionary = copy.dictionary;
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
	
	public String toPrettyString() {
		StringBuilder builder = new StringBuilder();
		for (ScrabbleTile tile : play) {
			if (tile.isBlank()) {
				builder.append(tile.getValue().toLowerCase());
			} else {
				builder.append(tile.getValue());
			}
		}
		return builder.toString();
	}
	
	public void addTile(ScrabbleTile tile) {
		play.add(tile);
		usedTiles.add(tile);
	}
	
	public void addBlankTile(String value, ScrabbleTile tile) {
		play.add(new ScrabbleTile(value, true));
		usedTiles.add(tile);
	}
	
	public Set<ScrabbleTile> getUnusedTiles() {
		Set<ScrabbleTile> returnTiles = new HashSet<ScrabbleTile>(scrabbleRack.getTiles());
		returnTiles.removeAll(usedTiles);
		return returnTiles;
	}
	
	public boolean isValidWord() {
		return dictionary.isWord(toString());
	}
	
	public boolean isValidPrefix() {
		return dictionary.isPrefix(toString());
	}
	
}
