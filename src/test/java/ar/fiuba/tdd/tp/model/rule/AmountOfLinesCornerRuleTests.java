package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.Position;
import ar.fiuba.tdd.tp.model.cell.PositionValueDuo;
import ar.fiuba.tdd.tp.model.cell.Value;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Vector;

import static org.junit.Assert.*;

public class AmountOfLinesCornerRuleTests {

    @Test
    public void testTransformValuesForOne() {
        AmountOfLinesCornerRule cornRule = new AmountOfLinesCornerRule(2);
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        PositionValueDuo value = new PositionValueDuo(new Value(3),new Position(0,0));
        values.add(value);
        Vector<PositionValueDuo> vec = cornRule.transformValuesForOne(values);
        assertTrue(vec.elementAt(1).getValue().isEqualTo(value.getValue()));
    }

    @Test
    public void testTransformValuesForOne2() {
        AmountOfLinesCornerRule cornRule = new AmountOfLinesCornerRule(2);
        ArrayList<PositionValueDuo> values = new ArrayList<>();
        PositionValueDuo value = new PositionValueDuo(new Value(3),new Position(0,3));
        values.add(value);
        Vector<PositionValueDuo> vec = cornRule.transformValuesForOne(values);
        assertTrue(vec.elementAt(2).getValue().isEqualTo(value.getValue()));
    }

}


