package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.model.cell.Value;

import java.awt.*;


public class FlagsButton extends Button {

    public FlagsButton(Value value) {
        this.painter = new Paintor(value);

        if (value.getValue() != -1) {
            setText(value.getValue().toString());
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        painter.paint(graphics,getWidth(),getHeight());
        setBorder(painter.getBorders());
    }
}
