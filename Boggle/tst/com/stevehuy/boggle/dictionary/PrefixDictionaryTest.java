package com.stevehuy.boggle.dictionary;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.stevehuy.dictionary.PrefixDictionary;

public class PrefixDictionaryTest {
	PrefixDictionary dictionary;

	@Before
	public void setup() {
		dictionary = new PrefixDictionary(3);
	}

	@Test
	public void testEmptyWordIsNotWord() {
		assertTrue(dictionary.isWord("") == false);
	}

	@Test
	public void testWordExists() {
		String testWord = "FOOFOOFOO";
		dictionary.add(testWord);
		assertTrue(dictionary.isWord(testWord));
	}

	@Test
	public void testWordAndSubWord() {
		String testWord1 = "FOOFOOFOO";
		String testWord2 = "FOO";
		dictionary.add(testWord1);
		dictionary.add(testWord2);
		assertTrue(dictionary.isWord(testWord1));
		assertTrue(dictionary.isWord(testWord2));
	}

	@Test
	public void testSubWordAndWord() {
		String testWord1 = "FOO";
		String testWord2 = "FOOFOOFOO";
		dictionary.add(testWord1);
		dictionary.add(testWord2);
		assertTrue(dictionary.isWord(testWord1));
		assertTrue(dictionary.isWord(testWord2));
	}

	@Test
	public void testWordIsPrefix() {
		String testWord = "FOOFOOFOO";
		dictionary.add(testWord);
		assertTrue(dictionary.isPrefix(testWord));
	}

	@Test
	public void testReentry() {
		String testWord = "REENTRY";
		assertTrue(dictionary.isPrefix("RE"));
		assertTrue(dictionary.isPrefix(testWord));
		assertTrue(dictionary.isWord(testWord));
	}

	@Test
	public void testCatPrefix() {
		String testWord = "CAT";
		List<String> testWords = dictionary.find(testWord);
		assertTrue(dictionary.isPrefix(testWord));
		assertTrue(dictionary.isWord(testWord));
		assertTrue(testWords.size() > 0);
	}
}
