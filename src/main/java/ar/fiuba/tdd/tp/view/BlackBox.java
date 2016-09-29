package ar.fiuba.tdd.tp.view;

import java.awt.*;
import javax.swing.*;

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
