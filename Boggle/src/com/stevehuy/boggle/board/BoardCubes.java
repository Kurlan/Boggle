package com.stevehuy.boggle.board;

import java.util.Collections;
import java.util.List;

public class BoardCubes {
	private final List<String> values;
	
	public BoardCubes(List<String> values) {
		this.values = values;
	}
	
	public String randomValue() {
		Collections.shuffle(values);
		return values.get(0);
	}
}
