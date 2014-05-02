package com;

import com.Game;
import org.junit.*;
import static org.junit.Assert.*;

public class GameTest {
    
    public GameTest() {
    }

    @Test
    public void testConstructor(){

        Game newGame = new Game (4, 8);

        int numOfPlayers = 4;

        assertEquals("Checking if players array is equal to number of players", newGame.createPlayers(numOfPlayers).length, numOfPlayers);

    }

    @Test
    public void testValidMoveValidCharacter() {

        Player player = new Player(new Position (0,0),0);

        char choice = 'u';

        Game game = new Game (2, 5);

        game.validMove(player, choice);

    }

/*
    @Test
    public void testMove() {

        Map map = new Map(5);

        Player player = new Player (0,0,0);

        assertFalse("Checking if character u is declined - player moves outside range", Game.move(map, player, 'u'));
        assertFalse("Checking if character l is declined - player moves outside range", Game.move(map, player, 'L'));
        assertTrue("Checking if character r is accepted", Game.move(map, player, 'r'));
        assertTrue("Checking if character d is accepted", Game.move(map, player, 'D'));
        assertFalse("Checking if incorrect character is declined", Game.move(map, player, 't'));


    }*/

}