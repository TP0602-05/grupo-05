package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.controller.MouseController;
import ar.fiuba.tdd.tp.model.cell.Value;

import java.awt.*;
import javax.swing.*;


public class FlagsButton extends Button {

    public FlagsButton(Value value, int row, int col) {
        this.painter = new Paintor(value);
        addMouseListener(new MouseController(row,col));

        if (value.getValue() != 0) {
            setText(value.getValue().toString());
        }
    }

}
