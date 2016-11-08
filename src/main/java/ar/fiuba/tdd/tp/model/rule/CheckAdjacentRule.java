package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.PositionValueDuo;
import ar.fiuba.tdd.tp.model.cell.Value;

import java.util.ArrayList;

public class CheckAdjacentRule implements Rule {

    int apply;

    public CheckAdjacentRule(int value) {
        this.apply = value;
    }

    @Override
    public boolean check(ArrayList<PositionValueDuo> values, PositionValueDuo value) {
        if (this.apply == 0) {
            return true;
        }
        int size = values.size();
        PositionValueDuo lastSet = values.get(size - 1);
        lastSet.print();

        return true;
    }

    @Override
    public boolean checkFinal(ArrayList<PositionValueDuo> values) {
        return false;
    }

    @Override
    public void printRule() {
        System.out.println("CheckAdjacents rules");

    }
}
