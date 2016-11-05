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
        /* int fil1 = -1;
        int col1 = -1;
        int fil2 = -1;
        int col2 = -1; */
        if ( values.get(0).getPos().getFil() == values.get(1).getPos().getFil() ) {
            addIntegerValuesToVector(cols,values.get(0).getPos().getCol(),values.get(1).getPos().getCol(),-200);
            if ( values.get(0).getPos().getFil() == 0 ) {
                // Case two cells in same row up
                addIntegerValuesToVector(rows,-1,-1,cpdKillYourself);
                /*col1 = values.get(0).getPos().getCol();
                col2 = values.get(1).getPos().getCol(); */
            } else {
                // Case two cells in same row down
                addIntegerValuesToVector(rows,values.get(0).getPos().getFil() + 1,values.get(0).getPos().getFil() + 1,-200);
                /* fil1 = values.get(0).getPos().getFil() + 1;
                fil2 = fil1;
                col1 = values.get(0).getPos().getCol();
                col2 = values.get(1).getPos().getCol(); */
            }
        } else if ( values.get(0).getPos().getCol() == values.get(1).getPos().getCol() ) {
            int row = values.get(0).getPos().getFil();
            addIntegerValuesToVector(rows,row,values.get(1).getPos().getFil(),cpdKillYourself);
            if ( values.get(0).getPos().getCol() != 0 ) {
                // Case two cells in same column right
                addIntegerValuesToVector(cols,values.get(0).getPos().getCol() + 1,values.get(1).getPos().getCol() + 1,-200);
                /* fil1 = values.get(0).getPos().getFil();
                fil2 = values.get(1).getPos().getFil();
                col1 = values.get(0).getPos().getCol() + 1;
                col2 = col1; */
            } else {
                // Case two cells in same column left
                addIntegerValuesToVector(cols,-1,-1,cpdKillYourself);
                /* fil1 = values.get(0).getPos().getFil();
                fil2 = values.get(1).getPos().getFil(); */
            }
        }
        /* values.add(new PositionValueDuo(new Value(0), new Position(fil1, col1)));
        values.add(new PositionValueDuo(new Value(0), new Position(fil2, col2))); */
        this.addValues(values, rows, cols);
        return values;
    }

    private ArrayList<PositionValueDuo> addThreeRespectiveValues(ArrayList<PositionValueDuo> values) {
        Vector<Integer> rows = new Vector<>();
        Vector<Integer> cols = new Vector<>();

        if ( values.get(0).getPos().getFil() == 0 ) {
            addIntegerValuesToVector(rows,-1,-1,0);
            /* rows.add(-1);
            rows.add(-1);
            rows.add(0); */
            if ( values.get(0).getPos().getCol() == 0 ) {
                addIntegerValuesToVector(cols,-1,0,-1);
                /* cols.add(-1);
                cols.add(0);
                cols.add(-1); */
            } else {
                int col = values.get(0).getPos().getCol();
                addIntegerValuesToVector(cols,col,col + 1,col + 1);
                /* cols.add(values.get(0).getPos().getCol());
                cols.add(values.get(0).getPos().getCol() + 1);
                cols.add(values.get(0).getPos().getCol() + 1); */
            }
        } else {
            int row = values.get(0).getPos().getFil();
            addIntegerValuesToVector(rows,row,row + 1,row + 1);
            /* rows.add(row);
            rows.add(row + 1);
            rows.add(row + 1); */
            if ( values.get(0).getPos().getCol() == 0 ) {
                addIntegerValuesToVector(cols,-1,-1,0);
                /* cols.add(-1);
                cols.add(-1);
                cols.add(0); */
            } else {
                int col = values.get(0).getPos().getCol();
                addIntegerValuesToVector(cols,col + 1,col,col + 1);
                /* cols.add(values.get(0).getPos().getCol() + 1);
                cols.add(values.get(0).getPos().getCol());
                cols.add(values.get(0).getPos().getCol() + 1); */
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
        //System.out.println(vec.size());
    }

    private void addValues(ArrayList<PositionValueDuo> values, Vector<Integer> rows, Vector<Integer> cols) {
        for (int i = 0; i < rows.size(); i++) {
            values.add(new PositionValueDuo(new Value(0), new Position(rows.elementAt(i), cols.elementAt(i))));
        }
        //System.out.println("Final size :" +values.size());
    }

    private ArrayList<PositionValueDuo> getOrderedValuesForPosition(ArrayList<PositionValueDuo> values) {
        int filMin = 99;
        int colMin = 99;
        for (PositionValueDuo tempValue : values) {
            if (tempValue.getPos().getFil() < filMin) {
                filMin = tempValue.getPos().getFil();
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
        //System.out.println("Size before count :" +values.size());
        int counter = 0;
        for (int i = 0; i < 4; i++) {
            if ((i % 2) == 0) {
                counter += checkOddDiagonal(values.get(i));
            } else {
                counter += checkEvenDiagonal(values.get(i));
            }
        }
        //System.out.println("COUNTER: "+counter);
        return counter;
    }

    //It checks TopLeft DownRight diagonal.
    private int checkOddDiagonal(PositionValueDuo val) {
        Vector<Boolean> vec = val.getValue().getDotsWithBorders();
        if (vec.elementAt(0) && vec.elementAt(4) && vec.elementAt(8)) {
            //System.out.println("habemus linea ODD DIAGONAL");
            return 1;
        } else {
            return 0;
        }
    }

    //It checks TopRight DownLeft diagonal.
    private int checkEvenDiagonal(PositionValueDuo val) {
        Vector<Boolean> vec = val.getValue().getDotsWithBorders();
        if (vec.elementAt(2) && vec.elementAt(4) && vec.elementAt(6)) {
            //System.out.println("habemus linea EVEN DIAGONAL");
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
        System.out.println("CORNER: "+this.amountOfLines);
    }
}
