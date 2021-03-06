package ar.fiuba.tdd.tp.model.cell;

import ar.fiuba.tdd.tp.view.BlackBox;
import ar.fiuba.tdd.tp.view.BlackCrossBox;
import ar.fiuba.tdd.tp.view.Button;

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
    public Button getView(int row, int col) {
        Button button = new BlackCrossBox(getValues(),row,col);
        return button;
    }
}
