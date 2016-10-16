package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.Position;
import ar.fiuba.tdd.tp.model.cell.PositionValueDuo;
import ar.fiuba.tdd.tp.model.cell.Value;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class NoRepeatRuleTests {

    @Test
    public void testAddCorrectValueToSet() {
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        NoRepeatRule noRepRule = new NoRepeatRule();
        PositionValueDuo firstValue = new PositionValueDuo(new Value(5), new Position(0,0));
        PositionValueDuo secondValue = new PositionValueDuo(new Value(4), new Position(0,0));
        values.add(firstValue);
        assertTrue(noRepRule.check(values,secondValue));
    }

    @Test
    public void testAddIncorrectValueToEmptySet() {
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        NoRepeatRule noRepRule = new NoRepeatRule();
        PositionValueDuo firstValue = new PositionValueDuo(new Value(5), new Position(0,0));
        PositionValueDuo secondValue = new PositionValueDuo(new Value(5), new Position(0,0));
        values.add(firstValue);
        assertFalse(noRepRule.check(values,secondValue));
    }

    @Test
    public void testCheckFinal() {
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        NoRepeatRule noRepRule = new NoRepeatRule();
        assertTrue(noRepRule.checkFinal(values));
    }
}
