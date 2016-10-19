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

    public int isCorner(Position otherPos) {
        return ((isUpCorner(otherPos) + isDownCorner(otherPos)) - 1);
    }

    public int isAdjacent(Position otherPos) {
        return ((isHorizontal(otherPos) + isVertical(otherPos)) - 1);
    }

    private int isUpCorner(Position otherPos) {
        if (this.isUpLeft(otherPos)) {
            return 1;
        } else {
            if (this.isUpRight(otherPos)) {
                return 2;
            } else {
                return 0;
            }
        }
    }

    private int isDownCorner(Position otherPos) {
        if (this.isDownLeft(otherPos)) {
            return 4;
        } else {
            if (this.isDownRight(otherPos)) {
                return 3;
            } else {
                return 0;
            }
        }
    }

    private int isHorizontal(Position otherPos) {
        if (this.isRight(otherPos)) {
            return 2;
        } else {
            if (this.isLeft(otherPos)) {
                return 4;
            } else {
                return 0;
            }
        }
    }

    private int isVertical(Position otherPos) {
        if (this.isUp(otherPos)) {
            return 1;
        } else {
            if (this.isDown(otherPos)) {
                return 3;
            } else {
                return 0;
            }
        }
    }

    Boolean isUp(Position otherPos) {
        return  ((otherPos.getXpos() == this.xpos)
                && (otherPos.getYpos() == (this.ypos + 1)));
    }

    Boolean isDown(Position otherPos) {
        return  ((otherPos.getXpos() == this.xpos)
                && (otherPos.getYpos() == (this.ypos - 1)));
    }

    Boolean isRight(Position otherPos) {
        return  ((otherPos.getXpos() == (this.xpos + 1))
                && (otherPos.getYpos() == this.ypos));
    }

    Boolean isLeft(Position otherPos) {
        return  ((otherPos.getXpos() == (this.xpos - 1))
                && (otherPos.getYpos() == this.ypos));
    }

    Boolean isUpRight(Position otherPos) {
        return  ((otherPos.getXpos() == (this.xpos + 1))
                && (otherPos.getYpos() == (this.ypos + 1)));
    }

    Boolean isDownRight(Position otherPos) {
        return  ((otherPos.getXpos() == (this.xpos + 1))
                && (otherPos.getYpos() == (this.ypos - 1)));
    }

    Boolean isDownLeft(Position otherPos) {
        return  ((otherPos.getXpos() == (this.xpos - 1))
                && (otherPos.getYpos() == (this.ypos - 1)));
    }

    Boolean isUpLeft(Position otherPos) {
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
