package com.stevehuy.scrabble.solver.board;

public class ScrabbleTile {
	public final String value;
	public Boolean isBlank;
	
	public ScrabbleTile(String value) {
		this.value = value;
	}
	
	public ScrabbleTile(String value, Boolean isBlank) {
		this.value = value;
		this.isBlank = isBlank;
	}
	
	
	public boolean isBlank() {
		if (value.equals("*")) {
			return true;
		}
		return Boolean.TRUE.equals(isBlank);
	}
	
	public String getValue() {
		return this.value;
	}
}
