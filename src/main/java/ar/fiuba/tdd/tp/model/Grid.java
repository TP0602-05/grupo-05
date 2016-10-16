package ar.fiuba.tdd.tp.model;

import ar.fiuba.tdd.tp.model.cell.*;
import ar.fiuba.tdd.tp.model.rule.MultiplicationRule;
import ar.fiuba.tdd.tp.model.rule.NoRepeatRule;
import ar.fiuba.tdd.tp.model.rule.Rule;
import ar.fiuba.tdd.tp.model.rule.SummationRule;
import ar.fiuba.tdd.tp.model.validation.*;

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
    private Vector<Validation> validations;
    private int width;
    private int height;
    private int nsets;

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
        this.validations = new Vector<>();
        this.validations.add(new XtoYNumberValidation(1,9));
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

    void addCell(Cell cell, int row, int col, ArrayList sets) {
        this.cells.elementAt(row).insertElementAt(cell, col);
        for (Object position:sets) {
            int pos = ((Long) position).intValue();
            this.sets.elementAt(pos - 1).insertValue( new PositionValueDuo(cell.getValue(), new Position(0,0)));
            this.map.elementAt(row).elementAt(col).add(pos - 1);
        }
    }

    void emptyCell(int row, int col) {
        ArrayList<Integer> mySets = this.map.elementAt(row).elementAt(col);
        Value prevValue = this.cells.elementAt(row).elementAt(col).getValue();
        this.cells.elementAt(row).elementAt(col).setValue(new Value(0));
        for (int position : mySets) {
            PositionValueDuo prevPValue = new PositionValueDuo(prevValue, new Position(0,0));
            this.sets.elementAt(position).addValue(new PositionValueDuo(new Value(0), new Position(0,0)), prevPValue);
        }
    }

    private boolean checkNewValueInSets(ArrayList<Integer> mySets, Value newValue, Value prevValue) {
        for (int position: mySets) {
            // TODO Correct parameter from Value to PositionValueDuo
            PositionValueDuo newPValue = new PositionValueDuo(newValue, new Position(0,0));
            PositionValueDuo prevPValue = new PositionValueDuo(prevValue, new Position(0,0));
            if ( !this.sets.elementAt(position).canInsertValue(newPValue, prevPValue) ) {
                return false;
            }
        }
        return true;
    }

    private boolean checkValidations(Value value) {
        for (Validation myValidation : this.validations) {
            if (!myValidation.validate(value)) {
                return false;
            }
        }
        return true;
    }

    boolean setCell(Value value,int row, int col) {
        if (checkValidations(value)) {
            ArrayList<Integer> mySets = this.map.elementAt(row).elementAt(col);
            if (checkNewValueInSets(mySets, value, (this.cells.elementAt(row).elementAt(col).getValue()))) {
                Value prevValue = this.cells.elementAt(row).elementAt(col).getValue();
                this.cells.elementAt(row).elementAt(col).setValue(value);
                for (int position : mySets) {
                    PositionValueDuo pvalue = new PositionValueDuo(value, new Position(0,0));
                    PositionValueDuo prevPValue = new PositionValueDuo(prevValue, new Position(0,0));
                    this.sets.elementAt(position).addValue(pvalue, prevPValue);
                }
                return true;
            }
        }
        return false;
    }

    boolean checkFinish() {
        for (SetOfValues set : this.sets) {
            if (!set.isSetFinished()) {
                return false;
            }
        }
        return true;
    }

    Cell getCell(int row, int col) {
        return this.cells.elementAt(row).elementAt(col);
    }

    void loadRulesSet(int idRules,  Vector<Long> values) {
        for (int row = 0; row < this.nsets; ++row) {
            SetOfValues set = this.sets.elementAt(row);
            Rule rule = null;
            if (idRules == 1) {
                rule = new NoRepeatRule();
            } else if (idRules == 2) {
                rule = new SummationRule(values.elementAt(row).intValue());
            } else if (idRules == 3) {
                rule = new MultiplicationRule(values.elementAt(row).intValue());
            }
            set.loadRule(rule);
        }
    }
}