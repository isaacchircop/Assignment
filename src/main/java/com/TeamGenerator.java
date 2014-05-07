package com;

import java.util.Random;
import java.util.ArrayList;

public class TeamGenerator {

    private int numOfPlayers, numOfTeams;

    private ConcreteTeam[] teamsPool;

    public TeamGenerator (int numOfPlayers, int numOfTeams) {

        this.numOfPlayers = numOfPlayers;
        this.numOfTeams = numOfTeams;

        teamsPool = new ConcreteTeam[numOfTeams];

    }

    public Player[] createTeams() {

        Player[] players = new Player[numOfPlayers];

        fillTeamsPool();

        int[] playerNumbers = new int[numOfPlayers];    // Player Numbers yet to be assigned a team

        int nextTeam = 0;

        // Fill  array with player numbers
        for (int i = 0; i < numOfPlayers; i++) {

            playerNumbers[i] = i;

        }

        Random rand = new Random();

        for (int i = 0; i < numOfPlayers; i++) {

            int randomIndex = rand.nextInt(numOfPlayers - i);

            players[playerNumbers[randomIndex]] = new Player (playerNumbers[randomIndex], teamsPool[nextTeam%numOfTeams]);

            nextTeam++;

            // Shift remaining elements to the left

            for (int j = randomIndex; j < numOfPlayers-1; j++) {

                playerNumbers[j] = playerNumbers[j+1];

            }

        }

        return players;

    }

    private void fillTeamsPool() {

        for (int i = 0; i < numOfTeams; i++) {

            teamsPool[i] = new ConcreteTeam();

        }

    }

}
