package com;

import java.io.*;

public class Player {
    
    private int currRow, currCol, initRow, initCol;
    
    private File html, css;
    
    public Player (int initRow, int initCol, int playerNumber) {
    
        this.currRow = this.initRow = initRow;
        this.currCol = this.initCol = initCol;
        
        this.html = new File ("map_name_" + playerNumber + ".html");
        this.css = new File ("map_name_" + playerNumber + ".css");

        // Delete files in case they exist
        this.html.delete();
        this.css.delete();
        
    }

    public File getHTML() {
    
        return html;
    
    }
    
    public File getCSS() {
    
        return css;
    
    }
    
    public int getCurrentRow() {
    
        return currRow;
    
    }
    
    public int getCurrentCol() {
    
        return currCol;
    
    }
    
    public int getInitRow() {
    
        return initRow;
    
    }
    
    public int getInitCol() {
    
        return initCol;
    
    }
    
    public void updatePosition(int row, int col) {
    
        currRow = row;
        currCol = col;
    
    }

    public void resetPosition() {
    
        currRow = initRow;
        currCol = initCol;
    
    }
    
}
