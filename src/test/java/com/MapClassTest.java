
package com;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import com.Map;
import org.junit.*;

import static org.junit.Assert.*;

public class MapClassTest {
    
    public MapClassTest() {
    }
    
    @Test
    public void testValidRange() {

        Map m = new Map(5);

        assertTrue("Checking if tile (4,2) exists in a map of size 5", m.checkInRange(4, 2));
        assertFalse("Checking if tile (6,2) exists in a map of size 5", m.checkInRange(6,2));
    
    }

    @Test
    public void testCorrectMapCreation() {

        int size = 5;
        Map map = new Map(5);

        assertEquals("Checking if map of correct size is created", map.getLength(), size);

    }

}
