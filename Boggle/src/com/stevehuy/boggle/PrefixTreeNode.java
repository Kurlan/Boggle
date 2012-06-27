package com.stevehuy.boggle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PrefixTreeNode {
	public HashMap<String, PrefixTreeNode> children;
	protected String keyValue;
	protected Boolean terminates;
	
	public PrefixTreeNode(String keyValue, Boolean terminates) {
		this.keyValue = keyValue;
		this.terminates = terminates;
		children = new HashMap<String, PrefixTreeNode>();
	}
	
	public void add(String word) {
		String firstLetter = null;
		HashMap<String, PrefixTreeNode>finder = children;
		for (int i = 0 ; i < word.length(); i++) {
			firstLetter = word.substring(i, i+1);
			Boolean terminates = i == word.length()-1;
			if (finder.containsKey(firstLetter)) {
				if (terminates) {
					finder.get(firstLetter).terminates = terminates;
				}
			} else {
				finder.put(firstLetter, new PrefixTreeNode(firstLetter, terminates));
			}
			
			finder = finder.get(firstLetter).children;
		}
		
	}
	
	public List<String> allSuffixes() {
		List<String> returnList = new ArrayList<String>();
		if (terminates) {
			returnList.add(keyValue);
		}
		
		for (String n: children.keySet()) {
			for (String c : children.get(n).allSuffixes()) {
				returnList.add(keyValue + c);
			}
		}
		
		return returnList;
	}
}
