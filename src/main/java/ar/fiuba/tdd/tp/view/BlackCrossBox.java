package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.model.cell.Value;

import java.awt.*;
import java.util.Vector;
import javax.swing.*;

/*
This kind of JButton is the one that has a crossline, and values in the sides.
 */
public class BlackCrossBox extends Button {

    public BlackCrossBox(Vector<Value> values, int row, int col) {
        setBackground(Color.black);
        setForeground(Color.white);
        setContentAreaFilled(false);
        setOpaque(true);

        Value value1 = values.elementAt(0);
        Value value2 = values.elementAt(1);
        setText(getStringFromValue(value2) + "        " + getStringFromValue(value1));
    }

    private String getStringFromValue(Value value) {
        if (value.getValue() != 0) {
            return value.getValue().toString();
        } else {
            return "    ";
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(Color.white);
        graphics.drawLine(0, 0, getWidth(), getHeight());
        graphics.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(70, 70);
    }
}
