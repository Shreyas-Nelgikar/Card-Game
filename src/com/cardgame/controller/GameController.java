package com.cardgame.controller;

import com.cardgame.models.Card;
import com.cardgame.models.Deck;
import com.cardgame.models.Game;
import com.cardgame.models.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class GameController {

    Scanner scanner = new Scanner(System.in);

    public Game createGame (Game game) {
        int currPlayerIndex = 0;
        Deck deck = new Deck();
        System.out.println("Welcome to the card Game");
        System.out.println("Please select at max 4 players");
        int noOfPlayers = scanner.nextInt();
        while (noOfPlayers > 4) {
            System.out.println("You have crossed the maximum limit of players. Please select again");
            noOfPlayers = scanner.nextInt();
        }
        ArrayList<ArrayList<Card>> inHandCards = deck.drawCards(noOfPlayers, 5);
        ArrayList<Player> players = new ArrayList<>();
        for (int i=0; i<noOfPlayers; i++) {
            System.out.println("Please select id for player " + (i+1));
            int id = scanner.nextInt();
            System.out.println("Please select name for player " + (i+1));
            String name = scanner.next();
            players.add(new Player(id, name, inHandCards.get(i)));
        }
        ArrayList<Card> standardDeck = new ArrayList<>();
        Card topCard = new Card("1", "A");
        return game;
    }

    public void displayCards (Game game, int currPlayerIndex) {
        game.displayCards(game.getPlayers().get(currPlayerIndex));
    }

}
