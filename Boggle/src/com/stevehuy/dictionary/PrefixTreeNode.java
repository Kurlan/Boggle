package com.stevehuy.dictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrefixTreeNode {
	protected final Map<String, PrefixTreeNode> children;
	protected final String keyValue;
	protected Boolean terminates;

	public PrefixTreeNode(String keyValue, Boolean terminates) {
		this.keyValue = keyValue;
		this.terminates = terminates;
		this.children = new HashMap<String, PrefixTreeNode>();
	}

	public void add(String word) {
		String firstLetter = null;
		Map<String, PrefixTreeNode> finder = children;
		for (int i = 0; i < word.length(); i++) {
			firstLetter = word.substring(i, i + 1);
			Boolean terminates = i == word.length() - 1;
			if (finder.containsKey(firstLetter)) {
				if (terminates) {
					finder.get(firstLetter).terminates = terminates;
				}
			} else {
				finder.put(firstLetter, new PrefixTreeNode(firstLetter,
						terminates));
			}

			finder = finder.get(firstLetter).children;
		}

	}

	public List<String> allSuffixes() {
		List<String> returnList = new ArrayList<String>();
		if (terminates) {
			returnList.add(keyValue);
		}

		for (String n : children.keySet()) {
			for (String c : children.get(n).allSuffixes()) {
				returnList.add(keyValue + c);
			}
		}

		return returnList;
	}
	

	public List<String> find(String prefix) {
		List<String> returnList = new ArrayList<String>();
		PrefixTreeNode finder = children.get(prefix.substring(0, 1));
		int i = 1;

		while (i < prefix.length()) {
			finder = finder.children.get(prefix.substring(i, i + 1));
			if (finder == null) {
				return returnList;
			}
			i++;
		}

		for (String key : finder.children.keySet()) {
			List<String> tempList = finder.children.get(key).allSuffixes();
			for (String t : tempList) {
				returnList.add(prefix + t);
			}
		}

		return returnList;
	}
}
