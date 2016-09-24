package ar.fiuba.tdd.tp.model.cell;

public class Cell {
    private boolean blocked;
    private Value value;

    public Cell() {
        this.blocked = false;
        this.value = null;
    }

    Cell(Value value) {
        this.blocked = true;
        this.value = value;
    }

    boolean isBlocked() {
        return this.blocked;
    }

    void setValue(Value value) {
        if ( ! this.isBlocked() ) {
            this.value = value;
        }
    }

    Value getValue() {
        return this.value;
    }
}
