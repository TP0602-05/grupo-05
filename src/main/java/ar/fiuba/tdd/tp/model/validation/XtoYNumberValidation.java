package ar.fiuba.tdd.tp.model.validation;

import ar.fiuba.tdd.tp.model.cell.Value;


public class XtoYNumberValidation implements Validation {

    private Integer xnumber;
    private Integer ynumber;

    public XtoYNumberValidation(Integer xvalue, Integer yvalue) {
        this.xnumber = xvalue;
        this.ynumber = yvalue;
    }

    public boolean validate(Value value) {
        boolean valid = false;
        Integer number = value.getValue();
        if ( (number >= xnumber) && (number <= ynumber) ) {
            valid = true;
        }
        return valid;

    }
}
