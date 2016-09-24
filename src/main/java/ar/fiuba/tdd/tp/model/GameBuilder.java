package ar.fiuba.tdd.tp.model;

import ar.fiuba.tdd.tp.model.cell.WriteCell;

/**
 * Created by joaquin on 24/09/16.
 */
public class GameBuilder {

    private String gameName;

    public GameBuilder(String gameName) {
        this.gameName = gameName;
    }

    public Grid createGrid(int width, int height) {
        Grid grid = new Grid(width,height);
        //TODO: depending on the game, some Cells must be added as ReadCell
        for(int row = 0; row < height; ++row) {
            for (int col = 0; col < width; ++col) {
                grid.addCell(new WriteCell(),row,col);
            }
        }
        return grid;
    }

    public void createSetsOfValues(Grid grid) {

    }
}
