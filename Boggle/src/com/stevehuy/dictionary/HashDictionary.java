package com.stevehuy.dictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

public class HashDictionary implements Dictionary {

	private final AtomicLong queryCounter;
	private final Set<String> wordSet;
	private final Map<String, List<String>> index;
	
	public HashDictionary(int minWordLength) {
		this.queryCounter = new AtomicLong();
		this.wordSet = new HashSet<String>();
		this.index = new HashMap<String, List<String>>();
		DictionaryUtil.loadDictionary(this, minWordLength);
		createIndex();
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

	public Set<String> getWords() {
		return wordSet;
	}
	
	private void createIndex() {
		for (String word: getWords()) {
			String sortedWord = sortWord(word);
			if (!index.containsKey(sortedWord)) {
				index.put(sortedWord, new ArrayList<String>());
			}
			index.get(sortedWord).add(word);
		}
	}
	
	public boolean hasSortedWordKey(String sortedWordKey) {
		return index.containsKey(sortedWordKey);
	}
	
	public List<String> getSortedWordList(String sortedWordKey) {
		return index.get(sortedWordKey);
	}

	public String sortWord(String word) {
		char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
	}
}
