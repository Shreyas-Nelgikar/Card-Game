package com.cardgame.models;

import java.util.ArrayList;
import java.util.Scanner;

public class GameIntialisation {

    private Deck deck;

    Scanner scanner = new Scanner(System.in);

    public int initializeNoOfPlayers () {
        int noOfPlayers = scanner.nextInt();
        while (noOfPlayers > 4) {
            System.out.println("You have crossed the maximum limit of players. Please select again");
            noOfPlayers = scanner.nextInt();
        }
        return noOfPlayers;
    }

    public ArrayList<Player> initializePlayers (int noOfPlayers) {
        Deck deck = new Deck();
        ArrayList<ArrayList<Card>> inHandCards = deck.drawCards(noOfPlayers, 5);
        ArrayList<Player> players = new ArrayList<>();
        for (int i=0; i<noOfPlayers; i++) {
            System.out.println("Please select id for player " + (i+1));
            int id = scanner.nextInt();
            System.out.println("Please select name for player " + (i+1));
            String name = scanner.next();
            players.add(new Player(id, name, inHandCards.get(i)));
        }
        return players;
    }

}
