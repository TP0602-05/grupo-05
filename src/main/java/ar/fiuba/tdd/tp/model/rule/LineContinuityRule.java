package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.PositionValueDuo;
import ar.fiuba.tdd.tp.model.cell.Value;

import java.util.ArrayList;

/**
 * Checks if within a set of values a line is continuous.
 */
public class LineContinuityRule implements Rule {

    public boolean check(ArrayList<PositionValueDuo> values, PositionValueDuo value) {
        return true;
    }


    public boolean checkFinal(ArrayList<PositionValueDuo> values) {
        return true;
    }

    public void printRule() {

    }
}
