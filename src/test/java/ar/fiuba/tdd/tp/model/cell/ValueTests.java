package ar.fiuba.tdd.tp.model.cell;

import org.junit.Test;

import java.util.Arrays;
import java.util.Vector;

import static org.junit.Assert.*;

public class ValueTests {

    private static final int UP_LEFT_BORDER     = 0;
    private static final int UP_BORDER          = 1;
    private static final int UP_RIGHT_BORDER    = 2;
    private static final int LEFT_BORDER        = 3;
    private static final int RIGHT_BORDER       = 4;
    private static final int DOWN_LEFT_BORDER   = 5;
    private static final int DOWN_BORDER        = 6;
    private static final int DOWN_RIGHT_BORDER  = 7;

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
        assertTrue(myValue1.areDotsEqualTo(myValue2));
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
        assertFalse(myValue1.areDotsEqualTo(myValue2));
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

        assertTrue(myValue1.areDotsEqualTo(myValue3));
    }

    @Test
    public void testIsEqualDots() {
        Boolean[] boollist1 = {true,true,true,false,false,false,false,false,false};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));
        Value value1 = new Value(0,boolvec1);
        Boolean[] boollist2 = {true,true,true,false,false,false,false,false,false};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        Value value2 = new Value(3,boolvec2);
        assertTrue(value1.areDotsEqualTo(value2));
    }

    @Test
    public void testIsNotEqualDots() {
        Boolean[] boollist1 = {true,true,true,false,false,false,false,false,true};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));
        Value value1 = new Value(0,boolvec1);
        Boolean[] boollist2 = {true,true,true,false,false,false,false,false,false};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        Value value2 = new Value(3,boolvec2);
        assertFalse(value1.areDotsEqualTo(value2));
    }

    private Value setupBoolVect() {
        Boolean[] boollist1 = { true,true,true,
                                true,true,true,
                                true,true,true};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));
        return new Value(0,boolvec1);
    }

    @Test
    public void testBorderValueAtUpLeft() {
        Value value1 = setupBoolVect();
        Boolean[] boollist2 = { false,false,false,
                                false,false,false,
                                false,false,true};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        Value value2 = new Value(0,boolvec2);
        assertTrue(value1.getBorderValueAt(UP_LEFT_BORDER).areDotsEqualTo(value2));
    }

    @Test
    public void testBorderValueAtUp() {
        Value value1 = setupBoolVect();
        Boolean[] boollist2 = { false,false,false,
                                false,false,false,
                                true,true,true};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        Value value2 = new Value(0,boolvec2);
        assertTrue(value1.getBorderValueAt(UP_BORDER).areDotsEqualTo(value2));
    }

    @Test
    public void testBorderValueAtUpRight() {
        Value value1 = setupBoolVect();
        Boolean[] boollist2 = { false,false,false,
                                false,false,false,
                                true,false,false};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        Value value2 = new Value(0,boolvec2);
        assertTrue(value1.getBorderValueAt(UP_RIGHT_BORDER).areDotsEqualTo(value2));
    }

    @Test
    public void testBorderValueAtLeft() {
        Value value1 = setupBoolVect();
        Boolean[] boollist2 = { false,false,true,
                                false,false,true,
                                false,false,true};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        Value value2 = new Value(0,boolvec2);
        assertTrue(value1.getBorderValueAt(LEFT_BORDER).areDotsEqualTo(value2));
    }

    @Test
    public void testBorderValueAtRight() {
        Value value1 = setupBoolVect();
        Boolean[] boollist2 = { true,false,false,
                                true,false,false,
                                true,false,false};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        Value value2 = new Value(0,boolvec2);
        assertTrue(value1.getBorderValueAt(RIGHT_BORDER).areDotsEqualTo(value2));
    }

    @Test
    public void testBorderValueAtDownLeft() {
        Value value1 = setupBoolVect();
        Boolean[] boollist2 = { false,false,true,
                                false,false,false,
                                false,false,false};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        Value value2 = new Value(0,boolvec2);
        assertTrue(value1.getBorderValueAt(DOWN_LEFT_BORDER).areDotsEqualTo(value2));
    }

    @Test
    public void testBorderValueAtDown() {
        Value value1 = setupBoolVect();
        Boolean[] boollist2 = { true,true,true,
                                false,false,false,
                                false,false,false};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        Value value2 = new Value(0,boolvec2);
        assertTrue(value1.getBorderValueAt(DOWN_BORDER).areDotsEqualTo(value2));
    }

    @Test
    public void testBorderValueAtDownRight() {
        Value value1 = setupBoolVect();
        Boolean[] boollist2 = { true,false,false,
                                false,false,false,
                                false,false,false};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        Value value2 = new Value(0,boolvec2);
        assertTrue(value1.getBorderValueAt(DOWN_RIGHT_BORDER).areDotsEqualTo(value2));
    }

    @Test
    public void testUpdateBorders() {
        Value value1 = new Value(0);

        Boolean[] boollist2 = { true,true,true,
                                false,false,false,
                                false,false,false};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        Value value2 = new Value(0,boolvec2);

        value1.updateBorders(value2,1);

        assertTrue( value1.getBorderDots().elementAt(0) == 1
                    && value1.getBorderDots().elementAt(1) == 1
                    && value1.getBorderDots().elementAt(2) == 1
                    && value1.getBorderDots().elementAt(3) == 0
                    && value1.getBorderDots().elementAt(4) == 0
                    && value1.getBorderDots().elementAt(5) == 0
                    && value1.getBorderDots().elementAt(6) == 0
                    && value1.getBorderDots().elementAt(7) == 0
                    && value1.getBorderDots().elementAt(8) == 0 );
    }

    @Test
    public void testUpdateBordersWithMoreValues() {
        Value value1 = new Value(0);

        Boolean[] boollist2 = { false,false,false,
                                true,false,false,
                                true,true,false };
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        Value value2 = new Value(0,boolvec2);

        Boolean[] boollist3 = { false,false,false,
                                true,false,true,
                                false,false,false };
        Vector<Boolean> boolvec3 = new Vector<>(Arrays.asList(boollist3));
        Value value3 = new Value(0,boolvec3);

        Boolean[] boollist4 = { true,false,false,
                                true,false,false,
                                false,false,false };
        Vector<Boolean> boolvec4 = new Vector<>(Arrays.asList(boollist4));
        Value value4 = new Value(0,boolvec4);

        value1.updateBorders(value2,1);
        value1.updateBorders(value3,1);
        value1.updateBorders(value4,1);

        assertTrue( value1.getBorderDots().elementAt(0) == 1
                && value1.getBorderDots().elementAt(1) == 0
                && value1.getBorderDots().elementAt(2) == 0
                && value1.getBorderDots().elementAt(3) == 3
                && value1.getBorderDots().elementAt(4) == 0
                && value1.getBorderDots().elementAt(5) == 1
                && value1.getBorderDots().elementAt(6) == 1
                && value1.getBorderDots().elementAt(7) == 1
                && value1.getBorderDots().elementAt(8) == 0 );
    }
}
