package ar.fiuba.tdd.tp.model.cell;

import java.util.Vector;

public class Cell {
    private boolean blocked;
    private Vector<Value> value;

    public Cell() {
        value = new Vector<>(1);
        this.blocked = false;
        this.value.addElement(new Value(0));
    }

    public Cell(Value value) {
        this.value = new Vector<>(1);
        this.blocked = true;
        this.value.addElement(value);
    }

    public Cell(Vector<Value> values) {
        this.blocked = true;
        this.value = values;
    }

    public int getAmountOfValues() {
        return this.value.size();
    }

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

    public void printCell() {
        this.value.elementAt(0).printValue();
    }
}
