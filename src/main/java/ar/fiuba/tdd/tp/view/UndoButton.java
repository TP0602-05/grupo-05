package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.controller.UndoController;

import javax.swing.*;


public class UndoButton extends JButton {

    public UndoButton() {
         //setText("UNDO");
        this.setSize(50,50);
        this.setVisible(true);
        this.setText("Undo");
        addMouseListener(new UndoController());
    }


}
