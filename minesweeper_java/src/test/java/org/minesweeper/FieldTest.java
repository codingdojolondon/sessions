package org.minesweeper;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class FieldTest {

	@Test
	public void shouldStartEmpty() {
		Field unit = new Field(2, 2);
		assertEquals(new Cell(0, 0, false), unit.cellAt(0, 0));
		assertEquals(new Cell(0, 1, false), unit.cellAt(0, 1));
		assertEquals(new Cell(1, 0, false), unit.cellAt(1, 0));
		assertEquals(new Cell(1, 1, false), unit.cellAt(1, 1));
	}

	@Test
	public void shouldAllowPlacingBombs() {
		Field unit = new Field(2, 2);
		unit.placeBombAt(0, 1);
		assertEquals(new Cell(0, 0, false), unit.cellAt(0, 0));
		assertEquals(new Cell(0, 1, true), unit.cellAt(0, 1));
		assertEquals(new Cell(1, 0, false), unit.cellAt(1, 0));
		assertEquals(new Cell(1, 1, false), unit.cellAt(1, 1));
	}

	@Test
	public void shouldProvideStringRepresentation() {
		Field unit = new Field(3, 3);
		unit.placeBombAt(0, 0);
		unit.placeBombAt(1, 0);
		unit.placeBombAt(2, 2);
		assertEquals("[* . .]" + "[* . .]" + "[. . *]", unit.toString());
	}

	@Test
	public void shouldFindNeighbours() {
		Field unit = new Field(3, 3);
		Set<Cell> cells = unit.getNeighboursAt(1, 1);
		Set<Cell> expected = new HashSet<Cell>();
		expected.add(new Cell(0, 0, false));
		expected.add(new Cell(0, 1, false));
		expected.add(new Cell(0, 2, false));
		expected.add(new Cell(1, 0, false));
		expected.add(new Cell(1, 2, false));
		expected.add(new Cell(2, 0, false));
		expected.add(new Cell(2, 1, false));
		expected.add(new Cell(2, 2, false));
		assertEquals(expected.size(), cells.size());
		for (Cell expectedCell : expected) {
			assertTrue(cells.contains(expectedCell));
		}
	}

	@Test
	public void shouldFindNeighboursAtCorner() {
		Field unit = new Field(3, 3);
		Set<Cell> cells = unit.getNeighboursAt(0, 0);
		Set<Cell> expected = new HashSet<Cell>();
		expected.add(new Cell(0, 1, false));
		expected.add(new Cell(1, 0, false));
		expected.add(new Cell(1, 1, false));
		assertEquals(expected.size(), cells.size());
		for (Cell expectedCell : expected) {
			assertTrue(cells.contains(expectedCell));
		}
	}

	@Test
	public void shouldFindNeighboursAtBottomCorner() {
		Field unit = new Field(3, 3);
		Set<Cell> cells = unit.getNeighboursAt(2, 2);
		Set<Cell> expected = new HashSet<Cell>();
		expected.add(new Cell(1, 2, false));
		expected.add(new Cell(1, 1, false));
		expected.add(new Cell(2, 1, false));
		assertEquals(expected.size(), cells.size());
		for (Cell expectedCell : expected) {
			assertTrue(cells.contains(expectedCell));
		}
	}

	@Test
	public void shouldGetZeroAdjacentBombs() {
		Field unit = new Field(3, 3);
		int bombs = unit.getNumberOfAdjacentBombsAt(2, 2);
		assertEquals(0, bombs);
	}

	@Test
	public void shouldGetNumberOfAdjacentBombs() {
		Field unit = new Field(3, 3);
		unit.placeBombAt(1, 1);
		int bombs = unit.getNumberOfAdjacentBombsAt(2, 2);
		assertEquals(1, bombs);
	}

	@Test
	public void shouldGetNumberOfAdjacentBombsOnARectangle() {
		Field unit = new Field(6, 3);
		unit.placeBombAt(5, 0);
		int bombs = unit.getNumberOfAdjacentBombsAt(5, 1);
		assertEquals(1, bombs);
	}

	@Test
	public void shouldGetMultipleAdjacentBombsOnARectangle() {
		Field unit = new Field(6, 3);
		unit.placeBombAt(5, 0);
		unit.placeBombAt(5, 1);
		unit.placeBombAt(5, 2);
		int bombs = unit.getNumberOfAdjacentBombsAt(4, 1);
		assertEquals(3, bombs);
	}

	@Test
	public void shouldIgnoreNonAdjacentBombsOnARectangle() {
		Field unit = new Field(6, 7);
		unit.placeBombAt(5, 0);
		unit.placeBombAt(3, 3);
		unit.placeBombAt(5, 2);
		int bombs = unit.getNumberOfAdjacentBombsAt(4, 1);
		assertEquals(2, bombs);
	}

}
