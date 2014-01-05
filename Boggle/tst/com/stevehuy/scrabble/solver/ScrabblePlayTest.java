package com.stevehuy.scrabble.solver;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.stevehuy.dictionary.PrefixDictionary;
import com.stevehuy.scrabble.solver.board.ScrabbleRack;
import com.stevehuy.scrabble.solver.board.ScrabbleTile;

public class ScrabblePlayTest {

	private ScrabblePlay play;
	private Set<ScrabbleTile> tiles;
	private ScrabbleTile a;
	private ScrabbleTile b;
	private ScrabbleTile c;
	
	@Before
	public void setup() {
		a = new ScrabbleTile("A");
		b = new ScrabbleTile("B");
		c = new ScrabbleTile("C");
		tiles = new HashSet<ScrabbleTile>();
		tiles.add(a);
		tiles.add(b);
		tiles.add(c);
		ScrabbleRack rack = new ScrabbleRack(7, tiles);
		play = new ScrabblePlay(rack, new HashSet<ScrabbleTile>(), new PrefixDictionary(2));	
	}
		
	@Test
	public void testUnusedTiles() {
		assertTrue(tiles.containsAll(play.getUnusedTiles()));
		assertEquals(tiles.size(), play.getUnusedTiles().size());
	}
	
	@Test
	public void testUnusedTilesAfterUsingTile() {
		play.addTile(a);
		assertEquals(play.getUnusedTiles().size(), 2);
		assertTrue(play.getUnusedTiles().contains(b));
		assertTrue(play.getUnusedTiles().contains(c));
		assertTrue( !play.getUnusedTiles().contains(a) );
	}
}
