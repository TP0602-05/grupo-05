package ar.fiuba.tdd.tp.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Controlador de teclado
 */
public class KeyboardController implements KeyListener {

    public  KeyboardController() {

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        if (keyEvent.getKeyChar() == 'u') {
            System.out.println("Presiono una u");
        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
