package ar.fiuba.tdd.tp.model;

import ar.fiuba.tdd.tp.model.cell.Value;
import ar.fiuba.tdd.tp.model.rule.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class SetOfValuesTests {

    @Test
    public void testEmptySetOfValuesAcceptValues() {
        SetOfValues mySet = new SetOfValues();
        //Value myValue = new Value(3);
        //assertTrue(mySet.canInsertValue(myValue));
        assertTrue(mySet.isSetFinished());
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
        mySet.insertValue(new Value(7));
        mySet.insertValue(new Value(3));
        assertTrue(mySet.isSetFinished());
    }

    @Test
    public void testEmptySetOfValuesWithRuleSummationCanInsertCorrectValue() {
        SetOfValues mySet = new SetOfValues();
        mySet.insertRule(new SummationRule(15));
        assertTrue(mySet.canInsertValue(new Value(3)));
    }

    @Test
    public void testEmptySetOfValuesWithRuleSummationCantInsertIncorrectValue() {
        SetOfValues mySet = new SetOfValues();
        mySet.insertRule(new SummationRule(6));
        assertFalse(mySet.canInsertValue(new Value(8)));
    }

    @Test
    public void testSetOfValuesWithRuleSummationCanInsertTwoCorrectValue() {
        SetOfValues mySet = new SetOfValues();
        mySet.insertRule(new SummationRule(15));
        Value myValue1 = new Value(10);
        Value myValue2 = new Value(3);
        boolean result = true;
        if (mySet.canInsertValue(myValue1)) {
            mySet.insertValue(myValue1);
            if (mySet.canInsertValue(myValue2)) {
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
        mySet.insertValue(new Value(10));
        assertFalse(mySet.canInsertValue(new Value(8)));
    }

    @Test
    public void testEmptySetOfValuesWithNoRepeatRuleCanInsertValue() {
        SetOfValues mySet = new SetOfValues();
        mySet.insertRule(new NoRepeatRule());
        assertTrue(mySet.canInsertValue(new Value(3)));
    }

    @Test
    public void testSetOfValuesWithNoRepeatRuleCanInsertValueNoRepeated() {
        SetOfValues mySet = new SetOfValues();
        mySet.insertRule(new NoRepeatRule());
        mySet.canInsertValue(new Value(7));
        assertTrue(mySet.canInsertValue(new Value(3)));
    }

    @Test
    public void testSetOfValuesWithNoRepeatRuleCantInsertValueRepeated() {
        SetOfValues mySet = new SetOfValues();
        mySet.insertRule(new NoRepeatRule());
        mySet.insertValue(new Value(7));
        assertFalse(mySet.canInsertValue(new Value(7)));
    }
}
