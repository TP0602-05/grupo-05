package ar.fiuba.tdd.tp.model.cell;

import java.util.Arrays;
import java.util.Vector;

/**
 * Holds a value and is capable of comparing  itself to other values.
 */

public class Value {
    private Integer value;
    private Vector<Boolean> dots;
    private Vector<Integer> borderDots;
    private static final int NUM_DOTS = 9;

    private static final int UP_LEFT_BORDER = 0;
    private static final int UP_BORDER = 1;
    private static final int UP_RIGHT_BORDER = 2;
    private static final int LEFT_BORDER = 3;
    private static final int CENTER = 4;
    private static final int RIGHT_BORDER = 5;
    private static final int DOWN_LEFT_BORDER = 6;
    private static final int DOWN_BORDER = 7;
    private static final int DOWN_RIGHT_BORDER = 8;


    private void initializeEmptyDots() {
        this.dots = new Vector<>(NUM_DOTS);
        for (int i = 0; i < NUM_DOTS; i++) {
            this.dots.add(false);
        }
    }

    private void initializeEmptyBorderDots() {
        this.borderDots = new Vector<>(NUM_DOTS);
        for (int i = 0; i < NUM_DOTS; i++) {
            this.borderDots.add(0);
        }
    }

    public Value(Integer value, Vector<Boolean> theDots) {
        this.value = value;
        this.dots = theDots;
        this.initializeEmptyBorderDots();
    }

    public Value(Integer value) {
        this.value = value;
        this.initializeEmptyDots();
        this.initializeEmptyBorderDots();
    }

    public Value(Vector<Boolean> theDots) {
        this.dots = theDots;
        this.value = 0;
        this.initializeEmptyBorderDots();
    }

    public Integer getValue() {
        return this.value;
    }

    public Vector<Boolean> getDots() {
        return this.dots;
    }

    public Vector<Boolean> getDotsWithBorders() {
        Vector<Boolean> dotsBorders = new Vector<>();
        for (int i = 0; i < NUM_DOTS; i++) {
            dotsBorders.add( this.dots.elementAt(i) || (this.borderDots.elementAt(i) > 0) );
        }
        return dotsBorders;
    }

    public Value getBorderValueAt(int border) {
        Boolean[] valueDots;
        if (border < 4) {
            valueDots = getBorderValueFirst(border);
        } else {
            valueDots = getBorderValueSecond(border);
        }
        /*switch (border) {
            case 0:
                valueDots = new Boolean[] {false, false, false, false, false, false, false, false,
                        this.dots.elementAt(UP_LEFT_BORDER)};
                break;
            case 1:
                valueDots = new Boolean[]{false, false, false, false, false, false,
                        this.dots.elementAt(UP_LEFT_BORDER),
                        this.dots.elementAt(UP_BORDER),
                        this.dots.elementAt(UP_RIGHT_BORDER)};
                break;
            case 2:
                valueDots = new Boolean[]{false, false, false, false, false, false,
                        this.dots.elementAt(UP_RIGHT_BORDER), false, false};
                break;
            case 3:
                valueDots = new Boolean[]{false, false,
                        this.dots.elementAt(UP_LEFT_BORDER),
                        false, false,
                        this.dots.elementAt(LEFT_BORDER),
                        false, false,
                        this.dots.elementAt(DOWN_LEFT_BORDER)};
                break;
            case 4:
                valueDots = new Boolean[]{this.dots.elementAt(UP_RIGHT_BORDER),
                        false, false,
                        this.dots.elementAt(RIGHT_BORDER),
                        false, false,
                        this.dots.elementAt(DOWN_RIGHT_BORDER),
                        false, false };
                break;
            case 5:
                valueDots = new Boolean[]{ false, false,
                        this.dots.elementAt(DOWN_LEFT_BORDER),
                        false, false, false, false, false, false };
                break;
            case 6:
                valueDots = new Boolean[]{this.dots.elementAt(DOWN_LEFT_BORDER),
                        this.dots.elementAt(DOWN_BORDER),
                        this.dots.elementAt(DOWN_RIGHT_BORDER),
                        false, false, false, false, false, false};
                break;
            case 7:
                valueDots = new Boolean[] {this.dots.elementAt(DOWN_RIGHT_BORDER),
                        false, false, false, false, false, false, false, false};
                break;
            default:
                valueDots = new Boolean[] {false, false, false, false, false, false, false, false, false};
        }
        */
        Vector<Boolean> myDots = new Vector<>(Arrays.asList(valueDots));
        return new Value(myDots);
    }

