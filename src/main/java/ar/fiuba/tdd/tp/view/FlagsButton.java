package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.model.cell.Value;

import java.awt.*;
import javax.swing.*;


public class FlagsButton extends JButton {

    Paintor painter;

    public FlagsButton(Value value, int row, int col) {
        painter = new Paintor(value);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        painter.paint(graphics,getWidth(),getHeight());
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(70, 70);
    }
}
