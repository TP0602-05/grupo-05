package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.Value;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class NoRepeatRuleTests {

    @Test
    public void testAddCorrectValueToSet() {
        ArrayList<Value> values = new ArrayList<>();
        NoRepeatRule noRepRule = new NoRepeatRule();
        Value firstValue = new Value(5);
        Value secondValue = new Value(4);
        values.add(firstValue);
        assertTrue(noRepRule.check(values,secondValue));
    }

    @Test
    public void testAddIncorrectValueToEmptySet() {
        ArrayList<Value> values = new ArrayList<>();
        NoRepeatRule noRepRule = new NoRepeatRule();
        Value firstValue = new Value(5);
        Value secondValue = new Value(5);
        values.add(firstValue);
        assertFalse(noRepRule.check(values,secondValue));
    }

    @Test
    public void testCheckFinal() {
        ArrayList<Value> values = new ArrayList<>();
        NoRepeatRule noRepRule = new NoRepeatRule();
        assertTrue(noRepRule.checkFinal(values));
    }
}
