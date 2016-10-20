package ar.fiuba.tdd.tp.view;

class ButtonFrame {
    public static void main(String[] args) {
        KeypadFrame frame = new KeypadFrame();
        ButtonHashing hashing = new ButtonHashing();

        frame.addButon(hashing.getMapAt(3));
        frame.addButon(hashing.getMapAt(6));
        frame.addButon(hashing.getMapAt(12));
        frame.addButon(hashing.getMapAt(14));

        frame.pack();
        frame.setVisible(true);
    }
}