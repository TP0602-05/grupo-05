package ar.fiuba.tdd.tp.model.cell;

public class Cell {
    private boolean blocked;
    private Value value;

    public Cell() {
        this.blocked = false;
        this.value = new Value(0);
    }

    public Cell(Value value) {
        this.blocked = true;
        this.value = value;
    }

    public boolean isBlocked() {
        return this.blocked;
    }

    public void setValue(Value value) {
        if ( ! this.isBlocked() ) {
            this.value = value;
        }
    }

    public Value getValue() {
        return this.value;
    }

    public String toString() {
        return this.value.toString();
    }

    public void printCell() {
        this.value.printValue();
    }
}
