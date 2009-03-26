package org.minesweeper;

import java.util.HashSet;
import java.util.Set;

public class Field {

	private final String[][] field;

	public Field(int rows, int cols) {
		field = new String[rows][];
		for (int i = 0; i < rows; i++) {
			String[] row = new String[cols];
			for (int j = 0; j < cols; j++) {
				row[j] = ".";
			}
			field[i] = row;
		}
	}

	public String cellAt(int row, int column) {
		return field[row][column];
	}

	public void placeBombAt(int row, int column) {
		field[row][column] = "*";
	}

	public Set<Cell> getNeighboursAt(int row, int col) {
		Set<Cell> result = new HashSet<Cell>();
		for (int rowIndex = row - 1; rowIndex <= row + 1; rowIndex++) {
			if (rowIndex >= 0 && rowIndex < field.length) {
				String[] currentRow = field[rowIndex];
				for (int colIndex = col - 1; colIndex <= col + 1; colIndex++) {
					if (colIndex >= 0 && colIndex < currentRow.length) {
						if (!(rowIndex == row && colIndex == col)) {
							result.add(new Cell(rowIndex, colIndex));
						}
					}
				}
			}
		}
		return result;
	}
	
	@Override
	public String toString() {
		String result = "";
		for (String[] row : field) {
			result += "[";
			for (String cell : row) {
				result += cell + " ";
			}
			result = result.substring(0, result.length() - 1);
			result += "]";
		}
		return result;
	}
}
