package com;

import java.io.*;
import java.util.*;

public class Map {
    
    private Tile[][] map;

    // Tested
    public Map (int n) {
    
        map = new Tile [n][n];
        
        for (int i = 0; i < n; i++) {
        
            for (int j = 0; j < n; j++) {
            
                map[i][j] = Tile.getRandomTile();
            
            }
        
        }
        
        // Select a random row and column and mark it as a treasure tile
        
        Random rand = new Random();
        
        int col = rand.nextInt(n);
        int row = rand.nextInt(n);
        
        map[row][col] = Tile.Treasure;

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

}
