package ar.fiuba.tdd.tp.view;

import java.awt.*;
import javax.swing.*;

public abstract class Button extends JButton {
    Paintor painter;

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
