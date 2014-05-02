package com;

import java.io.*;
import java.util.*;

public class Game {

    private Map map;
    private Player[] players;

    public Game (int numOfPlayers, int mapSize) {

        map = new Map(mapSize);
        players = createPlayers(numOfPlayers);

        // Output html and css files to display map to user

        outputMap();
        updateMapVisibility();

    }

    public void start() {

        int rndCnt = 0;

        do {

            rndCnt++;

            System.out.println("\n===================================================");
            System.out.println ("Round " + rndCnt + ": Move (U)p (D)own (L)eft or (R)ight\n");

            Scanner k = new Scanner (System.in);

            for (int i = 0; i < players.length; i++) {

                char move;

                do {

                    System.out.print ("Awaiting Input from Player " + i + ": ");

                    move = k.next().charAt(0);

                    System.out.println();

                } while (!validMove(players[i], move));

            }

            updateMapVisibility();

            resetPositionsIfWater();

        } while (!treasureFound());

        System.out.println ("Game Finished!");

    }

    public Player[] createPlayers (int players) {

        Player[] playersArray = new Player[players];

        for (int i = 0; i < players; i++) {

            Position initialPosition = getInitialPosition();

            playersArray[i] = new Player(initialPosition, i);

        }

        return playersArray;

    }

    private Position getInitialPosition() {

        Random rand = new Random();

        Position position;

        int mapSize = map.getLength();

        do {

            int row = rand.nextInt(mapSize);
            int col = rand.nextInt(mapSize);

            position = new Position(row,col);

        } while (!map.isGrass(position));

        return position;

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

    private void updateMapVisibility () {

        for (int i = 0; i < players.length; i++) {

            String codeToAppend = getCSSCode(players[i]);

            rewriteFile(players[i].getCSS(), codeToAppend);

        }

    }



    public String getAllExceptLastLine (File file) {

        String contents = "";

        // Load file contents except last line into variable called file

        if (file.length() > 0) {

            try {

                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);

                String line = br.readLine();

                String lastline = line;

                while ((line = br.readLine()) != null) {

                    contents = contents + lastline;
                    lastline = line;

                }

                br.close();

            }

            catch (FileNotFoundException e) {

                e.printStackTrace();

            }

            catch (IOException e) {

                e.printStackTrace();

            }

        }

        return contents;

    }

    public void rewriteFile (File cssFile, String appendString) {

        try {

            String fileContents = getAllExceptLastLine(cssFile);

            FileWriter fw = new FileWriter (cssFile);
            BufferedWriter bw = new BufferedWriter (fw);

            bw.write(fileContents);
            bw.write(appendString);
            bw.close();

        }

        catch (IOException e) {

            e.printStackTrace();

        }

    }

    public String getCSSCode (Player player) {

        Position currentPosition = player.getCurrentPosition();

        String cellID = currentPosition.getID();

        String currentTileColour = map.getColour(currentPosition);

        String cssCode = "td#" + cellID + "{background: " + currentTileColour + ";}\n";

        String imageCode;

        if (!currentTileColour.equals("blue")) {

            imageCode = "td#" + cellID + "{background: " + currentTileColour + " url(\"pin.png\") no-repeat center center; background-size:50%}\n";

        } else {

            Position initialPosition = player.getInitialPosition();
            cellID = initialPosition.getID();
            imageCode = "td#" + cellID + "{background: green url(\"pin.png\") no-repeat center center; background-size:50%}\n";

        }

        return cssCode + imageCode;

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

    public boolean treasureFound() {

        for (int i = 0; i < players.length; i++) {

            if (map.isTreasure(players[i].getCurrentPosition())) {

                return true;

            }

        }

        return false;

    }

    public void resetPositionsIfWater() {

        for (int i = 0; i < players.length; i++) {

            if (map.isWater(players[i].getCurrentPosition())) {

                players[i].resetPosition();

            }

        }

    }

}
