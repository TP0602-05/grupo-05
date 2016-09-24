package ar.fiuba.tdd.tp.model;


import ar.fiuba.tdd.tp.model.cell.Cell;

import java.util.Vector;

class Grid {
    private Vector<Vector<Cell>> cells;

    Grid(int width, int height) {
        this.cells = new Vector<>(height);
        for (int row = 0; row < height; ++row) {
            this.cells.insertElementAt(new Vector<>(width),row);
        }
    }

    void addCell(Cell cell,int row, int col) {
        this.cells.elementAt(row).insertElementAt(cell, col);
    }

    public Cell getCell(int row, int col) {
        return this.cells.elementAt(row).elementAt(col);
    }

}
