package com;

import java.util.*;

public class Map {

    private static Map instance;

    private static Tile[][] map;

    private Map(Tile[][] mapArray){

        map = mapArray;

    }

    public static Map createMap(Tile[][] mapArray) {

        if (instance == null) {

            instance = new Map(mapArray);

        }

        return instance;

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

    public Tile getTile(Position position) {

        int row = position.getRow();
        int col = position.getCol();

        return map[row][col];

    }

}
