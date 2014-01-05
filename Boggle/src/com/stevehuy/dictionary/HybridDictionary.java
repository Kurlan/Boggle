package com.stevehuy.dictionary;

public class HybridDictionary implements Dictionary {
	private final PrefixDictionary prefixDictionary;
	private final HashDictionary hashDictionary;
	
	public HybridDictionary(int minWordLength) {
		this.prefixDictionary = new PrefixDictionary(minWordLength);
		this.hashDictionary = new HashDictionary(minWordLength);
	}

	@Override
	public Boolean isWord(String word) {
		return hashDictionary.isWord(word);
	}

	@Override
	public void add(String word) {
		throw new RuntimeException("This dictionary is a composite, no addition needed");
	}
	
	public Boolean isPrefix(String prefix) {
		return prefixDictionary.isPrefix(prefix);
	}

	@Override
	public Long getNumberOfQueries() {
		return prefixDictionary.getNumberOfQueries() + hashDictionary.getNumberOfQueries();
	}
	
	
}
