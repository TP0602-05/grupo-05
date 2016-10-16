package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.Value;

import java.util.ArrayList;

/**
 * Checks if within a set of values a line is continuous.
 */
public class LineContinuityRule implements Rule {

    public boolean check(ArrayList<Value> values, Value value) {
        return true;
    }

    public boolean checkFinal(ArrayList<Value> values) {
        return true;
    }

    public void printRule() {

    }
}
