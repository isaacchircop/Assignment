package com;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 08/05/14
 * Time: 23:36
 * To change this template use File | Settings | File Templates.
 */
import org.junit.*;
import static org.junit.Assert.*;

public class SafeMapCreatorTest {
    @Test
    public void testGetWaterTilePercentage(){

        SafeMapCreator sm1 = new SafeMapCreator();

        assertEquals("Testing whether 0.1 is the actual returned percentage",0.1,sm1.getWaterTilePercentage(),1);
    }
}
