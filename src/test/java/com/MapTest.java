package com;

import org.junit.*;
import static org.junit.Assert.*;

public class MapTest {

    Tile [][] tiles;
    Map map;
    Position p1;

    @Before
    public void initialiseMap(){
        tiles = new Tile [5][5];
        map = Map.createMap(tiles);
        p1 = new Position(2,1);
    }

    @Test
    public void testCreateMap(){

        assertTrue("",Map.createMap(tiles) instanceof Map);

    }

    @Test
    public void testGetAsHTMLTable(){

        String html = map.getAsHTMLTable();
        assertTrue ("Checking if html code starts and ends with <table> tags", html.startsWith("<table") && html.endsWith("</table>"));

    }

    @Test
    public void testGetLength(){

        assertEquals("Testing the map length is 5", 5, map.getLength());

    }

    @Test
     public void testCheckInRange1(){

        assertTrue("Passing a valid range to checkInRange method", map.checkInRange(p1));

    }

    @Test
    public void testCheckInRange2(){

        Position pos2 = new Position(-1,2);
        assertFalse("Passing an invalid range to checkInRange method", map.checkInRange(pos2));

    }

    @Test
    public void testIsGrass1(){

        assertTrue("Testing the isGrass method",map.isGrass(p1));

    }

    @Test
    public void testGetTile(){

        assertTrue("Testing whether a tile is returned",map.getTile(p1) instanceof Tile);

    }
}
