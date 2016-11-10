package ar.fiuba.tdd.tp.view;


import ar.fiuba.tdd.tp.model.Observer;

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

                JButton undo = new UndoButton();
                undo.setSize(50,50);
                undo.setVisible(true);
                undo.setText("Undo");
                JPanel panelBoton = new JPanel();
                panelBoton.add(undo,BorderLayout.EAST);


                frame.add(panelBoton, BorderLayout.NORTH);
                frame.pack();
                frame.add(board, BorderLayout.CENTER);
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
        frame.add(board, BorderLayout.CENTER);
        frame.pack();
    }
}