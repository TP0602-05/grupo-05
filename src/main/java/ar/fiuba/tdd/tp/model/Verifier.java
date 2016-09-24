package ar.fiuba.tdd.tp.model;

import ar.fiuba.tdd.tp.model.rule.Rule;

import java.util.ArrayList;

public class Verifier {
    private ArrayList<Rule> rules;

    public Verifier() {
        this.rules = new ArrayList<>();
    }

    public void addRule(Rule rule) {
        this.rules.add(rule);
    }

    public boolean verifyAll() {
        boolean verification = true;
        for (Rule rule: this.rules) {
            if (verification & rule.check()) {
                verification = true;
            }
            else {
                verification = false;
            }
        }
        return verification;
    }
}
