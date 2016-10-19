package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.model.cell.Value;

import java.awt.*;
import java.util.Vector;
import javax.swing.*;

class ButtonDemo {

    static Vector<Boolean> initializeDots() {
        Vector<Boolean> dots = new Vector<>(9);
        dots.add(true);
        dots.add(false);
        dots.add(true);
        dots.add(true);
        dots.add(false);
        dots.add(true);
        dots.add(true);
        dots.add(true);
        dots.add(true);
        return dots;

    }
    public static void main(String[] args) {
        Vector<Boolean> dots = initializeDots();

        Value value = new Value(5,dots);

        KeypadButton button1 = new KeypadButton(value);
        KeypadButton button2 = new KeypadButton(value);
        KeypadButton button3 = new KeypadButton(value);
        KeypadButton button4 = new KeypadButton(value);

        KeypadFrame frame = new KeypadFrame();
        frame.addButon(button1);
        frame.addButon(button2);
        frame.addButon(button3);
        frame.addButon(button4);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}