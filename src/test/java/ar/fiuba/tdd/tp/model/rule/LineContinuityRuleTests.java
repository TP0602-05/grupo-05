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
        LineContinuityRule contRule = new LineContinuityRule();
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        PositionValueDuo value = new PositionValueDuo(new Value(0),new Position(0,0));
        assertFalse(contRule.check(values,value));
    }

    @Test
    public void testAddValueToEmptySet() {
        LineContinuityRule contRule = new LineContinuityRule();
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist = {true,true,true,false,false,false,false,false,false};
        Vector<Boolean> boolvec = new Vector<>(Arrays.asList(boollist));
        PositionValueDuo value = new PositionValueDuo(new Value(0,boolvec),new Position(1,0));
        assertFalse(contRule.check(values,value));
    }

    @Test
    public void testAddEmptyValueToSet() {
        LineContinuityRule contRule = new LineContinuityRule();
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist = {true,true,true,false,false,false,false,false,false};
        Vector<Boolean> boolvec = new Vector<>(Arrays.asList(boollist));
        PositionValueDuo value1 = new PositionValueDuo(new Value(0,boolvec),new Position(1,0));
        values.add(value1);
        PositionValueDuo value2 = new PositionValueDuo(new Value(0),new Position(1,1));
        assertFalse(contRule.check(values,value2));
    }

    @Test
    public void testAddCorrectValue1ToSet() {
        LineContinuityRule contRule = new LineContinuityRule();
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist1 = {false,true,false,false,true,true,false,false,false};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));
        PositionValueDuo value1 = new PositionValueDuo(new Value(0,boolvec1),new Position(1,0));
        values.add(value1);
        Boolean[] boollist2 = {false,true,false,false,true,false,false,true,false};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        PositionValueDuo value2 = new PositionValueDuo(new Value(0,boolvec2),new Position(1,1));
        assertTrue(contRule.check(values,value2));
    }

    @Test
    public void testAddCorrectValue2ToSet() {
        LineContinuityRule contRule = new LineContinuityRule();
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist1 = {true,true,true,false,false,false,false,false,false};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));
        PositionValueDuo value1 = new PositionValueDuo(new Value(0,boolvec1),new Position(2,0));
        values.add(value1);
        Boolean[] boollist2 = {false,false,true,false,false,true,false,false,true};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        PositionValueDuo value2 = new PositionValueDuo(new Value(0,boolvec2),new Position(1,1));
        assertTrue(contRule.check(values,value2));
    }

    @Test
    public void testAddCorrectValue3ToSet() {
        LineContinuityRule contRule = new LineContinuityRule();
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist1 = {true,false,false,false,true,false,false,false,true};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));
        PositionValueDuo value1 = new PositionValueDuo(new Value(0,boolvec1),new Position(0,2));
        values.add(value1);
        Boolean[] boollist2 = {true,false,false,false,true,false,false,false,true};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        PositionValueDuo value2 = new PositionValueDuo(new Value(0,boolvec2),new Position(1,1));
        assertTrue(contRule.check(values,value2));
    }

    @Test
    public void testAddIncorrectValue1ToSet() {
        LineContinuityRule contRule = new LineContinuityRule();
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist1 = {false,false,false,true,true,true,false,false,false};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));
        PositionValueDuo value1 = new PositionValueDuo(new Value(0,boolvec1),new Position(1,0));
        values.add(value1);
        Boolean[] boollist2 = {false,true,false,false,true,false,false,true,false};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        PositionValueDuo value2 = new PositionValueDuo(new Value(0,boolvec2),new Position(1,1));
        assertFalse(contRule.check(values,value2));
    }

    @Test
    public void testAddIncorrectValue2ToSet() {
        LineContinuityRule contRule = new LineContinuityRule();
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist1 = {false,false,false,true,true,true,false,true,false};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));
        PositionValueDuo value1 = new PositionValueDuo(new Value(0,boolvec1),new Position(1,0));
        values.add(value1);
        Boolean[] boollist2 = {true,false,false,false,true,false,false,false,true};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        PositionValueDuo value2 = new PositionValueDuo(new Value(0,boolvec2),new Position(1,1));
        assertFalse(contRule.check(values,value2));
    }

    @Test
    public void testAddIncorrectValue3ToSet() {
        LineContinuityRule contRule = new LineContinuityRule();
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist1 = {false,true,false,false,true,true,false,false,false};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));
        PositionValueDuo value1 = new PositionValueDuo(new Value(0,boolvec1),new Position(0,0));
        values.add(value1);
        Boolean[] boollist2 = {true,false,false,true,false,false,true,false,false};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        PositionValueDuo value2 = new PositionValueDuo(new Value(0,boolvec2),new Position(1,1));
        assertFalse(contRule.check(values,value2));
    }

    @Test
    public void testCheckOneContinuousValue() {
        LineContinuityRule contRule = new LineContinuityRule();
        Boolean[] boollist1 = {true,true,true,false,false,false,false,false,false};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));
        Value value1 = new Value(0,boolvec1);
        Boolean[] boollist2 = {false,false,true,false,false,true,false,false,true};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        Value value2 = new Value(0,boolvec2);
        assertTrue(contRule.checkOneContinuousValue(value1,value2,2,8));
    }
}
