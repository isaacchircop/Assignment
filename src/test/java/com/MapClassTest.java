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
public class MapClassTest {
    
    public MapClassTest() {
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
    public void testCheckInRangeMethodValidRange() {
        
        Map m = new Map(5);    
        assertTrue("Checking whether (4,2) is valid in a 5x5 map", m.checkInRange(4, 2));
    
    }
    @Test
    public void testCheckInRangeMethodInvalidRow() {
        
        Map m = new Map(8);    
        assertFalse("Checking whether (2,10) is valid on a 8x8 map ", m.checkInRange(2,10));        
    }
    @Test
    public void testCheckInRangeMethodInvalidColumn() {
        
        Map m = new Map(8);    
        assertFalse("Checking whether (12,5) is valid on a 8x8 map ", m.checkInRange(12,5));        
    }
}
