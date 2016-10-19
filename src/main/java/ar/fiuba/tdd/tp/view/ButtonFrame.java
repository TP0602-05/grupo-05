package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.model.cell.Value;

import java.awt.*;
import java.util.Vector;
import javax.swing.*;

class ButtonFrame extends JFrame {

    // constructor for ButtonFrame
    ButtonFrame(String title) {
        super( title );                     // invoke the JFrame constructor
        setLayout( new FlowLayout() );      // set the layout manager


        Vector<Boolean> dots = new Vector<>(9);
        dots.add(true);
        dots.add(true);
        dots.add(true);
        dots.add(true);
        dots.add(true);
        dots.add(true);
        dots.add(true);
        dots.add(true);
        dots.add(true);

        Value value = new Value(0,dots);
        FlagsButton button = new FlagsButton(value,0,0);


        add(button);                     // add the button to the JFrame
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
}

class ButtonDemo {
    public static void main(String[] args) {
        ButtonFrame frm = new ButtonFrame("Button Demo");

        frm.setSize(300, 150);
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
    }
}