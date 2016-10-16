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

    public void testAdjacentPositions() {
        Position posInit = new Position(5,5);
        assertTrue(posInit.isUp(new Position(5,6)));
        assertTrue(posInit.isRight(new Position(6,5)));
        assertTrue(posInit.isDown(new Position(5,4)));
        assertTrue(posInit.isLeft(new Position(4,5)));
    }

    public void testNotAdjacentPositions() {
        Position posInit = new Position(5,5);
        assertFalse(posInit.isUp(new Position(5,7)));
        assertFalse(posInit.isRight(new Position(5,5)));
        assertFalse(posInit.isDown(new Position(4,4)));
        assertFalse(posInit.isLeft(new Position(4,6)));
    }

    public void testCornertPositions() {
        Position posInit = new Position(5,5);
        assertTrue(posInit.isUpRight(new Position(6,6)));
        assertTrue(posInit.isDownRight(new Position(6,4)));
        assertTrue(posInit.isDownLeft(new Position(4,4)));
        assertTrue(posInit.isUpLeft(new Position(4,6)));
    }

    public void testNotCornertPositions() {
        Position posInit = new Position(5,5);
        assertFalse(posInit.isUpRight(new Position(6,5)));
        assertFalse(posInit.isDownRight(new Position(6,6)));
        assertFalse(posInit.isDownLeft(new Position(4,3)));
        assertFalse(posInit.isUpLeft(new Position(4,4)));
    }
}
