package ar.fiuba.tdd.tp.model.cell;

import ar.fiuba.tdd.tp.view.BlackBox;
import ar.fiuba.tdd.tp.view.Button;

import java.util.Vector;

/*
 Type #3 in json
 */
public class CellBlack extends Cell {
    public CellBlack() {
        this.value = new Vector<>();
        this.value.add(new Value(-1));
    }

    @Override
    public Button getView(int row, int col) {
        Button button = new BlackBox();
        return button;
    }
}
