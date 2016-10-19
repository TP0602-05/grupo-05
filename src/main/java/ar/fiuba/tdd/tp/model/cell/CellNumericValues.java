package ar.fiuba.tdd.tp.model.cell;

import ar.fiuba.tdd.tp.model.cell.data.Value;
import ar.fiuba.tdd.tp.view.cell.InputButton;

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
    public JButton getView(int row, int col) {
        JButton button = new InputButton(getValue(),row,col);
        return button;
    }
}
