package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.Position;
import ar.fiuba.tdd.tp.model.cell.PositionValueDuo;
import ar.fiuba.tdd.tp.model.cell.Value;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SummationRuleTests {

    @Test
    public void testAddCorrectValueToEmptySet() {
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        SummationRule sumRule = new SummationRule(20);
        PositionValueDuo value = new PositionValueDuo(new Value(5), new Position(0,0));
        assertTrue(sumRule.check(values,value));
    }

    @Test
    public void testAddCorrectValueToSet() {
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        SummationRule sumRule = new SummationRule(20);
        PositionValueDuo firstValue = new PositionValueDuo(new Value(5), new Position(0,0));
        PositionValueDuo secondValue = new PositionValueDuo(new Value(10), new Position(0,0));
        values.add(firstValue);
        assertTrue(sumRule.check(values,secondValue));
    }

    @Test
    public void testAddIncorrectValueToEmptySet() {
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        SummationRule sumRule = new SummationRule(20);
        PositionValueDuo firstValue = new PositionValueDuo(new Value(15), new Position(0,0));
        PositionValueDuo secondValue = new PositionValueDuo(new Value(10), new Position(0,0));
        values.add(firstValue);
        assertFalse(sumRule.check(values,secondValue));
    }

    @Test
    public void testRightCheckFinal() {
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        SummationRule sumRule = new SummationRule(10);
        PositionValueDuo value = new PositionValueDuo(new Value(10), new Position(0,0));
        values.add(value);
        assertTrue(sumRule.checkFinal(values));
    }

    @Test
    public void testWrongCheckFinal() {
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        SummationRule sumRule = new SummationRule(10);
        PositionValueDuo value = new PositionValueDuo(new Value(8), new Position(0,0));
        values.add(value);
        assertFalse(sumRule.checkFinal(values));
    }
}
