package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.Value;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SummationRuleTests {

    @Test
    public void testAddCorrectValueToEmptySet() {
        ArrayList<Value> values = new ArrayList<>();
        SummationRule sumRule = new SummationRule(20);
        Value value = new Value(5);
        assertTrue(sumRule.check(values,value));
    }

    @Test
    public void testAddCorrectValueToSet() {
        ArrayList<Value> values = new ArrayList<>();
        SummationRule sumRule = new SummationRule(20);
        Value firstValue = new Value(5);
        Value secondValue = new Value(10);
        values.add(firstValue);
        assertTrue(sumRule.check(values,secondValue));
    }

    @Test
    public void testAddIncorrectValueToEmptySet() {
        ArrayList<Value> values = new ArrayList<>();
        SummationRule sumRule = new SummationRule(20);
        Value firstValue = new Value(15);
        Value secondValue = new Value(10);
        values.add(firstValue);
        assertFalse(sumRule.check(values,secondValue));
    }

    @Test
    public void testRightCheckFinal() {
        ArrayList<Value> values = new ArrayList<>();
        SummationRule sumRule = new SummationRule(10);
        Value value = new Value(10);
        values.add(value);
        assertTrue(sumRule.checkFinal(values));
    }

    @Test
    public void testWrongCheckFinal() {
        ArrayList<Value> values = new ArrayList<>();
        SummationRule sumRule = new SummationRule(10);
        Value value = new Value(8);
        values.add(value);
        assertFalse(sumRule.checkFinal(values));
    }
}
