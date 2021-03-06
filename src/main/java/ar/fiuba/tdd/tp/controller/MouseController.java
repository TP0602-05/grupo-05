package ar.fiuba.tdd.tp.controller;

import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.cell.Value;
import ar.fiuba.tdd.tp.view.KeypadFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 * Implementation of Abstract class MouseAdapter. Used for receiving mouse events.
 * This class exists as convenience for creating listener objects.
 *  Mouse events let you track when a mouse is pressed, released, clicked, moved, dragged,
 *  when it enters a component, when it exits and when a mouse wheel is moved.
 */
public class MouseController extends MouseAdapter {
    private int row;
    private int col;

    public MouseController(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        if (!Game.getInstance().getCell(row, col).isBlocked()) {
            if (event.getButton() == MouseEvent.BUTTON1) {
                KeypadFrame frame = new KeypadFrame();
                for (Value value : Game.getInstance().getAllowedValues()) {
                    frame.addButon(value,row,col);
                }
                frame.pack();
                frame.setVisible(true);
            } else if (event.getButton() == MouseEvent.BUTTON3) {
                Game.getInstance().deleteValue(row, col);
            }
        }
    }
}
