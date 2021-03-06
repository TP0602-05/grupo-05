package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.PositionValueDuo;

import ar.fiuba.tdd.tp.model.cell.Value;

import java.util.ArrayList;

/**
 * Checks if values within a set follow a certain rule,
 * either by themselves or considering a new value.
 */
public interface Rule {

    //boolean check(ArrayList<Value> values, Value value);

    boolean check(ArrayList<PositionValueDuo> values, PositionValueDuo value);

    //boolean checkFinal(ArrayList<Value> values);

    boolean checkFinal(ArrayList<PositionValueDuo> values);

    void printRule();
}
