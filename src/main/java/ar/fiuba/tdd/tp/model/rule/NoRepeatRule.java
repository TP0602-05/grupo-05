package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.Cell;

import java.util.Set;

public class NoRepeatRule extends GenericRule{

    public NoRepeatRule(Set<Cell> cells) {
        super(cells);
    }

    @Override
    public boolean check() {
        return false;
    }
}
