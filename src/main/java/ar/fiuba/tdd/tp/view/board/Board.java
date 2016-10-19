package ar.fiuba.tdd.tp.view.board;

import ar.fiuba.tdd.tp.model.observables.Game;
import ar.fiuba.tdd.tp.model.cell.Cell;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

/*
This is the panel that contains the grid.
The constructor loads all the cell of the grid.
 */
public class Board extends JPanel {

    public Board() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        int gridRows = Game.getInstance().getRows();
        int gridCols = Game.getInstance().getCols();

        for (int row = 0; row < gridRows; row++) {
            for (int col = 0; col < gridCols; col++) {
                gbc.gridx = col;
                gbc.gridy = row;

                JButton cellPane;
                cellPane = getCellType(row,col);

                if (Game.getInstance().gridHasBlocks()) {
                    cellPane.setBorder(setBlocks(row,col));
                }

                add(cellPane, gbc);
            }
        }
    }

    private JButton getCellType(int row, int col) {
        Cell cell = Game.getInstance().getCell(row,col);
        JButton cellPane;
        cellPane = cell.getView(row,col);
        return cellPane;
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