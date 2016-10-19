package ar.fiuba.tdd.tp.model.rule.math;

import ar.fiuba.tdd.tp.model.cell.data.PositionValueDuo;
import ar.fiuba.tdd.tp.model.rule.Rule;

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

    /*
    public boolean check(ArrayList<Value> values, Value value) {
        if (this.multiplicationValue == 0) {
            return true;
        }
        Integer multiplication = this.calculate(values) * value.getValue();
        return (multiplication <= this.multiplicationValue);
    }
    */

    /*
    public boolean checkFinal(ArrayList<Value> values) {
        if (this.multiplicationValue == 0) {
            return true;
        }
        Integer multiplication = this.calculate(values);
        return (multiplication == this.multiplicationValue);
    }
    */

    public void printRule() {
        System.out.println("MUL:" + this.multiplicationValue);
    }

}


