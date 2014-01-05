package com.stevehuy.dictionary;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class DictionaryUtil {
	private static String DICTIONARY_FILE_PATH = "data/dictionary";
	
	public static void loadDictionary(Dictionary dictionary, int minWordLength) {
		try {
			FileInputStream fstream = new FileInputStream(DICTIONARY_FILE_PATH);
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				if (strLine.length() >= minWordLength) {
					dictionary.add(strLine);
				}
			}
			// Close the input stream
			in.close();
		} catch (IOException e) {
			throw new RuntimeException("Cannot load dictionary");
		}
	}
}
