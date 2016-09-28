package ar.fiuba.tdd.tp.model;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class FinishGameListener extends Observer {

    @Override
    public void update() {
        System.out.print("finish game update\n");
        if (Game.getInstance().checkFinish()) {
            JFrame frame = new JFrame();
            frame.setLayout(new GridBagLayout());
            JPanel panel = new JPanel();
            JLabel jlabel = new JLabel("Ganaste!");
            jlabel.setFont(new Font("Verdana",1,20));
            panel.add(jlabel);
            panel.setBorder(new LineBorder(Color.BLACK)); // make it easy to see
            frame.add(panel, new GridBagConstraints());
            frame.setSize(400, 400);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            System.out.print("GANASTE");
        }
    }
}
