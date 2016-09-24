package ar.fiuba.tdd.tp.model.cell;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReadCellTest {

    @Test
    public void createACellAndGetValue() {
        ReadCell cell = new ReadCell(10);
        assertTrue(10 == cell.readValue());
    }
}
