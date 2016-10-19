package ar.fiuba.tdd.tp.model.rule.circuits;

import ar.fiuba.tdd.tp.model.cell.data.PositionValueDuo;
import ar.fiuba.tdd.tp.model.rule.Rule;

import java.util.ArrayList;

/*
 * Check if a cell was previously visited before visiting it again
 */
public class NoRepeatCellRule implements Rule {
    public boolean check(ArrayList<PositionValueDuo> values, PositionValueDuo value) {
        return true;
    }


    public boolean checkFinal(ArrayList<PositionValueDuo> values) {
        return true;
    }

    public void printRule() {

    }
}
