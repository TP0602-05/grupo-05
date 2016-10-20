package ar.fiuba.tdd.tp.model.cell;

import ar.fiuba.tdd.tp.view.BlackBox;
import ar.fiuba.tdd.tp.view.Button;

import javax.swing.*;

/*
 Type #3 in json
 */
public class CellBlack extends Cell {
    @Override
    public Button getView(int row, int col) {
        Button button = new BlackBox();
        return button;
    }
}
