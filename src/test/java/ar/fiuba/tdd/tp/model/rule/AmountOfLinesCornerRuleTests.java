package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.Position;
import ar.fiuba.tdd.tp.model.cell.PositionValueDuo;
import ar.fiuba.tdd.tp.model.cell.Value;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import static org.junit.Assert.*;

public class AmountOfLinesCornerRuleTests {

    @Test
    public void testAddCorrectValueToSetOne1() {
        AmountOfLinesCornerRule linesRule = new AmountOfLinesCornerRule(1);
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist1 = {true,false,false,false,true,false,false,false,true};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));
        PositionValueDuo value1 = new PositionValueDuo(new Value(0,boolvec1),new Position(0,0));
        assertTrue(linesRule.check(values,value1));
    }

    @Test
    public void testAddCorrectValueToSetOne() {
        AmountOfLinesCornerRule linesRule = new AmountOfLinesCornerRule(1);
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist1 = {false,false,true,false,true,false,true,false,false};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));
        PositionValueDuo value1 = new PositionValueDuo(new Value(0,boolvec1),new Position(0,0));
        assertTrue(linesRule.check(values,value1));
    }

    @Test
    public void testAddIncorrectValueToSetOne() {
        AmountOfLinesCornerRule linesRule = new AmountOfLinesCornerRule(0);
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist1 = {true,false,false,false,true,false,false,false,true};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));
        PositionValueDuo value1 = new PositionValueDuo(new Value(0,boolvec1),new Position(0,0));
        assertFalse(linesRule.check(values,value1));
    }

    @Test
    public void testAddCorrectValueToSetTwo1() {
        AmountOfLinesCornerRule linesRule = new AmountOfLinesCornerRule(2);
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist1 = {true,false,false,false,true,false,false,false,true};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));
        PositionValueDuo value1 = new PositionValueDuo(new Value(0,boolvec1),new Position(2,0));
        values.add(value1);
        Boolean[] boollist2 = {false,false,true,false,true,false,true,false,false};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        PositionValueDuo value2 = new PositionValueDuo(new Value(0,boolvec2),new Position(2,1));
        assertTrue(linesRule.check(values,value2));
    }

    @Test
    public void testAddCorrectValueToSetTwo2() {
        AmountOfLinesCornerRule linesRule = new AmountOfLinesCornerRule(1);
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist1 = {true,false,false,false,true,false,false,false,true};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));
        PositionValueDuo value1 = new PositionValueDuo(new Value(0,boolvec1),new Position(2,0));
        values.add(value1);
        Boolean[] boollist2 = {true,false,false,false,true,false,false,false,true};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        PositionValueDuo value2 = new PositionValueDuo(new Value(0,boolvec2),new Position(2,1));
        assertTrue(linesRule.check(values,value2));
    }

    @Test
    public void testAddIncorrectValueToSetTwo1() {
        AmountOfLinesCornerRule linesRule = new AmountOfLinesCornerRule(1);
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist1 = {true,false,false,false,true,false,false,false,true};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));
        PositionValueDuo value1 = new PositionValueDuo(new Value(0,boolvec1),new Position(2,0));
        values.add(value1);
        Boolean[] boollist2 = {false,false,true,false,true,false,true,false,false};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        PositionValueDuo value2 = new PositionValueDuo(new Value(0,boolvec2),new Position(2,1));
        assertFalse(linesRule.check(values,value2));
    }

    @Test
    public void testAddIncorrectValueToSetTwo2() {
        AmountOfLinesCornerRule linesRule = new AmountOfLinesCornerRule(0);
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist1 = {true,false,false,false,true,false,false,false,true};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));
        PositionValueDuo value1 = new PositionValueDuo(new Value(0,boolvec1),new Position(1,2));
        values.add(value1);
        Boolean[] boollist2 = {true,false,false,false,true,false,false,false,true};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        PositionValueDuo value2 = new PositionValueDuo(new Value(0,boolvec2),new Position(0,2));
        assertFalse(linesRule.check(values,value2));
    }

    @Test
    public void testAddCorrectValueToSetFour() {
        Boolean[] boollist1 = {true,false,false,false,true,false,false,false,true};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));
        Boolean[] boollist2 = {false,false,true,false,true,false,true,false,false};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        PositionValueDuo value1 = new PositionValueDuo(new Value(0,boolvec1),new Position(0,0));
        PositionValueDuo value3 = new PositionValueDuo(new Value(0,boolvec1),new Position(1,1));
        PositionValueDuo value4 = new PositionValueDuo(new Value(0,boolvec1),new Position(1,0));
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        values.add(value1);
        values.add(value3);
        values.add(value4);
        AmountOfLinesCornerRule linesRule = new AmountOfLinesCornerRule(3);
        PositionValueDuo value2 = new PositionValueDuo(new Value(0,boolvec2),new Position(0,1));
        assertTrue(linesRule.check(values,value2));
    }

    @Test
    public void testAddIncorrectValueToSetFour() {
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist1 = {true,false,false,false,true,false,false,false,true};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));
        Boolean[] boollist2 = {false,false,true,false,true,false,true,false,false};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        PositionValueDuo value1 = new PositionValueDuo(new Value(0,boolvec1),new Position(0,0));
        values.add(value1);
        PositionValueDuo value2 = new PositionValueDuo(new Value(0,boolvec2),new Position(0,1));
        PositionValueDuo value3 = new PositionValueDuo(new Value(0,boolvec1),new Position(1,1));
        values.add(value3);
        PositionValueDuo value4 = new PositionValueDuo(new Value(0,boolvec2),new Position(1,0));
        values.add(value4);
        AmountOfLinesCornerRule linesRule = new AmountOfLinesCornerRule(3);
        assertFalse(linesRule.check(values,value2));
    }

    @Test
    public void testAddCorrectValueToSetFinalFour() {
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist1 = {true,false,false,false,true,false,false,false,true};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));
        Boolean[] boollist2 = {false,false,true,false,true,false,true,false,false};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        PositionValueDuo value1 = new PositionValueDuo(new Value(0,boolvec1),new Position(0,0));
        values.add(value1);
        PositionValueDuo value2 = new PositionValueDuo(new Value(0,boolvec2),new Position(0,1));
        values.add(value2);
        PositionValueDuo value3 = new PositionValueDuo(new Value(0,boolvec1),new Position(1,1));
        values.add(value3);
        PositionValueDuo value4 = new PositionValueDuo(new Value(0,boolvec1),new Position(1,0));
        values.add(value4);
        AmountOfLinesCornerRule linesRule = new AmountOfLinesCornerRule(3);
        assertTrue(linesRule.checkFinal(values));
    }

    @Test
    public void testAddCorrectValueToSetFinalTwo1() {
        AmountOfLinesCornerRule linesRule = new AmountOfLinesCornerRule(2);
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        Boolean[] boollist1 = {true,false,false,false,true,false,false,false,true};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));
        PositionValueDuo value1 = new PositionValueDuo(new Value(0,boolvec1),new Position(2,0));
        values.add(value1);
        Boolean[] boollist2 = {false,false,true,false,true,false,true,false,false};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        PositionValueDuo value2 = new PositionValueDuo(new Value(0,boolvec2),new Position(2,1));
        values.add(value2);
        assertTrue(linesRule.checkFinal(values));
    }

}


