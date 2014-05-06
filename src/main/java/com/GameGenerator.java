package com;

public class GameGenerator {

    private int numOfPlayers, numOfTeams, mapSize;
    private char difficulty;

    public GameGenerator(int numOfPlayers, int numOfTeams, int mapSize, char difficulty) {

        this.numOfPlayers = numOfPlayers;
        this.numOfTeams = numOfTeams;
        this.mapSize = mapSize;
        this.difficulty = difficulty;

    }

    public Game createGame() {

        // Generate teams
        TeamGenerator teamGenerator = new TeamGenerator(numOfPlayers, numOfTeams);
        Player[] players = teamGenerator.createTeams();

        for (int i = 0; i < players.length; i++) {
            System.out.println(players[i]);
        }

        // Generate map
        MapGenerator mapGenerator = getGenerator();
        Map map = mapGenerator.createMap(mapSize);

        return new Game (players, map);

    }

    private MapGenerator getGenerator() {

        if (difficulty == 'S') {

            return new SafeMapCreator();

        } else {

            return new HazardousMapCreator();

        }

    }

}
