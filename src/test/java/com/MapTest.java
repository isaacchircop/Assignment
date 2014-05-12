package com;



/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 12/05/14
 * Time: 12:53
 * To change this template use File | Settings | File Templates.
 */
import org.junit.*;
import static org.junit.Assert.*;
public class MapTest {
    @Test
    public void testCreateMap(){

        Tile [][] tiles = new Tile [5][5];
        assertTrue("",Map.createMap(tiles) instanceof Map);

    }
    @Test
    public void testGetAsHTMLTable(){

        Tile [][] tiles = new Tile [5][5];
        Map map = Map.createMap(tiles);

        String html = map.getAsHTMLTable();

        assertTrue ("Checking if html code starts and ends with <table> tags", html.startsWith("<table") && html.endsWith("</table>"));


    }
    @Test
    public void testGetLength(){
        Tile tiles [][] = new Tile [5][5];
        Map map = Map.createMap(tiles);
        assertEquals("Testing the map length is 5",5,map.getLength());
    }
    @Test
    public void testCheckInRange(){
        Tile tiles [][] = new Tile [5][5];
        Map map = Map.createMap(tiles);
        Position pos1 = new Position(2,2);

        assertTrue("Testing the checkInRange method", map.checkInRange(pos1));

    }
    @Test
    public void testIsGrass(){
        Tile tiles [][] = new Tile [5][5];
        Map map = Map.createMap(tiles);
        Position pos1 = new Position(2,2);
        assertTrue("Testing the isGrass method",map.isGrass(pos1));
    }
    @Test
    public void testGetTile(){
        Tile tiles [][] = new Tile [5][5];
        Map map = Map.createMap(tiles);
        Position pos1 = new Position(2,2);
        assertTrue("Testing whether a tile is returned",map.getTile(pos1) instanceof Tile);
    }
}
