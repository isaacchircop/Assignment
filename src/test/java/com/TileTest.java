package com;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 09/05/14
 * Time: 13:10
 * To change this template use File | Settings | File Templates.
 */
import org.junit.*;
import static org.junit.Assert.*;
public class TileTest {
    @Test
    public void testGetRandomTile(){
        assertNotNull("Testing whether a Tile object is returned",Tile.getRandomTile());
    }
}
