package com;

import java.util.*;
import java.io.*;

public class Interface {
    
    public static void main (String args[]) {
        
        // Get number of players and map size
    
        int players = getPlayers();
        int size = getMap(players);
        
        // Create Map
        
        Tile[][] map = createMap(size);
        
        // Create starting positions and obtain player objects
        
        Player[] playersArray = generateStart (map, players);
                
        // Output Map to HTML Files
        
        htmlOutput(map.length, playersArray);
        
        // Create inital CSS Files
        
        cssOutput(map, playersArray);
        
    }
    
    public static int getPlayers() {
    
        System.out.print ("Number of players: ");

        Scanner k = new Scanner (System.in);
        int players = k.nextInt();
    
        while (players < 2 || players > 8) {

            System.out.println ("\nInvalid Input!  Minimum: 2 Players, Maximum: 8 Players\n");
            
            System.out.print ("Number of players: ");
            players = k.nextInt();
            
        }
        
        return players;
    
    }
    
    public static int getMap(int players) {
        
        Scanner k = new Scanner (System.in);
    
        System.out.print ("\nMap height and width (n): ");
        int n = k.nextInt();
        
        if (players <= 4) {
        
            while (n < 5 || n > 50) {
            
                System.out.println ("\nInvalid Input!  Minimum n: 5, Maximum n: 50\n");
            
                System.out.println ("Map height and width (n): ");
                n = k.nextInt();
            
            }
        
        } else {
        
            while (n < 8 || n > 50) {
            
                System.out.println ("\nInvalid Input!  Minimum n: 8, Maximum n: 50\n");
            
                System.out.println ("Map height and width (n): ");
                n = k.nextInt();
            
            }
        
        }
        
        return n;
    
    }
    
    public static Tile[][] createMap(int n) {
    
        Tile[][] map = new Tile [n][n];
        
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
        
        return map;
    
    }
    
    public static Player[] generateStart (Tile[][] map, int players) {
    
        int length = map.length;
        
        Player[] playersArray = new Player[players];
        
        Random rand = new Random();
        int row, col;
        
        for (int i = 0; i < players; i++) {
            
            do {

                row = rand.nextInt(length);
                col = rand.nextInt(length);

            } while (map[row][col] != Tile.Grass);
            
            playersArray[i] = new Player(row,col, i);
        
        }
        
        return playersArray;
    
    }
    
    public static String getBodyCode(int n) {
    
        String body = "<body><table border=\"1\">";
        
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
    
    public static void htmlOutput (int mapSize, Player[] players) {
    
        FileWriter fw;
        BufferedWriter bw;
        
        String body = getBodyCode(mapSize);
        
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

    public static void cssOutput (Tile[][] map, Player[] players) {
        
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
            
            String cssCode = "td {background-color: #aaaaaa; border:1px solid white;} td#" + cellID + "{background-color:" + colour + ";}";
        
            try {
            
                fw = new FileWriter (players[i].getCSS(), true);
                bw = new BufferedWriter (fw);
                
                bw.write(cssCode);
                bw.close();
                
            }
            
            catch (IOException e) {
            
                e.printStackTrace();
            
            }
        
        }
    
    }
    
}
