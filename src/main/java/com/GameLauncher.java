package com;

import java.util.Scanner;

public class GameLauncher {

    public static void main (String args[]) {

        System.out.println ("Getting map generation parameters:");

        // Get number of players and map size
        int numOfPlayers = getPlayers();
        int numOfTeams = getTeams(numOfPlayers);
        int mapSize = getMapSize(numOfPlayers);
        char difficulty = getDifficulty();

        // Create a new game generator
        GameGenerator generator = new GameGenerator(numOfPlayers, numOfTeams, mapSize, difficulty);

        // Create a new game
        Game game = generator.createGame();

        // Start playing the game
        game.startGame();

    }

    public static int getPlayers() {

        System.out.print ("Number of players: ");

        Scanner k = new Scanner (System.in);
        int players = k.nextInt();

        while (!playerNumberCheck(players)) {

            System.out.println ("\nInvalid Input!  Minimum: 2 Players, Maximum: 8 Players\n");

            System.out.print("Number of players: ");
            players = k.nextInt();

        }

        return players;

    }
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
    public static boolean mapSizeCheck(int size, int players){

        if((players <= 4) && (size < 5 || size > 50)){

            return false;

        } else {

            return !((players >= 5) && (size < 8 || size > 50));

        }

    }

    public static char getDifficulty() {

        System.out.print ("Difficulty level (S/H):  ");
        Scanner k = new Scanner (System.in);

        char choice = Character.toUpperCase(k.next().charAt(0));

        while (!validChoice(choice)) {

            System.out.println ("\nInvalid Input!  Please input S/H\n");

            System.out.print("Difficulty Level (S/H):");
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

    public static int getTeams(int players) {

        System.out.print("Number of Teams: ");

        Scanner k = new Scanner (System.in);

        int teams = k.nextInt();

        while (teams > players || teams == 0) {

            if (teams == 0) {
                System.out.println("\nInvalid input! Number of teams cannot equal 0.\n");

                System.out.print ("Number of Teams: ");

                teams = k.nextInt();
            }
            else {
                System.out.println ("\nInvalid input!  Team number must be smaller than number of players.\n");

                System.out.print ("Number of Teams: ");

                teams = k.nextInt();
            }

        }


        return teams;

    }


}
