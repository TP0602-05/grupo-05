package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.cell.Value;

import javax.swing.*;
import java.awt.*;


public class KeypadButton extends JButton{

    private Value value;
    private Paintor painter;

    public KeypadButton(Value value) {
        this.value = value;
        painter = new Paintor(value);

        if(value.getValue() != 0) {
            setText(value.getValue().toString());
        }
    }

    public void addKeypadValue(int currentRow, int currentCol) {
        Game.getInstance().addKeypadValue(value,currentRow,currentCol);
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
