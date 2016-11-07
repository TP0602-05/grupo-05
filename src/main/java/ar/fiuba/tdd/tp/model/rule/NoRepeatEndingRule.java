package ar.fiuba.tdd.tp.model.rule;


import ar.fiuba.tdd.tp.model.cell.PositionValueDuo;
import ar.fiuba.tdd.tp.model.cell.Value;

import java.util.ArrayList;

public class NoRepeatEndingRule implements Rule {

    public boolean check(ArrayList<PositionValueDuo> values, PositionValueDuo value) {
        return true;
    }

    public boolean checkFinal(ArrayList<PositionValueDuo> values) {
        ArrayList<Integer> arrayAux = new ArrayList<>();
        for (PositionValueDuo myValue: values ) {
            if (myValue.getValue().getValue() != 0) {
                if (arrayAux.contains(myValue.getValue().getValue())) {
                    return false;
                }
                arrayAux.add(myValue.getValue().getValue());
            }
        }
        return true;
    }

    public void printRule() {

    }
}
