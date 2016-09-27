package ar.fiuba.tdd.tp.model.cell;

public class Value {
    private Integer value;

    public Value(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public boolean isEqualTo(Value otherValue) {
        return ( this.value.equals(otherValue.getValue()) );
    }

    boolean printValue() {
        System.out.println(this.value);
        return true;
    }

    public String toString() {
        return this.value.toString();
    }
}

