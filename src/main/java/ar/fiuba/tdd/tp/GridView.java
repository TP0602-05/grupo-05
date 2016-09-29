package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.Observer;
import ar.fiuba.tdd.tp.model.cell.Value;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


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

                    CellPane cellPane = new CellPane(Game.getInstance().getValue(row,col), row, col);

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
                    cellPane.setBorder(border);

                    add(cellPane, gbc);
                }
            }
        }
    }

    public class CellPane extends JButton {

        public CellPane(Value value, int row, int col) {
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
            return new Dimension(50, 50);
        }
    }
}