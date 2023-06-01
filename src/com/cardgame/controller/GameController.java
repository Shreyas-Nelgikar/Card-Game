package com.cardgame.controller;

import com.cardgame.models.*;

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
        ArrayList<ArrayList<Card>> cards = deck.drawCards(1, 52);
        ArrayList<Card> standardDeck = cards.get(0);
        Card topCard = standardDeck.get(standardDeck.size()-1);
        standardDeck.remove(standardDeck.size()-1);
        game.setCurrPlayerIndex(currPlayerIndex);
        game.setPlayers(players);
        game.setStandardDeck(standardDeck);
        game.setTopCard(topCard);
        game.setGameState(GameState.IN_PROGRESS);
        return game;
    }

    public void displayCards (Game game, int currPlayerIndex) {
        game.displayCards(game.getPlayers().get(currPlayerIndex));
    }

}
