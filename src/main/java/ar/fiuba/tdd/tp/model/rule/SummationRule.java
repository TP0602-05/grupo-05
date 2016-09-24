package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.Cell;

import java.util.Set;

public class SummationRule extends GenericRule{

    private int summationValue;

    public SummationRule(Set<Cell> cells, Integer summationValue) {
        super(cells);
        this.summationValue = summationValue;
    }

    @Override
    public boolean check() {
        Integer summation = 0;
        for (Cell cell: this.getCells() ) {
            summation += 0; // TODO: cell.getValue();
        }
        return summation.equals(this.summationValue);
    }
}
