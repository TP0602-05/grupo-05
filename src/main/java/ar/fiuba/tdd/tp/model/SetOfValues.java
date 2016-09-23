package ar.fiuba.tdd.tp.model;

import java.util.ArrayList;

abstract class SetOfValues {

    private ArrayList<Object> values;

    SetOfValues() {
        this.values = new ArrayList<>();
    }

    void insertValue(Object object) {
        this.values.add(object);
    }

    void deleteValue(Object object) {
        this.values.remove(object); // TODO: object.getValue()
    }

    abstract boolean canInsertValue(Object object);
}
