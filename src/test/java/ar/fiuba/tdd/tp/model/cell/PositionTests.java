package ar.fiuba.tdd.tp.model.cell;

import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTests {

    @Test
    public void testEqualPositions() {
        Position pos1 = new Position(5,5);
        Position pos2 = new Position(5,5);
        assertTrue(pos1.isEqual(pos2));
    }

    @Test
    public void testNotEqualPositions() {
        Position pos1 = new Position(5,5);
        Position pos2 = new Position(5,4);
        assertFalse(pos1.isEqual(pos2));
    }

    @Test
    public void testNextPositions() {
        Position pos1 = new Position(5,5);
        Position pos2 = new Position(4,4);
        assertTrue(pos1.isNext(pos2));
    }

    @Test
    public void testNotNextPositions() {
        Position pos1 = new Position(5,5);
        Position pos2 = new Position(3,4);
        assertFalse(pos1.isNext(pos2));
    }

    @Test
    public void testAdjacentPositions() {
        Position posInit = new Position(5,5);
        assertTrue(posInit.isUp(new Position(5,6)));
        assertTrue(posInit.isRight(new Position(6,5)));
        assertTrue(posInit.isDown(new Position(5,4)));
        assertTrue(posInit.isLeft(new Position(4,5)));
    }

    @Test
    public void testNotAdjacentPositions() {
        Position posInit = new Position(5,5);
        assertFalse(posInit.isUp(new Position(5,7)));
        assertFalse(posInit.isRight(new Position(5,5)));
        assertFalse(posInit.isDown(new Position(4,4)));
        assertFalse(posInit.isLeft(new Position(4,6)));
    }

    @Test
    public void testIntAdjacentPositions() {
        Position posInit = new Position(5,5);
        assertTrue((posInit.isAdjacent(new Position(5,6))) == 0);
        assertTrue((posInit.isAdjacent(new Position(6,5))) == 1);
        assertTrue((posInit.isAdjacent(new Position(5,4))) == 2);
        assertTrue((posInit.isAdjacent(new Position(4,5))) == 3);
    }

    @Test
    public void testCornerPositions() {
        Position posInit = new Position(5,5);
        assertTrue(posInit.isUpRight(new Position(6,6)));
        assertTrue(posInit.isDownRight(new Position(6,4)));
        assertTrue(posInit.isDownLeft(new Position(4,4)));
        assertTrue(posInit.isUpLeft(new Position(4,6)));
    }

    @Test
    public void testNotCornerPositions() {
        Position posInit = new Position(5,5);
        assertFalse(posInit.isUpRight(new Position(6,5)));
        assertFalse(posInit.isDownRight(new Position(6,6)));
        assertFalse(posInit.isDownLeft(new Position(4,3)));
        assertFalse(posInit.isUpLeft(new Position(4,4)));
    }

    @Test
    public void testIntCornerPositions() {
        Position posInit = new Position(5,5);
        assertTrue((posInit.isCorner(new Position(6,6))) == 1);
        assertTrue((posInit.isCorner(new Position(6,4))) == 2);
        assertTrue((posInit.isCorner(new Position(4,4))) == 3);
        assertTrue((posInit.isCorner(new Position(4,6))) == 0);
    }
}
