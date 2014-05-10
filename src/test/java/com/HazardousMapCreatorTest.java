package com;



/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 09/05/14
 * Time: 23:58
 * To change this template use File | Settings | File Templates.
 */
import org.junit.Test;
import static org.junit.Assert.*;
public class HazardousMapCreatorTest {
    @Test
    public void testGetWaterTilePercentage(){
        HazardousMapCreator h1 = new HazardousMapCreator();
        assertNotNull("Testing whether the water value returned is not NULL",h1.getWaterTilePercentage());
    }
}
