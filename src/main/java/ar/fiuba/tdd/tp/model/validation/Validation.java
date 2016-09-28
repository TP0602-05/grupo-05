package ar.fiuba.tdd.tp.model.validation;

import ar.fiuba.tdd.tp.model.cell.Value;

public interface Validation {

    boolean validate(Value value);
}
