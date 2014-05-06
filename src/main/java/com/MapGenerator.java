package com;

import java.util.Random;

public abstract class MapGenerator {

    private Tile[][] map;
    private int mapSize;

    public Map createMap (int size) {

        map = new Tile[size][size];
        mapSize = size;

        fillMap();

        return Map.createMap(map);

    }

    // Complete filling up of map
    private void fillMap() {

        // Fill all map tiles as grass
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                map[i][j] = Tile.Grass;
            }
        }

        // Get Number of Tiles that are to be filled with water
        double percent = getWaterTilePercentage();
        int numOfWaterTiles = (int)(mapSize * mapSize * percent);

        // Choose which positions are to be filled with water
        Position[] waterTiles = getWaterPositions(numOfWaterTiles);

        // Fill positions with water
        setWaterTiles(waterTiles);

        // Choose a random tile to be treasure tile
        Position treasureLocation = getRandomPosition();
        map[treasureLocation.getRow()][treasureLocation.getCol()] = Tile.Treasure;

    }

    // Get the percentage number of tiles to be filled with water
    protected abstract double getWaterTilePercentage();

    // Returns an array of random positions which are to be filled with water
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

    // Returns a random position on the map
    private Position getRandomPosition() {

        Random random = new Random();

        int mapSize = map.length;

        int col = random.nextInt(mapSize);
        int row = random.nextInt(mapSize);

        return new Position (row, col);

    }

    // Sets the positions specified as parameters to Water Tiles
    private void setWaterTiles(Position[] waterTiles) {

        for (int i = 0; i < waterTiles.length; i++) {

            int row = waterTiles[i].getRow();
            int col = waterTiles[i].getCol();

            map[row][col] = Tile.Water;

        }

    }

}
