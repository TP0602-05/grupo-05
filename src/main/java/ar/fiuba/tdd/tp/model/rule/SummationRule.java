package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.Value;

import java.util.ArrayList;

public class SummationRule implements Rule {

    private int summationValue;

    public SummationRule(Integer summationValue) {
        this.summationValue = summationValue;
    }

    private Integer calculate(ArrayList<Value> values) {
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

    public void printRule() {
        System.out.println("SUM:" + this.summationValue);
    }
}
