package com;

public class HazardousMapCreator extends MapGenerator {

    @Override
    protected double getWaterTilePercentage() {

        // Generate a random number between 25 and 35 inclusive
        double randNum = (Math.random() * 11) + 25;

        return randNum / 100;

    }

}
