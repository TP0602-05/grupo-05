package ar.fiuba.tdd.tp.model;


import ar.fiuba.tdd.tp.model.cell.Cell;

import java.util.Vector;

public class Grid {
    private Vector<Vector<Cell>> cells;
    private Verifier verifier;

    public Grid(int width, int height) {
        this.verifier = new Verifier();
        this.cells = new Vector<>(height);
        for(int row = 0; row < height; ++row) {
            this.cells.insertElementAt(new Vector<Cell>(width),row);
        }
    }

    public void addCell(Cell cell,int row, int col) {
        this.cells.elementAt(row).insertElementAt(cell, col);
    }

    public Cell getCell(int row, int col) {
        return this.cells.elementAt(row).elementAt(col);
    }

    public boolean verifyRules() {
        return this.verifier.verifyAll();
    }

}
