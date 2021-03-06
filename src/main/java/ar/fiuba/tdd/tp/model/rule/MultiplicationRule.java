package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.PositionValueDuo;
import ar.fiuba.tdd.tp.model.cell.Value;

import java.util.ArrayList;

/**
 * Checks if multiplication between the values within a set is a certain number.
 */
public class MultiplicationRule implements Rule {

    private int multiplicationValue;

    public boolean check(ArrayList<PositionValueDuo> values, PositionValueDuo value) {
        if (this.multiplicationValue == 0) {
            return true;
        }
        Integer multiplication = this.calculate(values) * value.getValue().getValue();
        return (multiplication <= this.multiplicationValue);
    }


    public boolean checkFinal(ArrayList<PositionValueDuo> values) {
        if (this.multiplicationValue == 0) {
            return true;
        }
        Integer multiplication = this.calculate(values);
        return (multiplication == this.multiplicationValue);
    }


    public MultiplicationRule(Integer multiplicationValue) {
        this.multiplicationValue = multiplicationValue;
    }

    private Integer calculate(ArrayList<PositionValueDuo> values) {
        Integer multiplication = 1;
        for (PositionValueDuo myValue: values ) {
            if (myValue.getValue().getValue() != 0) {
                multiplication *= myValue.getValue().getValue();
            }
        }
        return multiplication;
    }


    public void printRule() {
        System.out.println("MUL:" + this.multiplicationValue);
    }

}


