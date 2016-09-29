package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.controller.MouseController;
import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.cell.Value;

import java.awt.*;
import javax.swing.*;

public class InputButton extends JButton {

    //TODO: Dividir esto, NCSS max es 20
    public InputButton(Value value, int row, int col) {
        addMouseListener(new MouseController(row,col));

        Value valueAux = Game.getInstance().getValue(row,col);
        if (valueAux.getValue() != 0) {
            setText(value.getValue().toString());
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(70, 70);
    }
}