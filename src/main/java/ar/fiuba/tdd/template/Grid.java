package ar.fiuba.tdd.template;


public class Grid {
    Cell[][] cells;
    Verifier verifier;

    public boolean insertValue(int row, int col, int value){
        if (!cells[row][col].isBlocked())
            return verifier.insertValue(row,col,value);
        else
            return false;
    }

    public boolean deleteValue(int row, int col) {
        if (!cells[row][col].isBlocked()) {
            verifier.deleteValue(row, col, cells[row][col].getValue());
            return true;
        }
        else
            return false;
    }
}
