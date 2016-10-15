package ar.fiuba.tdd.tp.model.cell;

/**
 * It contains the x y position of a cell and understands adyacency.
 */
public class Position {
    private int xpos;
    private int ypos;

    public Position(int xnum, int ynum) {
        this.xpos = xnum;
        this.ypos = ynum;
    }

    public Boolean isEqual(Position otherPos) {
        return  ((otherPos.getXpos() == this.xpos)
                && (otherPos.getYpos() == this.ypos));
    }

    public Boolean isNext(Position otherPos) {
        return  ((otherPos.getXpos() < (this.xpos + 2))
                && (otherPos.getXpos() > (this.xpos - 2))
                && (otherPos.getYpos() < (this.ypos + 2))
                && (otherPos.getYpos() > (this.ypos - 2)));
    }

    public int getXpos() {
        return xpos;
    }

    public int getYpos() {
        return ypos;
    }
}
