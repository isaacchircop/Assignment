package com;

import java.util.*;

public class Interface {
    
    public static void main (String args[]) {
        
        // Get number of players and map size
    
        int numPlayers = getPlayers();
        int size = getMapSize(numPlayers);
        
        // Create Map and Players
        Map map = new Map (size);
        Player[] players = createPlayers(map, numPlayers);
                
        // Output Map to HTML Files
        map.outputInitialMap(players);
        
        // Create inital CSS Files
        map.outputUpdatedMap(players);
        
        int rndCnt = 0;
        
        do {
        
            rndCnt++;
            
            System.out.println("\n===================================================");
            System.out.println ("Round " + rndCnt + ": Move (U)p (D)own (L)eft or (R)ight\n");

            Scanner k = new Scanner (System.in);

            for (int i = 0; i < players.length; i++) {

                boolean validMove = false;

                do {

                    System.out.print ("Awaiting Input from Player " + i + ": ");

                    char move = k.next().toUpperCase().charAt(0);

                    System.out.println();

                    int row = players[i].getCurrentRow();
                    int col = players[i].getCurrentCol();

                    boolean validCharacter = true;

                    switch (move) {

                        case 'U':

                            row--;
                            break;

                        case 'D':

                            row++;
                            break;

                        case 'L':

                            col--;
                            break;

                        case 'R':

                            col++;
                            break;

                        default:

                            System.out.println ("Invalid Move!  Please input one of these character options: U, D, L, R");
                            validCharacter = false;
                            break;

                    }

                    if (validCharacter == true) {

                        validMove = map.checkInRange(row, col);

                        if (validMove) {

                            players[i].updatePosition (row, col);

                        } else {

                            System.out.println ("Invalid Move!  You tried to move outside map limit.  Please try again");

                        }

                    }

                } while (validMove == false);

            }
            
        } while (map.outputUpdatedMap(players) == false);
        
        System.out.println ("Game Finished!");
        
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
    
    public static int getMapSize(int players) {
        
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
    
    public static Player[] createPlayers (Map map, int players) {
    
        int length = map.getLength();
        
        Player[] playersArray = new Player[players];
        
        Random rand = new Random();
        int row, col;
        
        for (int i = 0; i < players; i++) {
            
            do {

                row = rand.nextInt(length);
                col = rand.nextInt(length);

            } while (map.getTile(row, col) != Tile.Grass);
            
            playersArray[i] = new Player(row,col, i);
        
        }
        
        return playersArray;
    
    }
            
    
}
