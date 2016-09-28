package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.Value;

import java.util.ArrayList;

public interface Rule {

    boolean check(ArrayList<Value> values, Value value);

    boolean checkFinal(ArrayList<Value> values);

    void printRule();
}
