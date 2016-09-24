package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.Cell;

import java.util.Set;

abstract class GenericRule implements Rule {

    private Set<Cell> cells;

    GenericRule(Set<Cell> cells) {
        this.cells = cells;
    }

    Set<Cell> getCells() {
        return this.cells;
    }

    public abstract boolean check();
}
