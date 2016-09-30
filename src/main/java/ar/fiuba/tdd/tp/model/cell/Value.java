package ar.fiuba.tdd.tp.model.cell;

/**
 * Holds a value and is capable of comparing  itself to other values.
 */
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

    void printValue() {
        System.out.println(this.value);
    }

    public String toString() {
        return this.value.toString();
    }
}

