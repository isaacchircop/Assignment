package com;

import java.io.*;
import java.util.*;

public class Game {

    private Map map;
    private Player[] players;

    public Game (Player[] players, Map map) {

        this.players = players;
        this.map = map;

    }

    public void startGame() {

        // Instantiate Player Positions
        instantiatePositions();

        int rndCnt = 0;

        // Output html and css files to display map to user

        outputMap();

        while (!updateAndCheckPositions()) {

            rndCnt++;

            System.out.println("\n================================================================");
            System.out.println("Round " + rndCnt + ": Move (U)p (D)own (L)eft or (R)ight\n");

            Scanner k = new Scanner(System.in);

            for (int i = 0; i < players.length; i++) {

                char move;

                do {

                    System.out.print("Awaiting Input from Player " + i + ": ");

                    move = k.next().charAt(0);

                    System.out.println();

                } while (!validMove(players[i], move));

            }

        }

        System.out.println ("Game Finished!");

    }

    private void instantiatePositions() {

        for (int i = 0; i < players.length; i++) {

            players[i].setInitialPosition(getInitialPosition());

        }

    }

    private Position getInitialPosition() {

        Random rand = new Random();

        Position initialPosition;

        do {

            int row = rand.nextInt(map.getLength());
            int col = rand.nextInt(map.getLength());

            initialPosition = new Position(row,col);

        } while (!map.isGrass(initialPosition));

        return initialPosition;

    }

    public boolean validMove (Player player, char choice) {

        Position currentPosition = player.getCurrentPosition();
        Position newPosition = getNewPosition(player, choice);

        if (!newPosition.isEqual(currentPosition)) {

            if (map.checkInRange(newPosition)) {

                player.updatePosition (newPosition);
                return true;

            } else {

                System.out.println ("Invalid Move!  You tried to move outside map limit.  Please try again");
                return false;

            }

        } else {

            System.out.println ("Invalid Character!  Please try again");
            return false;

        }

    }

    public Position getNewPosition(Player player, char choice) {

        Position currentPosition = player.getCurrentPosition();
        Position newPosition = new Position (currentPosition.getRow(), currentPosition.getCol());

        choice = Character.toUpperCase(choice);

        switch (choice) {

            case 'U':

                newPosition.decrRow();
                break;

            case 'D':

                newPosition.incrRow();
                break;

            case 'L':

                newPosition.decrCol();
                break;

            case 'R':

                newPosition.incrCol();
                break;

            default:
                break;

        }

        return newPosition;

    }

    public boolean updateAndCheckPositions() {

        boolean treasureFound = false;

        // Change team file

        for (int i = 0; i < players.length; i++) {

            Position currentPosition = players[i].getCurrentPosition();

            switch (map.getTile(currentPosition)) {

                case Grass:

                    players[i].setTileColour("green");
                    break;

                case Water:

                    players[i].setTileColour("blue");
                    break;


                case Treasure:

                    players[i].setTileColour("yellow");
                    treasureFound = true;
                    break;

            }

        }

        for (int i = 0; i < players.length; i++) {

            players[i].updateMapDisplay();

        }

        return treasureFound;

    }

    private void outputMap () {

        FileWriter fw;
        BufferedWriter bw;

        String mapTable = map.getAsHTMLTable();
        String body = "<body>" + mapTable + "</body>";

        for (int i = 0; i < players.length; i++) {

            String head = "<head><link rel=\"stylesheet\" type=\"text/css\" href=\"map_name_" + i + ".css\"></head>";
            String html = "<html>" + head + body + "</html>";

            try {

                fw = new FileWriter(players[i].getHTML());
                bw = new BufferedWriter (fw);

                bw.write(html);
                bw.close();

            }

            catch (IOException e) {

                e.printStackTrace();

            }

        }

    }

}
