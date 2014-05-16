package com;

import org.junit.*;
import static org.junit.Assert.*;

public class ConcreteTeamTest {
    @Test
    public void testUncoverTile(){
        ConcreteTeam ct1 = new ConcreteTeam();
        ct1.uncoverTile(new Position(1,1),"green");
        assertNotNull("Testing whether the visited tile code is updated",ct1.getVisitedTilesCode());

    }
    @Test
    public void testGetVisitedTilesCode(){
        ConcreteTeam t1 = new ConcreteTeam();
        assertNotNull("Testing whether the returned code is not null",t1.getVisitedTilesCode() );
    }
}
