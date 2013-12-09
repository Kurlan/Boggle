package com.stevehuy.boggle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.stevehuy.boggle.board.BoggleBoard;
import com.stevehuy.boggle.board.Point;


//  Represents a potential play in boggle
public class BogglePlay {

	BoggleBoard board;
	LinkedList<Point> played;
	public BogglePlay(BoggleBoard board) {
		played = new LinkedList<Point>();
		this.board = board;
	}
	
	public List<BogglePlay> possiblePlays() {
		List<BogglePlay> possiblePlays = new ArrayList<BogglePlay>();
		if (played.size() == 0) {
			for (Integer i = 0; i < board.getSize(); i++) {
				for (Integer j = 0; j < board.getSize(); j++) {
					BogglePlay play = new BogglePlay(this.board);
					Point p = new Point(i, j);
					play.played.offer(p);
					possiblePlays.add(play);
				}
			}
			return possiblePlays;
		}
		Point last = played.get(played.size()-1);

		List<Point> possibleNext = possibleNextTiles(last, played);
		
		for (Point p: possibleNext) {
			BogglePlay play = new BogglePlay(this.board);
			play.played.addAll(this.played);
			play.played.offer(p);
			possiblePlays.add(play);
		}
		return possiblePlays;
	}

	
	protected List<Point> possibleNextTiles(Point last, List<Point> taken) {
		List<Point> returnList = new LinkedList<Point>();
		Integer size = board.getSize();
		Boolean[][] tempBoard = new Boolean[size][size];
		
		for (int i = 0; i < size;i++) {
			for (int j = 0; j < size;j++) {
				tempBoard[i][j] = true;
			}
		}
		for (Point p:taken) {
			tempBoard[p.x][p.y] = false;
		}
		Integer x = last.x;
		Integer y = last.y;
		
		if (x - 1 > 0 && tempBoard[x-1][y]) {
			returnList.add(new Point(x-1,y));
		}
		if (y - 1 > 0 && tempBoard[x][y-1]) {
			returnList.add(new Point(x,y-1));
		}
		if (x + 1 < size && tempBoard[x+1][y]) {
			returnList.add(new Point(x+1,y));
		}
		if (y + 1 < size && tempBoard[x][y+1]) {
			returnList.add(new Point(x,y+1));
		}
		if (x - 1 > 0 && y - 1 > 0 && tempBoard[x-1][y-1]) {
			returnList.add(new Point(x-1,y-1));
		}
		if (x - 1 > 0 && y + 1 < size && tempBoard[x-1][y+1]) {
			returnList.add(new Point(x-1,y+1));
		}
		if (x + 1 < size && y + 1 < size && tempBoard[x+1][y+1]) {
			returnList.add(new Point(x+1,y+1));
		}
		if (x + 1 < size && y - 1 > 0  && tempBoard[x+1][y-1]) {
			returnList.add(new Point(x+1,y-1));
		}
		
		return returnList;
	}
	
	public String getPlay() {
		StringBuilder b = new StringBuilder();
		for (Point p: played) {
			b.append(board.get(p.x, p.y));
		}
		
		return b.toString();
	}
}
