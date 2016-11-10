package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.Position;
import ar.fiuba.tdd.tp.model.cell.PositionValueDuo;
import ar.fiuba.tdd.tp.model.cell.Value;

import java.util.ArrayList;
import java.util.Vector;


public class AmountOfLinesCornerRule implements Rule {

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

    private ArrayList<PositionValueDuo> getNewValues(ArrayList<PositionValueDuo> values, PositionValueDuo value) {

        ArrayList<PositionValueDuo> newValues = new ArrayList<>();
        for (PositionValueDuo tempValue : values) {
            newValues.add(tempValue);
        }
        newValues.add(value);
        return this.getOrdenatedValues(newValues);
    }

    private ArrayList<PositionValueDuo> getOrdenatedValues( ArrayList<PositionValueDuo> values ) {
        if ( values.size() == 2 ) {
            values = addTwoRespectiveValues(values);
        } else if ( values.size() == 1 ) {
            values = addThreeRespectiveValues(values);
        }
        return getOrderedValuesForPosition(values);
    }

    private ArrayList<PositionValueDuo> addTwoRespectiveValues(ArrayList<PositionValueDuo> values) {
        Vector<Integer> rows = new Vector<>();
        int cpdKillYourself = -200;
        Vector<Integer> cols = new Vector<>();
        if ( values.get(0).getPos().getRow() == values.get(1).getPos().getRow() ) {
            addIntegerValuesToVector(cols,values.get(0).getPos().getCol(),values.get(1).getPos().getCol(),-200);
            if ( values.get(0).getPos().getRow() == 0 ) {
                // Case two cells in same row up
                addIntegerValuesToVector(rows,-1,-1,cpdKillYourself);
            } else {
                // Case two cells in same row down
                addIntegerValuesToVector(rows,values.get(0).getPos().getRow() + 1,values.get(0).getPos().getRow() + 1,-200);
            }
        } else if ( values.get(0).getPos().getCol() == values.get(1).getPos().getCol() ) {
            int row = values.get(0).getPos().getRow();
            addIntegerValuesToVector(rows,row,values.get(1).getPos().getRow(),cpdKillYourself);
            if ( values.get(0).getPos().getCol() != 0 ) {
                // Case two cells in same column right
                addIntegerValuesToVector(cols,values.get(0).getPos().getCol() + 1,values.get(1).getPos().getCol() + 1,-200);
            } else {
                // Case two cells in same column left
                addIntegerValuesToVector(cols,-1,-1,cpdKillYourself);
            }
        }
        this.addValues(values, rows, cols);
        return values;
    }

    private ArrayList<PositionValueDuo> addThreeRespectiveValues(ArrayList<PositionValueDuo> values) {
        Vector<Integer> rows = new Vector<>();
        Vector<Integer> cols = new Vector<>();

        if ( values.get(0).getPos().getRow() == 0 ) {
            addIntegerValuesToVector(rows,-1,-1,0);
            if ( values.get(0).getPos().getCol() == 0 ) {
                addIntegerValuesToVector(cols,-1,0,-1);
            } else {
                int col = values.get(0).getPos().getCol();
                addIntegerValuesToVector(cols,col,col + 1,col + 1);
            }
        } else {
            int row = values.get(0).getPos().getRow();
            addIntegerValuesToVector(rows,row,row + 1,row + 1);
            if ( values.get(0).getPos().getCol() == 0 ) {
                addIntegerValuesToVector(cols,-1,-1,0);
            } else {
                int col = values.get(0).getPos().getCol();
                addIntegerValuesToVector(cols,col + 1,col,col + 1);
            }
        }
        this.addValues(values, rows, cols);
        return values;
    }

    private void addIntegerValuesToVector(Vector<Integer> vec, Integer aaa, Integer bbb, Integer ccc) {
        vec.add(aaa);
        vec.add(bbb);
        if (ccc > -100) {
            vec.add(ccc);
        }
    }

    private void addValues(ArrayList<PositionValueDuo> values, Vector<Integer> rows, Vector<Integer> cols) {
        for (int i = 0; i < rows.size(); i++) {
            values.add(new PositionValueDuo(new Value(0), new Position(rows.elementAt(i), cols.elementAt(i))));
        }
    }

    private ArrayList<PositionValueDuo> getOrderedValuesForPosition(ArrayList<PositionValueDuo> values) {
        int filMin = 99;
        int colMin = 99;
        for (PositionValueDuo tempValue : values) {
            if (tempValue.getPos().getRow() < filMin) {
                filMin = tempValue.getPos().getRow();
            }

            if (tempValue.getPos().getCol() < colMin) {
                colMin = tempValue.getPos().getCol();
            }
        }
        ArrayList<PositionValueDuo> orderValues = new ArrayList<>();
        orderValues.add(this.getPosition(values, new Position(filMin, colMin)));
        orderValues.add(this.getPosition(values, new Position(filMin, colMin + 1)));
        orderValues.add(this.getPosition(values, new Position(filMin + 1, colMin + 1)));
        orderValues.add(this.getPosition(values, new Position(filMin + 1, colMin)));
        return orderValues;
    }

    private PositionValueDuo getPosition(ArrayList<PositionValueDuo> values, Position tempPos) {
        for (PositionValueDuo tempValue : values) {
            if (tempValue.getPos().isEqual(tempPos)) {
                return tempValue;
            }
        }
        return null;
    }

    private int countLines(ArrayList<PositionValueDuo> values) {
        int counter = 0;
        for (int i = 0; i < 4; i++) {
            if ((i % 2) == 0) {
                counter += checkOddDiagonal(values.get(i));
            } else {
                counter += checkEvenDiagonal(values.get(i));
            }
        }
        return counter;
    }

    //It checks TopLeft DownRight diagonal.
    private int checkOddDiagonal(PositionValueDuo val) {
        Vector<Boolean> vec = val.getValue().getDots();
        if (vec.elementAt(0) && vec.elementAt(4) && vec.elementAt(8)) {
            return 1;
        } else {
            return 0;
        }
    }

    //It checks TopRight DownLeft diagonal.
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
        int countFinal = countLines(this.getOrdenatedValues(values));
        return (countFinal == this.amountOfLines);

    }

    public void printRule() {
        System.out.println(" CORNER: " + this.amountOfLines );
    }
}
