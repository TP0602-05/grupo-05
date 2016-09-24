package ar.fiuba.tdd.tp.model.cell;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValueTests {

    @Test
    public void testCreateValue() {
        Value myValue = new Value(3);
        assertTrue( myValue.getValue() == 3 );
    }

    @Test
    public void testCreateValuesWithTheSameContent() {
        Value myValue1 = new Value(7);
        Value myValue2 = new Value(7);
        assertTrue( myValue1.isEqualTo(myValue2) );
    }

    @Test
    public void testCreateValuesWithDifferentContent() {
        Value myValue1 = new Value(7);
        Value myValue2 = new Value(3);
        assertFalse( myValue1.isEqualTo(myValue2) );
    }
}
