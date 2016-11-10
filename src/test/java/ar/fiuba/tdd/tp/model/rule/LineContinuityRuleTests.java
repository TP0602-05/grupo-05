package ar.fiuba.tdd.tp.model.rule;


import ar.fiuba.tdd.tp.model.cell.Position;
import ar.fiuba.tdd.tp.model.cell.PositionValueDuo;
import ar.fiuba.tdd.tp.model.cell.Value;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import static org.junit.Assert.*;

public class LineContinuityRuleTests {

    @Test
    public void testAddEmptyValueToEmptySet() {
        LineContinuityRule contRule = new LineContinuityRule(2);
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        values.add(new PositionValueDuo(new Value(0),new Position(0,0)));
        PositionValueDuo value = new PositionValueDuo(new Value(0),new Position(0,0));
        assertTrue(contRule.check(values,value));
    }

    @Test
    public void testAddValueToEmptySet() {
        LineContinuityRule contRule = new LineContinuityRule(2);
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist = {true,true,true,false,false,false,false,false,false};
        Vector<Boolean> boolvec = new Vector<>(Arrays.asList(boollist));
        values.add(new PositionValueDuo(new Value(0),new Position(0,0)));
        values.add(new PositionValueDuo(new Value(0),new Position(0,0)));
        PositionValueDuo value = new PositionValueDuo(new Value(0,boolvec),new Position(1,0));
        assertTrue(contRule.check(values,value));
    }

    @Test
    public void testAddEmptyValueToSet() {
        LineContinuityRule contRule = new LineContinuityRule(2);
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist = {true,true,true,false,false,false,false,false,false};
        Vector<Boolean> boolvec = new Vector<>(Arrays.asList(boollist));
        PositionValueDuo value1 = new PositionValueDuo(new Value(0,boolvec),new Position(1,0));
        values.add(value1);
        values.add(new PositionValueDuo(new Value(0),new Position(0,0)));
        PositionValueDuo value2 = new PositionValueDuo(new Value(0),new Position(1,1));
        assertFalse(contRule.check(values,value2));
    }

