package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.PositionValueDuo;
import ar.fiuba.tdd.tp.model.cell.Value;

import java.util.ArrayList;

/**
 * Checks if values within a set add up to a certain number.
 */
public class SummationRule implements Rule {

    private int summationValue;
    private int apply;

    public SummationRule(Integer summationValue) {
        if (summationValue == 0) {
            apply = summationValue;
        } else {
            apply = 1;
            this.summationValue = summationValue;
        }
    }

    public boolean check(ArrayList<PositionValueDuo> values, PositionValueDuo value) {
        /*
        Integer summation = this.calculate(values) + value.getValue().getValue();
        return (summation <= this.summationValue);
        */
        return true;
    }


    public boolean checkFinal(ArrayList<PositionValueDuo> values) {
        if (apply == 0) {
            return true;
        }
        Integer summation = this.calculate(values);
        return summation.equals(this.summationValue);
    }


    private Integer calculate(ArrayList<PositionValueDuo> values) {
        Integer summation = 0;
        for (PositionValueDuo myValue: values ) {
            summation += myValue.getValue().getValue();
        }
        return summation;
    }


    /*private Integer calculate(ArrayList<Value> values) {
        Integer summation = 0;
        for (Value myValue: values ) {
            summation += myValue.getValue();
        }
        return summation;
    }

    public boolean check(ArrayList<Value> values, Value value) {
        Integer summation = this.calculate(values) + value.getValue();
        return (summation <= this.summationValue);
    }

    public boolean checkFinal(ArrayList<Value> values) {
        Integer summation = this.calculate(values);
        return summation.equals(this.summationValue);
    }
    */
    public void printRule() {
        System.out.println("SUM:" + this.summationValue);
    }
}
