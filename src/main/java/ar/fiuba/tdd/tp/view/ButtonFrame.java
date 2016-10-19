package ar.fiuba.tdd.tp.view;

class ButtonDemo {
    public static void main(String[] args) {
        KeypadFrame frame = new KeypadFrame();
        ButtonHashing hashing = new ButtonHashing();

        KeypadButton button1 = new KeypadButton(hashing.getMapAt(3));
        KeypadButton button2 = new KeypadButton(hashing.getMapAt(14));
        KeypadButton button3 = new KeypadButton(hashing.getMapAt(6));
        KeypadButton button4 = new KeypadButton(hashing.getMapAt(15));

        frame.addButon(button1);
        frame.addButon(button2);
        frame.addButon(button3);
        frame.addButon(button4);

        frame.pack();
        frame.setVisible(true);
    }
}