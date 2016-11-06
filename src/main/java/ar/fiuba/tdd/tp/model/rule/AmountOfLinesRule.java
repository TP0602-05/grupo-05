package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.PositionValueDuo;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Checks if the specified number of lines corresponds with the amount of lines drawn.
 */
public class AmountOfLinesRule implements Rule {

    private int amountOfLines;
    private static final int CENTER = 4;

    public AmountOfLinesRule(Integer amount) {
        this.amountOfLines = amount;
    }


    public boolean checkFinal(ArrayList<PositionValueDuo> values) {
        int cantLines = 0;
        if (this.amountOfLines < 0) {
            return true;
        } else {
            for (PositionValueDuo valueToCount: values) {
                cantLines += this.countLinesOfOne(valueToCount.getValue().getDots());
            }
        }
        return (cantLines == amountOfLines);
    }


    public boolean check(ArrayList<PositionValueDuo> values, PositionValueDuo value) {

        int cantLines = this.countLinesOfOne(value.getValue().getDots());

        for ( PositionValueDuo valueToCount: values ) {
            cantLines += this.countLinesOfOne(valueToCount.getValue().getDots());
        }
        if (this.amountOfLines < 0) {
            return true;
        }
        return (cantLines <= amountOfLines);
    }

    private int countLinesOfOne(Vector<Boolean> booleans) {
        if ( booleans.elementAt(CENTER) ) {
            return 1;
        }
        return 0;
    }

    public void printRule() {
        System.out.println("CANT LINES:" + this.amountOfLines);
    }
}
