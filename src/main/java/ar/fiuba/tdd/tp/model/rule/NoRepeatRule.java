package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.Position;
import ar.fiuba.tdd.tp.model.cell.PositionValueDuo;
import ar.fiuba.tdd.tp.model.cell.Value;

import java.util.ArrayList;

/**
 * Checks if values within a set are repeated or not.
 */
public class NoRepeatRule implements Rule{

    public boolean check(ArrayList<PositionValueDuo> values, PositionValueDuo value) {
        boolean notRepeated = true;
        for (PositionValueDuo myValue: values ) {
            if (myValue.getValue().isEqualTo(value.getValue())) {
                notRepeated = false;
            }
        }
        return notRepeated;
    }


    public boolean checkFinal(ArrayList<PositionValueDuo> values) {
        for (PositionValueDuo value: values) {
            if (value.getValue().isEqualTo(new Value(-1))) {
                return false;
            }
        }
        return true;
    }

    /*
    public boolean check(ArrayList<Value> values, Value value) {
        boolean notRepeated = true;
        for (Value myValue: values ) {
            if (myValue.isEqualTo(value)) {
                notRepeated = false;
            }
        }
        return notRepeated;
    }

    public boolean checkFinal(ArrayList<Value> values) {
        for (Value value: values) {
            if (value.isEqualTo(new Value(0))) {
                return false;
            }
        }
        return true;
    }
    */

    public void printRule() {
        System.out.println("NO repeteable");
    }
}
