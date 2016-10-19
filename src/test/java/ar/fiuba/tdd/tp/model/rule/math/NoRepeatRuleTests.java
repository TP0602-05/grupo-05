package ar.fiuba.tdd.tp.model.rule.math;

import ar.fiuba.tdd.tp.model.cell.data.Position;
import ar.fiuba.tdd.tp.model.cell.data.PositionValueDuo;
import ar.fiuba.tdd.tp.model.cell.data.Value;

import ar.fiuba.tdd.tp.model.rule.sets.NoRepeatRule;
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
