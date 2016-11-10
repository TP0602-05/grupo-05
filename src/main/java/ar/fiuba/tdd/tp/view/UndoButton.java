package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.controller.UndoController;

import javax.swing.*;


public class UndoButton extends JButton {

    public UndoButton() {
         //setText("UNDO");
        addMouseListener(new UndoController());
    }


}
