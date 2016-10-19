package ar.fiuba.tdd.tp.model.rule.math;

import ar.fiuba.tdd.tp.model.cell.data.Position;
import ar.fiuba.tdd.tp.model.cell.data.PositionValueDuo;
import ar.fiuba.tdd.tp.model.cell.data.Value;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MultiplicationRuleTests {

    @Test
    public void testAddCorrectValueToEmptySet() {
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        MultiplicationRule mulRule = new MultiplicationRule(20);
        assertTrue(mulRule.check(values,new PositionValueDuo(new Value(5), new Position(0,0))));
    }

    @Test
    public void testAddCorrectValueToSet() {
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        MultiplicationRule mulRule = new MultiplicationRule(20);
        PositionValueDuo firstValue = new PositionValueDuo(new Value(5), new Position(0,0));
        PositionValueDuo secondValue = new PositionValueDuo(new Value(3), new Position(0,0));
        values.add(firstValue);
        assertTrue(mulRule.check(values,secondValue));
    }

    @Test
    public void testAddIncorrectValueToEmptySet() {
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        MultiplicationRule mulRule = new MultiplicationRule(20);
        PositionValueDuo firstValue = new PositionValueDuo(new Value(3), new Position(0,0));
        PositionValueDuo secondValue = new PositionValueDuo(new Value(9), new Position(0,0));
        values.add(firstValue);
        assertFalse(mulRule.check(values,secondValue));
    }

    @Test
    public void testRightCheckFinal() {
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        MultiplicationRule mulRule = new MultiplicationRule(10);
        values.add(new PositionValueDuo(new Value(5), new Position(0,0)));
        values.add(new PositionValueDuo(new Value(2), new Position(0,0)));
        assertTrue(mulRule.checkFinal(values));
    }

    @Test
    public void testWrongCheckFinal() {
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        MultiplicationRule mulRule = new MultiplicationRule(10);
        values.add(new PositionValueDuo(new Value(5), new Position(0,0)));
        assertFalse(mulRule.checkFinal(values));
    }
}
