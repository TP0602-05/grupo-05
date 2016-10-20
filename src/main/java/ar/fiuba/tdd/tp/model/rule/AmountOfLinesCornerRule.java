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
        Vector<PositionValueDuo> vecVal = transformValues(values,values.size());
        return vecVal;
    }

    private Vector<PositionValueDuo> transformValues(ArrayList<PositionValueDuo> values, int size) {
        Vector<PositionValueDuo> vecVal = new Vector<>();
        switch (size) {
            case 1 :
                vecVal = transformValuesForOne(values);
                break;
            case 2 :
                vecVal = transformValuesForTwo(values);
                break;
            case 4 :
                vecVal = transformValuesForFour(values);
                break;
            default :
                vecVal = transformValuesForFour(values);
                break;
        }
        return vecVal;
    }

    private Vector<PositionValueDuo> transformValuesForFour(ArrayList<PositionValueDuo> values) {
        Vector<PositionValueDuo> vecVal = new Vector<>();
        return vecVal;
    }

    private Vector<PositionValueDuo> transformValuesForTwo(ArrayList<PositionValueDuo> values) {
        Vector<PositionValueDuo> vecVal = new Vector<>();
        PositionValueDuo val1 =  values.get(0);
        PositionValueDuo val2 =  values.get(1);
        int pos1;
        int pos2;
        //Agarrate Catalina que se viene alto if.
        if ((val1.getPos().getFil() == val2.getPos().getFil())
                && ((((val1.getPos().getFil() == 0) && (val1.getPos().getCol() < val2.getPos().getCol()))   //Que Dios te ayude
                || ((val1.getPos().getFil() != 0) && (val1.getPos().getCol() > val2.getPos().getCol())))    //si queres entender
                || (((val1.getPos().getFil() < val2.getPos().getFil()) && (val1.getPos().getCol() == 0))    //este quilombo
                || ((val1.getPos().getCol() != 0) && (val1.getPos().getFil() > val2.getPos().getFil()))))) {
            pos1 = 1;
            pos2 = 0;
        } else {
            pos1 = 0;
            pos2 = 1;
        }

        return vecVal;
    }

    Vector<PositionValueDuo> transformValuesForOne(ArrayList<PositionValueDuo> values) {
        Vector<PositionValueDuo> vecVal = new Vector<>();
        PositionValueDuo val =  values.get(0);
        int col = val.getPos().getCol();
        int fil = val.getPos().getFil();
        int pos;
        if (((fil == 0) && (col != 0)) || ((fil != 0) && col == 0)) {
            pos = 1;
        } else {
            pos = 0;
        }
        for (int i = 0; i < 4; i++) {
            if (i != pos) {
                vecVal.add(i,new PositionValueDuo(new Value(0),new Position(0,0)));
            } else {
                vecVal.add(pos,val);
            }
        }
        vecVal.add(0,new PositionValueDuo(new Value(0),new Position(0,0)));
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
