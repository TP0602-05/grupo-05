package ar.fiuba.tdd.tp.model;

import java.util.ArrayList;

abstract class Observable {

    private ArrayList<Observer> observers = new ArrayList<>();

    void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    void deleteObserver(Observer observer) {
        this.observers.remove(observer);
    }

    void notifyObservers() {
        for (Observer observer: this.observers) {
            observer.update();
        }
    }

}