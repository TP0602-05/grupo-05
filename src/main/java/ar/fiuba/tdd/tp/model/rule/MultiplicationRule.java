package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.Value;

import java.util.ArrayList;

/**
 * Checks if multiplication between the values within a set is a certain number.
 */
public class MultiplicationRule implements Rule {

    private int multiplicationValue;

    public MultiplicationRule(Integer multiplicationValue) {
        this.multiplicationValue = multiplicationValue;
    }

    private Integer calculate(ArrayList<Value> values) {
        Integer multiplication = 1;
        for (Value myValue: values ) {
            if (myValue.getValue() != 0) {
                multiplication *= myValue.getValue();
            }
        }
        return multiplication;
    }

    public boolean check(ArrayList<Value> values, Value value) {
        if (this.multiplicationValue == 0) {
            return true;
        }
        Integer multiplication = this.calculate(values) * value.getValue();
        return (multiplication <= this.multiplicationValue);
    }

    public boolean checkFinal(ArrayList<Value> values) {
        if (this.multiplicationValue == 0) {
            return true;
        }
        Integer multiplication = this.calculate(values);
        return (multiplication == this.multiplicationValue);
    }

    public void printRule() {
        System.out.println("MUL:" + this.multiplicationValue);
    }

}


