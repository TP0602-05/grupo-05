package ar.fiuba.tdd.tp.model.cell;

import ar.fiuba.tdd.tp.view.Button;
import ar.fiuba.tdd.tp.view.FlagsButton;
import ar.fiuba.tdd.tp.view.InputFlagsButton;

import java.awt.*;
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

    public Boolean isBlackCell() {
        Value value = this.getValue();
        Vector<Boolean> dots = value.getDots();
        Boolean line = dots.get(0) && dots.get(1) && dots.get(2);

        if (line && dots.get(3) && dots.get(4) && dots.get(5)
                && dots.get(6) && dots.get(7) && dots.get(8)) {
            return true;
        } else {
            return false;
        }
    }
}
