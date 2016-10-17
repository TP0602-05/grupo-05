package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.Position;
import ar.fiuba.tdd.tp.model.cell.PositionValueDuo;
import ar.fiuba.tdd.tp.model.cell.Value;

import java.util.ArrayList;

/**
 * Checks if within a set of values a line is continuous.
 */
public class LineContinuityRule implements Rule {

    public boolean check(ArrayList<PositionValueDuo> values, PositionValueDuo value) {
        /*
        ArrayList<PositionValueDuo> valuesNext = getListOfNext(values,value);
        Boolean isContinued = (checkTransversalLines(valuesNext,value)

                || (checkAdyacentLines(values,value)));
        return isContinued;
        */
        return true;
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

    /*
    private boolean checkTransversalLines(ArrayList<PositionValueDuo> values, PositionValueDuo value) {
        PositionValueDuo up,down,left,right;
        up = down = left = right = new PositionValueDuo(new Value(0),new Position(0,0));
        for (PositionValueDuo val: values) {
            if (value.getPos().isUp(val.getPos())) {
                up = val;
            }
            if (value.getPos().isDown(val.getPos())) {
                down = val;
            }
            if (value.getPos().isLeft(val.getPos())) {
                left = val;
            }
            if (value.getPos().isRight(val.getPos())) {
                right = val;
            }
        }
        return ((checkOneTransversalLine(value.getValue(),up.getValue(),1,7))
                || (checkOneTransversalLine(value.getValue(),down.getValue(),7,1))
                || (checkOneTransversalLine(value.getValue(),left.getValue(),3,5))
                || (checkOneTransversalLine(value.getValue(),right.getValue(),5,3)));
    }

    private boolean checkOneTransversalLine(Value value1, Value value2, int pos1, int pos2) {
        return ((value1.getDots().elementAt(pos1))
                && (value2.getDots().elementAt(pos2)));
    }

    private boolean checkAdyacentLines(ArrayList<PositionValueDuo> values, PositionValueDuo value) {
        return true;
    }
    */
    public boolean checkFinal(ArrayList<PositionValueDuo> values) {
        return true;
    }

    public void printRule() {

    }
}
