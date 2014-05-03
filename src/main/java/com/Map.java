package com;

import java.util.*;

public class Map {

    private Tile[][] map;
    private int mapSize;

    // Tested
    public Map (int n, Difficulty difficulty) {
    
        map = new Tile [n][n];
        mapSize = n;

        fillMap (difficulty);

    }

    // Tested
    public String getAsHTMLTable() {

        int n = map.length;

        String htmlTable = "<table border=\"1\" bordercolor=\"#ffffff\" bgcolor=\"#aaaaaa\">\n";

        for (int i = 0; i < n; i++) {

            htmlTable = htmlTable + "<tr>\n";

            for (int j = 0; j < n; j++) {

                htmlTable = htmlTable + "<td id = \"cell" + i + j + "\" width = \"50\" height = \"50\"></td>\n";

            }

            htmlTable = htmlTable + "</tr>\n";

        }

        htmlTable = htmlTable + "</table>";

        return htmlTable;

    }
    
    public String getColour (Position position) {

        int row = position.getRow();
        int col = position.getCol();

        switch (map[row][col]) {

            case Grass:
                return "green";

            case Water:
                return "blue";

            default:
                return "yellow";

        }

    }

    // Tested
    public int getLength() {

        return map.length;

    }

    // Tested
    public boolean checkInRange (Position position) {
    
        int length = map.length;

        int row = position.getRow();
        int col = position.getCol();
        
        return (row < length && col < length && row >= 0 && col >= 0);
    
    }

    public boolean isGrass(Position position) {

        int row = position.getRow();
        int col = position.getCol();

        return (map[row][col] == Tile.Grass);

    }

    public boolean isWater(Position position) {

        int row = position.getRow();
        int col = position.getCol();

        return (map[row][col] == Tile.Water);

    }

    public boolean isTreasure(Position position) {

        int row = position.getRow();
        int col = position.getCol();

        return (map[row][col] == Tile.Treasure);

    }

    private int getNumberOfWaterTiles(Difficulty difficulty) {

        int mapArea = mapSize * mapSize;

        switch (difficulty) {

            case Safe: {

                final double percentage = 0.1;

                return (int) (percentage * mapArea);

            }

            case Hazardous: {

                double percentage = (Math.random()*11 + 25) / 100;

                return (int) (percentage * mapArea);

            }

            default: {

                return -1;

            }

        }

    }

    private Position getRandomPosition() {

        Random random = new Random();

        int mapSize = map.length;

        int col = random.nextInt(mapSize);
        int row = random.nextInt(mapSize);

        return new Position (row, col);

    }

    private Position[] getWaterPositions (int numOfTiles) {

        Position[] waterTiles = new Position[numOfTiles];

        for (int i = 0; i < numOfTiles; i++) {

            boolean validPosition;

            do {

                waterTiles[i] = getRandomPosition();
                validPosition = true;

                for (int j = 0; j < i; j++) {

                    if (waterTiles[i].isEqual(waterTiles[j])) {

                        validPosition = false;
                        break;

                    }

                }

            } while (!validPosition);

        }

        return waterTiles;

    }

    private void fillWithWater(Position[] waterTiles) {

        for (int i = 0; i < waterTiles.length; i++) {

            int row = waterTiles[i].getRow();
            int col = waterTiles[i].getCol();

            map[row][col] = Tile.Water;

        }

    }

    private void fillMap(Difficulty difficulty) {

        // Fill all map tiles as grass
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                map[i][j] = Tile.Grass;
            }
        }

        // Get Number of Tiles that are to be filled with water
        int numOfWaterTiles = getNumberOfWaterTiles(difficulty);

        // Choose which positions are to be filled with water
        Position[] waterTiles = getWaterPositions(numOfWaterTiles);

        // Fill positions with water
        fillWithWater(waterTiles);

        // Choose a random tile to be treasure tile
        Position treasureLocation = getRandomPosition();
        map[treasureLocation.getRow()][treasureLocation.getCol()] = Tile.Treasure;

    }

}
