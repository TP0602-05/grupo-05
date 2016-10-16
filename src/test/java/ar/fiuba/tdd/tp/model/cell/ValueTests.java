package ar.fiuba.tdd.tp.model.cell;

import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.*;

public class ValueTests {

    private void addNBooleansTo(Vector<Boolean> dots, Boolean bool, int cant) {
        for ( int i = 0; i <= cant; i++ ) {
            dots.add(bool);
        }
    }

    @Test
    public void testCreateValueInteger() {
        Value myValue = new Value(3);
        assertTrue( myValue.getValue() == 3 );
    }

    @Test
    public void testCreateValuesIntegerWithTheSameContent() {
        Value myValue1 = new Value(7);
        Value myValue2 = new Value(7);
        assertTrue( myValue1.isEqualTo(myValue2) );
    }

    @Test
    public void testCreateValuesIntegerWithDifferentContent() {
        Value myValue1 = new Value(7);
        Value myValue2 = new Value(3);
        assertFalse( myValue1.isEqualTo(myValue2) );
    }

    @Test
    public void testCreateValueDotsWithSameContent() {
        Vector<Boolean> dots1 = new Vector<>();
        this.addNBooleansTo(dots1, false, 9);
        Value myValue1 = new Value(dots1);
        Vector<Boolean> dots2 = new Vector<>();
        this.addNBooleansTo(dots2, false, 9);
        Value myValue2 = new Value(dots2);
        assertTrue(myValue1.isDotsEqualTo(myValue2));
    }

    @Test
    public void testCreateValueDotsWithDifferentContent() {
        Vector<Boolean> dots1 = new Vector<>();
        this.addNBooleansTo(dots1, false, 9);
        Value myValue1 = new Value(dots1);
        Vector<Boolean> dots2 = new Vector<>();
        this.addNBooleansTo(dots2, false, 5);
        this.addNBooleansTo(dots2, true, 4);
        Value myValue2 = new Value(dots2);
        assertFalse(myValue1.isDotsEqualTo(myValue2));
    }

    @Test
    public void testCombineValueDots() {
        Vector<Boolean> dots1 = new Vector<>();
        this.addNBooleansTo(dots1, true, 1);
        this.addNBooleansTo(dots1, false, 8);

        Vector<Boolean> dots2 = new Vector<>();
        this.addNBooleansTo(dots2, false, 8);
        this.addNBooleansTo(dots2, true, 1);

        Vector<Boolean> dots3 = new Vector<>();
        this.addNBooleansTo(dots3, true, 1);
        this.addNBooleansTo(dots3, false, 7);
        this.addNBooleansTo(dots3, true, 1);
        Value myValue3 = new Value(dots3);
        Value myValue2 = new Value(dots2);
        Value myValue1 = new Value(dots1);
        myValue1.combineDots(myValue2);

        assertTrue(myValue1.isDotsEqualTo(myValue3));
    }
}
