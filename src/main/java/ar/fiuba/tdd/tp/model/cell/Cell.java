package ar.fiuba.tdd.tp.model.cell;

import ar.fiuba.tdd.tp.view.Button;

import java.util.Vector;
import javax.swing.*;

/**
 * Holds an array of values and knows whether it can be blocked or not.
 */
public abstract class Cell {
    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    private boolean blocked;

    public void setValue(Vector<Value> value) {
        this.value = value;
    }

    public void setValue(Value value) {
        if ( ! this.isBlocked() ) {
            this.value.setElementAt(value,0);
        }
    }

    public void setBorders(Vector<Integer> borders) {
        this.borders = borders;
    }

    public Vector<Integer> getBorders() {
        return borders;
    }

    private Vector<Integer> borders;

    protected Vector<Value> value;

    public Cell() {}

    public abstract Button getView(int row, int col);

    public boolean isBlocked() {
        return this.blocked;
    }


    public Value getValue() {
        return this.value.elementAt(0);
    }

    public Vector<Value> getValues() {
        return this.value;
    }

    public String toString() {
        return this.value.toString();
    }

}
