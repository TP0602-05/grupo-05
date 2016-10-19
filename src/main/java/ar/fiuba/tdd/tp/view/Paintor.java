package ar.fiuba.tdd.tp.view;


import ar.fiuba.tdd.tp.model.cell.Value;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Vector;

public class Paintor {

    private Value value;

    public Paintor(Value value) {
        this.value = value;
    }

    public void paint(Graphics graphics, int width, int height) {
        Vector<Boolean> dots = value.getDots();
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setStroke(new BasicStroke(20));
        if (dots.get(0) && dots.get(0) && dots.get(0)) {
            g2.draw(new Line2D.Float(0, 0, width, height));
        }

        g2.dispose();
    }
}
