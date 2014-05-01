package com;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.*;

import java.io.File;

import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class PlayerClassTest {

    public PlayerClassTest() {
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
    public void testGetHTML() {
        Player p1 = new Player(0,0,0);
        assertTrue("Testing whether getHTML() returns a File type object",p1.getHTML() instanceof File);
    }
    @Test
    public void testGetCSS() {
        Player p1 = new Player(0,0,0);
        assertTrue("Testing whether getCSS() returns a File type object",p1.getCSS() instanceof File);
    }
    @Test
    public void testGetCurrentRow() {
        Player p1 = new Player(0,0,0);
        p1.updatePosition(3,4);
        assertEquals("Testing whether getCurrentRow() returns 3",p1.getCurrentRow(),3);
    }
    @Test
    public void testGetCurrentColumn() {
        Player p1 = new Player(0,0,0);
        p1.updatePosition(3,4);
        assertEquals("Testing whether getCurrentCol() returns 4",p1.getCurrentCol(),4);
    }
    @Test
    public void testGetInitRow() {
        Player p1 = new Player(5,6,0);
        assertEquals("Testing whether getInitRow() returns 5",p1.getInitRow(),5);
    }
    @Test
    public void testGetInitColumn() {
        Player p1 = new Player(5,6,0);
        assertEquals("Testing whether getInitColumn() returns 6",p1.getInitCol(),6);
    }
}
