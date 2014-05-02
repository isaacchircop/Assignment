package com;

import com.Map;
import com.Position;
import org.junit.*;
import static org.junit.Assert.*;

public class MapClassTest {
    
    public MapClassTest() {
    }
    
    @Test
    public void testValidMapRange() {

        Map m = new Map(5);
        Position pos = new Position (4,2);

        assertTrue("Checking if tile (4,2) exists in a map of size 5", m.checkInRange(pos));
    
    }

    @Test
    public void testInvalidMapRange() {

        Map m = new Map(5);
        Position pos = new Position (6,2);

        assertFalse("Checking if tile (6,2) exists in a map of size 5", m.checkInRange(pos));

    }

    @Test
    public void testCorrectMapCreation() {

        int size = 5;
        Map map = new Map(5);

        assertEquals("Checking if map of correct size is created", map.getLength(), size);

    }

    @Test
    public void testGetLength() {

        Map map = new Map(5);

        assertEquals("Testing if map length returns correct value", map.getLength(), 5);

    }

    @Test
    public void testGetHTMLCode() {

        Map map = new Map(5);

        String html = map.getAsHTMLTable();

        assertTrue ("Checking if html code starts and ends with <table> tags", html.startsWith("<table") && html.endsWith("</table>"));

    }

}