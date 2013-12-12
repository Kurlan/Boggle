package com.stevehuy.scrabble.solver.board;

public class ScrabbleTile {
	public final String value;
	
	public ScrabbleTile(String value) {
		this.value = value;
	}
	
	public boolean isBlank() {
		if (value == null) {
			return true;
		}
		return false;
	}
	
	public String getValue() {
		return this.value;
	}
}
