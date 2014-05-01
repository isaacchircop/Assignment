package com;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import com.Interface;
import com.Map;
import org.junit.*;

import static org.junit.Assert.*;

public class InterfaceClassTest {
    
    public InterfaceClassTest() {
    }

    @Test
    public void testingPlayerNumbers() {

        assertTrue("Checking validity 7 players", Interface.playerNumberCheck(7));
        assertFalse("Checking validity of 10 players", Interface.playerNumberCheck(10));

    }

    @Test
    public void testValidMapSize() {

        assertTrue("Checking validity of map size of 10 for 4 players", Interface.mapSizeCheck(10, 6));
        assertFalse("Checking whether a map size of 5 is valid with 6 players", Interface.mapSizeCheck(5, 6));
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
    @Test
    public void testCorrectPlayerArraySize(){

        assertEquals("Checking size of array created for 4 players", Interface.createPlayers(new Map(5),4).length, 4);


    }

}
