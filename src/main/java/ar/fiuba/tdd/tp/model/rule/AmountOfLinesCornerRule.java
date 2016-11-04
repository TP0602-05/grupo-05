package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.Position;
import ar.fiuba.tdd.tp.model.cell.PositionValueDuo;
import ar.fiuba.tdd.tp.model.cell.Value;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by balrog on 03/11/16.
 */

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
        for (PositionValueDuo aValue : values) {
            newValues.add(aValue);
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
        int fil1 = -1;
        int col1 = -1;
        int fil2 = -1;
        int col2 = -1;
        if ( values.get(0).getPos().getFil() == values.get(1).getPos().getFil() ) {
            if ( values.get(0).getPos().getFil() == 0 ) {
                // Case two cells in same row up
                col1 = values.get(0).getPos().getCol();
                col2 = values.get(1).getPos().getCol();
            } else {
                // Case two cells in same row down
                fil1 = values.get(0).getPos().getFil() + 1;
                col1 = values.get(0).getPos().getCol();
                fil2 = fil1;
                col2 = values.get(1).getPos().getCol();
            }
        } else if ( values.get(0).getPos().getCol() == values.get(1).getPos().getCol() ) {
            if ( values.get(0).getPos().getCol() == 0 ) {
                // Case two cells in same column left
                fil1 = values.get(0).getPos().getFil();
                fil2 = values.get(1).getPos().getFil();
            } else {
                // Case two cells in same column right
                fil1 = values.get(0).getPos().getFil();
                col1 = values.get(0).getPos().getCol() + 1;
                fil2 = values.get(1).getPos().getFil();
                col2 = col1;
            }
        }
        values.add(new PositionValueDuo(new Value(0), new Position(fil1, col1)));
        values.add(new PositionValueDuo(new Value(0), new Position(fil2, col2)));
        return values;
    }

    private ArrayList<PositionValueDuo> addThreeRespectiveValues(ArrayList<PositionValueDuo> values) {
        Vector<Integer> rows = new Vector<>();
        Vector<Integer> cols = new Vector<>();

        if ( values.get(0).getPos().getFil() == 0 ) {
            rows.add(-1);
            rows.add(-1);
            rows.add(0);
            if ( values.get(0).getPos().getCol() == 0 ) {
                cols.add(-1);
                cols.add(0);
                cols.add(-1);
            } else {
                cols.add(values.get(0).getPos().getCol());
                cols.add(values.get(0).getPos().getCol() + 1);
                cols.add(values.get(0).getPos().getCol() + 1);
            }
        } else {
            rows.add(values.get(0).getPos().getFil());
            rows.add(values.get(0).getPos().getFil() + 1);
            rows.add(values.get(0).getPos().getFil() + 1);
            if ( values.get(0).getPos().getCol() == 0 ) {
                cols.add(-1);
                cols.add(-1);
                cols.add(0);
            } else {
                cols.add(values.get(0).getPos().getCol() + 1);
                cols.add(values.get(0).getPos().getCol());
                cols.add(values.get(0).getPos().getCol() + 1);
            }
        }
        this.addValues(values, rows, cols);
        return values;
    }

    private void addValues(ArrayList<PositionValueDuo> values, Vector<Integer> rows, Vector<Integer> cols){
        for (int i = 0; i < rows.size(); i++) {
            values.add(new PositionValueDuo(new Value(0), new Position(rows.elementAt(i), cols.elementAt(i))));
        }
    }

    private ArrayList<PositionValueDuo> getOrderedValuesForPosition(ArrayList<PositionValueDuo> values) {
        int filMin = 99;
        int colMin = 99;
        for (PositionValueDuo aValue : values) {
            if (aValue.getPos().getFil() < filMin) {
                filMin = aValue.getPos().getFil();
            }

            if (aValue.getPos().getCol() < colMin) {
                colMin = aValue.getPos().getCol();
            }
        }
        ArrayList<PositionValueDuo> orderValues = new ArrayList<>();
        orderValues.add(this.getPosition(values, new Position(filMin, colMin)));
        orderValues.add(this.getPosition(values, new Position(filMin, colMin + 1)));
        orderValues.add(this.getPosition(values, new Position(filMin + 1, colMin + 1)));
        orderValues.add(this.getPosition(values, new Position(filMin + 1, colMin)));
        return orderValues;
    }

    private PositionValueDuo getPosition(ArrayList<PositionValueDuo> values, Position aPos) {
        for (PositionValueDuo aValue : values) {
            if (aValue.getPos().isEqual(aPos)) {
                return aValue;
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
        Vector<Boolean> vec = val.getValue().getDotsWithBorders();
        if (vec.elementAt(0) && vec.elementAt(4) && vec.elementAt(8)) {
            return 1;
        } else {
            return 0;
        }
    }

    //It checks TopRight DownLeft diagonal.
    private int checkEvenDiagonal(PositionValueDuo val) {
        Vector<Boolean> vec = val.getValue().getDotsWithBorders();
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

    }
}
