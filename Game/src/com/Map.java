package com;

import java.io.*;
import java.util.*;

public class Map {
    
    private Tile[][] map;
    
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
        
    private String getBodyCode() {
        
        int n = map.length;
    
        String body = "<body><table border=\"1\" bordercolor=\"#ffffff\" bgcolor=\"#aaaaaa\">";
        
        for (int i = 0; i < n; i++) {
            
            body = body + "<tr>";
        
            for (int j = 0; j < n; j++) {
            
                body = body + "<td id = \"cell" + i + j + "\" width = \"50\" height = \"50\"></td>";
            
            }
            
            body = body + "</tr>";
        
        }
        
        body = body + "</table></body>";
        
        return body;
    
    }
    
    public void outputInitialMap (Player[] players) {
    
        FileWriter fw;
        BufferedWriter bw;
        
        String body = getBodyCode();
        
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
    
    public void outputUpdatedMap (Player[] players) {
        
        FileWriter fw;
        BufferedWriter bw;
    
        for (int i = 0; i < players.length; i++) {
            
            int row = players[i].getCurrentRow();
            int col = players[i].getCurrentCol();
            
            String cellID = "cell" + row + col;
            
            String colour = "";
            
            switch (map[row][col]) {
            
                case Grass:
                    colour = "green";
                    break;
                    
                case Water:
                    colour = "blue";
                    break;
                    
                default:
                    colour = "yellow";
                    break;
                 
            }
            
            String cssCode = "td#" + cellID + "{background: " + colour + ";}\n";
            
            String imageCode = "td#" + cellID + "{background: " + colour + " url(\"pin.png\") no-repeat center center; background-size:50%}\n";
            
            try {
                
                String file = "";
                
                // Load file contents except last line into variable called file
                
                if (players[i].getCSS().length() > 0) {
                
                    FileReader fr = new FileReader(players[i].getCSS());
                    BufferedReader br = new BufferedReader(fr);
                    
                    String line = br.readLine();
                    
                    String lastline = line;
                    
                    while ((line = br.readLine()) != null) {

                        file = file + lastline;
                        lastline = line;

                    }
                    
                    br.close();
                
                }
                
                fw = new FileWriter (players[i].getCSS());
                bw = new BufferedWriter (fw);
            
                bw.write(file);
                bw.write(cssCode);
                bw.write(imageCode);
                bw.close();
                
            }
            
            catch (IOException e) {
            
                e.printStackTrace();
            
            }
        
        }
    
    }
    
    public int getLength() {
    
        return map.length;
    
    }
    
    public Tile getTile(int row, int col) {
    
        return map[row][col];
    
    }
    
    public boolean checkInRange (int row, int col) {
    
        int length = map.length;
        
        if (row < length && col < length && row >= 0 && col >= 0) {
        
            return true;
        
        } else {
        
            return false;
        
        }
    
    }
    
}
