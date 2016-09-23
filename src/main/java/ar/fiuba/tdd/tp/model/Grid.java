package ar.fiuba.tdd.tp.model;


public class Grid {
    Cell[][] cells;
    Verifier verifier;

    public Grid() {
        cells = null;
        verifier = new Verifier();
    }

    public boolean insertValue(int row, int col, Object obj) {
        if (!cells[row][col].isBlocked()){
            return verifier.insertValue(row,col,obj);
        }
        else {
            return false;
        }
    }

    public boolean deleteValue(int row, int col) {
        if (!cells[row][col].isBlocked()) {
            verifier.deleteValue(row, col, cells[row][col].getValue());
            return true;
        }
        else{
            return false;
        }
    }
}
