package com;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 08/05/14
 * Time: 23:28
 * To change this template use File | Settings | File Templates.
 */
import org.junit.*;
import static org.junit.Assert.*;

public class ConcreteTeamTest {
    @Test
    public void testUncoverTile(){

    }
    @Test
    public void testGetVisitedTilesCode(){
        ConcreteTeam t1 = new ConcreteTeam();
        assertNotNull("Testing whether the returned code is not null",t1.getVisitedTilesCode() );
    }
}
