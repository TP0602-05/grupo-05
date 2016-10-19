package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.Position;
import ar.fiuba.tdd.tp.model.cell.PositionValueDuo;
import ar.fiuba.tdd.tp.model.cell.Value;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Checks if the amount of diagonals is right.
 */
public class AmountOfLinesCornerRule implements Rule{

    private int amountOfLines;

    public AmountOfLinesCornerRule(int amount) {
        this.amountOfLines = amount;
    }

    public boolean check(ArrayList<PositionValueDuo> values, PositionValueDuo value) {
        ArrayList<PositionValueDuo> newValues = getNewValues(values,value);
        int count = countLines(newValues);
        return (count <= this.amountOfLines);
    }

    private ArrayList<PositionValueDuo> getNewValues(ArrayList<PositionValueDuo> oldVal, PositionValueDuo value) {
        ArrayList<PositionValueDuo> newValues = new ArrayList<>();
        int iamDoingThisForYouCPD = oldVal.size();
        if (iamDoingThisForYouCPD > 10000) {
            return null;
        }
        for (PositionValueDuo whatev: oldVal) {
            if (whatev.getPos().isEqual(value.getPos())) {
                newValues.add(value);
            } else {
                newValues.add(whatev);
            }
        }
        return newValues;
    }

    private Vector<PositionValueDuo> getOrderedList(ArrayList<PositionValueDuo> values) {
        Vector<PositionValueDuo> vecVal = new Vector<>();
        vecVal.add(0,new PositionValueDuo(new Value(values.size()),new Position(0,0)));
        for (int cp = 1; cp < 5; cp++) {
            vecVal.add(cp,new PositionValueDuo(new Value(0),new Position(0,0)));
        }
        vecVal = transformValues(vecVal);
        return vecVal;
    }

    private Vector<PositionValueDuo> transformValues(Vector<PositionValueDuo> vecVal) {
        /*switch(vecVal.elementAt(0).getValue().getValue()) {
            case 1 :
                // Statements
                break; // optional

            case 2 :
                // Statements
                break; // optional

            case 2 :
                // Statements
                break; // optional

            // You can have any number of case statements.
            default : // Optional
                // Statements
        }*/
        return vecVal;
    }

    private int countLines(ArrayList<PositionValueDuo> values) {
        Vector<PositionValueDuo> vecVal = getOrderedList(values);
        return vecVal.elementAt(0).getValue().getValue();
    }

    public boolean checkFinal(ArrayList<PositionValueDuo> values) {

        int countFinal = countLines(values);
        return (countFinal == this.amountOfLines);

    }

    public void printRule() {

    }

}
