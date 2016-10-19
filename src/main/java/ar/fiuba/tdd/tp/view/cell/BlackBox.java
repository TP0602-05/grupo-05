package ar.fiuba.tdd.tp.view.cell;

import java.awt.*;
import javax.swing.*;

/*
This kind of JButton is all black.
 */
public class BlackBox extends JButton {

    public BlackBox() {
        setBackground(Color.black);
        setContentAreaFilled(false);
        setOpaque(true);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(70, 70);
    }
}
