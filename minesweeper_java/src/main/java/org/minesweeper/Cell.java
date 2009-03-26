package org.minesweeper;

public final class Cell {
	private final int row;
	private final int column;
	private final boolean isBomb;

	public Cell(int row, int column, boolean isBomb) {
		this.row = row;
		this.column = column;
		this.isBomb = isBomb;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	
	@Override
	public String toString() {
		return isBomb?"*":".";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + (isBomb ? 1231 : 1237);
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Cell other = (Cell) obj;
		if (column != other.column)
			return false;
		if (isBomb != other.isBomb)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

	public boolean isBomb() {
		return isBomb;
	} 
	
	

}
