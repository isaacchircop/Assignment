package com;

import java.io.*;

public class Player {
    
    private Position initialPosition, currentPosition;
    private AbstractTeam team;
    private File html, css;
    private boolean treasureFound;
    public int playerNumber;
    
    public Player (int playerNumber, AbstractTeam team) {

        treasureFound = false;

        this.playerNumber = playerNumber;

        // Setting team number
        this.team = team;

        // Creating new map files
        this.html = new File ("map_name_" + playerNumber + ".html");
        this.css = new File ("map_name_" + playerNumber + ".css");
        this.html.delete();
        this.css.delete();
        
    }

    // Tested
    public File getHTML() {
    
        return html;
    
    }

    // Tested
    public Position getCurrentPosition(){

        return currentPosition;

    }

    // Tested
    public Position getInitialPosition() {

        return initialPosition;

    }

    // Tested
    public void updatePosition(Position newPosition) {
    
        currentPosition = newPosition;
    
    }

    public void setInitialPosition(Position initialPosition) {

        this.currentPosition = this.initialPosition = initialPosition;

    }

    public void setTileColour(String colour) {

        team.uncoverTile(currentPosition, colour);

        if (colour.equals("blue")) {

            currentPosition = initialPosition;

        } else if (colour.equals("yellow")) {

            treasureFound = true;

        }

    }

    public void updateMapDisplay() {

        String colour;

        if (treasureFound) {

            colour = "yellow";

        } else {

            colour = "green";

        }

        String cellID = currentPosition.getID();
        String appendString = "td#" + cellID + "{background: " + colour + " url(\"pin.png\") no-repeat center center; background-size:50%}\n";

        try {

            FileWriter fw = new FileWriter (css);
            BufferedWriter bw = new BufferedWriter (fw);

            bw.write(team.getVisitedTilesCode());
            bw.write(appendString);
            bw.close();

        }

        catch (IOException e) {

            e.printStackTrace();

        }

    }

}
