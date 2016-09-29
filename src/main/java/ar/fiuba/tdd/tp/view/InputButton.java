package ar.fiuba.tdd.tp.view;

import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.cell.Value;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class InputButton extends JButton {

    //TODO: Dividir esto, NCSS max es 20
    public InputButton(Value value, int row, int col) {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                if (!Game.getInstance().getCell(row, col).isBlocked()) {
                    if (event.getButton() == MouseEvent.BUTTON1) {
                        JFrame frameInput = new JFrame();
                        frameInput.setLayout(new BorderLayout());
                        frameInput.setBounds(100, 100, 100, 100);

                        JPanel jp = new JPanel();
                        JTextField textField = new JTextField();
                        textField.setColumns(5);
                        JButton botonOK = new JButton("OK");
                        botonOK.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent actionEvent) {
                                frameInput.dispose();
                                Value value = new Value(Integer.parseInt(textField.getText()));
                                Game.getInstance().setValue(row, col, value);
                            }
                        });

                        jp.add(textField);
                        jp.add(botonOK);
                        frameInput.add(jp);
                        frameInput.setLocationRelativeTo(null);
                        frameInput.setVisible(true);
                    } else if (event.getButton() == MouseEvent.BUTTON3) {
                        Game.getInstance().deleteValue(row, col);
                    }
                }
            }
        });

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