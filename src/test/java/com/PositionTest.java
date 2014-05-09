package com;

import org.junit.*;
import static org.junit.Assert.*;

public class PositionTest {

    public PositionTest() {
    }

    @Test
    public void testGetID() {

        Position pos = new Position (0,0);

        assertEquals("Testing if cell ID is as expected", pos.getID(), "cell" + 0 + "" + 0);

    }

    @Test
    public void testGetRow() {

        Position pos = new Position (0,0);

        assertEquals("Testing row getter", pos.getRow(), 0);

    }

    @Test
    public void testGetCol() {

        Position pos = new Position (0,0);

        assertEquals("Testing column getter", pos.getCol(), 0);

    }

    @Test
    public void testRowIncr() {

        int row = 2;

        Position pos = new Position (row,2);
        pos.incrRow();

        assertEquals("Testing row getter", pos.getRow(), row+1);

    }

    @Test
    public void testRowDecr() {

        int row = 2;

        Position pos = new Position (row,2);
        pos.decrRow();

        assertEquals("Testing row getter", pos.getRow(), row-1);

    }

    @Test
    public void testColIncr() {

        int col = 2;

        Position pos = new Position (2,col);
        pos.incrCol();

        assertEquals("Testing row getter", pos.getCol(), col+1);

    }

    @Test
    public void testColDecr() {

        int col = 2;

        Position pos = new Position (2,col);
        pos.decrCol();

        assertEquals("Testing row getter", pos.getCol(), col-1);

    }

    @Test
    public void testEqual() {

        Position pos1 = new Position (0,0);
        Position pos2 = new Position (0,0);

        assertTrue("Testing equality of two positions", pos1.isEqual(pos2));

    }

    @Test
    public void testNotEqual() {

        Position pos1 = new Position (0,0);
        Position pos2 = new Position (1,0);

        assertFalse("Testing equality of two positions", pos1.isEqual(pos2));

    }

}