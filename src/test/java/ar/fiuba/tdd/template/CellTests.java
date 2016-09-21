package ar.fiuba.tdd.template;

import org.junit.Test;

import static org.junit.Assert.*;

public class CellTests {

    @Test
    public void testCreateEmptyCellNotBlocked() {
        Cell myCell = new Cell();
        assertTrue( ! myCell.isBlocked() );
    }

    @Test
    public void testCreateCellBlocked() {
        Cell myCell = new Cell(5);
        assertTrue( myCell.isBlocked() );
    }

    @Test
    public void testAddValueToBlockedCell() {
        Cell myCell = new Cell(5);
        myCell.setValue(3);
        assertEquals(myCell.getValue(), 5);
    }

    @Test
    public void testAddValueToEmptyCell() {
        Cell myCell = new Cell();
        myCell.setValue(5);
        assertEquals(myCell.getValue(), 5);
    }

    @Test
    public void testEmptyCellReturnNullValue() {
        Cell myCell = new Cell();
        assertNull(myCell.getValue());
    }
}
