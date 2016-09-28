package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.Value;

import java.util.ArrayList;

public class NoRepeatRule implements Rule{

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
        return true;
    }
}
