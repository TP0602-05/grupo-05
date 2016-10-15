package ar.fiuba.tdd.tp.model.cell;



/**
 * Contains both position and value of a certain cell for rules to understand.
 */
public class PositionValueDuo {

    private Value val;
    private Position pos;

    public PositionValueDuo(Value value, Position position) {
        this.val = value;
        this.pos = position;
    }

    public Value getValue() {
        return val;
    }

    public Position getPos() {
        return pos;
    }
}
