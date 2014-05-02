package com;

import java.io.*;

public class Player {
    
    private Position currentPosition;
    private Position initialPosition;
    
    private File html, css;
    
    public Player (Position position, int playerNumber) {
    
        initialPosition = position;
        currentPosition = position;
        
        this.html = new File ("map_name_" + playerNumber + ".html");
        this.css = new File ("map_name_" + playerNumber + ".css");

        // Delete files in case they exist
        this.html.delete();
        this.css.delete();
        
    }

    // Tested
    public File getHTML() {
    
        return html;
    
    }

    // Tested
    public File getCSS() {
    
        return css;
    
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

    // Tested
    public void resetPosition() {
    
        currentPosition = initialPosition;
    
    }
    
}
