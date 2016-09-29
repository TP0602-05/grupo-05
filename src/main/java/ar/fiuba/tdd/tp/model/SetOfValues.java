package ar.fiuba.tdd.tp.model;

import ar.fiuba.tdd.tp.model.cell.*;
import ar.fiuba.tdd.tp.model.rule.NoRepeatRule;
import ar.fiuba.tdd.tp.model.rule.Rule;

import java.util.ArrayList;
import java.util.Iterator;

class SetOfValues {

    private ArrayList<Value> values;
    private ArrayList<Rule> rules;

    SetOfValues() {
        this.values = new ArrayList<>();
        this.rules  = new ArrayList<>();
    }

    void insertValue(Value value) {
        this.values.add(value);
    }

    void addValue(Value value, Value prevValue) {
        this.values.add(value);
        this.deleteValue(prevValue);
    }

    void insertRule(Rule rule) {
        this.rules.add(rule);
    }

    void deleteValue(Value value) {
        for (Iterator<Value> iterator = this.values.iterator(); iterator.hasNext();) {
            Value myValue = iterator.next();
            if (myValue.isEqualTo(value)) {
                iterator.remove();
                break;
            }
        }
    }

    boolean canInsertValue(Value value) {
        // TODO: Recibir valor previo, quitarlo del set antes de chequear y volver a agregarlo al final.
        boolean result = true;
        for (Rule myRule: this.rules) {
            if ( ! myRule.check(this.values, value) ) {
                result = false;
            }
        }
        return result;
    }

    boolean isSetFinished() {
        for (Rule myRule: this.rules) {
            if ( ! myRule.checkFinal(this.values) ) {
                return false;
            }
        }
        return true;
    }

    void printSet() {
        for (Iterator<Value> iterator = this.values.iterator(); iterator.hasNext();) {
            Value myValue = iterator.next();
            myValue.printValue();
        }
    }

    void printRules() {
        for (Iterator<Rule> iterator = this.rules.iterator(); iterator.hasNext();) {
            Rule myValue = iterator.next();
            myValue.printRule();
        }
    }

    void loadRule(Rule rule) {

        this.rules.add(rule);

    }
}
