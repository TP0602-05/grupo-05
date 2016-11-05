package ar.fiuba.tdd.tp.model;

import ar.fiuba.tdd.tp.model.cell.Cell;
import ar.fiuba.tdd.tp.model.cell.Value;
import ar.fiuba.tdd.tp.view.GridView;

import java.util.Vector;

public class Game extends Observable {
    private static Game instance = null;
    private GridView gridView;
    private Grid grid;
    private GameBuilder gameBuilder;
    private Vector<Value> allowedValues;
    private boolean isFinished;

    public Vector<Value> getAllowedValues() {
        return allowedValues;
    }

    private Game(String gameName) {
        gameBuilder = new GameBuilder(gameName);
        try {
            gameBuilder.loadConf();
        } catch (Exception e) {
            e.printStackTrace();
        }
        grid = gameBuilder.createGrid();

        this.isFinished = false;

        gridView = new GridView(gameName);
        this.addObserver(gridView);
        this.addObserver(new FinishGameListener());
        this.allowedValues = this.gameBuilder.getAllowedValues();
    }

    public static Game getInstance() {
        return instance;
    }

    public static void init(String gameName) {
        instance = new Game(gameName);
    }

    private void update() {
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

    public boolean setValue(int row, int col, Value value) {
        boolean worked = grid.setCell(value, row, col);
        this.update();
        this.notifyObservers();
        return worked;
    }

    public boolean setValueInCompilationTime(int row, int col, Value value) {
        boolean worked = grid.setCell(value, row, col);
        this.update();
        return worked;
    }

    public void deleteValue(int row, int col) {
        grid.emptyCell(row, col);
        this.update();
        this.notifyObservers();
    }

    public boolean addKeypadValue(Value value, int row, int col) {
        //boolean worked = grid.addKeypadValue(value, row, col);
        /* System.out.println("VALOR: " + value.getValue());
        System.out.println("FILA: " + row);
        System.out.println("COLUMNA: " + col); */
        boolean worked = grid.setCell(value, row, col);
        this.update();
        this.notifyObservers();
        return worked;
    }
}