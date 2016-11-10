package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.Position;
import ar.fiuba.tdd.tp.model.cell.PositionValueDuo;
import ar.fiuba.tdd.tp.model.cell.Value;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import static org.junit.Assert.*;

public class AmountOfLinesRuleTests {

    @Test
    public void testAddEmptyValueToEmptySet() {
        AmountOfLinesRule linesRule = new AmountOfLinesRule(2);
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        values.add(new PositionValueDuo(new Value(0),new Position(0,0)));
        values.add(new PositionValueDuo(new Value(0),new Position(0,0)));
        PositionValueDuo value = new PositionValueDuo(new Value(3),new Position(0,1));
        assertTrue(linesRule.check(values,value));
    }

    @Test
    public void testAddCorrectValueToEmptySet() {
        AmountOfLinesRule linesRule = new AmountOfLinesRule(2);
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist = {true,true,true,false,false,false,false,false,false};
        Vector<Boolean> boolvec = new Vector<>(Arrays.asList(boollist));
        values.add(new PositionValueDuo(new Value(0),new Position(0,0)));
        values.add(new PositionValueDuo(new Value(0),new Position(0,0)));
        PositionValueDuo value = new PositionValueDuo(new Value(3,boolvec),new Position(0,1));
        assertTrue(linesRule.check(values,value));
    }

    /*@Test
    public void testAddIncorrectValueToEmptySet() {
        AmountOfLinesRule linesRule = new AmountOfLinesRule(1);
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist = {true,true,true,true,false,false,true,false,false};
        Vector<Boolean> boolvec = new Vector<>(Arrays.asList(boollist));
        values.add(new PositionValueDuo(new Value(0),new Position(0,0)));
        values.add(new PositionValueDuo(new Value(0),new Position(0,0)));
        PositionValueDuo value = new PositionValueDuo(new Value(3,boolvec),new Position(0,1));
        assertFalse(linesRule.check(values,value));
    }*/

    @Test
    public void testAddEmptyValueToSet() {
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist1 = {true,true,true,false,false,false,false,false,false};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));
        PositionValueDuo value1 = new PositionValueDuo(new Value(3,boolvec1),new Position(0,1));
        values.add(new PositionValueDuo(new Value(0),new Position(0,0)));
        values.add(new PositionValueDuo(new Value(0),new Position(0,0)));
        values.add(value1);
        PositionValueDuo value2 = new PositionValueDuo(new Value(3),new Position(0,1));
        AmountOfLinesRule linesRule = new AmountOfLinesRule(2);
        assertTrue(linesRule.check(values,value2));
    }

    @Test
    public void testAddCorrectValueToSet() {
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist1 = {true,true,true,false,false,false,false,false,false};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));
        PositionValueDuo value1 = new PositionValueDuo(new Value(3,boolvec1),new Position(0,1));
        values.add(value1);
        values.add(new PositionValueDuo(new Value(0),new Position(0,0)));
        values.add(new PositionValueDuo(new Value(0),new Position(0,0)));
        Boolean[] boollist2 = {false,false,true,false,false,true,false,false,true};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        AmountOfLinesRule linesRule = new AmountOfLinesRule(2);
        PositionValueDuo value2 = new PositionValueDuo(new Value(3,boolvec2),new Position(0,1));
        assertTrue(linesRule.check(values,value2));
    }

    /*@Test
    public void testAddIncorrectValueToSet() {
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist1 = {true,true,true,false,false,false,false,false,false};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));
        PositionValueDuo value1 = new PositionValueDuo(new Value(3,boolvec1),new Position(0,1));
        values.add(value1);
        values.add(new PositionValueDuo(new Value(0),new Position(0,0)));
        values.add(new PositionValueDuo(new Value(0),new Position(0,0)));
        Boolean[] boollist2 = {true,true,true,false,false,true,false,false,true};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        PositionValueDuo value2 = new PositionValueDuo(new Value(3,boolvec2),new Position(0,1));
        AmountOfLinesRule linesRule = new AmountOfLinesRule(2);
        assertFalse(linesRule.check(values,value2));
    }*/

}
