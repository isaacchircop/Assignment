package com;

import java.util.Random;

public enum Tile {
    
    Grass, Water, Treasure;
    
    public static Tile getRandomTile() {
    
        Random rand = new Random();
        return values()[rand.nextInt(values().length-1)];
    
    }
    
}
