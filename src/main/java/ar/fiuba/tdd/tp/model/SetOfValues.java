package ar.fiuba.tdd.tp.model;

import ar.fiuba.tdd.tp.model.cell.*;
import ar.fiuba.tdd.tp.model.rule.Rule;

import java.util.ArrayList;
import java.util.Iterator;

/*
Class created to manage the relation between the sets, the values, and the rules
Every set, contains values.
Every set, contains rules.
Values and rules are loaded in runtime.
*/
class SetOfValues {

    private ArrayList<PositionValueDuo> values;
    private ArrayList<Rule> rules;

    SetOfValues() {
        this.values = new ArrayList<>();
        this.rules  = new ArrayList<>();
    }

    void insertValue(PositionValueDuo value) {
        this.values.add(value);
    }

    void addValue(PositionValueDuo value, PositionValueDuo prevValue) {
        this.values.add(value);
        this.deleteValue(prevValue);
    }

    void insertRule(Rule rule) {
        this.rules.add(rule);
    }

    void deleteValue(PositionValueDuo value) {
        for (Iterator<PositionValueDuo> iterator = this.values.iterator(); iterator.hasNext();) {
            PositionValueDuo myValue = iterator.next();
            if (myValue.getPos().isEqual(value.getPos())) {
                iterator.remove();
                break;
            }
        }
    }
    
    boolean canInsertValue(PositionValueDuo value, PositionValueDuo prevValue) {
        // TODO: Recibir valor previo, quitarlo del set antes de chequear y volver a agregarlo al final.
        boolean result = true;
        this.deleteValue(prevValue);
        for (Rule myRule: this.rules) {
            if ( ! myRule.check(this.values, value) ) {
                result = false;
            }
        }
        this.values.add(prevValue);
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
        for (Iterator<PositionValueDuo> iterator = this.values.iterator(); iterator.hasNext();) {
            PositionValueDuo myValue = iterator.next();
            myValue.print();
        }
    }
        /*
    void printRules() {
        for (Iterator<Rule> iterator = this.rules.iterator(); iterator.hasNext();) {
            Rule myValue = iterator.next();
            myValue.printRule();
        }
    }
    */

    void loadRule(Rule rule) {

        this.rules.add(rule);

    }
}
