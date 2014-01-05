package com.stevehuy.dictionary;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class PrefixDictionary implements Dictionary {

	private final PrefixTreeNode root;
	private final AtomicLong queryCounter;
	
	public PrefixDictionary(int minWordLength) {
		this.root = new PrefixTreeNode(null, false);
		this.queryCounter = new AtomicLong();
		DictionaryUtil.loadDictionary(this, minWordLength);
	}

	@Override
	public Boolean isWord(String word) {
		queryCounter.incrementAndGet();
		if (word == null || word.equals("")) {
			return false;
		}
		PrefixTreeNode finder = root.children.get(word.substring(0, 1));
		int i = 1;

		while (i < word.length()) {
			finder = finder.children.get(word.substring(i, i + 1));
			if (finder == null) {
				return false;
			}
			i++;
		}
		return finder.terminates;
	}

	public Boolean isPrefix(String prefix) {
		queryCounter.incrementAndGet();
		PrefixTreeNode finder = root.children.get(prefix.substring(0, 1));
		int i = 1;

		while (i < prefix.length()) {
			finder = finder.children.get(prefix.substring(i, i + 1));
			if (finder == null) {
				return false;
			}
			i++;
		}
		return true;
	}

	@Override
	public void add(String word) {
		root.add(word);	
	}

	public List<String> find(String prefix) {
		return root.find(prefix);
	}

	@Override
	public Long getNumberOfQueries() {
		return queryCounter.get();
	}
}
