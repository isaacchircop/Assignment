package com;

import java.util.*;
import java.io.*;

public class Interface {
    
    public static void main (String args[]) {
        
        // Get number of players and map size
    
        int players = getPlayers();
        int n = getMap(players);
        
        // Create Map
        
        Tile[][] map = createMap(n);
        
        // Output Map to HTML Files
        
        File[] files = getHTMLFiles(players);
        htmlOutput(files, n, players);
        
        // Display map on console
        
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
    
    public static File[] getHTMLFiles(int numOfFiles) {

        // Create array of files
        
        File[] files = new File[numOfFiles];
        
        for (int i = 0; i < numOfFiles; i++) {
        
            files[i] = new File ("map_name_" + i + ".html");
        
        }
        
        return files;

    }
    
    public static File[] getCSSFiles(int numOfFiles) {
    
        // Create array of files
        
        File[] files = new File[numOfFiles];
        
        for (int i = 0; i < numOfFiles; i++) {
        
            files[i] = new File ("map_name_" + i + ".css");
        
        }
        
        return files;
    
    }
    
    public static String getBodyCode(int n) {
    
        String body = "<body><table border=\"1\">";
        
        for (int i = 0; i < n; i++) {
            
            body = body + "<tr>";
        
            for (int j = 0; j < n; j++) {
            
                body = body + "<td class = \"" + i + j + "\" bgcolor=\"#aaaaaa\" width = \"50\" height = \"50\"></td>";
            
            }
            
            body = body + "</tr>";
        
        }
        
        body = body + "</table></body>";
        
        return body;
    
    }
    
    public static void htmlOutput (File[] files, int n, int players) {
    
        FileWriter fw;
        BufferedWriter bw;
        
        String body = getBodyCode(n);
        
        for (int i = 0; i < players; i++) {
            
            String head = "<head><link rel=\"stylesheet\" type=\"text/css\" href=\"map_name_" + i + ".css\"></head>";
            String html = "<html>" + head + body + "</html>";
        
            try {
            
                fw = new FileWriter(files[i]);
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
