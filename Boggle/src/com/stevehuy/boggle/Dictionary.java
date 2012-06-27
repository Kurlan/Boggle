package com.stevehuy.boggle;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Dictionary extends PrefixTreeNode {
	private static String DICTIONARY_FILE_PATH = "/Users/steve/dictionary";
	private static Integer MIN_WORD_LENGTH = 3;
	
	public Dictionary() {
		super(null, false);
		try{
			
			System.out.println("Loading dictionary");
			FileInputStream fstream = new FileInputStream(DICTIONARY_FILE_PATH);
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			//Read File Line By Line
			while ((strLine = br.readLine()) != null)   {
				if (strLine.length() >= MIN_WORD_LENGTH) {
					add(strLine);
				}
			}
			//Close the input stream
			in.close();
			} catch (Exception e){//Catch exception if any
				System.err.println("Error: " + e.getMessage());
			}
	}
	
	public Boolean isWord(String word) {
		if (word == null || word.equals("")) {
			return false;
		}
		PrefixTreeNode finder = children.get(word.substring(0, 1));
		int i = 1;
		
		while (i < word.length()) {
			finder = finder.children.get(word.substring(i, i+1));
			if (finder == null) {
				return false;
			}
			i++;
		}
		return finder.terminates;
	}
	
	public Boolean isPrefix(String prefix) {
		PrefixTreeNode finder = children.get(prefix.substring(0, 1));
		int i = 1;
		
		while (i < prefix.length()) {
			finder = finder.children.get(prefix.substring(i, i+1));
			if (finder == null) {
				return false;
			}
			i++;
		}
		return true;
	}
	
	public List<String> find(String prefix) {
		List<String> returnList = new ArrayList<String>();
		PrefixTreeNode finder = children.get(prefix.substring(0, 1));
		int i = 1;
		
		while (i < prefix.length()) {
			finder = finder.children.get(prefix.substring(i, i+1));
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
