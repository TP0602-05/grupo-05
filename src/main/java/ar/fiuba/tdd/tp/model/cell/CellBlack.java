package ar.fiuba.tdd.tp.model.cell;

import ar.fiuba.tdd.tp.view.cell.BlackBox;

import javax.swing.*;

/*
 Type #3 in json
 */
public class CellBlack extends Cell {
    @Override
    public JButton getView(int row, int col) {
        JButton button = new BlackBox();
        return button;
    }
}
