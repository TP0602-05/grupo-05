package ar.fiuba.tdd.tp.model.validation;

import ar.fiuba.tdd.tp.model.cell.Value;

/**
 * Checks if entered value verifies a certain condition,
 * specified by the classes implementing this interface
 */

public interface Validation {

    boolean validate(Value value);
}
