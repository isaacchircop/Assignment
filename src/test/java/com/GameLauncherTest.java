package com;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 09/05/14
 * Time: 13:48
 * To change this template use File | Settings | File Templates.
 */

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class GameLauncherTest {
    @Test
    public void testPlayerNumberCheck1(){
        assertTrue("Testing whether 3 players are valid",GameLauncher.playerNumberCheck(3));
    }
    @Test
    public void testPlayerNumberCheck2(){
        assertFalse("Testing whether 10 players are invalid",GameLauncher.playerNumberCheck(10));
    }
    @Test
    public void testMapSizeCheck1(){
        assertTrue("Testing validity of map size of 10 for 6 players", GameLauncher.mapSizeCheck(10, 6));
    }
    @Test
    public void testMapSizeCheck2(){
        assertFalse("Testing whether a map size of 5 is valid with 6 players", GameLauncher.mapSizeCheck(5, 6));

    }
    @Test
    public void testMapSizeCheck3(){
        assertFalse("Testing whether a map size of 2 is invalid with 2 players", GameLauncher.mapSizeCheck(2, 2));
    }
    @Test
    public void testValidChoice0(){
        assertTrue("Testing whether an input of 'H' is accepted",GameLauncher.validChoice('H'));
    }
    @Test
    public void testValidChoice1(){
        assertTrue("Testing whether an input of 'S' is accepted",GameLauncher.validChoice('S'));
    }
    @Test
    public void testInvalidChoice0(){
        assertFalse("Testing whether an input of 'g' is refused",GameLauncher.validChoice('g'));
    }

}
