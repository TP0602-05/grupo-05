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
        g2.setStroke(new BasicStroke(15));

        //1
        if (dots.get(0) && dots.get(3) && dots.get(6)) {
            g2.draw(new Line2D.Float(0, 0, 0, height));
        }

        //2
        if (dots.get(0) && dots.get(1) && dots.get(2)) {
            g2.draw(new Line2D.Float(0, 0, width, 0));
        }

        //3
        if (dots.get(2) && dots.get(5) && dots.get(8)) {
            g2.draw(new Line2D.Float(width, 0, width, height));
        }

        //4
        if (dots.get(6) && dots.get(7) && dots.get(8)) {
            g2.draw(new Line2D.Float(0, height, width, height));
        }

        //5
        if (dots.get(0) && dots.get(4) && dots.get(8)) {
            g2.draw(new Line2D.Float(0, 0, width, height));
        }

        //6
        if (dots.get(2) && dots.get(4) && dots.get(6)) {
            g2.draw(new Line2D.Float(width, 0, 0, height));
        }

        //7
        if (dots.get(4) && dots.get(5) && dots.get(7)) {
            g2.draw(new Line2D.Float(width/2, height/2, width, height/2));
            g2.draw(new Line2D.Float(width/2, height/2, width/2, height));
        }

        //8
        if (dots.get(3) && dots.get(4) && dots.get(7)) {
            g2.draw(new Line2D.Float(0, height/2, width/2, height/2));
            g2.draw(new Line2D.Float(width/2, height/2, width/2, height));
        }

        //9
        if (dots.get(1) && dots.get(4) && dots.get(5)) {
            g2.draw(new Line2D.Float(width/2, height/2, width/2, 0));
            g2.draw(new Line2D.Float(width/2, height/2, width, height/2));
        }

        //10
        if (dots.get(1) && dots.get(3) && dots.get(4)) {
            g2.draw(new Line2D.Float(width/2, height/2, 0, height/2));
            g2.draw(new Line2D.Float(width/2, height/2, width/2, 0));
        }

        //11
        if (dots.get(1) && dots.get(4) && dots.get(7)) {
            g2.draw(new Line2D.Float(width/2, 0, width/2, height));
        }

        //12
        if (dots.get(3) && dots.get(4) && dots.get(5)) {
            g2.draw(new Line2D.Float(0, height/2, width, height/2));
        }

    }
}
