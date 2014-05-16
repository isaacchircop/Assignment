package com;

import org.junit.Test;
import static org.junit.Assert.*;

public class TileTest {

    @Test
    public void testGetRandomTile(){

        assertNotNull("Testing whether a Tile object is returned",Tile.getRandomTile());

    }

}
