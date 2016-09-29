package ar.fiuba.tdd.tp.model;

import ar.fiuba.tdd.tp.view.GridView;
import ar.fiuba.tdd.tp.model.cell.Cell;
import ar.fiuba.tdd.tp.model.cell.Value;

public class Game extends Observable {
    private static Game instance = null;
    private GridView gridView;
    private Grid grid;
    private GameBuilder gameBuilder;
    private boolean isFinished;

    private Game(String gameName) {
        gameBuilder = new GameBuilder(gameName);
        try {
            gameBuilder.loadConf();
        } catch (Exception e) {
            e.printStackTrace();
        }
        grid = gameBuilder.createGrid();
       // grid.printRuleSets();

        this.isFinished = false;

        gridView = new GridView(gameName);
        this.addObserver(gridView);
        this.addObserver(new FinishGameListener());
    }

    public static Game getInstance() {
        return instance;
    }

    public static void init(String gameName) {
        instance = new Game(gameName);
    }

    public void update() {
        this.isFinished = this.grid.checkFinish();
    }

    public boolean checkFinish() {
        return this.isFinished;
    }

    public Value getValue(int row, int col) {
        Cell cell = this.grid.getCell(row,col);
        return cell.getValue();
    }

    public int getRows() {
        return this.grid.getHeight();
    }

    public int getCols() {
        return this.grid.getWidth();
    }

    public Cell getCell(int row, int col) {
        return this.grid.getCell(row,col);
    }

    public void setValue(int row, int col, Value value) {
        grid.setCell(value, row, col);
        this.update();
        this.notifyObservers();
    }

    public void deleteValue(int row, int col) {
        grid.emptyCell(row, col);
        this.update();
        this.notifyObservers();
    }
}