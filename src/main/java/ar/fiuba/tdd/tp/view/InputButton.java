package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.controller.MouseController;
import ar.fiuba.tdd.tp.model.cell.Value;

import java.awt.*;
import javax.swing.*;

/*
This kind of JButton is the one for the data input in the grid.
 */
public class InputButton extends Button {

    public InputButton(Value value, int row, int col) {
        addMouseListener(new MouseController(row,col));

        if (value.getValue() != 0) {
            setText(value.getValue().toString());
        }
    }

}