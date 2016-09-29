package ar.fiuba.tdd.tp.view;


import ar.fiuba.tdd.tp.model.Game;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;


public class Pane extends JPanel {

    public Pane() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        int gridRows = Game.getInstance().getRows();
        int gridCols = Game.getInstance().getCols();

        for (int row = 0; row < gridRows; row++) {
            for (int col = 0; col < gridCols; col++) {
                gbc.gridx = col;
                gbc.gridy = row;

                JButton cellPane;
                // esto viola Demeter Law, falta refactorizar a.getB().getC()
                if (Game.getInstance().getCell(row,col).getAmountOfValues() == 1) {
                    cellPane = new InputButton(Game.getInstance().getValue(row,col), row, col);
                } else {
                    //Demeter Law again
                    cellPane = new BlackButton(Game.getInstance().getCell(row,col).getValues(),row,col);
                }

                if (Game.getInstance().gridHasBlocks()) {
                    cellPane.setBorder(setBlocks(row,col));
                }
                add(cellPane, gbc);
            }
        }
    }

    private Border setBlocks(int row, int col) {
        Border border = null;
        if ((row % 3) == 0 && (col % 3) == 0) {
            border = new MatteBorder(4, 4, 0, 0, Color.pink);
        } else {
            if ((row % 3) == 0) {
                border = new MatteBorder(4, 0, 0, 0, Color.pink);
            } else {
                if ((col % 3) == 0) {
                    border = new MatteBorder(0, 4, 0, 0, Color.pink);
                }
            }
        }
        return border;
    }
}