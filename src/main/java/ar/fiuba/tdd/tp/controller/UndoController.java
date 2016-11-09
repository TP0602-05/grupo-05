package ar.fiuba.tdd.tp.controller;

import ar.fiuba.tdd.tp.model.Game;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Implementation of Abstract class MouseAdapter. Used for receiving mouse events.
 * This class exists as convenience for creating listener objects.
 *  Mouse events let you track when a mouse is pressed, released, clicked, moved, dragged,
 *  when it enters a component, when it exits and when a mouse wheel is moved.
 */
public class UndoController extends MouseAdapter {

    public UndoController() {

    }

    @Override
    public void mouseClicked(MouseEvent event) {
        if (!Game.getInstance().undoPlay()) {
            return;
        }
    }
}
