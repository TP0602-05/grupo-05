package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.controller.MouseController;
import ar.fiuba.tdd.tp.model.cell.Value;

import java.awt.*;


public class InputFlagsButton extends FlagsButton {
    public InputFlagsButton(Value value, int row, int col) {
        super(value);
        addMouseListener(new MouseController(row,col));
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
    }
}
