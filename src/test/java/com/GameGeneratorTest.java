package com;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 09/05/14
 * Time: 13:38
 * To change this template use File | Settings | File Templates.
 */
import org.junit.*;
import static org.junit.Assert.*;
public class GameGeneratorTest {
    @Test
    public void testCreateGame(){

        GameGenerator g1 = new GameGenerator(5,3,7,'S');
        assertNotNull("Testing whther a game is actually created",g1.createGame());

    }
}
