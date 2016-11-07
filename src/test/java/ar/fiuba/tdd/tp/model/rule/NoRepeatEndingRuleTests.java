package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.Position;
import ar.fiuba.tdd.tp.model.cell.PositionValueDuo;
import ar.fiuba.tdd.tp.model.cell.Value;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NoRepeatEndingRuleTests {

    @Test
    public void testAddCorrectValueToSet() {
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        NoRepeatEndingRule noRepEndRule = new NoRepeatEndingRule();
        PositionValueDuo firstValue = new PositionValueDuo(new Value(5), new Position(0,0));
        PositionValueDuo secondValue = new PositionValueDuo(new Value(4), new Position(0,0));
        values.add(firstValue);
        assertTrue(noRepEndRule.check(values,secondValue));
    }

    @Test
    public void testAddIncorrectValueToEmptySet() {
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        NoRepeatEndingRule noRepEndRule = new NoRepeatEndingRule();
        PositionValueDuo firstValue = new PositionValueDuo(new Value(5), new Position(0,0));
        PositionValueDuo secondValue = new PositionValueDuo(new Value(5), new Position(0,0));
        values.add(firstValue);
        values.add(secondValue);
        assertFalse(noRepEndRule.checkFinal(values));
    }

    @Test
    public void testCheckFinalWithCeros() {
        PositionValueDuo firstValue = new PositionValueDuo(new Value(0), new Position(0,0));
        PositionValueDuo secondValue = new PositionValueDuo(new Value(0), new Position(0,0));
        PositionValueDuo thirdValue = new PositionValueDuo(new Value(1), new Position(0,0));
        PositionValueDuo forthValue = new PositionValueDuo(new Value(2), new Position(0,0));
        PositionValueDuo fifthValue = new PositionValueDuo(new Value(3), new Position(0,0));
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        values.add(firstValue);
        values.add(secondValue);
        values.add(thirdValue);
        values.add(forthValue);
        values.add(fifthValue);
        NoRepeatEndingRule noRepEndingRule = new NoRepeatEndingRule();
        assertTrue(noRepEndingRule.checkFinal(values));
    }
}
