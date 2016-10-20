package ar.fiuba.tdd.tp.model.cell;

import ar.fiuba.tdd.tp.view.BlackBox;
import ar.fiuba.tdd.tp.view.Button;
import ar.fiuba.tdd.tp.view.FlagsButton;
import ar.fiuba.tdd.tp.view.InputButton;

import java.util.Vector;
import javax.swing.*;

/*
 Type #4 in json
 */
public class CellFlagsAndNumbers extends Cell {

    public CellFlagsAndNumbers(Value value) {
        this.setValue(new Vector<>(1));
        this.getValues().addElement(value);
    }

    @Override
    public Button getView(int row, int col) {
        Button button = new FlagsButton(this.getValue(),row,col);
        return button;
    }
}
