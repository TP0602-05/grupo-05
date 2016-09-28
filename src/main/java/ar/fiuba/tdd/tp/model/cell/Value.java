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

    public void printValue() {
        System.out.println(this.value);
    }

    public String toString() {
        return this.value.toString();
    }
}

