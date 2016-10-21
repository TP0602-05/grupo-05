package ar.fiuba.tdd.tp.model.cell;

import ar.fiuba.tdd.tp.view.Button;
import ar.fiuba.tdd.tp.view.FlagsButton;
import ar.fiuba.tdd.tp.view.InputFlagsButton;

import java.util.Vector;

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
        Button button = new InputFlagsButton(this.getValue(),row,col);
        return button;
    }
}
