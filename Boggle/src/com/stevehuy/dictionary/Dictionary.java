package com.stevehuy.dictionary;

public interface Dictionary {

	public Boolean isWord(String word);
	public void add(String word);
	public Boolean isPrefix(String prefix);
	
	public Long getNumberOfQueries();
}
