package ar.fiuba.tdd.tp.model.cell;

import ar.fiuba.tdd.tp.view.BlackBox;
import ar.fiuba.tdd.tp.view.InputButton;

import java.util.Vector;
import javax.swing.*;

/*
 Type #4 in json
 */
public class CellFlagsAndNumbers extends Cell {

    public CellFlagsAndNumbers(Value value) {
        this.setValue(new Vector<>(1));
        /*int dots = value.getNumDots();
        Vector<Boolean> dots1 = new Vector<>();
        for (int i = 0; i < dots; i++) {
            dots1.add(false);
        }
        value = value.setDots(dots1);
        */
        this.getValues().addElement(value);

    }

    @Override
    public JButton getView(int row, int col) {
        JButton button = new InputButton(this.getValue(),row,col);
        return button;
    }
}
