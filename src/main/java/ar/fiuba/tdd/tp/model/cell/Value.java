package ar.fiuba.tdd.tp.model.cell;

public class Value {
    private Integer value;

    Value(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public boolean isEqualTo(Value otherValue) {
        return ( this.value.equals(otherValue.getValue()) );
    }
}
