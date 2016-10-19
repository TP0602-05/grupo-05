package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.controller.MouseController;
import ar.fiuba.tdd.tp.model.cell.Value;

import java.awt.*;
import javax.swing.*;


public class FlagsButton extends JButton {

    private Paintor painter;

    public FlagsButton(Value value, int row, int col) {
        painter = new Paintor(value);
        addMouseListener(new MouseController(row,col));

        if(value.getValue() != 0) {
            setText(value.getValue().toString());
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        painter.paint(graphics,getWidth(),getHeight());
        graphics.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(70, 70);
    }
}
