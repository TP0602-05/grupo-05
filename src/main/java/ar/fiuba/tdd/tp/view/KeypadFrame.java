package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.cell.Position;
import ar.fiuba.tdd.tp.model.cell.Value;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class KeypadFrame extends JFrame {

    //private int currentRow;
    //private int currentCol;
    private GridBagConstraints gbc;
    private int itemsInRow;
    private int maxItemsInRow;


    public KeypadFrame() {
        setTitle("Keypad");
        setLayout(new GridBagLayout());
        setLocationRelativeTo(null);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.gridy = 0;
        maxItemsInRow = 3;
        itemsInRow = 0;
    }

    public void addButon(Value value, int row, int col) {
        itemsInRow++;
        KeypadButton button = new KeypadButton(value);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Game.getInstance().addKeypadValue(value,row,col);
                dispose();
            }
        });

        add(button,gbc);
        if (itemsInRow == maxItemsInRow) {
            gbc.gridy += 1 ;
            itemsInRow = 0;
        }
    }
/*
    public void setCurrentPosition(Position position) {
        currentRow = position.getYpos();
        currentCol = position.getYpos();
    }
*/
}
