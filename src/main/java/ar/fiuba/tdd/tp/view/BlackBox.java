package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.model.cell.Value;

import java.awt.*;
import javax.swing.*;

/*
This kind of JButton is all black.
 */
public class BlackBox extends Button {

    public BlackBox() {
        painter = new Paintor(new Value(0));
        setBackground(Color.black);
        setContentAreaFilled(false);
        setOpaque(true);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(70, 70);
    }
}
