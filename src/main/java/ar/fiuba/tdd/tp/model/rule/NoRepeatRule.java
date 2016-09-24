package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.Value;

import java.util.ArrayList;

public class NoRepeatRule implements Rule{

    public boolean check(ArrayList<Value> values, Value value) {
        return false;
    }

    public boolean checkFinal(ArrayList<Value> values) {
        return true;
    }
}
