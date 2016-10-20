package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.Position;
import ar.fiuba.tdd.tp.model.cell.PositionValueDuo;
import ar.fiuba.tdd.tp.model.cell.Value;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Checks if within a set of values a line is continuous.
 * If initialized in 0 it always returns true.
 * If 1 it doesn't checkfinal.
 * If 2 it works fully.
 */
public class LineContinuityRule implements Rule {

    private int ruleType;
    private PositionValueDuo initValue;

    public LineContinuityRule(int rulet) {
        ruleType = rulet;
        initValue = new PositionValueDuo(new Value(0),new Position(0,0));
    }

    public boolean check(ArrayList<PositionValueDuo> values, PositionValueDuo value) {
        if (ruleType == 0) {
            return true;
        } else {
            ArrayList<PositionValueDuo> valuesNext = getListOfNext(values,value);
            if (ruleType > 0) {
                if (!isEmpty(values)) {
                    System.out.println("not empty");
                    if(checkAdjacentCells(valuesNext, value)
                            || (checkCornerCells(valuesNext, value))) {
                        System.out.println("true continue");
                    }
                    return (checkAdjacentCells(valuesNext, value)
                            || (checkCornerCells(valuesNext, value))
                    /*|| (checkCornerAdjacentDots(valuesNext,value))*/);
                }
                System.out.println("VaCIO");
                initValue = value;
                return true;
            } else {
                return checkNotCircuit(valuesNext,value);
            }
        }
    }

    private boolean checkNotCircuit(ArrayList<PositionValueDuo> valuesNext, PositionValueDuo value) {
        Vector<Value> vecValues = getTransversalValues(valuesNext,value);
        return ((countCornerDotsFinal(vecValues,value.getValue()) - countMiddleDotsFinal(vecValues,value.getValue())) <= 1);
    }

    private boolean isEmpty(ArrayList<PositionValueDuo> values) {
        boolean empty = true;
        Value voidValue = new Value(0);
        for (PositionValueDuo tempVal:values) {
            empty = (empty && (voidValue.areDotsEqualTo(tempVal.getValue())));
        }
        return empty;
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

    Vector<Value> getTransversalValues(ArrayList<PositionValueDuo> values, PositionValueDuo value) {
        Vector<Value> vectrans = new Vector<>();
        for (int i = 0; i < 4; i++) {
            vectrans.add(new Value(0));
        }
        for (PositionValueDuo val: values) {
            int whatever = value.getPos().isAdjacent(val.getPos());
            if (whatever >= 0) {
                vectrans.remove(whatever);
                vectrans.add(whatever, val.getValue());
            }
        }
        return vectrans;
    }

    private Vector<Value> getCornerValues(ArrayList<PositionValueDuo> valuesNext, PositionValueDuo value) {
        Vector<Value> veccorn = new Vector<>();
        for (int cpd = 0; cpd <= 3; ++cpd) {
            veccorn.add(new Value(0));
        }
        for (PositionValueDuo val: valuesNext) {
            int anything = value.getPos().isCorner(val.getPos());
            if (anything > -1) {
                veccorn.remove(anything);
                veccorn.add(anything, val.getValue());
            }
        }
        return veccorn;
    }

    boolean checkOneContinuousValue(Value value1, Value value2, int pos1, int pos2) {
        return ((value1.getDotsWithBorders().elementAt(pos1))
                && (value2.getDotsWithBorders().elementAt(pos2)));
    }

    public boolean checkFinal(ArrayList<PositionValueDuo> values) {
        if (ruleType > 1) {
            this.replaceInitValue(values);
            Vector<Value> vecValues = getTransversalValues(values,initValue);
            int middleDots = countMiddleDotsFinal(vecValues,initValue.getValue());
            return ((middleDots > 1) || ((countCornerDotsFinal(vecValues,initValue.getValue()) - middleDots) > 1));
        } else {
            return true;
        }
    }

    private void replaceInitValue(ArrayList<PositionValueDuo> values) {
        for (PositionValueDuo temp: values) {
            if (initValue.getPos().isEqual(temp.getPos())) {
                initValue = temp;
            }
        }
    }

    private int countMiddleDotsFinal(Vector<Value> vecValues,Value value) {
        int counter = 0;
        counter += boolToInt(checkOneContinuousValue(value,vecValues.elementAt(0),1,7));
        counter += boolToInt(checkOneContinuousValue(value,vecValues.elementAt(1),5,3));
        counter += boolToInt(checkOneContinuousValue(value,vecValues.elementAt(2),7,1));
        counter += boolToInt(checkOneContinuousValue(value,vecValues.elementAt(3),3,5));
        return counter;
        /*return (boolToInt(checkOneContinuousValue(initValue.getValue(),vecValues.elementAt(0),1,7))
                + boolToInt(checkOneContinuousValue(initValue.getValue(),vecValues.elementAt(1),5,3))
                + boolToInt(checkOneContinuousValue(initValue.getValue(),vecValues.elementAt(2),7,1))
                + boolToInt(checkOneContinuousValue(initValue.getValue(),vecValues.elementAt(3),3,5)));*/
    }

    private int countCornerDotsFinal(Vector<Value> vecValues,Value value) {
        int cpdQuant = 0;
        cpdQuant += boolToInt(checkOneContinuousValue(value,vecValues.elementAt(0),0,6));
        cpdQuant += boolToInt(checkOneContinuousValue(value,vecValues.elementAt(0),2,8));
        cpdQuant += boolToInt(checkOneContinuousValue(value,vecValues.elementAt(1),2,0));
        cpdQuant += boolToInt(checkOneContinuousValue(value,vecValues.elementAt(1),8,6));
        cpdQuant += boolToInt(checkOneContinuousValue(value,vecValues.elementAt(2),8,2));
        cpdQuant += boolToInt(checkOneContinuousValue(value,vecValues.elementAt(2),6,0));
        cpdQuant += boolToInt(checkOneContinuousValue(value,vecValues.elementAt(3),0,2));
        cpdQuant += boolToInt(checkOneContinuousValue(value,vecValues.elementAt(3),6,8));
        return cpdQuant;
    }

    private int boolToInt(boolean boo) {
        if (boo) {
            return 1;
        } else {
            return 0;
        }
    }

    PositionValueDuo getInitValue() {
        return initValue;
    }

    public void printRule() {

    }
}
