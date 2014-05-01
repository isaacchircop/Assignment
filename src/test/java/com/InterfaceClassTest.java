package com;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class InterfaceClassTest {
    
    public InterfaceClassTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testPlayerNumberCheckValidPlayers() {        
        assertTrue("Checking whether 7 players are valid", Interface.playerNumberCheck(7));
    }
    @Test
    public void testPlayerNumberCheckInvalidPlayers() {
        
        assertFalse("Checking whether 10 players are valid", Interface.playerNumberCheck(10));
    }
    @Test 
    public void testMapSizeCheckValidSize1() {
        
        assertTrue("Checking whether a map size of 7 is valid with 2 players", Interface.mapSizeCheck(5, 2));
    }
    @Test 
    public void testMapSizeCheckValidSize2() {
        
        assertTrue("Checking whether a map size of 10 is valid with 6 players", Interface.mapSizeCheck(10, 6));
    }
    @Test 
    public void testMapSizeCheckInvalidSize1() {
        
        assertFalse("Checking whether a map size of 2 is invalid with 2 players", Interface.mapSizeCheck(2, 2));
    }
    @Test 
    public void testMapSizeCheckInvalidSize2() {
        
        assertFalse("Checking whether a map size of 66 is invalid with 2 players", Interface.mapSizeCheck(66, 2));
    }
    @Test 
    public void testMapSizeCheckInvalidSize3() {
        
        assertFalse("Checking whether a map size of 100 is invalid with 6 players", Interface.mapSizeCheck(100, 6));
    }
    @Test 
    public void testMapSizeCheckInvalidSize4() {
        
        assertFalse("Checking whether a map size of 5 is invalid with 6 players", Interface.mapSizeCheck(5, 6));
    }
    @Test 
    public void testCheckNumberOfPlayersValid() {
        Player [] players = {new Player(0,0,0),new Player(3,3,1)};
        assertTrue("Checking whether 2 players exist in the array", Interface.checkNumberOfPlayers(players, 2));
    }
    @Test 
    public void testGetMapSizeValid4Players() {
        assertEquals(4,Interface.getMapSize(4));
    }
    @Test
    public void testGetMapSizeValid6Players() {
        assertEquals(6,Interface.getMapSize(6));
    }
    @Test
    public void testGetPlayersValid5PLayers() {
        assertEquals(5,Interface.getPlayers());
    }
    @Test
    public void testCheckNumberOfPlayersInvalid() {
        Player [] players = {new Player(0,0,0),new Player(3,3,1)};
        assertFalse("Testing whether 3 players exist in the array", Interface.checkNumberOfPlayers(players, 3));
    }
    @Test
    public void testPerformUpdateValid(){
        Player [] players = {new Player(0,0,0),new Player(3,3,1)};
        Map map = new Map(5);
        assertTrue("Testing whether the map update can be performed",Interface.performUpdate(players,map));
    }
}
