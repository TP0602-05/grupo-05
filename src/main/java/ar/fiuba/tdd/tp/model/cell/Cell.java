package ar.fiuba.tdd.tp.model.cell;

public class Cell {
    private boolean blocked;
    private Object value;

    public Cell() {
        this.blocked = false;
        this.value = null;
    }

    Cell(Object value) {
        this.blocked = true;
        this.value = value;
    }

    boolean isBlocked() {
        return this.blocked;
    }

    void setValue(Object value) {
        if ( ! this.isBlocked() ) {
            this.value = value;
        }
    }

    Object getValue() {
        return this.value;
    }
}
