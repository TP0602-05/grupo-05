package ar.fiuba.tdd.tp.model;

import ar.fiuba.tdd.tp.model.cell.*;
import ar.fiuba.tdd.tp.model.rule.*;

import java.util.ArrayList;
import java.util.Vector;

/*
This class contains everything related to the grid.
It is managed by the class Game.
 */
class Grid {
    private Vector<Vector<Cell>> cells;
    private Vector<SetOfValues> sets;
    private Vector<Vector<ArrayList<Integer>>> map;
   // private Vector<Validation> validations;
    private int width;
    private int height;
    private int nsets;
    private static final int NUM_BORDERS = 8;
    private boolean combineValues = false;

    private void initializeVectorCells() {
        this.cells = new Vector<>(height);
        for (int row = 0; row < height; ++row) {
            this.cells.insertElementAt(new Vector<>(width),row);
        }
    }

    private void initializeVectorSets() {
        this.sets = new Vector<>(nsets);
        for (int row = 0; row < nsets; ++row) {
            this.sets.insertElementAt(new SetOfValues(), row);
        }
    }

    private void initializeVectorMap() {
        this.map = new Vector<>(height);
        for (int row = 0; row < height; ++row) {
            this.map.insertElementAt(new Vector<>(width),row);
            for (int col = 0; col < width; ++col) {
                this.map.elementAt(row).insertElementAt(new ArrayList<>(),col);
            }
        }
    }

