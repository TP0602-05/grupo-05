package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.cell.PositionValueDuo;
import ar.fiuba.tdd.tp.model.cell.Value;

import java.util.ArrayList;
import java.util.Vector;

public class CheckAdjacentRule implements Rule {

    private int apply;

    public CheckAdjacentRule(int value) {
        this.apply = value;
    }

    @Override
    public boolean check(ArrayList<PositionValueDuo> values, PositionValueDuo value) {
        if (this.apply == 0) {
            return true;
        }
        boolean checkCondition = true;
        if (isBlackCell(value.getValue())) {
            checkCondition = checkRuleCondition(values,value);
        }
        return checkCondition;
    }

    private boolean checkRuleCondition(ArrayList<PositionValueDuo> values, PositionValueDuo value) {
        for (PositionValueDuo otherValue : values) {
            if (areAdjacent(otherValue,value)) {
                if (isBlackCell(otherValue.getValue())) {
                    return false;
                } else {
                    if (!hasWayOut(otherValue,values)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean hasWayOut(PositionValueDuo otherValue, ArrayList<PositionValueDuo> values) {
        int posibleWaysOut = 0;
        for (PositionValueDuo otherValue2 : values) {
            if (areAdjacent(otherValue,otherValue2)) {
                if (!isBlackCell(otherValue2.getValue())) {
                    posibleWaysOut++;
                }
            }
        }
        return (posibleWaysOut >= 1);
    }

    private boolean areAdjacent(PositionValueDuo otherValue, PositionValueDuo value) {
        int difCol = Math.abs(otherValue.getPos().getCol() - value.getPos().getCol());
        int difRow = Math.abs(otherValue.getPos().getRow() - value.getPos().getRow());

        // if they are adjacents
        if (((difRow == 1) && (difCol == 0)) || ((difRow == 0) && (difCol == 1))) {
            return true;
        }
        return false;
    }

    private Boolean isBlackCell(Value value) {
        Vector<Boolean> dots = value.getDots();
        Boolean line = dots.get(0) && dots.get(1) && dots.get(2);

        return line && dots.get(3) && dots.get(4) && dots.get(5)
                && dots.get(6) && dots.get(7) && dots.get(8);
    }

    @Override
    public boolean checkFinal(ArrayList<PositionValueDuo> values) {
        return true;
    }

    @Override
    public void printRule() {
        System.out.println("CheckAdjacents rules");
    }
}
