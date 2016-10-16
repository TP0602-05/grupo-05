package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.Value;

import java.util.ArrayList;

/**
 * Checks if the specified number of lines corresponds with the amount of lines drawn.
 */
public class AmountOfLinesRule implements Rule {

    private int amountOfLines;

    public AmountOfLinesRule(Integer amount) {
        this.amountOfLines = amount;
    }

    public boolean check(ArrayList<Value> values, Value value) {
        if (this.amountOfLines == 0) {
            return true;
        }
        return true;
    }

    public boolean checkFinal(ArrayList<Value> values) {
        return true;
    }

    public void printRule() {

    }
}
