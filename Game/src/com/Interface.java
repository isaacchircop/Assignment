package com;

import java.util.*;
import java.io.*;

public class Interface {
    
    public static void main (String args[]) {
        
        // Get number of players and map size
    
        int players = getPlayers();
        int n = getMap(players);
        
        // Get a newly created map
        
        Tile[][] map = createMap(n);
        
        // Get array of buffered writers - used to output map to html files
        
        BufferedWriter [] bw = getBW(players);
        
        String html = getHTMLCode(n);
        
        for (int i = 0; i < players; i++) {
        
            try {
            
                bw[i].write(html);
                bw[i].close();
                
            }
        
            catch (IOException e) {
                
                e.printStackTrace();
            
            }
            
        }
        
        // Display map
        
        for (int i = 0; i < n; i++) {
        
            for (int j = 0; j < n; j++) {
            
                System.out.print (map[i][j] + "  ");
            
            }
            
            System.out.println ("");
        
        }
        
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
    
    public static BufferedWriter[] getBW(int n) {
    
        // Create array of files
        
        File[] files = new File[n];
        
        for (int i = 0; i < n; i++) {
        
            files[i] = new File ("map_name_" + i + ".html");
        
        }
        
        // Create array of file writers
        
        FileWriter [] fw = new FileWriter[n];
        
        for (int i = 0; i < n; i++) {
        
            try {
            
                fw[i] = new FileWriter (files[i]);
                
            }
            
            catch (IOException e) {
            
                e.printStackTrace();
                
            }
        
        }
        
        // Create array of buffered writers
        
        BufferedWriter [] bw = new BufferedWriter[n];
        
        for (int i = 0; i < n; i++) {
        
            bw[i] = new BufferedWriter (fw[i]);
        
        }
        
        return bw;
    
    }
    
    public static String getHTMLCode(int n) {
    
        String html = "<html><body><table border=\"1\">";
        
        for (int i = 0; i < n; i++) {
            
            html = html + "<tr>";
        
            for (int j = 0; j < n; j++) {
            
                html = html + "<td bgcolor=\"#aaaaaa\" width = \"50\" height = \"50\"></td>";
            
            }
            
            html = html + "</tr>";
        
        }
        
        html = html + "</table></body></html>";
        
        return html;
    
    }
    
}
