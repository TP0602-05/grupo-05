package ar.fiuba.tdd.tp.model;

import ar.fiuba.tdd.tp.GridView;
import ar.fiuba.tdd.tp.model.cell.Cell;
import ar.fiuba.tdd.tp.model.cell.Value;

public class Game extends Observable {
    private static Game instance = null;
    private GridView gridView;
    private Grid grid;
    private GameBuilder gameBuilder;

    private Game(String gameName) {
        gameBuilder = new GameBuilder(gameName);
        try {
            gameBuilder.loadConf();
        } catch (Exception e) {
            e.printStackTrace();
        }
        grid = gameBuilder.createGrid();
        grid.printRuleSets();

        gridView = new GridView(gameName);
        this.addObserver(gridView);
    }

    public static Game getInstance() {
        return instance;
    }

    public static void init(String gameName) {
        instance = new Game(gameName);
    }

    public Value getValue(int row, int col) {
        Cell cell = this.grid.getCell(row,col);
        return cell.getValue();
    }

    public void setValue(int row, int col, Value value) {
        grid.setCell(new Cell(value), row, col);
        this.notifyObservers();
    }

}