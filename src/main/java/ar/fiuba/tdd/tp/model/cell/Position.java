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

    public Boolean isUp(Position otherPos) {
        return  ((otherPos.getXpos() == this.xpos)
                && (otherPos.getYpos() == (this.ypos + 1)));
    }

    public Boolean isDown(Position otherPos) {
        return  ((otherPos.getXpos() == this.xpos)
                && (otherPos.getYpos() == (this.ypos - 1)));
    }

    public Boolean isRight(Position otherPos) {
        return  ((otherPos.getXpos() == (this.xpos + 1))
                && (otherPos.getYpos() == this.ypos));
    }

    public Boolean isLeft(Position otherPos) {
        return  ((otherPos.getXpos() == (this.xpos - 1))
                && (otherPos.getYpos() == this.ypos));
    }

    public Boolean isUpRight(Position otherPos) {
        return  ((otherPos.getXpos() == (this.xpos + 1))
                && (otherPos.getYpos() == (this.ypos + 1)));
    }

    public Boolean isDownRight(Position otherPos) {
        return  ((otherPos.getXpos() == (this.xpos + 1))
                && (otherPos.getYpos() == (this.ypos - 1)));
    }

    public Boolean isDownLeft(Position otherPos) {
        return  ((otherPos.getXpos() == (this.xpos - 1))
                && (otherPos.getYpos() == (this.ypos - 1)));
    }

    public Boolean isUpLeft(Position otherPos) {
        return  ((otherPos.getXpos() == (this.xpos - 1))
                && (otherPos.getYpos() == (this.ypos + 1)));
    }


    public int getXpos() {
        return xpos;
    }

    public int getYpos() {
        return ypos;
    }
}
