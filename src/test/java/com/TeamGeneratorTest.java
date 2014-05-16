package com;

import org.junit.*;
import static org.junit.Assert.*;

public class TeamGeneratorTest {

    public boolean allArrayElementsFilled(Player [] players){

        boolean flag = true;

        for(int i = 0; i < players.length; i++)
        {
            if(players[i].equals(null))
            {
                flag = false;
                break;
            }
        }
        return flag;
    }

    @Test
    public void testCreateTeams(){

        TeamGenerator t1 = new TeamGenerator(5,3);

        Player [] players = t1.createTeams();
        assertTrue(allArrayElementsFilled(players));
    }
}
