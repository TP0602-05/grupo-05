package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.PositionValueDuo;

import java.util.ArrayList;
import java.util.Vector;

public class AmountOfLinesBorderRule implements Rule {

    private int amountOfBorderLines;
    private static final int UP = 1;
    private static final int LEFT = 3;
    private static final int RIGTH = 5;
    private static final int DOWN = 7;

    public AmountOfLinesBorderRule(Integer amount) {
        this.amountOfBorderLines = amount;
    }

    public boolean checkFinal(ArrayList<PositionValueDuo> values) {
        if (this.amountOfBorderLines >= 0) {
            return (this.counterLines(values.get(0).getValue().getDotsWithBorders()) == amountOfBorderLines);
        }
        return true;

    }

    public boolean check(ArrayList<PositionValueDuo> values, PositionValueDuo value) {
        if (this.amountOfBorderLines >= 0) {
            return (counterLines(value.getValue().getDotsWithBorders()) <= amountOfBorderLines);
        }
        return true;
    }

    int counterLines(Vector<Boolean> dots) {
        return (boolToInt(dots.elementAt(UP))
                + boolToInt(dots.elementAt(LEFT))
                + boolToInt(dots.elementAt(RIGTH))
                + boolToInt(dots.elementAt(DOWN)));
    }

    private int boolToInt(Boolean bool) {
        if (bool) {
            return 1;
        }
        return 0;
    }

    public void printRule() {
        System.out.println("Number of LINES:" + this.amountOfBorderLines);
    }
}
