/*package com;



/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 10/05/14
 * Time: 00:04
 * To change this template use File | Settings | File Templates.

import com.Map;
import com.Position;
import org.junit.Test;
import static org.junit.Assert.*;
public class MapTest {
    @Test
    public void testCreateMap(){

    }
    @Test
    public void testGetAsHTMLTable(){

        Tile [][] mapArray = new
        Map map = new Map(mapArray);

        String html = map.getAsHTMLTable();

        assertTrue ("Testing if html code starts and ends with <table> tags", html.startsWith("<table") && html.endsWith("</table>"));

    }
    @Test
    public void testGetColour(){

    }
    @Test
    public void testGetLength(){
        int size = 5;
        Map map = new Map(5, Difficulty.Hazardous);

        assertEquals("Checking if map of correct size is created", map.getLength(), size);


    }
    @Test
    public void testCheckInRange1(){
        Map m = new Map(5, Difficulty.Safe);
        Position pos = new Position (4,2);

        assertTrue("Checking if tile (4,2) exists in a map of size 5", m.checkInRange(pos));


    }
    @Test
    public void testCheckInRange2(){
        Map m = new Map(5, Difficulty.Safe);
        Position pos = new Position (6,2);

        assertFalse("Checking if tile (6,2) exists in a map of size 5", m.checkInRange(pos));

    }

    @Test
    public void testCheckInRange3(){
        Map m = new Map(5, Difficulty.Safe);
        Position pos = new Position (6,2);

        assertFalse("Checking if tile (6,2) exists in a map of size 5", m.checkInRange(pos));


    }

    @Test
    public void testIsGrass(){

    }
    @Test
    public void testIsWater(){

    }
    @Test
    public void testIsTreasure(){

    }
    @Test
    public void testGetTile(){

    }
}  */



