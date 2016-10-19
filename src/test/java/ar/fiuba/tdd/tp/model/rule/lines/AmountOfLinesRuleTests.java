package ar.fiuba.tdd.tp.model.rule.lines;

import ar.fiuba.tdd.tp.model.cell.data.Position;
import ar.fiuba.tdd.tp.model.cell.data.PositionValueDuo;
import ar.fiuba.tdd.tp.model.cell.data.Value;

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
        PositionValueDuo value = new PositionValueDuo(new Value(3),new Position(0,1));
        assertTrue(linesRule.check(values,value));
    }

    @Test
    public void testAddCorrectValueToEmptySet() {
        AmountOfLinesRule linesRule = new AmountOfLinesRule(2);
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist = {true,true,true,false,false,false,false,false,false};
        Vector<Boolean> boolvec = new Vector<>(Arrays.asList(boollist));
        PositionValueDuo value = new PositionValueDuo(new Value(3,boolvec),new Position(0,1));
        assertTrue(linesRule.check(values,value));
    }

    @Test
    public void testAddIncorrectValueToEmptySet() {
        AmountOfLinesRule linesRule = new AmountOfLinesRule(1);
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist = {true,true,true,true,false,false,true,false,false};
        Vector<Boolean> boolvec = new Vector<>(Arrays.asList(boollist));
        PositionValueDuo value = new PositionValueDuo(new Value(3,boolvec),new Position(0,1));
        assertFalse(linesRule.check(values,value));
    }

    @Test
    public void testAddEmptyValueToSet() {
        AmountOfLinesRule linesRule = new AmountOfLinesRule(2);
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist1 = {true,true,true,false,false,false,false,false,false};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));
        PositionValueDuo value1 = new PositionValueDuo(new Value(3,boolvec1),new Position(0,1));
        values.add(value1);
        PositionValueDuo value2 = new PositionValueDuo(new Value(3),new Position(0,1));
        assertTrue(linesRule.check(values,value2));
    }

    @Test
    public void testAddCorrectValueToSet() {
        AmountOfLinesRule linesRule = new AmountOfLinesRule(2);
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist1 = {true,true,true,false,false,false,false,false,false};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));
        PositionValueDuo value1 = new PositionValueDuo(new Value(3,boolvec1),new Position(0,1));
        values.add(value1);
        Boolean[] boollist2 = {false,false,true,false,false,true,false,false,true};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        PositionValueDuo value2 = new PositionValueDuo(new Value(3,boolvec2),new Position(0,1));
        assertTrue(linesRule.check(values,value2));
    }

    @Test
    public void testAddIncorrectValueToSet() {
        AmountOfLinesRule linesRule = new AmountOfLinesRule(2);
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist1 = {true,true,true,false,false,false,false,false,false};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));
        PositionValueDuo value1 = new PositionValueDuo(new Value(3,boolvec1),new Position(0,1));
        values.add(value1);
        Boolean[] boollist2 = {true,true,true,false,false,true,false,false,true};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        PositionValueDuo value2 = new PositionValueDuo(new Value(3,boolvec2),new Position(0,1));
        assertFalse(linesRule.check(values,value2));
    }

}
