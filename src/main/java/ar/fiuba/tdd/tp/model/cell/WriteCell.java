package ar.fiuba.tdd.tp.model.cell;

public class WriteCell extends Cell{

    public WriteCell(Integer value) {
        super(value);
    }

    public WriteCell() {
        super(null);
    }

    public void writeValue(Integer value) {
        this.value = value;
    }
}
