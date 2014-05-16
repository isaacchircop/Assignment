package com;

import org.junit.*;
import java.io.File;
import static org.junit.Assert.*;

public class PlayerTest {

    Player player;
    Position initPos, newPos;

    @Before
    public void initialisePLayer(){
        player = new Player(0,new ConcreteTeam());
        initPos = new Position(0,0);
        newPos = new Position(1,1);
    }

    @Test
    public void testGetHTML(){

        File htmlFile = player.getHTML();
        assertTrue("Testing whether getHTML() returns an HTML File Type", htmlFile.getPath().endsWith(".html"));

    }

    @Test
    public void testGetInitialPosition(){

        player.setInitialPosition(initPos);
        assertEquals("testing the get initial position method",initPos ,player.getInitialPosition());
    }

    @Test
    public void testGetCurrentPosition(){

        player.updatePosition(newPos);
        assertTrue("Testing the current position",player.getCurrentPosition().equals(newPos));

    }

    @Test
    public void testUpdatePosition(){

        player.setInitialPosition(initPos);
        player.updatePosition(newPos);

        assertFalse("Testing that new position is not equal to old position", player.getCurrentPosition().equals(initPos));  // In this case previous position was initial position
        assertTrue("Testing that new position is in fact as required", newPos.equals(player.getCurrentPosition()));

    }

    @Test
    public void testSetTileColourBlue(){

        player.setInitialPosition(initPos);

        player.updatePosition(newPos);
        player.setTileColour("blue");

        assertTrue("Testing whether the current tile is set to the initial tile when a blue tile is encountered", player.getCurrentPosition().equals(initPos));

    }

}
