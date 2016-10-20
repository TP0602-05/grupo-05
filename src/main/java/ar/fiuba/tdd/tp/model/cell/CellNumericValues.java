package ar.fiuba.tdd.tp.model.cell;

import ar.fiuba.tdd.tp.view.Button;
import ar.fiuba.tdd.tp.view.InputButton;

import java.util.Vector;
import javax.swing.*;

/*
 Type #1 in json
 */
public class CellNumericValues extends Cell {

    public CellNumericValues(Value value, boolean isBlocked) {
        this.setValue(new Vector<>(1));
        this.setBlocked(isBlocked);
        this.getValues().addElement(value);
    }

    @Override
    public Button getView(int row, int col) {
        Button button = new InputButton(getValue(),row,col);
        return button;
    }
}
