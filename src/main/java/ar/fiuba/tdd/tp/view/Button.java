package ar.fiuba.tdd.tp.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public abstract class Button extends JButton {
    Paintor painter;

    public void setBorders(Border border) {
        painter.setBorders(border);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        painter.paint(graphics,getWidth(),getHeight());
        setBorder(painter.getBorders());
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(70, 70);
    }
}
