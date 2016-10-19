package ar.fiuba.tdd.tp.model.cell;

import ar.fiuba.tdd.tp.model.cell.data.Value;
import ar.fiuba.tdd.tp.view.cell.BlackCrossBox;

import java.util.Vector;
import javax.swing.*;

/*
 Type #2 in json
 */
public class CellDualSum extends Cell {

    public CellDualSum(Vector<Value> values) {
        this.setBlocked(true);
        this.setValue(values);
    }

    @Override
    public JButton getView(int row, int col) {
        JButton button = new BlackCrossBox(getValues(),row,col);
        return button;
    }
}
