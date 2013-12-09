package com.stevehuy.boggle.board;

public class BoggleTile {
	private final Point location;
	private final String value;
	
	public BoggleTile(Point location, String value) {
		this.location = location;
		this.value = value;
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
		
		final BoggleTile other = (BoggleTile) rhs;
		
		
		return value.equals(other.getValue()) && location.equals(other.getLocation());
	}
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + location.hashCode();
        result = prime * result + value.hashCode();
        return result;
    }
	
	public String getValue() {
		return this.value;
	}
	
	public Point getLocation() {
		return this.location;
	}
	
}
