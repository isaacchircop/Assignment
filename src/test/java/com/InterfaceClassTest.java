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
    public void testCorrectPlayerArrayCreation(){

        assertEquals("Checking size of array created for 4 players", Interface.createPlayers(new Map(5),4).length, 4);

    }

    @Test
    public void testMove() {

        Map map = new Map(5);

        Player player = new Player (0,0,0);

        assertFalse("Checking if character u is declined - player moves outside range", Interface.move(map, player, 'u'));
        assertFalse("Checking if character l is declined - player moves outside range", Interface.move(map, player, 'L'));
        assertTrue("Checking if character r is accepted", Interface.move(map, player, 'r'));
        assertTrue("Checking if character d is accepted", Interface.move(map, player, 'D'));
        assertFalse("Checking if incorrect character is declined", Interface.move(map, player, 't'));


    }

}
