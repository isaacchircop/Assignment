package com;



/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 10/05/14
 * Time: 13:15
 * To change this template use File | Settings | File Templates.
 */
import org.junit.Test;
import java.io.File;
import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void testGetHTML(){
        Player player = new Player(0,new ConcreteTeam());
        File htmlFile = player.getHTML();

        assertTrue("Testing whether getHTML() returns an HTML File Type", htmlFile.getPath().endsWith(".html"));


    }
    @Test
    public void testGetCSS(){
        Player player = new Player(0,new ConcreteTeam());
        File cssFile = player.getCSS();

        assertTrue("Testing whether getCSS() returns a CSS File Type", cssFile.getPath().endsWith(".css"));


    }
    @Test
    public void testGetCurrentPosition(){
        Player p1 = new Player(0,new ConcreteTeam());
        assertNotNull("",p1.getCurrentPosition());

    }
    @Test
    public void testGetInitialPosition(){
        Position initPos = new Position (5,6);
        Player p1 = new Player(0,new ConcreteTeam());
        p1.setInitialPosition(initPos);

        assertEquals("testing the get initial position method",initPos ,p1.getInitialPosition());

    }
    @Test
    public void testUpdatePosition(){
        Position initPos = new Position (5,6);
        Player p1 = new Player(0,new ConcreteTeam());
        p1.setInitialPosition(initPos);

        Position newpos = new Position(7,7);
        p1.updatePosition(newpos);
        assertEquals("Testing the update position method", newpos, p1.getCurrentPosition());

    }
    @Test
    public void testSetInitialPosition(){
        Player p1 = new Player(0,new ConcreteTeam());
        Position initpos = new Position(4,3);
        p1.setInitialPosition(initpos);

        assertTrue("Testing the set initial position method", p1.getInitialPosition().equals(initpos));

    }
    @Test
    public void testSetTileColour(){
        Player p1 = new Player(0,new ConcreteTeam());
        p1.setTileColour("green");

    }
    @Test
    public void testUpdateMapDisplay(){

    }



}
