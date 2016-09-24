package ar.fiuba.tdd.tp.model.cell;

class Value {
    private Integer value;

    Value(Integer value) {
        this.value = value;
    }

    Integer getValue() {
        return this.value;
    }

    boolean equals(Value otherValue) {
        return this.value.equals(otherValue.value);
    }
}
