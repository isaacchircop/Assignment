/*package com;

import org.junit.*;
import java.io.File;
import static org.junit.Assert.*;

public class PlayerClassTest {

    public PlayerClassTest() {
    }
    
    @Test
    public void testGetHTML() {

        Player player = new Player(new Position (0,0), 0);
        File htmlFile = player.getHTML();

        assertTrue("Testing whether getHTML() returns an HTML File Type", htmlFile.getPath().endsWith(".html"));

    }

    @Test
    public void testGetCSS() {

        Player player = new Player(new Position (0,0),0);
        File cssFile = player.getCSS();

        assertTrue("Testing whether getCSS() returns a CSS File Type", cssFile.getPath().endsWith(".css"));

    }

    @Test
    public void testGetInitialPosition() {

        Position initPos = new Position (5,6);
        Player p1 = new Player(initPos, 0);

        assertTrue("Testing initial position getter", p1.getInitialPosition().isEqual(initPos));

    }

    @Test
    public void testUpdateResetAndCurrentGetter() {

        Position initPos = new Position (5,6);
        Player p1 = new Player(initPos, 0);

        assertTrue("Testing current position getter", p1.getCurrentPosition().isEqual(initPos));

        Position newPos = new Position (0,0);
        p1.updatePosition(newPos);

        assertFalse("Testing if position got updated", p1.getCurrentPosition().isEqual(initPos));
        assertTrue("Testing current position getter", p1.getCurrentPosition().isEqual(newPos));

        p1.resetPosition();

        assertTrue("Testing if position is resetted", p1.getCurrentPosition().isEqual(initPos));

    }

}
*/