    @Test
    public void testAddCorrectValue1ToSet() {
        LineContinuityRule contRule = new LineContinuityRule(2);
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist1 = {false,true,false,false,true,true,false,false,false};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));
        PositionValueDuo value1 = new PositionValueDuo(new Value(0,boolvec1),new Position(2,1));
        values.add(value1);
        values.add(new PositionValueDuo(new Value(0),new Position(0,0)));
        Boolean[] boollist2 = {false,true,false,false,true,false,false,true,false};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        PositionValueDuo value2 = new PositionValueDuo(new Value(0,boolvec2),new Position(1,1));
        assertTrue(contRule.check(values,value2));
    }

    @Test
    public void testAddCorrectValue2ToSet() {
        LineContinuityRule contRule = new LineContinuityRule(2);
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist1 = {true,true,true,false,false,false,false,false,false};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));
        PositionValueDuo value1 = new PositionValueDuo(new Value(0,boolvec1),new Position(2,2));
        values.add(value1);
        values.add(new PositionValueDuo(new Value(0),new Position(0,0)));
        Boolean[] boollist2 = {false,false,true,false,false,true,false,false,true};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        PositionValueDuo value2 = new PositionValueDuo(new Value(0,boolvec2),new Position(1,1));
        assertTrue(contRule.check(values,value2));
    }

    @Test
    public void testAddCorrectValue3ToSet() {
        LineContinuityRule contRule = new LineContinuityRule(2);
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist1 = {true,false,false,false,true,false,false,false,true};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));
        PositionValueDuo value1 = new PositionValueDuo(new Value(0,boolvec1),new Position(0,0));
        values.add(value1);
        Boolean[] boollist2 = {true,false,false,false,true,false,false,false,true};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        PositionValueDuo value2 = new PositionValueDuo(new Value(0,boolvec2),new Position(1,1));
        assertTrue(contRule.check(values,value2));
    }

    @Test
    public void testAddIncorrectValue1ToSet() {
        LineContinuityRule contRule = new LineContinuityRule(2);
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist1 = {false,false,false,true,true,true,false,false,false};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));
        PositionValueDuo value1 = new PositionValueDuo(new Value(0,boolvec1),new Position(2,1));
        values.add(value1);
        Boolean[] boollist2 = {false,true,false,false,true,false,false,true,false};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        PositionValueDuo value2 = new PositionValueDuo(new Value(0,boolvec2),new Position(1,1));
        assertFalse(contRule.check(values,value2));
    }

    @Test
    public void testAddIncorrectValue2ToSet() {
        LineContinuityRule contRule = new LineContinuityRule(2);
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist1 = {false,false,false,true,true,true,false,true,false};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));
        PositionValueDuo value1 = new PositionValueDuo(new Value(0,boolvec1),new Position(2,1));
        values.add(value1);
        Boolean[] boollist2 = {true,false,false,false,true,false,false,false,true};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        PositionValueDuo value2 = new PositionValueDuo(new Value(0,boolvec2),new Position(1,1));
        assertFalse(contRule.check(values,value2));
    }

    @Test
    public void testAddIncorrectValue3ToSet() {
        LineContinuityRule contRule = new LineContinuityRule(2);
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist1 = {false,true,false,false,true,true,false,false,false};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));
        PositionValueDuo value1 = new PositionValueDuo(new Value(0,boolvec1),new Position(2,0));
        values.add(value1);
        Boolean[] boollist2 = {true,false,false,true,false,false,true,false,false};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        PositionValueDuo value2 = new PositionValueDuo(new Value(0,boolvec2),new Position(1,1));
        assertFalse(contRule.check(values,value2));
    }

    @Test
    public void testCheckIncorrectCircuit() {
        LineContinuityRule contRule = new LineContinuityRule(2);
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist1 = {false,true,false,false,true,true,false,false,false};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));
        PositionValueDuo value1 = new PositionValueDuo(new Value(0,boolvec1),new Position(2,0));
        contRule.check(values,value1);
        values.add(value1);
        Boolean[] boollist3 = {false,true,false,true,true,false,false,false,false};
        Vector<Boolean> boolvec3 = new Vector<>(Arrays.asList(boollist3));
        PositionValueDuo value3 = new PositionValueDuo(new Value(0,boolvec3),new Position(2,1));
        values.add(value3);
        Boolean[] boollist4 = {false,false,false,true,true,true,false,false,false};
        Vector<Boolean> boolvec4 = new Vector<>(Arrays.asList(boollist4));
        PositionValueDuo value4 = new PositionValueDuo(new Value(0,boolvec4),new Position(1,0));
        values.add(value4);
        assertFalse(contRule.checkFinal(values));
    }

    @Test
    public void testCheckIncorrectCircuit2() {
        LineContinuityRule contRule = new LineContinuityRule(2);
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollistIn = {false,false,true,false,false,true,true,true,true};
        Vector<Boolean> boolvecIn = new Vector<>(Arrays.asList(boollistIn));
        PositionValueDuo valueIn = new PositionValueDuo(new Value(0,boolvecIn),new Position(1,1));
        contRule.check(values,valueIn);
        values.add(valueIn);
        Boolean[] boollist0 = {true,false,false,true,false,false,true,false,false};
        Vector<Boolean> boolvec0 = new Vector<>(Arrays.asList(boollist0));
        PositionValueDuo value0 = new PositionValueDuo(new Value(0,boolvec0),new Position(0,1));
        values.add(value0);
        Boolean[] boollist2 = {true,true,true,false,false,false,false,false,false};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        PositionValueDuo value2 = new PositionValueDuo(new Value(1,boolvec2),new Position(2,1));
        values.add(value2);
        assertFalse(contRule.checkFinal(values));
    }

    @Test
    public void testCheckNotCircuitCorrect() {
        LineContinuityRule contRule = new LineContinuityRule(-1);
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollistIn = {true,false,false,false,true,false,false,false,true};
        Vector<Boolean> boolvecIn = new Vector<>(Arrays.asList(boollistIn));
        PositionValueDuo valueIn = new PositionValueDuo(new Value(0,boolvecIn),new Position(1,1));
        Boolean[] boollist0 = {true,false,false,true,false,false,true,false,false};
        Vector<Boolean> boolvec0 = new Vector<>(Arrays.asList(boollist0));
        PositionValueDuo value0 = new PositionValueDuo(new Value(0,boolvec0),new Position(0,1));
        values.add(value0);
        Boolean[] boollist2 = {true,false,false,false,true,false,false,false,true};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        PositionValueDuo value2 = new PositionValueDuo(new Value(1,boolvec2),new Position(2,1));
        values.add(value2);
        assertTrue(contRule.check(values,valueIn));
    }

    @Test
    public void testCheckNotCircuitIncorrect() {
        LineContinuityRule contRule = new LineContinuityRule(-1);
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollistIn = {true,false,false,false,true,false,false,false,true};
        Vector<Boolean> boolvecIn = new Vector<>(Arrays.asList(boollistIn));
        PositionValueDuo valueIn = new PositionValueDuo(new Value(0,boolvecIn),new Position(1,1));
        Boolean[] boollist0 = {true,false,false,true,false,false,true,false,false};
        Vector<Boolean> boolvec0 = new Vector<>(Arrays.asList(boollist0));
        PositionValueDuo value0 = new PositionValueDuo(new Value(0,boolvec0),new Position(1,2));
        values.add(value0);
        Boolean[] boollist2 = {true,true,true,false,false,false,false,false,false};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        PositionValueDuo value2 = new PositionValueDuo(new Value(1,boolvec2),new Position(1,0));
        values.add(value2);
        assertFalse(contRule.check(values,valueIn));
    }

    @Test
    public void testCheckInitValue() {
        LineContinuityRule contRule = new LineContinuityRule(1);
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist = {true,true,true,false,false,false,false,false,false};
        Vector<Boolean> boolvec = new Vector<>(Arrays.asList(boollist));
        PositionValueDuo value = new PositionValueDuo(new Value(0,boolvec),new Position(1,0));
        contRule.check(values,value);
        assertTrue(value.getValue().areDotsEqualTo(contRule.getInitValue().getValue()));
    }

    @Test
    public void testCheckInitValue2() {
        LineContinuityRule contRule = new LineContinuityRule(1);
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist = {true,true,true,false,false,false,false,false,false};
        Vector<Boolean> boolvec = new Vector<>(Arrays.asList(boollist));
        PositionValueDuo value = new PositionValueDuo(new Value(0,boolvec),new Position(1,0));
        contRule.check(values,value);
        assertTrue(value.getValue().areDotsEqualTo(contRule.getInitValue().getValue()));
        Boolean[] boollist2 = {false,true,true,false,false,false,false,false,false};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        PositionValueDuo value2 = new PositionValueDuo(new Value(0,boolvec2),new Position(1,0));
        contRule.check(values,value2);
        assertTrue(value2.getValue().areDotsEqualTo(contRule.getInitValue().getValue()));


    }

    @Test
    public void testCheckOneContinuousValue() {
        LineContinuityRule contRule = new LineContinuityRule(1);
        Boolean[] boollist1 = {true,true,true,false,false,false,false,false,false};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));
        Value value1 = new Value(0,boolvec1);
        Boolean[] boollist2 = {false,false,true,false,false,true,false,false,true};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        Value value2 = new Value(0,boolvec2);
        assertTrue(contRule.checkOneContinuousValue(value1,value2,2,8));
    }

    @Test
    public void testTransversalValues() {
        LineContinuityRule contRule = new LineContinuityRule(1);
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist = {false,true,false,false,true,true,false,false,false};
        Vector<Boolean> boolvec = new Vector<>(Arrays.asList(boollist));
        PositionValueDuo valueIn = new PositionValueDuo(new Value(0,boolvec),new Position(1,1));
        PositionValueDuo value0 = new PositionValueDuo(new Value(1,boolvec),new Position(0,1));
        values.add(value0);
        PositionValueDuo value2 = new PositionValueDuo(new Value(3,boolvec),new Position(2,1));
        values.add(value2);
        PositionValueDuo value3 = new PositionValueDuo(new Value(4,boolvec),new Position(1,0));
        PositionValueDuo value1 = new PositionValueDuo(new Value(2,boolvec),new Position(1,2));
        values.add(value1);
        values.add(value3);
        Vector<Value> valuesNext = contRule.getTransversalValues(values,valueIn);
        assertTrue(value0.getValue().isEqualTo(valuesNext.elementAt(0)));
        assertTrue(value1.getValue().isEqualTo(valuesNext.elementAt(1)));
        assertTrue(value2.getValue().isEqualTo(valuesNext.elementAt(2)));
        assertTrue(value3.getValue().isEqualTo(valuesNext.elementAt(3)));
    }

    @Test
    public void testCornerValues() {
        LineContinuityRule contRule = new LineContinuityRule(1);
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist = {false,true,false,false,true,true,false,false,false};
        Vector<Boolean> boolvec = new Vector<>(Arrays.asList(boollist));
        PositionValueDuo valueIn = new PositionValueDuo(new Value(0,boolvec),new Position(1,1));
        PositionValueDuo value0 = new PositionValueDuo(new Value(1,boolvec),new Position(0,1));
        values.add(value0);
        PositionValueDuo value2 = new PositionValueDuo(new Value(3,boolvec),new Position(2,1));
        values.add(value2);
        PositionValueDuo value3 = new PositionValueDuo(new Value(4,boolvec),new Position(1,0));
        PositionValueDuo value1 = new PositionValueDuo(new Value(2,boolvec),new Position(1,2));
        values.add(value1);
        values.add(value3);
        Vector<Value> valuesNext = contRule.getTransversalValues(values,valueIn);
        assertTrue(value0.getValue().isEqualTo(valuesNext.elementAt(0)));
        assertTrue(value1.getValue().isEqualTo(valuesNext.elementAt(1)));
        assertTrue(value2.getValue().isEqualTo(valuesNext.elementAt(2)));
        assertTrue(value3.getValue().isEqualTo(valuesNext.elementAt(3)));
    }
}
