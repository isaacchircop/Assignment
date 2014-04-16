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
        
        if (this.html.exists()) {
        
            this.html.delete();
        
        }
        
        if (this.css.exists()) {
        
            this.css.delete();
        
        }
        
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
    
}