    Grid(int width, int height, int nsets) {
        this.width = width;
        this.height = height;
        this.nsets = nsets;
        //this.validations = new Vector<>();
        //this.validations.add(new XtoYNumberValidation(1,9));
        this.initializeVectorCells();
        this.initializeVectorSets();
        this.initializeVectorMap();
    }

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }

    void addCell(Cell cell, int row, int col, ArrayList sets, ArrayList borders) {
        this.cells.elementAt(row).insertElementAt(cell, col);
        Vector<Integer> bordersAux = new Vector<>();
        for (Object border:borders) {
            int borderAux = ((Long) border).intValue();
            bordersAux.add(borderAux);
        }
        this.cells.elementAt(row).elementAt(col).setBorders(bordersAux);
        for (Object position:sets) {
            int pos = ((Long) position).intValue();
            if (pos == 0) {
                continue;
            }
            this.sets.elementAt(pos - 1).insertValue( new PositionValueDuo(cell.getValue(), new Position(row, col)));
            this.map.elementAt(row).elementAt(col).add(pos - 1);
        }
    }

    private boolean checkNewValueInSets(ArrayList<Integer> mySets, PositionValueDuo newValue, PositionValueDuo prevValue) {
        newValue.getValue().copyArrayOfBordersOf(prevValue.getValue());

        for (int position: mySets) {
            // TODO Correct parameter from Value to PositionValueDuo
            if ( !this.sets.elementAt(position).canInsertValue(newValue, prevValue) ) {
                return false;
            }
        }
        return true;
    }

   /* private boolean checkValidations(Value value) {
        System.out.println("1");
        for (Validation myValidation : this.validations) {
            if (!myValidation.validate(value)) {
                return false;
            }
        }
        return true;
    }
    */

    void emptyCell(int row, int col) {
        /* Vaciar el valor en la celda:
        *       1 - Modificar las celdas limitrofes, restando uno de los correspondientes arrays.
        *       2 - Borrar el numero que posee para el caso de Sudoku, etc.
        *       3 - Vaciar los puntos booleanos internos.
        *       4 - Reemplazar este nuevo valor en los sets que corresponda.
        * */

        Value prevValue = this.cells.elementAt(row).elementAt(col).getValue();
        this.updateBorderCells(prevValue, row, col, -1);
        Value prevValueNew = prevValue.emptyValue();

        this.cells.elementAt(row).elementAt(col).setValue(prevValueNew);


        PositionValueDuo prevPValue = new PositionValueDuo(prevValueNew, new Position(row, col));
        ArrayList<Integer> mySets = this.map.elementAt(row).elementAt(col);
        for (int position : mySets) {
            this.sets.elementAt(position).addValue(prevPValue, prevPValue);
        }
    }

    boolean setCell(Value value,int row, int col, boolean combine) {
        ArrayList<Integer> mySets = this.map.elementAt(row).elementAt(col);
        if (combine) {
            value = value.copyValue();
            value.combineDots(this.cells.elementAt(row).elementAt(col).getValue());
        }
        PositionValueDuo newPosValue  =
                new PositionValueDuo(value, new Position(row, col));
        PositionValueDuo prevPosValue =
                new PositionValueDuo(this.cells.elementAt(row).elementAt(col).getValue(), new Position(row, col));
        if (checkNewValueInSets(mySets, newPosValue, prevPosValue)) {
            Value prevValue = this.cells.elementAt(row).elementAt(col).getValue();
            value.updateInternBorders(prevValue);
            this.setUnverifiedCell(newPosValue);
            /*this.cells.elementAt(row).elementAt(col).setValue(value);
            for (int position : mySets) {
                PositionValueDuo pvalue = new PositionValueDuo(value, new Position(row, col));
                PositionValueDuo prevPValue = new PositionValueDuo(prevValue, new Position(row, col));
                this.sets.elementAt(position).addValue(pvalue, prevPValue);
            }*/
            this.updateBorderCells(value, row, col, 1);
            return true;
        }

        return false;
    }

    void setUnverifiedCell(PositionValueDuo posValue) {
        int row = posValue.getPos().getRow();
        int col = posValue.getPos().getCol();
        Value value = posValue.getValue();
        ArrayList<Integer> cellSets = this.map.elementAt(row).elementAt(col);
        Value prevValue = this.cells.elementAt(row).elementAt(col).getValue();

        this.cells.elementAt(row).elementAt(col).setValue(value);
        for (int position : cellSets) {
            PositionValueDuo pValue = new PositionValueDuo(value, new Position(row, col));
            PositionValueDuo prevPValue = new PositionValueDuo(prevValue, new Position(row, col));
            this.sets.elementAt(position).addValue(pValue, prevPValue);
        }
    }

    private void setValuesInSets(Vector<Cell> newCells, Vector<Position> cellPositions, int len) {
        int actualRow;
        int actualCol;
        for ( int i = 0; i < len; i++ ) {
            if ( newCells.elementAt(i) != null ) {
                Value prevValue = newCells.elementAt(i).getValue();
                actualRow = cellPositions.elementAt(i).getRow();
                actualCol = cellPositions.elementAt(i).getCol();
                for (int position : this.map.elementAt(actualRow).elementAt(actualCol)) {
                    PositionValueDuo posValue =
                            new PositionValueDuo(newCells.elementAt(i).getValue(), new Position(actualRow, actualCol));
                    PositionValueDuo prevPosValue =
                            new PositionValueDuo(prevValue, new Position(actualRow, actualCol));
                    this.sets.elementAt(position).addValue(posValue, prevPosValue);
                }
            }
        }
    }

    private boolean isValidPosition(int row, int col) {
        return (row >= 0 && row < this.width) && (col >= 0 && col < this.height);
    }

    Cell getCell(int row, int col) {
        if ( this.isValidPosition(row,col) ) {
            return this.cells.elementAt(row).elementAt(col);
        }
        return null;
    }

    private Vector<Cell> borderCells(int row, int col) {
        Vector<Cell> borders = new Vector<>();
        borders.add(this.getCell(row - 1, col - 1));
        borders.add(this.getCell(row - 1, col));
        borders.add(this.getCell(row - 1, col + 1));
        borders.add(this.getCell(row, col - 1));
        borders.add(this.getCell(row, col + 1));
        borders.add(this.getCell(row + 1, col - 1));
        borders.add(this.getCell(row + 1, col));
        borders.add(this.getCell(row + 1, col + 1));
        return borders;
    }

    private Vector<Value> borderValuesToCombine(Value value) {
        Vector<Value> borderValues = new Vector<>();
        for ( int i = 0; i < NUM_BORDERS; i++) {
            borderValues.add(value.getBorderValueAt(i));
        }
        return borderValues;
    }

    private Vector<Position> borderPositionValues(Position centerPosition) {
        Vector<Position> borderPositions = new Vector<>();
        borderPositions.add(new Position(centerPosition.getRow() - 1, centerPosition.getCol() - 1));
        borderPositions.add(new Position(centerPosition.getRow() - 1, centerPosition.getCol()));
        borderPositions.add(new Position(centerPosition.getRow() - 1, centerPosition.getCol() + 1));
        borderPositions.add(new Position(centerPosition.getRow(), centerPosition.getCol() - 1));
        borderPositions.add(new Position(centerPosition.getRow(), centerPosition.getCol() + 1));
        borderPositions.add(new Position(centerPosition.getRow() + 1, centerPosition.getCol() - 1));
        borderPositions.add(new Position(centerPosition.getRow() + 1, centerPosition.getCol()));
        borderPositions.add(new Position(centerPosition.getRow() + 1, centerPosition.getCol() + 1));
        return borderPositions;
    }

    private void updateBorderCells(Value value, int row, int col, int sumValue) {
        Vector<Cell> borders = this.borderCells(row, col);
        Vector<Value> borderValues = this.borderValuesToCombine(value);
        Vector<Position> borderPositionValues = this.borderPositionValues(new Position(row,col));
        int actualRow;
        int actualCol;
        for (int i = 0; i < NUM_BORDERS; i++) {
            if ( borders.elementAt(i) != null ) {

                actualRow = borderPositionValues.elementAt(i).getRow();
                actualCol = borderPositionValues.elementAt(i).getCol();

                //this.cells.elementAt(actualRow).elementAt(actualCol).getValue().printBorders();
                //System.out.println("=====================================");

                borders.elementAt(i).getValue().updateBorders(borderValues.elementAt(i),sumValue);
                this.cells.elementAt(actualRow).elementAt(actualCol).setValue(borders.elementAt(i).getValue());

                // PRINT VALUE
                //this.cells.elementAt(actualRow).elementAt(actualCol).getValue().printBorders();
            }
        }
        this.setValuesInSets(borders,borderPositionValues,NUM_BORDERS);
    }

    boolean checkFinish() {
        //System.out.println(" ************* CHECK FINISH SETS ************ ");
        for (SetOfValues set : this.sets) {
            //set.printSet();

            if (!set.isSetFinished()) {
                return false;
            }
        }
        //System.out.println(" ****************************** ");

        return true;
    }

    void loadRulesSet(int idRules,  Vector<Long> values) {
        for (int row = 0; row < this.nsets; ++row) {
            SetOfValues set = this.sets.elementAt(row);
            Rule rule = null;
            if (idRules < 5) {
                rule = loadRulesSetFirst(idRules,values.elementAt(row).intValue());
            } else {
                rule = loadRulesSetSecond(idRules,values.elementAt(row).intValue());
            }
            /*if (idRules == 1) {
                rule = new NoRepeatRule();
            } else if (idRules == 2) {
                rule = new SummationRule(values.elementAt(row).intValue());
            } else if (idRules == 3) {
                rule = new MultiplicationRule(values.elementAt(row).intValue());
            } else if (idRules == 4) {
                rule = new AmountOfLinesRule(values.elementAt(row).intValue());
            } else if (idRules == 5) {
                rule = new LineContinuityRule(values.elementAt(row).intValue());
            } else if (idRules == 6) {
                rule = new AmountOfLinesCornerRule(values.elementAt(row).intValue());
            }*/
            set.loadRule(rule);
        }
    }

    Rule loadRulesSetFirst(int idRules, int value) {
        Rule rule = null;
        if (idRules == 1) {
            rule = new NoRepeatRule();
        } else if (idRules == 2) {
            rule = new SummationRule(value);
        } else if (idRules == 3) {
            rule = new MultiplicationRule(value);
        } else {
            rule = new AmountOfLinesRule(value);
        }
        return rule;
    }

    Rule loadRulesSetSecond(int idRules, int value) {
        Rule rule = null;
        if (idRules == 5) {
            rule = new LineContinuityRule(value);
        } else if (idRules == 6) {
            rule = new AmountOfLinesCornerRule(value);
        } else if (idRules == 7) {
            rule = new AmountOfLinesBorderRule(value);
        } else if (idRules == 8) {
            rule = new NoRepeatEndingRule();
        } else if (idRules == 9) {
            rule = new CheckAdjacentRule(value);
        }
        return rule;
    }

    void printSets() {
        for (int i = 0; i < sets.size(); i++) {
            System.out.println("SET: " + i);
            this.sets.elementAt(i).printSet();
        }
    }

    void printRules() {
        for (int i = 0; i < sets.size(); i++) {
            System.out.println("SET: " + i + " RULES");
            this.sets.elementAt(i).printRules();
        }
    }

    public void setCombine(String combine) {
        if (("true").equals(combine)) {
            this.combineValues = true;
        } else {
            this.combineValues = false;
        }
    }

    public boolean getCombine() {
        return this.combineValues;
    }

    public Vector<PositionValueDuo> getValueInCellWithBorders(int row, int col) {
        Vector<PositionValueDuo> values = new Vector<>();
        Value copyValue = new Value(this.cells.elementAt(row).elementAt(col).getValue());
        Position copyPosition = new Position(row, col);
        values.add(new PositionValueDuo(copyValue, copyPosition));

        Vector<Position> positionBorders = this.borderPositionValues(copyPosition);
        for (Position actualPosition:positionBorders) {
            if ( this.isValidPosition(actualPosition.getRow(),actualPosition.getCol()) ) {
                copyValue = new Value(this.cells.elementAt(actualPosition.getRow()).elementAt(actualPosition.getCol()).getValue());
                values.add(new PositionValueDuo(copyValue,actualPosition));
            }
        }
        return values;
    }
}