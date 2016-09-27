package ar.fiuba.tdd.tp.model;

import ar.fiuba.tdd.tp.model.cell.Cell;

import java.util.Vector;

public class Grid {
    private Vector<Vector<Cell>> cells;
    int width;
    int height;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new Vector<>(height);
        for (int row = 0; row < height; ++row) {
            this.cells.insertElementAt(new Vector<>(width),row);
        }
    }

    public void printGrid() {
        System.out.println("-------------------------------------");
        for (int row = 0; row < height; ++row) {
            String fila = "| ";
            for (int col = 0; col < width; ++col) {
                //System.out.println("ROW:"+row+"/ COL:"+col);
                String val = this.cells.elementAt(row).elementAt(col).toString();
                //System.out.print(val);
                fila = fila.concat(val);
                fila = fila.concat(" | ");
            }
            System.out.println(fila);
            System.out.println("-------------------------------------");

        }

    }

    public void addCell(Cell cell,int row, int col) {
        this.cells.elementAt(row).insertElementAt(cell, col);
    }

    public void setCell(Cell cell,int row, int col) {
        this.cells.elementAt(row).setElementAt(cell, col);
    }

    public Cell getCell(int row, int col) {
        return this.cells.elementAt(row).elementAt(col);
    }

}