package com;

import java.util.Scanner;

public class GameLauncher {

    public static void main (String args[]) {

        // Get number of players and map size

        int numPlayers = getPlayers();
        int size = getMapSize(numPlayers);

        char diff = getDifficulty();

        // Create a new game for the specified inputs

        Game game = new Game (numPlayers, size, diff);

        game.start();

    }

    public static int getPlayers() {

        System.out.print ("Number of players: ");

        Scanner k = new Scanner (System.in);
        int players = k.nextInt();

        while (!playerNumberCheck(players)) {

            System.out.println ("\nInvalid Input!  Minimum: 2 Players, Maximum: 8 Players\n");

            System.out.print ("Number of players: ");
            players = k.nextInt();

        }

        return players;

    }

    // Tested
    public static boolean playerNumberCheck(int players) {

        return !(players < 2 || players > 8);
    }

    public static int getMapSize(int players) {

        Scanner k = new Scanner (System.in);

        System.out.print ("\nMap height and width (n): ");
        int n = k.nextInt();

        while (!mapSizeCheck(n, players)) {

            if (players <= 4) {

                System.out.println ("\nInvalid Input!  Minimum n: 5, Maximum n: 50\n");

            } else {

                System.out.println ("\nInvalid Input!  Minimum n: 8, Maximum n: 50\n");

            }

            System.out.print ("Map height and width (n): ");
            n = k.nextInt();

        }

        return n;

    }

    // Tested
    public static boolean mapSizeCheck(int size, int players){

        if((players <= 4) && (size < 5 || size > 50)){

            return false;

        } else {

            return !((players >= 5) && (size < 8 || size > 50));

        }

    }

    public static char getDifficulty() {

        System.out.println ("Please select difficulty level: [S]afe (10% water tiles) or [H]azardous (25%-35% water tiles)");

        Scanner k = new Scanner (System.in);

        char choice = Character.toUpperCase(k.next().charAt(0));

        while (!validChoice(choice)) {

            System.out.println ("\nInvalid Input!  Minimum: 2 Players, Maximum: 8 Players\n");

            System.out.print ("Difficult Level: [S]/[H]");
            choice = Character.toUpperCase(k.next().charAt(0));

        }

        return choice;

    }

    public static boolean validChoice(char choice) {

        if ((choice == 'S') || (choice == 'H')) {

            return true;

        } else {

            return false;

        }

    }

}
