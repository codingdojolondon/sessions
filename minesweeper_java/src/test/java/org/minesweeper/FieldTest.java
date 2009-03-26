package org.minesweeper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FieldTest {

    @Test
    public void shouldProvideStringRepresentation() {
        Field unit = new Field(3, 3);
        unit.placeBombAt(0, 0);
        unit.placeBombAt(1, 0);
        unit.placeBombAt(2, 2);
        assertEquals("[* . .]" + "[* . .]" + "[. . *]", unit.toString());
    }

    @Test
    public void shouldFindBombsInNeighbourCells() {
        Field unit = new Field(3, 3);
        unit.placeBombAt(1, 1);
        assertEquals(1, unit.getAdjacentBombs(0, 0));
        assertEquals(1, unit.getAdjacentBombs(0, 1));
        assertEquals(1, unit.getAdjacentBombs(0, 2));
        assertEquals(1, unit.getAdjacentBombs(1, 0));
        assertEquals(1, unit.getAdjacentBombs(1, 2));
        assertEquals(1, unit.getAdjacentBombs(2, 0));
        assertEquals(1, unit.getAdjacentBombs(2, 1));
        assertEquals(1, unit.getAdjacentBombs(2, 2));
    }

    @Test
    public void shouldFindNeighboursAtCorner() {
        Field unit = new Field(3, 3);
        unit.placeBombAt(0, 0);
        assertEquals(1, unit.getAdjacentBombs(0, 1));
        assertEquals(1, unit.getAdjacentBombs(1, 1));
        assertEquals(0, unit.getAdjacentBombs(0, 2));
        assertEquals(1, unit.getAdjacentBombs(1, 0));
        assertEquals(0, unit.getAdjacentBombs(1, 2));
        assertEquals(0, unit.getAdjacentBombs(2, 0));
        assertEquals(0, unit.getAdjacentBombs(2, 1));
        assertEquals(0, unit.getAdjacentBombs(2, 2));
    }

    @Test
    public void shouldFindNeighboursAtBottomCorner() {
        Field unit = new Field(3, 3);
        unit.placeBombAt(2, 2);
        assertEquals(0, unit.getAdjacentBombs(0, 0));
        assertEquals(0, unit.getAdjacentBombs(0, 1));
        assertEquals(1, unit.getAdjacentBombs(1, 1));
        assertEquals(0, unit.getAdjacentBombs(0, 2));
        assertEquals(0, unit.getAdjacentBombs(1, 0));
        assertEquals(1, unit.getAdjacentBombs(1, 2));
        assertEquals(0, unit.getAdjacentBombs(2, 0));
        assertEquals(1, unit.getAdjacentBombs(2, 1));
    }

    @Test
    public void shouldGetZeroAdjacentBombsWhenThereAreNoBombsInTheField() {
        Field unit = new Field(3, 3);
        assertEquals(0, unit.getAdjacentBombs(2, 2));
    }

    @Test
    public void shouldGetNumberOfAdjacentBombs() {
        Field unit = new Field(3, 3);
        unit.placeBombAt(1, 1);
        assertEquals(1, unit.getAdjacentBombs(2, 2));
    }

    @Test
    public void shouldGetNumberOfAdjacentBombsOnARectangle() {
        Field unit = new Field(6, 3);
        unit.placeBombAt(5, 0);
        assertEquals(1, unit.getAdjacentBombs(5, 1));
    }

    @Test
    public void shouldGetMultipleAdjacentBombsOnARectangle() {
        Field unit = new Field(6, 3);
        unit.placeBombAt(5, 0);
        unit.placeBombAt(5, 1);
        unit.placeBombAt(5, 2);
        assertEquals(3, unit.getAdjacentBombs(4, 1));
    }

    @Test
    public void shouldIgnoreNonAdjacentBombsOnARectangle() {
        Field unit = new Field(6, 7);
        unit.placeBombAt(5, 0);
        unit.placeBombAt(3, 3);
        unit.placeBombAt(5, 2);
        int bombs = unit.getAdjacentBombs(4,1);
        assertEquals(2, bombs);
    }

    @Test
    public void shouldRememberTheNumberOfBombs() {
        Cell unit = new Cell( true);
        unit.increaseNumberOfBombs();
        assertEquals(1, unit.getAdjacentBombs());
    }

    @Test
    public void shouldReturnZeroWhenThereAreNoBombs() {
        Field unit = new Field(1, 1);
        assertEquals(0, unit.getBombCount());
    }

    @Test
    public void shouldReturnOneWhenBombIsPlacedOnce() {
        Field unit = new Field(1, 1);
        unit.placeBombAt(0, 0);
        assertEquals(1, unit.getBombCount());
    }
}
