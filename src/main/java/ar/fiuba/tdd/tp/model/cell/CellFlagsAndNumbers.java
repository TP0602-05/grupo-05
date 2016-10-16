package ar.fiuba.tdd.tp.model.cell;

import ar.fiuba.tdd.tp.view.BlackBox;

import javax.swing.*;

/*
 Type #4 in json
 */
public class CellFlagsAndNumbers extends Cell {
    @Override
    public JButton getView(int row, int col) {
        JButton button = new BlackBox();
        return button;
    }
}
