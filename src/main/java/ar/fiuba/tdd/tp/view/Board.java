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

                Button cellPane;
                cellPane = getCellType(row,col);

                add(cellPane, gbc);
            }
        }
    }

    private Button getCellType(int row, int col) {
        Cell cell = Game.getInstance().getCell(row,col);
        Button cellPane;
        cellPane = cell.getView(row,col);
        Vector<Integer> bordersCell = Game.getInstance().getCell(row,col).getBorders();
        Border border = new MatteBorder(bordersCell.get(0) * 4,bordersCell.get(1) * 4,bordersCell.get(2) * 4,bordersCell.get(3) * 4,Color.yellow);
        cellPane.setBorders(border);
        return cellPane;
    }

}