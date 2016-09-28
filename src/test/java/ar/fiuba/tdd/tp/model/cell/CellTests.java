package ar.fiuba.tdd.tp.model.cell;

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
        Cell myCell = new Cell(new Value(5));
        assertTrue( myCell.isBlocked() );
    }

    @Test
    public void testAddValueToBlockedCell() {
        Cell myCell = new Cell(new Value(5));
        myCell.setValue(new Value(3));
        assertTrue(myCell.getValue().isEqualTo(new Value(5)));
    }

    @Test
    public void testAddValueToEmptyCell() {
        Cell myCell = new Cell();
        myCell.setValue(new Value(5));
        assertTrue(myCell.getValue().isEqualTo(new Value(5)));
    }

    @Test
    public void testEmptyCellReturnNullValue() {
        Cell myCell = new Cell();
        assertTrue(myCell.getValue().isEqualTo(new Value(0)));
    }
}
