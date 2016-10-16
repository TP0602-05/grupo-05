package ar.fiuba.tdd.tp.model.cell;

import ar.fiuba.tdd.tp.view.InputButton;

import javax.swing.*;
import java.util.Vector;

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
    public JButton getView(int row, int col) {
        JButton button = new InputButton(getValue(),row,col);
        return button;
    }
}
