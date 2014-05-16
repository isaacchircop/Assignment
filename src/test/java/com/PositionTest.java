package com;

import org.junit.*;
import static org.junit.Assert.*;

public class PositionTest {

    Position pos,pos3,pos4;
    int col,row;

    @Before
    public void initialisePosition(){
        col = 2;
        row = 2;
        pos = new Position (0,0);
        pos3 = new Position(row,2);
        pos4 = new Position(2,col);
    }

    @Test
    public void testGetID() {

        assertEquals("Testing if cell ID is as expected", pos.getID(), "cell" + 0 + "" + 0);

    }

    @Test
    public void testGetRow() {

        assertEquals("Testing row getter", pos.getRow(), 0);

    }

    @Test
    public void testGetCol() {

        assertEquals("Testing column getter", pos.getCol(), 0);

    }

    @Test
    public void testRowIncr() {

        pos3.incrRow();
        assertEquals("Testing row getter", pos3.getRow(), row+1);

    }

    @Test
    public void testRowDecr() {

        pos3.decrRow();
        assertEquals("Testing row getter", pos3.getRow(), row-1);

    }

    @Test
    public void testColIncr() {

        pos4.incrCol();
        assertEquals("Testing row getter", pos4.getCol(), col+1);

    }

    @Test
    public void testColDecr() {

        pos4.decrCol();
        assertEquals("Testing row getter", pos4.getCol(), col-1);

    }

    @Test
    public void testEqual() {

        Position pos2 =  new Position(0,0);
        assertTrue("Testing equality of two positions", pos.isEqual(pos2));

    }

    @Test
    public void testNotEqual() {

        Position pos2 =  new Position(3,2);
        assertFalse("Testing equality of two positions", pos.isEqual(pos2));

    }

}