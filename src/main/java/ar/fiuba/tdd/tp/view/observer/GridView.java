package ar.fiuba.tdd.tp.view.observer;


import ar.fiuba.tdd.tp.view.board.Board;

import java.awt.*;
import javax.swing.*;

/*
This is the main frame, that contains everything related to the grid.
Instantiates the frame, and loads the main panel.
Implements the pattern Observer.
On every update resets the board.
 */
public class GridView extends Observer{

    private JFrame frame;
    private Board board;

    public GridView(String gameName) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                frame = new JFrame(gameName);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                board = new Board();
                frame.add(board);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.setResizable(false);
            }
        });
    }

    @Override
    public void update() {
        frame.remove(board);
        board = new Board();
        frame.add(board);
        frame.pack();
    }
}