package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.cell.Value;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;


public class KeypadButton extends FlagsButton {

    public KeypadButton(Value value) {
        super(value);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.dispose();
    }

}
