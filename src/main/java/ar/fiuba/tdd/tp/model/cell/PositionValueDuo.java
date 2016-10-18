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

    public void print() {
        System.out.println("POS X:" + this.pos.getXpos() + " POS Y:" + this.pos.getYpos() + " VALUE:" + this.val.toString());
    }
}
