package org.minesweeper;

import java.util.HashSet;
import java.util.Set;

public class Field {

	private final Cell[][] grid;

	public Field(int rows, int cols) {
		grid = new Cell[rows][];
		for (int i = 0; i < rows; i++) {
			Cell[] row = new Cell[cols];
			for (int j = 0; j < cols; j++) {
				row[j] = new Cell(i, j, false);
			}
			grid[i] = row;
		}
	}

	public Cell cellAt(int row, int column) {
		return grid[row][column];
	}

	public void placeBombAt(int row, int column) {
		grid[row][column] = new Cell(row, column, true);
	}

	public Set<Cell> getNeighboursAt(int row, int col) {
		Set<Cell> result = new HashSet<Cell>();
		for (int rowIndex = Math.max(0, row - 1); rowIndex <= Math.min(row + 1,
				getHeight() - 1); rowIndex++) {
			result.addAll(getRowNeighbours(row, col, rowIndex));
		}
		return result;
	}

	private Set<Cell> getRowNeighbours(int row, int col, int rowIndex) {
		Set<Cell> result = new HashSet<Cell>();
		for (int colIndex = Math.max(col - 1, 0); colIndex <= Math.min(col + 1,
				getWidth() - 1); colIndex++) {
			if (!(rowIndex == row && colIndex == col)) {
				result.add(cellAt(rowIndex, colIndex));
			}
		}
		return result;
	}

	private int getWidth() {
		return grid[0].length;
	}

	private int getHeight() {
		return grid.length;
	}

	@Override
	public String toString() {
		String result = "";
		for (Cell[] row : grid) {
			result += "[";
			for (Cell cell : row) {
				result += cell + " ";
			}
			result = result.substring(0, result.length() - 1);
			result += "]";
		}
		return result;
	}

	public int getNumberOfAdjacentBombsAt(int row, int col) {
		int result = 0;
		for (Cell cell : getNeighboursAt(row, col)) {
			if (cell.isBomb()) {
				result++;
			}
		}
		return result;
	}
}
