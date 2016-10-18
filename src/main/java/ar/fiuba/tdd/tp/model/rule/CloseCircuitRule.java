package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.PositionValueDuo;

import java.util.ArrayList;

/**
* Checks if the circuit is closed.
*/
public class CloseCircuitRule implements Rule {
    public boolean check(ArrayList<PositionValueDuo> values, PositionValueDuo value) {
        return true;
    }


    public boolean checkFinal(ArrayList<PositionValueDuo> values) {
        return true;
    }

    public void printRule() {

    }
}

