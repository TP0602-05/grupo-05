package ar.fiuba.tdd.tp.model;

import ar.fiuba.tdd.tp.model.cell.*;
import ar.fiuba.tdd.tp.model.rule.Rule;

import java.util.ArrayList;
import java.util.Iterator;

public class SetOfValues {

    private ArrayList<Value> values;
    private ArrayList<Rule> rules;

    SetOfValues() {
        this.values = new ArrayList<>();
        this.rules  = new ArrayList<>();
    }

    void insertValue(Value value) {
        this.values.add(value);
    }

    void insertRule(Rule rule) {
        this.rules.add(rule);
    }

    void deleteValue(Value value) {
        for (Iterator<Value> iterator = this.values.iterator(); iterator.hasNext();) {
            Value myValue = iterator.next();
            if (myValue.isEqualTo(value)) {
                iterator.remove();
                return;
            }
        }
    }

    public boolean canInsertValue(Value value) {
        boolean result = true;
        for (Rule myRule: this.rules) {
            if ( ! myRule.check(this.values, value) ) {
                result = false;
            }
        }
        return result;
    }

    public boolean isSetFinished() {
        boolean result = true;
        for (Rule myRule: this.rules) {
            if ( ! myRule.checkFinal(this.values) ) {
                result = false;
            }
        }
        return result;
    }
}
