package ar.fiuba.tdd.tp.model;

import ar.fiuba.tdd.tp.model.cell.Cell;

public class GameBuilder {

    private String gameName;

    public GameBuilder(String gameName) {
        this.gameName = gameName;
    }

    public Grid createGrid(int width, int height) {
        Grid grid = new Grid(width,height);
        //TODO: depending on the game, some Cells must be added as ReadCell
        for (int row = 0; row < height; ++row) {
            for (int col = 0; col < width; ++col) {
                grid.addCell(new Cell(),row,col);
            }
        }
        return grid;
    }

    public void createSetsOfValues(Grid grid) {

    }
}
