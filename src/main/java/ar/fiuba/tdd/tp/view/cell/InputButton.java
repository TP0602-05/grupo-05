package ar.fiuba.tdd.tp.view.cell;

import ar.fiuba.tdd.tp.controller.MouseController;
import ar.fiuba.tdd.tp.model.cell.data.Value;

import java.awt.*;
import javax.swing.*;

/*
This kind of JButton is the one for the data input in the grid.
 */
public class InputButton extends JButton {

    public InputButton(Value value, int row, int col) {
        addMouseListener(new MouseController(row,col));

        if (value.getValue() != 0) {
            setText(value.getValue().toString());
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(70, 70);
    }
}