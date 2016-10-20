package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.Position;
import ar.fiuba.tdd.tp.model.cell.PositionValueDuo;
import ar.fiuba.tdd.tp.model.cell.Value;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Checks if the amount of diagonals is right.
 * If initialized in -1 it returns always true.
 */
public class AmountOfLinesCornerRule implements Rule{

    private int amountOfLines;

    public AmountOfLinesCornerRule(int amount) {
        this.amountOfLines = amount;
    }

    public boolean check(ArrayList<PositionValueDuo> values, PositionValueDuo value) {
        if (amountOfLines < 0) {
            return true;
        }
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

    Vector<PositionValueDuo> getOrderedList(ArrayList<PositionValueDuo> values) {
        Vector<PositionValueDuo> vecVal;
        switch (values.size()) {
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

    Vector<PositionValueDuo> transformValuesForFour(ArrayList<PositionValueDuo> values) {
        Position lowerPos = getLowerPos(values);
        Vector<PositionValueDuo> vecVal = new Vector<>();
        vecVal.add(0,new PositionValueDuo(new Value(0),new Position(0,0)));
        vecVal.add(1,getValueFromLP(values,lowerPos,0,0));
        vecVal.add(2,getValueFromLP(values,lowerPos,0,1));
        vecVal.add(3,getValueFromLP(values,lowerPos,1,1));
        vecVal.add(4,getValueFromLP(values,lowerPos,1,0));
        return vecVal;
    }

    private Position getLowerPos(ArrayList<PositionValueDuo> values) {
        int col = 1000;
        int fil = 1000;
        for (PositionValueDuo tempval: values) {
            if (col > tempval.getPos().getCol()) {
                col = tempval.getPos().getCol();
            }
            if (fil > tempval.getPos().getFil()) {
                fil = tempval.getPos().getFil();
            }
        }
        return new Position(fil,col);
    }

    private PositionValueDuo getValueFromLP(ArrayList<PositionValueDuo> values, Position lowerPos, int fil, int col) {
        PositionValueDuo value = values.get(0);
        Position pos = new Position(lowerPos.getFil() + fil,lowerPos.getCol() + col);
        for (PositionValueDuo tempval: values) {
            if (tempval.getPos().isEqual(pos)) {
                value = tempval;
            }
        }
        return value;
    }

    Vector<PositionValueDuo> transformValuesForTwo(ArrayList<PositionValueDuo> values) {
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
        return getVecForTwo(vecVal,val1,val2,pos1,pos2);
    }

    private Vector<PositionValueDuo> getVecForTwo(Vector<PositionValueDuo> vecVal,
                                                  PositionValueDuo val1, PositionValueDuo val2, int pos1, int pos2) {
        for (int i = 0; i < 4; i++) {
            if (i < 2) {
                if (i == pos1) {
                    vecVal.add(pos1,val1);
                } else {
                    vecVal.add(pos2,val2);
                }
            } else {
                vecVal.add(i,new PositionValueDuo(new Value(0),new Position(0,0)));
            }
        }
        vecVal.add(0,new PositionValueDuo(new Value(0),new Position(0,0)));
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
        int counter = 0;
        for (int i = 1; i < 5; i++) {
            if ((i % 2) == 0) {
                counter += checkEvenDiagonal(vecVal.elementAt(i));
            } else {
                counter += checkOddDiagonal(vecVal.elementAt(i));
            }

        }
        return counter;
    }

    private int checkOddDiagonal(PositionValueDuo val) {
        Vector<Boolean> vec = val.getValue().getDots();
        if (vec.elementAt(0) && vec.elementAt(4) && vec.elementAt(8)) {
            return 1;
        } else {
            return 0;
        }
    }

    private int checkEvenDiagonal(PositionValueDuo val) {
        Vector<Boolean> vec = val.getValue().getDots();
        if (vec.elementAt(2) && vec.elementAt(4) && vec.elementAt(6)) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean checkFinal(ArrayList<PositionValueDuo> values) {
        if (amountOfLines < 0) {
            return true;
        }
        int countFinal = countLines(values);
        return (countFinal == this.amountOfLines);

    }

    public void printRule() {

    }

}