    private Boolean[] getBorderValueFirst(int border) {
        Boolean[] valueDots;
        switch (border) {
            case 0:
                valueDots = new Boolean[] {false, false, false, false, false, false, false, false,
                        this.dots.elementAt(UP_LEFT_BORDER)};
                break;
            case 1:
                valueDots = new Boolean[]{false, false, false, false, false, false,
                        this.dots.elementAt(UP_LEFT_BORDER),
                        this.dots.elementAt(UP_BORDER),
                        this.dots.elementAt(UP_RIGHT_BORDER)};
                break;
            case 2:
                valueDots = new Boolean[]{false, false, false, false, false, false,
                        this.dots.elementAt(UP_RIGHT_BORDER), false, false};
                break;
            case 3:
                valueDots = new Boolean[]{false, false,
                        this.dots.elementAt(UP_LEFT_BORDER),
                        false, false,
                        this.dots.elementAt(LEFT_BORDER),
                        false, false,
                        this.dots.elementAt(DOWN_LEFT_BORDER)};
                break;
            default:
                valueDots = new Boolean[] {false, false, false, false, false, false, false, false, false};
        }
        return valueDots;
    }

    private Boolean[] getBorderValueSecond(int border) {
        Boolean[] valueDots;
        switch (border) {
            case 4:
                valueDots = new Boolean[]{this.dots.elementAt(UP_RIGHT_BORDER),
                        false, false,
                        this.dots.elementAt(RIGHT_BORDER),
                        false, false,
                        this.dots.elementAt(DOWN_RIGHT_BORDER),
                        false, false };
                break;
            case 5:
                valueDots = new Boolean[]{ false, false,
                        this.dots.elementAt(DOWN_LEFT_BORDER),
                        false, false, false, false, false, false };
                break;
            case 6:
                valueDots = new Boolean[]{this.dots.elementAt(DOWN_LEFT_BORDER),
                        this.dots.elementAt(DOWN_BORDER),
                        this.dots.elementAt(DOWN_RIGHT_BORDER),
                        false, false, false, false, false, false};
                break;
            case 7:
                valueDots = new Boolean[] {this.dots.elementAt(DOWN_RIGHT_BORDER),
                        false, false, false, false, false, false, false, false};
                break;
            default:
                valueDots = new Boolean[] {false, false, false, false, false, false, false, false, false};
        }
        return valueDots;
    }

    public void updateBorders(Value newBorders, int sumValue) {
        Integer newValue;
        for (int i = 0; i < NUM_DOTS; i++) {
            if ( newBorders.getDots().elementAt(i) ) {
                newValue = this.borderDots.elementAt(i) + sumValue;
                this.borderDots.set(i, newValue);
            }
        }
    }

    Vector<Integer> getBorderDots() {
        return this.borderDots;
    }

    public boolean isEqualTo(Value otherValue) {
        return ( this.value.equals(otherValue.getValue()) );
    }

    public boolean areDotsEqualTo(Value otherValue) {
        boolean equal = true;
        for (int i = 0; i < NUM_DOTS; i++) {
            equal = (equal && (this.dots.elementAt(i) == otherValue.getDots().elementAt(i)));
        }
        return equal;
    }

    public void combineDots(Value otherValue) {
        //System.out.println("before combine");
        //System.out.println(this.dots);
        Vector<Boolean> newDots = new Vector<>();
        for ( int i = 0; i < NUM_DOTS; i++ ) {
            newDots.add( this.dots.elementAt(i) || otherValue.getDots().elementAt(i) );
        }
        this.dots = newDots;
        //System.out.println("after combine");
        //System.out.println(this.dots);
    }

    void printValue() {
        System.out.println(this.value);
    }

    public void printBorders() {
        System.out.println(this.borderDots.toString());
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

    public Value emptyValue() {
        Boolean[] valueDots = new Boolean[] {false, false, false, false, false, false, false, false, false};
        Value newValue = new Value(0, new Vector<>(Arrays.asList(valueDots)));
        newValue.borderDots = this.borderDots;
        return newValue;
    }

    public void updateInternBorders(Value prevValue) {
        this.borderDots = prevValue.borderDots;
    }

    public Value copyValue() {
        Vector<Boolean> cpBoolean = new Vector<>();
        for (int i = 0; i < this.dots.size(); i++) {
            cpBoolean.add(this.dots.elementAt(i));
        }
        return new Value(cpBoolean);
    }
}

