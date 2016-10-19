package ar.fiuba.tdd.tp.model.validation;

import ar.fiuba.tdd.tp.model.cell.data.Value;

import org.junit.Test;

import static org.junit.Assert.*;

public class XtoYNumberValidationTests {

    @Test
    public void testValidateCorrectInBetweenValue() {
        XtoYNumberValidation validation = new XtoYNumberValidation(1,9);
        Value value = new Value(5);
        assertTrue(validation.validate(value));
    }

    @Test
    public void testValidateCorrectLimitValue() {
        XtoYNumberValidation validation = new XtoYNumberValidation(1,9);
        Value value = new Value(9);
        assertTrue(validation.validate(value));
    }

    @Test
    public void testDontValidateInorrectValue() {
        XtoYNumberValidation validation = new XtoYNumberValidation(1,9);
        Value value = new Value(10);
        assertFalse(validation.validate(value));
    }

}
