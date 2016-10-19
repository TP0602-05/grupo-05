package ar.fiuba.tdd.tp.model.cell;

import java.util.Vector;

/**
 * Holds a value and is capable of comparing  itself to other values.
 */

public class Value {
    private Integer value;
    private Vector<Boolean> dots;
    private static final int NUM_DOTS = 9;

    private void initializeEmptyDots() {
        this.dots = new Vector<>(NUM_DOTS);
        for (int i = 0; i < NUM_DOTS; i++) {
            this.dots.add(false);
        }
    }

    public Value(Integer value, Vector<Boolean> theDots) {
        this.value = value;
        this.dots = theDots;
    }

    public Value(Integer value) {
        this.value = value;
        this.initializeEmptyDots();
    }

    public Value(Vector<Boolean> theDots) {
        this.dots = theDots;
        this.value = 0;
    }

    public Integer getValue() {
        return this.value;
    }

    public Vector<Boolean> getDots() {
        return this.dots;
    }

    public boolean isEqualTo(Value otherValue) {
        return ( this.value.equals(otherValue.getValue()) );
    }

    boolean isDotsEqualTo(Value otherValue) {
        for ( int i = 0; i < NUM_DOTS; i++ ) {
            if ( this.dots.elementAt(i) != otherValue.getDots().elementAt(i) ) {
                return false;
            }
        }
        return true;
    }

    public boolean areDotsEqualTo(Value otherValue) {
        boolean equal = true;
        for (int i = 0; i < NUM_DOTS; i++) {
            equal = (equal && (this.dots.elementAt(i) == otherValue.getDots().elementAt(i)));
        }
        return equal;
    }

    void combineDots(Value otherValue) {
        Vector<Boolean> newDots = new Vector<>();
        for ( int i = 0; i < NUM_DOTS; i++ ) {
            newDots.add( this.dots.elementAt(i) || otherValue.getDots().elementAt(i) );
        }
        this.dots = newDots;
    }

    void printValue() {
        System.out.println(this.value);
    }

    public String toString() {
        return this.value.toString();
    }

    public int getNumDots() {
        return this.NUM_DOTS;
    }

    public Value setDots(Vector<Boolean> dots1) {
        this.dots = dots1;
        return this;
    }
}

