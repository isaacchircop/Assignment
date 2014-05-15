package com;



/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 10/05/14
 * Time: 13:15
 * To change this template use File | Settings | File Templates.
 */
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import static org.junit.Assert.*;

public class PlayerTest {

    Player player;
    Position initpos, newpos;
    @Before
    public void initialisePLayer(){
        player = new Player(0,new ConcreteTeam());
        initpos = new Position(0,0);
        newpos = new Position(1,1);
    }


    @Test
    public void testGetHTML(){
        File htmlFile = player.getHTML();
        assertTrue("Testing whether getHTML() returns an HTML File Type", htmlFile.getPath().endsWith(".html"));
    }
    @Test
    public void testGetCSS(){
        File cssFile = player.getCSS();
        assertTrue("Testing whether getCSS() returns a CSS File Type", cssFile.getPath().endsWith(".css"));
    }
    @Test
    public void testGetCurrentPosition(){
        Position newpos = new Position(2,2);
        player.updatePosition(newpos);
        assertTrue("Testing the current position",player.getCurrentPosition().equals(newpos));

    }
    @Test
    public void testGetInitialPosition(){
        Position initPos = new Position (5,6);
        player.setInitialPosition(initPos);
        assertEquals("testing the get initial position method",initPos ,player.getInitialPosition());
    }
    @Test
    public void testUpdatePosition(){
        Position initPos = new Position (5,6);
        player.setInitialPosition(initPos);

        Position newpos = new Position(7,7);
        player.updatePosition(newpos);
        assertEquals("Testing the update position method", newpos, player.getCurrentPosition());

    }
    @Test
    public void testSetInitialPosition(){
        Position initpos = new Position(4,3);
        player.setInitialPosition(initpos);

        assertTrue("Testing the set initial position method", player.getInitialPosition().equals(initpos));

    }
    @Test
     public void testSetTileColourBlue(){
        player.setInitialPosition(initpos);

        player.updatePosition(newpos);
        player.setTileColour("blue");

        assertTrue("Testing whether the current tile is set to the initial tile when a blue tile is encountered",player.getCurrentPosition().equals(initpos));


    }
    @Test
    public void testSetTileColourYellowAndUpdateDisplay(){
        player.setInitialPosition(initpos);

        player.updatePosition(newpos);
        player.setTileColour("yellow");

        player.updateMapDisplay();

        assertTrue("Testing whether getCSS() returns a CSS File Type", player.getCSS().getPath().endsWith(".css"));
    }

    @Test
    public void testUpdateMapDisplay(){
        player.setInitialPosition(initpos);

        Position newpos = new Position(1,1);
        player.updatePosition(newpos);

        player.updateMapDisplay();

        assertTrue("Testing whether getCSS() returns a CSS File Type", player.getCSS().getPath().endsWith(".css"));

    }



}
