package ar.fiuba.tdd.tp.model.cell;

import org.junit.Test;

import static org.junit.Assert.*;

public class WriteCellTest {

    @Test
    public void createACellWriteAndGetValue() {
        WriteCell cell = new WriteCell(10);
        cell.writeValue(5);
        assertTrue(5 == cell.readValue());
    }

    @Test
    public void createANullCell() {
        WriteCell cell = new WriteCell();
        assertNull(cell.readValue());
    }

    @Test
    public void createANullCellWriteAndReadValue() {
        WriteCell cell = new WriteCell();
        cell.writeValue(10);
        assertTrue(10 == cell.readValue());
    }
}