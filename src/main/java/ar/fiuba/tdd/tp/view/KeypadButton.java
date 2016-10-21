package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.cell.Value;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;


public class KeypadButton extends Button {

    private Value value;

    public KeypadButton(Value value) {
        this.value = value;
        painter = new Paintor(value);

        if (value.getValue() != 0) {
            setText(value.getValue().toString());
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        painter.paint(graphics,getWidth(),getHeight());
        graphics.dispose();
    }

}
