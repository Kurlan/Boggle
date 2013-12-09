package com.stevehuy.boggle.board;

public class Point {
	public Integer x;
	public Integer y;

	public Point(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object rhs) {
		if (this == rhs) {
			return true;
		}

		if (rhs == null) {
			return false;
		}

		if (getClass() != rhs.getClass()) {
			return false;
		}

		final Point p = (Point) rhs;
		return x.equals(p.x) && y.equals(p.y);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
}
