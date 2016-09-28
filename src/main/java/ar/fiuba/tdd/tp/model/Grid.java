package ar.fiuba.tdd.tp.model;

import ar.fiuba.tdd.tp.model.cell.Cell;
import ar.fiuba.tdd.tp.model.rule.NoRepeatRule;
import ar.fiuba.tdd.tp.model.rule.Rule;
import ar.fiuba.tdd.tp.model.rule.SummationRule;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class Grid {
    private Vector<Vector<Cell>> cells;
    private Vector<SetOfValues> sets;
    private int width;
    private int height;
    private int nsets;

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
        for (Iterator<Long> iterator = sets.iterator(); iterator.hasNext();) {
            int pos = (int)((Long) iterator.next()).intValue();
            this.sets.elementAt(pos - 1).insertValue( cell.getValue());
        }
    }

    public void setCell(Cell cell,int row, int col) {
        this.cells.elementAt(row).setElementAt(cell, col);
    }

    public Cell getCell(int row, int col) {
        return this.cells.elementAt(row).elementAt(col);
    }

    public void printSets() {
        for (int row = 0; row < this.nsets; ++row) {
            System.out.println("SET :" + row);
            SetOfValues set = this.sets.elementAt(row);
            set.printSet();
        }
    }

    public void printRuleSets() {
        for (int row = 0; row < this.nsets; ++row) {
            System.out.println("SET :" + row);
            SetOfValues set = this.sets.elementAt(row);
            set.printRules();
        }
    }

    public void loadRulesSet(int idRules,  Vector<Integer> values) {
        for (int row = 0; row < this.nsets; ++row) {
            SetOfValues set = this.sets.elementAt(row);
            Rule rule = null;
            if (idRules == 1) {
                rule = new NoRepeatRule();
            } else if (idRules == 2) {
                rule = new SummationRule(values.elementAt(row));
            }
            set.loadRule(rule);
        }
    }


}