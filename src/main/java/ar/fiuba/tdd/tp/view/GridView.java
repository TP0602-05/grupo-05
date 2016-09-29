package ar.fiuba.tdd.tp.view;


import ar.fiuba.tdd.tp.model.Observer;

import java.awt.*;
import javax.swing.*;

public class GridView extends Observer{

    private JFrame frame;
    private Pane pane;

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
                pane = new Pane();
                frame.add(pane);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.setResizable(false);
            }
        });
    }

    @Override
    public void update() {
        frame.remove(pane);
        pane = new Pane();
        frame.add(pane);
        frame.pack();
    }
}