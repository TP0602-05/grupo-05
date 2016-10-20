package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.cell.Cell;
import ar.fiuba.tdd.tp.model.cell.Value;

import java.awt.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

/*
This is the panel that contains the grid.
The constructor loads all the cells of the grid.
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

}