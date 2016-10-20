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
        Position posInit = new Position(1,1);
        assertTrue(posInit.isUp(new Position(0,1)));
        assertTrue(posInit.isRight(new Position(1,2)));
        assertTrue(posInit.isDown(new Position(2,1)));
        assertTrue(posInit.isLeft(new Position(1,0)));
    }

    @Test
    public void testNotAdjacentPositions() {
        Position posInit = new Position(1,1);
        assertFalse(posInit.isUp(new Position(1,3)));
        assertFalse(posInit.isRight(new Position(1,1)));
        assertFalse(posInit.isDown(new Position(0,0)));
        assertFalse(posInit.isLeft(new Position(0,2)));
    }

    @Test
    public void testIntAdjacentPositions() {
        Position posInit = new Position(1,1);
        assertTrue((posInit.isAdjacent(new Position(0,1))) == 0);
        assertTrue((posInit.isAdjacent(new Position(1,2))) == 1);
        assertTrue((posInit.isAdjacent(new Position(2,1))) == 2);
        assertTrue((posInit.isAdjacent(new Position(1,0))) == 3);
    }

    @Test
    public void testCornerPositions() {
        Position posInit = new Position(1,1);
        assertTrue(posInit.isUpRight(new Position(0,2)));
        assertTrue(posInit.isDownRight(new Position(2,2)));
        assertTrue(posInit.isDownLeft(new Position(2,0)));
        assertTrue(posInit.isUpLeft(new Position(0,0)));
    }

    @Test
    public void testNotCornerPositions() {
        Position posInit = new Position(1,1);
        assertFalse(posInit.isUpRight(new Position(2,3)));
        assertFalse(posInit.isDownRight(new Position(1,0)));
        assertFalse(posInit.isDownLeft(new Position(2,1)));
        assertFalse(posInit.isUpLeft(new Position(1,2)));
    }

    @Test
    public void testIntCornerPositions() {
        Position posInit = new Position(1,1);
        assertTrue((posInit.isCorner(new Position(0,2))) == 1);
        assertTrue((posInit.isCorner(new Position(2,2))) == 2);
        assertTrue((posInit.isCorner(new Position(2,0))) == 3);
        assertTrue((posInit.isCorner(new Position(0,0))) == 0);
    }
}
