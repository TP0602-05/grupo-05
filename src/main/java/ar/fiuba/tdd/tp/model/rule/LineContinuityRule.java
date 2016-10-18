package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.PositionValueDuo;
import ar.fiuba.tdd.tp.model.cell.Value;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Checks if within a set of values a line is continuous.
 */
public class LineContinuityRule implements Rule {

    public boolean check(ArrayList<PositionValueDuo> values, PositionValueDuo value) {

        ArrayList<PositionValueDuo> valuesNext = getListOfNext(values,value);
        return (checkAdjacentCells(valuesNext,value)
                || (checkCornerCells(valuesNext,value))
                /*|| (checkCornerAdjacentDots(valuesNext,value))*/);
    }

    private ArrayList<PositionValueDuo> getListOfNext(ArrayList<PositionValueDuo> values, PositionValueDuo value) {
        ArrayList<PositionValueDuo> valuesNext = new ArrayList<>();
        for (PositionValueDuo val: values) {
            if (value.getPos().isNext(val.getPos())) {
                valuesNext.add(val);
            }
        }
        return valuesNext;
    }


    private boolean checkAdjacentCells(ArrayList<PositionValueDuo> values, PositionValueDuo value) {
        Vector<Value> vecValues = getTransversalValues(values,value);
        return ((checkOneContinuousValue(value.getValue(),vecValues.elementAt(0),0,6))
                || (checkOneContinuousValue(value.getValue(),vecValues.elementAt(0),1,7))
                || (checkOneContinuousValue(value.getValue(),vecValues.elementAt(0),2,8))
                || (checkOneContinuousValue(value.getValue(),vecValues.elementAt(1),2,0))
                || (checkOneContinuousValue(value.getValue(),vecValues.elementAt(1),5,3))
                || (checkOneContinuousValue(value.getValue(),vecValues.elementAt(1),8,6))
                || (checkOneContinuousValue(value.getValue(),vecValues.elementAt(2),8,2))
                || (checkOneContinuousValue(value.getValue(),vecValues.elementAt(2),7,1))
                || (checkOneContinuousValue(value.getValue(),vecValues.elementAt(2),6,0))
                || (checkOneContinuousValue(value.getValue(),vecValues.elementAt(3),0,2))
                || (checkOneContinuousValue(value.getValue(),vecValues.elementAt(3),3,5))
                || (checkOneContinuousValue(value.getValue(),vecValues.elementAt(3),6,8)));
    }

    /*private boolean checkCornerAdjacentDots(ArrayList<PositionValueDuo> values, PositionValueDuo value) {
        Vector<Value> vecValues = getTransversalValues(values,value);
        return ((checkOneContinuousValue(value.getValue(),vecValues.elementAt(0),0,6))
                || (checkOneContinuousValue(value.getValue(),vecValues.elementAt(0),2,8))
                || (checkOneContinuousValue(value.getValue(),vecValues.elementAt(1),2,0))
                || (checkOneContinuousValue(value.getValue(),vecValues.elementAt(1),8,6))
                || (checkOneContinuousValue(value.getValue(),vecValues.elementAt(2),8,2))
                || (checkOneContinuousValue(value.getValue(),vecValues.elementAt(2),6,0))
                || (checkOneContinuousValue(value.getValue(),vecValues.elementAt(3),0,2))
                || (checkOneContinuousValue(value.getValue(),vecValues.elementAt(3),6,8)));
    }
    */
    private boolean checkCornerCells(ArrayList<PositionValueDuo> values, PositionValueDuo value) {
        Vector<Value> vecValues = getCornerValues(values,value);
        return ((checkOneContinuousValue(value.getValue(),vecValues.elementAt(0),0,8))
                || (checkOneContinuousValue(value.getValue(),vecValues.elementAt(1),2,6))
                || (checkOneContinuousValue(value.getValue(),vecValues.elementAt(2),8,0))
                || (checkOneContinuousValue(value.getValue(),vecValues.elementAt(3),6,2)));
    }

    private Vector<Value> getTransversalValues(ArrayList<PositionValueDuo> values, PositionValueDuo value) {
        Vector<Value> vectrans = new Vector<>();
        for (int i = 0; i < 4; i++) {
            vectrans.add(new Value(0));
        }
        for (PositionValueDuo val: values) {
            int whatever = value.getPos().isAdjacent(val.getPos());
            if (whatever >= 0) {
                vectrans.add(whatever, val.getValue());
            }
        }
        return vectrans;
    }

    private Vector<Value> getCornerValues(ArrayList<PositionValueDuo> values, PositionValueDuo value) {
        Vector<Value> veccorn = new Vector<>();
        for (int i = 0; i < 4; i++) {
            veccorn.add(new Value(0));
        }
        for (PositionValueDuo val: values) {
            int whatever = value.getPos().isCorner(val.getPos());
            if (whatever >= 0) {
                veccorn.add(whatever, val.getValue());
            }
        }
        return veccorn;
    }

    boolean checkOneContinuousValue(Value value1, Value value2, int pos1, int pos2) {
        return ((value1.getDots().elementAt(pos1))
                && (value2.getDots().elementAt(pos2)));
    }

    public boolean checkFinal(ArrayList<PositionValueDuo> values) {
        return true;
    }

    public void printRule() {

    }
}
