package org.minesweeper;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class FieldTest {

	@Test
	public void shouldStartEmpty() {
		Field unit = new Field(2, 2);
		assertEquals(".", unit.cellAt(0, 0));
		assertEquals(".", unit.cellAt(0, 1));
		assertEquals(".", unit.cellAt(1, 0));
		assertEquals(".", unit.cellAt(1, 1));
	}

	@Test
	public void shouldAllowPlacingBombs() {
		Field unit = new Field(2, 2);
		unit.placeBombAt(0, 1);
		assertEquals(".", unit.cellAt(0, 0));
		assertEquals("*", unit.cellAt(0, 1));
		assertEquals(".", unit.cellAt(1, 0));
		assertEquals(".", unit.cellAt(1, 1));
	}

	@Test
	public void shouldProvideStringRepresentation() {
		Field unit = new Field(3, 3);
		unit.placeBombAt(0, 0);
		unit.placeBombAt(1, 0);
		unit.placeBombAt(2, 2);
		assertEquals("[* . .]"+
				     "[* . .]"+
				     "[. . *]", unit.toString());
	}
	
	
	@Test
	public void shouldFindNeighbours() {
		Field unit = new Field(3, 3);
		Set<Cell> cells = unit.getNeighboursAt(1, 1);
		Set<Cell> expected = new HashSet<Cell>();
		expected.add(new Cell(0, 0));
		expected.add(new Cell(0, 1));
		expected.add(new Cell(0, 2));
		expected.add(new Cell(1, 0));
		expected.add(new Cell(1, 2));
		expected.add(new Cell(2, 0));
		expected.add(new Cell(2, 1));
		expected.add(new Cell(2, 2));
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
		expected.add(new Cell(0, 1));
		expected.add(new Cell(1, 0));
		expected.add(new Cell(1, 1));
		assertEquals(expected.size(), cells.size());
		for (Cell expectedCell : expected) {
			assertTrue(cells.contains(expectedCell));
		}
	}
}
