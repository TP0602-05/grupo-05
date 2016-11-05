package ar.fiuba.tdd.tp.view;


import ar.fiuba.tdd.tp.model.cell.Value;

import java.awt.*;
import java.awt.geom.Line2D;

import java.util.Vector;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class Paintor {

    private Value value;
    private Border borders;

    public Paintor(Value value) {
        this.value = value;
        borders = new MatteBorder(0,0,0,0,Color.black);
    }

    void drawOne(Vector<Boolean> dots, Graphics2D g2, int height, int width) {

        //1
        if (dots.get(0) && dots.get(3) && dots.get(6)) {
            g2.draw(new Line2D.Float(0, 0, 0, height));
        }

        //2
        if (dots.get(0) && dots.get(1) && dots.get(2)) {
            g2.draw(new Line2D.Float(0, 0, width, 0));
        }

    }

    void drawTwo(Vector<Boolean> dots, Graphics2D g2, int height, int width) {

        //4
        if (dots.get(6) && dots.get(7) && dots.get(8)) {
            g2.draw(new Line2D.Float(0, height, width, height));
        }

        //5
        if (dots.get(0) && dots.get(4) && dots.get(8)) {
            g2.draw(new Line2D.Float(0, 0, width, height));
        }
    }

    void drawThree(Vector<Boolean> dots, Graphics2D g2, int height, int width) {
        //7
        if (dots.get(4) && dots.get(5) && dots.get(7)) {
            g2.draw(new Line2D.Float(width / (float) 2, height / (float) 2, width, height / (float) 2));
            g2.draw(new Line2D.Float(width / (float) 2, height / (float) 2, width / (float) 2, height));
        }

        //8
        if (dots.get(3) && dots.get(4) && dots.get(7)) {
            g2.draw(new Line2D.Float(0, height / (float) 2, width / (float) 2, height / (float) 2));
            g2.draw(new Line2D.Float(width / (float) 2, height / (float) 2, width / (float) 2, height));
        }

    }

    void drawFour(Vector<Boolean> dots, Graphics2D g2, int height, int width) {
        //3
        if (dots.get(2) && dots.get(5) && dots.get(8)) {
            g2.draw(new Line2D.Float(width, 0, width, height));
        }

        //6
        if (dots.get(2) && dots.get(4) && dots.get(6)) {
            g2.draw(new Line2D.Float(width, 0, 0, height));
        }
    }

    void drawFive(Vector<Boolean> dots, Graphics2D g2, int height, int width) {
        //10
        if (dots.get(1) && dots.get(3) && dots.get(4)) {
            g2.draw(new Line2D.Float(width / (float) 2, height / (float) 2, 0, height / (float) 2));
            g2.draw(new Line2D.Float(width / (float) 2, height / (float) 2, width / (float) 2, 0));
        }

        //9
        if (dots.get(1) && dots.get(4) && dots.get(5)) {
            g2.draw(new Line2D.Float(width / (float) 2, height / (float) 2, width / (float) 2, 0));
            g2.draw(new Line2D.Float(width / (float) 2, height / (float) 2, width, height / (float) 2));
        }
    }

    public void paint(Graphics graphics, int width, int height) {
        Vector<Boolean> dots = value.getDots();
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setStroke(new BasicStroke(15));

        drawOne(dots,g2,height,width);
        drawTwo(dots,g2,height,width);
        drawThree(dots,g2,height,width);
        drawFour(dots,g2,height,width);
        drawFive(dots,g2,height,width);

        //11
        if (dots.get(1) && dots.get(4) && dots.get(7)) {
            g2.draw(new Line2D.Float(width / (float) 2, 0, width / (float) 2, height));
        }

        //12
        if (dots.get(3) && dots.get(4) && dots.get(5)) {
            g2.draw(new Line2D.Float(0, height / (float) 2, width, height / (float) 2));
        }

    }

    public Border getBorders() {
        return borders;
    }

    public void setBorders(Border borders) {
        this.borders = borders;
    }
}
