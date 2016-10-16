package ar.fiuba.tdd.tp.model.cell;

import javax.swing.*;
import java.util.Vector;

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

    private Vector<Value> value;

    public Cell() {}

    public abstract JButton getView(int row, int col);

    public boolean isBlocked() {
        return this.blocked;
    }

    public void setValue(Value value) {
        if ( ! this.isBlocked() ) {
            this.value.setElementAt(value,0);
        }
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

   /* public void printCell() {
        this.value.elementAt(0).printValue();
    }*/
}
