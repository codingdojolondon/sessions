package org.minesweeper;

public final class Cell {
	private final boolean isBomb;
    private int numberOfAdjacentBombs;

    public Cell(boolean isBomb) {
        this.isBomb = isBomb;
    }
    
	@Override
	public String toString() {
		return isBomb?"*":".";
	}

	public boolean isBomb() {
		return isBomb;
	}

    public int getAdjacentBombs() {
        return this.numberOfAdjacentBombs;
    }

    public void setAdjacentBombs(int numberOfAdjacentBombsAt) {
        this.numberOfAdjacentBombs = numberOfAdjacentBombsAt;
    }

    public void increaseNumberOfBombs() {
        numberOfAdjacentBombs++;
    } 
	
	

}
