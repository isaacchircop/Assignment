package com;

import org.junit.Test;
import static org.junit.Assert.*;

public class HazardousMapCreatorTest {

    @Test
    public void testGetWaterTilePercentage(){

        HazardousMapCreator h1 = new HazardousMapCreator();
        assertNotNull("Testing whether the water value returned is not NULL",h1.getWaterTilePercentage());

    }

}
