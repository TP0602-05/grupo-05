package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.PositionValueDuo;
import ar.fiuba.tdd.tp.model.cell.Value;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Checks if the specified number of lines corresponds with the amount of lines drawn.
 */
public class AmountOfLinesRule implements Rule {

    private int amountOfLines;

    public AmountOfLinesRule(Integer amount) {
        this.amountOfLines = amount;
    }


    public boolean checkFinal(ArrayList<PositionValueDuo> values) {
        if (this.amountOfLines == 0) {
            return true;
        }
        int cantLines = 0;
        for (PositionValueDuo valueToCount: values) {
            cantLines += this.countLinesOfOne(valueToCount.getValue().getDots());
        }
        return (cantLines == amountOfLines);
    }


    public boolean check(ArrayList<PositionValueDuo> values, PositionValueDuo value) {
        if (this.amountOfLines == 0) {
            return true;
        }
        int cantLines = this.countLinesOfOne(value.getValue().getDots());
        for (PositionValueDuo valueToCount: values
             ) {
            cantLines += this.countLinesOfOne(valueToCount.getValue().getDots());
        }
        return (cantLines <= amountOfLines);
    }

    private int countLinesOfOne(Vector<Boolean> booleans) {
        int counter = 0;
        int finalCont;

        for (Boolean mybool : booleans) {
            if (mybool) {
                counter++;
            }
        }
        if (counter == 8) {
            finalCont = 4;
        } else {
            finalCont = ((counter - 1) / 2);
        }
        return finalCont;
    }

    public void printRule() {

    }
}
