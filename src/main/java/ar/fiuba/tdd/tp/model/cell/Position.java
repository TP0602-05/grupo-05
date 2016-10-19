package ar.fiuba.tdd.tp.model.cell;

/**
 * It contains the x y position of a cell and understands adyacency.
 */
public class Position {
    private int fil;
    private int col;

    public Position(int xnum, int ynum) {
        this.fil = xnum;
        this.col = ynum;
    }

    public Boolean isEqual(Position otherPos) {
        return  ((otherPos.getFil() == this.fil)
                && (otherPos.getCol() == this.col));
    }

    public Boolean isNext(Position otherPos) {
        return  ((otherPos.getFil() < (this.fil + 2))
                && (otherPos.getFil() > (this.fil - 2))
                && (otherPos.getCol() < (this.col + 2))
                && (otherPos.getCol() > (this.col - 2)));
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
        return  ((otherPos.getFil() == this.fil - 1)
                && (otherPos.getCol() == (this.col)));
    }

    Boolean isDown(Position otherPos) {
        return  ((otherPos.getFil() == this.fil + 1)
                && (otherPos.getCol() == (this.col)));
    }

    Boolean isRight(Position otherPos) {
        return  ((otherPos.getFil() == (this.fil))
                && (otherPos.getCol() == this.col + 1));
    }

    Boolean isLeft(Position otherPos) {
        return  ((otherPos.getFil() == (this.fil))
                && (otherPos.getCol() == this.col - 1));
    }

    Boolean isUpRight(Position otherPos) {
        return  ((otherPos.getFil() == (this.fil - 1))
                && (otherPos.getCol() == (this.col + 1)));
    }

    Boolean isDownRight(Position otherPos) {
        return  ((otherPos.getFil() == (this.fil + 1))
                && (otherPos.getCol() == (this.col + 1)));
    }

    Boolean isDownLeft(Position otherPos) {
        return  ((otherPos.getFil() == (this.fil + 1))
                && (otherPos.getCol() == (this.col - 1)));
    }

    Boolean isUpLeft(Position otherPos) {
        return  ((otherPos.getFil() == (this.fil - 1))
                && (otherPos.getCol() == (this.col - 1)));
    }


    int getFil() {
        return fil;
    }

    int getCol() {
        return col;
    }
}
