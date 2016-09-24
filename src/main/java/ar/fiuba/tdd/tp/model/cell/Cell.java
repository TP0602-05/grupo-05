package ar.fiuba.tdd.tp.model.cell;

public abstract class Cell {
    Integer value;

    public Cell(Integer value) {
        this.value = value;
    }

    public Integer readValue() {
        return this.value;
    }

}
