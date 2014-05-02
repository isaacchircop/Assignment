package com;

import com.GameLauncher;
import org.junit.*;
import static org.junit.Assert.*;

public class GameLauncherTest {

    public GameLauncherTest() {
    }

    @Test
    public void testingPlayerNumbers() {

        assertTrue("Checking validity 7 players", GameLauncher.playerNumberCheck(7));
        assertFalse("Checking validity of 10 players", GameLauncher.playerNumberCheck(10));

    }

    @Test
    public void testValidMapSize() {

        assertTrue("Checking validity of map size of 10 for 4 players", GameLauncher.mapSizeCheck(10, 6));
        assertFalse("Checking whether a map size of 5 is valid with 6 players", GameLauncher.mapSizeCheck(5, 6));
        assertFalse("Checking whether a map size of 2 is invalid with 2 players", GameLauncher.mapSizeCheck(2, 2));

    }

}