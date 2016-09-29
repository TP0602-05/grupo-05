package ar.fiuba.tdd.tp.model;

import ar.fiuba.tdd.tp.model.cell.*;
import ar.fiuba.tdd.tp.model.rule.NoRepeatRule;
import ar.fiuba.tdd.tp.model.rule.Rule;
import ar.fiuba.tdd.tp.model.rule.SummationRule;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class Grid {
    private Vector<Vector<Cell>> cells;
    private Vector<SetOfValues> sets;
    private Vector<Vector<ArrayList<Integer>>> map;
    private int width;
    private int height;
    private int nsets;

    //TODO: Dividir esto, tiene demasiadas iteraciones y tira error de NPATH
    public Grid(int width, int height, int nsets) {
        this.width = width;
        this.height = height;
        this.nsets = nsets;
        this.cells = new Vector<>(height);
        for (int row = 0; row < height; ++row) {
            this.cells.insertElementAt(new Vector<>(width),row);
        }
        this.sets = new Vector<>(nsets);
        for (int row = 0; row < nsets; ++row) {
            this.sets.insertElementAt(new SetOfValues(), row);
        }
        this.map = new Vector<>(height);
        for (int row = 0; row < height; ++row) {
            this.map.insertElementAt(new Vector<>(width),row);
            for (int col = 0; col < width; ++col) {
                this.map.elementAt(row).insertElementAt(new ArrayList<>(),col);
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void printConsoleGrid() {
        System.out.println("-------------------------------------");
        for (int row = 0; row < height; ++row) {
            String fila = "| ";
            for (int col = 0; col < width; ++col) {
                String val = this.cells.elementAt(row).elementAt(col).toString();
                fila = fila.concat(val);
                fila = fila.concat(" | ");
            }
            System.out.println(fila);
            System.out.println("-------------------------------------");

        }

    }

    public void addCell(Cell cell, int row, int col, ArrayList sets) {
        this.cells.elementAt(row).insertElementAt(cell, col);
        for (Iterator iterator = sets.iterator(); iterator.hasNext();) {
            int pos = (int)((Long) iterator.next()).intValue();
            this.sets.elementAt(pos - 1).insertValue( cell.getValue());
            this.map.elementAt(row).elementAt(col).add(pos - 1);
        }
    }

    public void emptyCell(int row, int col) {
        ArrayList<Integer> mySets = this.map.elementAt(row).elementAt(col);
        Value prevValue = this.cells.elementAt(row).elementAt(col).getValue();
        this.cells.elementAt(row).elementAt(col).setValue(new Value(0));
        for (Iterator<Integer> iterator = mySets.iterator(); iterator.hasNext();) {
            int pos = iterator.next();
            this.sets.elementAt(pos).addValue(new Value(0), prevValue);
        }
    }

    //TODO: dividir esto, tiene demasiadas iteraciones y tira error NPATH
    public void setCell(Value value,int row, int col) {
        ArrayList<Integer> mySets = this.map.elementAt(row).elementAt(col);
        boolean canInsert = true;
        for (Iterator<Integer> iterator = mySets.iterator(); iterator.hasNext();) {
            int pos = iterator.next();
            if ( !this.sets.elementAt(pos).canInsertValue(value) ) {
                canInsert = false;
            }
        }
        if ( canInsert ) {
            Value prevValue = this.cells.elementAt(row).elementAt(col).getValue();
            this.cells.elementAt(row).elementAt(col).setValue(value);
            for (Iterator<Integer> iterator = mySets.iterator(); iterator.hasNext();) {
                int pos = iterator.next();
                this.sets.elementAt(pos).addValue(value, prevValue);
            }
        }
    }

    public boolean checkFinish() {
        for (SetOfValues set : this.sets) {
            if (!set.isSetFinished()) {
                return false;
            }
        }
        return true;
    }

    public Cell getCell(int row, int col) {
        return this.cells.elementAt(row).elementAt(col);
    }

    public void printSets() {
        for (int row = 0; row < this.nsets; ++row) {
            System.out.println("SET :" + row);
            SetOfValues set = this.sets.elementAt(row);
        }
    }

    public void printRuleSets() {
        for (int row = 0; row < this.nsets; ++row) {
            System.out.println("SET :" + row);
            SetOfValues set = this.sets.elementAt(row);
            set.printRules();
        }
    }


    public void loadRulesSet(int idRules,  Vector<Long> values) {
        for (int row = 0; row < this.nsets; ++row) {
            SetOfValues set = this.sets.elementAt(row);
            Rule rule = null;
            if (idRules == 1) {
                rule = new NoRepeatRule();
            } else if (idRules == 2) {
                rule = new SummationRule(values.elementAt(row).intValue());
            }
            set.loadRule(rule);
        }
    }
}