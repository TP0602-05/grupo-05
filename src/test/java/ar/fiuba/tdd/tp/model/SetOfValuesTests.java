package ar.fiuba.tdd.tp.model;

import ar.fiuba.tdd.tp.model.cell.Position;
import ar.fiuba.tdd.tp.model.cell.PositionValueDuo;
import ar.fiuba.tdd.tp.model.cell.Value;
import ar.fiuba.tdd.tp.model.rule.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class SetOfValuesTests {

    @Test
    public void testEmptySetOfValuesAcceptValues() {
        SetOfValues mySet = new SetOfValues();
        PositionValueDuo myValue = new PositionValueDuo(new Value(3), new Position(0,0));
        assertTrue("Test testEmptySetOfValuesAcceptValues OK",mySet.canInsertValue(myValue,
                new PositionValueDuo(new Value(2), new Position(0,0))));
    }

    @Test
    public void testEmptySetOfValuesWithoutRulesIsFinished() {
        SetOfValues mySet = new SetOfValues();
        assertTrue(mySet.isSetFinished());
    }

    @Test
    public void testSetOfValuesWithRuleSummationIsFinished() {
        SetOfValues mySet = new SetOfValues();
        mySet.insertRule(new SummationRule(10));
        mySet.insertValue(new PositionValueDuo(new Value(7), new Position(0,0)));
        mySet.insertValue(new PositionValueDuo(new Value(3), new Position(0,0)));
        assertTrue(mySet.isSetFinished());
    }

    @Test
    public void testEmptySetOfValuesWithRuleSummationCanInsertCorrectValue() {
        SetOfValues mySet = new SetOfValues();
        mySet.insertRule(new SummationRule(15));
        assertTrue(mySet.canInsertValue(new PositionValueDuo(new Value(3), new Position(0,0)),
                new PositionValueDuo(new Value(2), new Position(0,0))));
    }

    @Test
    public void testEmptySetOfValuesWithRuleSummationCantInsertIncorrectValue() {
        SetOfValues mySet = new SetOfValues();
        mySet.insertRule(new SummationRule(6));
        assertTrue(mySet.canInsertValue(new PositionValueDuo(new Value(8), new Position(0,0)),
                new PositionValueDuo(new Value(2), new Position(0,0))));
    }

    @Test
    public void testSetOfValuesWithRuleSummationCanInsertTwoCorrectValue() {
        SetOfValues mySet = new SetOfValues();
        mySet.insertRule(new SummationRule(15));
        PositionValueDuo myValue1 = new PositionValueDuo(new Value(10), new Position(0,0));
        PositionValueDuo myValue2 = new PositionValueDuo(new Value(3), new Position(0,0));
        boolean result = true;
        if (mySet.canInsertValue(myValue1, new PositionValueDuo(new Value(2), new Position(0,0)))) {
            mySet.insertValue(myValue1);
            if (mySet.canInsertValue(myValue2, new PositionValueDuo(new Value(2), new Position(0,0)))) {
                mySet.insertValue(myValue2);
            } else {
                result = false;
            }
        } else {
            result = false;
        }
        assertTrue(result);
    }

    @Test
    public void testSetOfValuesWithRuleSummationCantInsertIncorrectValueAfterInsertOneCorrect() {
        SetOfValues mySet = new SetOfValues();
        mySet.insertRule(new SummationRule(15));
        mySet.insertValue(new PositionValueDuo(new Value(10), new Position(0,0)));
        assertTrue(mySet.canInsertValue(new PositionValueDuo(new Value(8), new Position(0,0)),
                new PositionValueDuo(new Value(2), new Position(2,0))));
    }

    @Test
    public void testEmptySetOfValuesWithNoRepeatRuleCanInsertValue() {
        SetOfValues mySet = new SetOfValues();
        mySet.insertRule(new NoRepeatRule());
        assertTrue(mySet.canInsertValue(new PositionValueDuo(new Value(3), new Position(0,0)),
                new PositionValueDuo(new Value(2), new Position(0,0))));
    }

    @Test
    public void testSetOfValuesWithNoRepeatRuleCanInsertValueNoRepeated() {
        SetOfValues mySet = new SetOfValues();
        mySet.insertRule(new NoRepeatRule());
        mySet.insertValue(new PositionValueDuo(new Value(7), new Position(0,0)));
        assertTrue(mySet.canInsertValue(new PositionValueDuo(new Value(3), new Position(0,0)),
                new PositionValueDuo(new Value(2), new Position(0,0))));
    }

    @Test
    public void testSetOfValuesWithNoRepeatRuleCantInsertValueRepeated() {
        SetOfValues mySet = new SetOfValues();
        mySet.insertRule(new NoRepeatRule());
        mySet.insertValue(new PositionValueDuo(new Value(7), new Position(0,0)));
        assertFalse(mySet.canInsertValue(new PositionValueDuo(new Value(7), new Position(0,0)),
                new PositionValueDuo(new Value(2), new Position(3,0))));
    }

    @Test
    public void testSetOfValuesDeleteValue() {
        SetOfValues mySet = new SetOfValues();
        mySet.insertRule(new NoRepeatRule());
        mySet.insertValue(new PositionValueDuo(new Value(7), new Position(0,0)));
        mySet.deleteValue(new PositionValueDuo(new Value(7), new Position(0,0)));
        assertTrue(mySet.canInsertValue(new PositionValueDuo(new Value(7), new Position(0,0)),
                new PositionValueDuo(new Value(2), new Position(0,0))));
    }

    @Test
    public void testSetOfValuesDeleteMoreValues() {
        SetOfValues mySet = new SetOfValues();
        mySet.insertRule(new NoRepeatRule());
        mySet.insertValue(new PositionValueDuo(new Value(7), new Position(0,0)));
        mySet.insertValue(new PositionValueDuo(new Value(6), new Position(0,0)));
        mySet.insertValue(new PositionValueDuo(new Value(5), new Position(1,1)));
        mySet.insertValue(new PositionValueDuo(new Value(4), new Position(0,0)));
        mySet.deleteValue(new PositionValueDuo(new Value(5), new Position(1,1)));
        assertTrue(mySet.canInsertValue(new PositionValueDuo(new Value(5), new Position(1,1)),
                new PositionValueDuo(new Value(2), new Position(4,0))));
    }
}
