package com;

import org.junit.*;
import java.io.File;
import static org.junit.Assert.*;

public class PlayerClassTest {

    public PlayerClassTest() {
    }
    
    @Test
    public void testGetHTML() {

        Player player = new Player(0,0,0);
        File htmlFile = player.getHTML();

        assertTrue("Testing whether getHTML() returns an HTML File Type", htmlFile.getPath().endsWith(".html"));

    }

    @Test
    public void testGetCSS() {

        Player player = new Player(0,0,0);
        File cssFile = player.getCSS();

        assertTrue("Testing whether getCSS() returns a CSS File Type", cssFile.getPath().endsWith(".css"));

    }

    @Test
    public void testGetInitRow() {

        Player p1 = new Player(5,6,0);
        assertEquals("Testing whether getInitRow() returns 5",p1.getInitRow(),5);

    }

    @Test
    public void testGetInitColumn() {

        Player p1 = new Player(5,6,0);
        assertEquals("Testing whether getInitColumn() returns 6",p1.getInitCol(),6);

    }

    @Test
    public void testGetCurrentPosition() {

        Player p1 = new Player(0,0,0);
        p1.updatePosition(3,4);

        assertEquals("Testing whether getCurrentRow() returns 3", p1.getCurrentRow(),3);
        assertEquals("Testing whether getCurrentCol() returns 4",p1.getCurrentCol(),4);

    }

    @Test
    public void testPositionChanges() {

        int initRow = 0;
        int initCol = 0;

        Player player = new Player (initRow, initCol, 0);

        int newRow = 5;
        int newCol = 6;

        player.updatePosition(5, 6);

        assertEquals("Testing whether getCurrentRow() returns 3", player.getCurrentRow(), newRow);
        assertEquals("Testing whether getCurrentCol() returns 4",player.getCurrentCol(), newCol);

        player.resetPosition();

        assertEquals("Testing if new row is equal to initial row", player.getCurrentRow(), initRow);
        assertEquals("Testing if new col is equal to initial col", player.getCurrentCol(), initCol);

    }


}
