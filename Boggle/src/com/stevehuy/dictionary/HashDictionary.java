package com.stevehuy.dictionary;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

public class HashDictionary implements Dictionary {

	private final AtomicLong queryCounter;
	private final Set<String> wordSet;
	
	public HashDictionary(int minWordLength) {
		this.queryCounter = new AtomicLong();
		this.wordSet = new HashSet<String>();
		DictionaryUtil.loadDictionary(this, minWordLength);
	}
	
	@Override
	public Boolean isWord(String word) {
		queryCounter.incrementAndGet();
		return this.wordSet.contains(word);
	}

	@Override
	public void add(String word) {
		this.wordSet.add(word);
	}

	@Override
	public Long getNumberOfQueries() {
		return queryCounter.get();
	}

	@Override
	public Boolean isPrefix(String prefix) {
		throw new RuntimeException("Operation not supported");
	}

}
