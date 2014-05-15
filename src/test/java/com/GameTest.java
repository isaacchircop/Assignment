package com;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 09/05/14
 * Time: 23:04
 * To change this template use File | Settings | File Templates.
*/
import org.junit.*;
import static org.junit.Assert.*;
public class GameTest {
    Tile [][] tiles;
    Player p1;
    Player [] players;
    Game g1;
    @Before
    public void initialiseGameTest(){
        tiles = new Tile[5][5];
        p1 = new Player(0, new ConcreteTeam());
        p1.setInitialPosition(new Position(0,0));
        players = new Player[3];
        players[0] = p1;
        g1 = new Game(players,Map.createMap(tiles));
    }
    @Test
    public void testValidMove1(){
        p1.setInitialPosition(new Position(3,4));
        assertTrue("Testing whether a valid move has been inputted", g1.validMove(p1,'u'));
    }
    @Test
    public void testValidMove2(){
        assertFalse("Testing whether a valid move has been inputted", g1.validMove(p1,'u'));
    }
    @Test
    public void testValidMove3(){
        p1.setInitialPosition(new Position(2,2));
        assertFalse("Testing whether a valid move has been inputted", g1.validMove(p1,'p'));
    }
    @Test
    public void testGetNewPosition1(){
        p1.updatePosition(new Position(0,1));
        assertTrue("Testing whether the get new position method returns a position object", g1.getNewPosition(p1, 'u') instanceof Position);
    }
    @Test
    public void testGetNewPosition2(){
        p1.updatePosition(new Position(0,1));
        assertTrue("Testing whether the get new position method returns a position object", g1.getNewPosition(p1, 'l') instanceof Position);
    }
    @Test
    public void testGetNewPosition3(){
        p1.updatePosition(new Position(0,1));
        assertTrue("Testing whether the get new position method returns a position object", g1.getNewPosition(p1, 'r') instanceof Position);
    }
    @Test
    public void testGetNewPosition4(){
        p1.updatePosition(new Position(0,1));
        assertTrue("Testing whether the get new position method returns a position object", g1.getNewPosition(p1, 'd') instanceof Position);
    }
    @Test
    public void testUpdateAndCheckPositions(){
        Player p2 = new Player(1, new ConcreteTeam());
        Player p3 = new Player(2, new ConcreteTeam());

        p2.setInitialPosition(new Position(3,4));
        p3.setInitialPosition(new Position(1,2));

        players[0] = p1;
        players[1] = p2;
        players[2] = p3;
        assertFalse("Testing whether the updateAndCheckPositions method works", g1.updateAndCheckPositions());

    }
}



