package ar.fiuba.tdd.template;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.*;
/*
public class TestGrid01 {

    public TestGrid01() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Grilla");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    gbc.gridx = col;
                    gbc.gridy = row;

                    CellPane cellPane = new CellPane(gbc.gridx);
                    Border border = null;
                    if (row < 4) {
                        if (col < 4) {
                            border = new MatteBorder(1, 1, 0, 0, Color.GRAY);
                        } else {
                            border = new MatteBorder(1, 1, 0, 1, Color.GRAY);
                        }
                    } else {
                        if (col < 4) {
                            border = new MatteBorder(1, 1, 1, 0, Color.GRAY);
                        } else {
                            border = new MatteBorder(1, 1, 1, 1, Color.GRAY);
                        }
                    }
                    cellPane.setBorder(border);
                    add(cellPane, gbc);
                }
            }
        }
    }

    public class CellPane extends JButton {

        private Color defaultBackground;
        private int gbc;

        public CellPane(int _gbc) {

            gbc = _gbc;

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                    System.out.println("LLEGO");
                    System.out.println("Pos x: " + gbc);
                    setText("CLICK");
                    JFrame f = new JFrame();
                    f.setLayout(new BorderLayout());
                    f.setBounds(100,100,100,100);

                    //f.add(new JEditorPane());
                    JPanel jp = new JPanel();
                    JTextField campoTexto = new JTextField();
                    campoTexto.s
                    JButton botonOK = new JButton("OK");

                    jp.add(campoTexto);
                    jp.add(botonOK);
                    f.add(jp);
                    f.setLocationRelativeTo(null);
                    f.setVisible(true);
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    defaultBackground = getBackground();
                    setBackground(Color.BLUE);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    setBackground(defaultBackground);
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(50, 50);
        }
    }
}

*/