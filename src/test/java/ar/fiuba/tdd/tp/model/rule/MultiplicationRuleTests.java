package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.Value;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MultiplicationRuleTests {

    @Test
    public void testAddCorrectValueToEmptySet() {
        ArrayList<Value> values = new ArrayList<>();
        MultiplicationRule mulRule = new MultiplicationRule(20);
        Value value = new Value(5);
        assertTrue(mulRule.check(values,value));
    }

    @Test
    public void testAddCorrectValueToSet() {
        ArrayList<Value> values = new ArrayList<>();
        MultiplicationRule mulRule = new MultiplicationRule(20);
        Value firstValue = new Value(5);
        Value secondValue = new Value(3);
        values.add(firstValue);
        assertTrue(mulRule.check(values,secondValue));
    }

    @Test
    public void testAddIncorrectValueToEmptySet() {
        ArrayList<Value> values = new ArrayList<>();
        MultiplicationRule mulRule = new MultiplicationRule(20);
        Value firstValue = new Value(3);
        Value secondValue = new Value(9);
        values.add(firstValue);
        assertFalse(mulRule.check(values,secondValue));
    }

    @Test
    public void testRightCheckFinal() {
        ArrayList<Value> values = new ArrayList<>();
        MultiplicationRule mulRule = new MultiplicationRule(10);
        values.add(new Value(5));
        values.add(new Value(2));
        assertTrue(mulRule.checkFinal(values));
    }

    @Test
    public void testWrongCheckFinal() {
        ArrayList<Value> values = new ArrayList<>();
        MultiplicationRule mulRule = new MultiplicationRule(10);
        values.add(new Value(5));
        assertFalse(mulRule.checkFinal(values));
    }
}
