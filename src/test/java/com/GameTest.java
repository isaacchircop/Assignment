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
    public void testInvalidMoveValidCharacterU() {

        Position pos = new Position (0,0);
        Player player = new Player(pos,0);

        char choice = 'u';

        Game game = new Game (2, 5);

        assertFalse("Checking if old position is equal to new proposed position", game.getNewPosition(player,choice).isEqual(pos));
        assertFalse("Checking if Up direction is declined", game.validMove(player, choice));

    }

    @Test
    public void testValidMoveValidCharacterD() {

        Position pos = new Position (0,0);
        Player player = new Player(pos,0);

        char choice = 'd';

        Game game = new Game (2, 5);

        assertFalse("Checking if old position is equal to new proposed position", game.getNewPosition(player,choice).isEqual(pos));
        assertTrue("Checking if Down direction is accepted", game.validMove(player, choice));

    }

    @Test
    public void testValidMoveInvalidCharacterL() {

        Position pos = new Position (0,0);
        Player player = new Player(pos,0);

        char choice = 'L';

        Game game = new Game (2, 5);

        assertFalse("Checking if old position is equal to new proposed position", game.getNewPosition(player,choice).isEqual(pos));
        assertFalse("Checking if Left direction is declined", game.validMove(player, choice));

    }

    @Test
    public void testValidMoveValidCharacterR() {

        Position pos = new Position (0,0);
        Player player = new Player(pos,0);

        char choice = 'R';

        Game game = new Game (2, 5);

        assertFalse("Checking if old position is equal to new proposed position", game.getNewPosition(player,choice).isEqual(pos));
        assertTrue("Checking if Right direction is accepted", game.validMove(player, choice));

    }

    @Test
    public void testInValidMoveInvalidCharacterT() {

        Position pos = new Position (0,0);
        Player player = new Player(pos,0);

        char choice = 't';

        Game game = new Game (2, 5);

        assertTrue("Checking if old position is equal to new proposed position", game.getNewPosition(player,choice).isEqual(pos));
        assertFalse("Checking if character t is declined", game.validMove(player, choice));

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