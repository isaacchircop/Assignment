package com;

import com.Interface;
import com.Map;
import org.junit.*;
import static org.junit.Assert.*;

public class InterfaceClassTest {
    
    public InterfaceClassTest() {
    }

    @Test
    public void testingPlayerNumbers() {

        assertTrue("Checking validity 7 players", Interface.playerNumberCheck(7));
        assertFalse("Checking validity of 10 players", Interface.playerNumberCheck(10));

    }

    @Test
    public void testValidMapSize() {

        assertTrue("Checking validity of map size of 10 for 4 players", Interface.mapSizeCheck(10, 6));
        assertFalse("Checking whether a map size of 5 is valid with 6 players", Interface.mapSizeCheck(5, 6));
        assertFalse("Checking whether a map size of 2 is invalid with 2 players", Interface.mapSizeCheck(2, 2));

    }

    @Test
    public void testCorrectPlayerArraySize() {

        assertEquals("Checking size of array created for 4 players", Interface.createPlayers(new Map(5),4).length, 4);

    }

}
