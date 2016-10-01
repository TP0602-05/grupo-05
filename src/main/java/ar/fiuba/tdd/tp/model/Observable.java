package ar.fiuba.tdd.tp.model;

import java.util.ArrayList;

/*
Class created to implement Observer Pattern.
 */
abstract class Observable {

    private ArrayList<Observer> observers = new ArrayList<>();

    void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    void notifyObservers() {
        this.observers.forEach(Observer::update);
    }

}