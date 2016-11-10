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
            if (myValue.getValue().getValue() != -1) {
                summation += myValue.getValue().getValue();
            }
        }
        return summation;
    }

    public void printRule() {
        System.out.println("SUM:" + this.summationValue);
    }
}
