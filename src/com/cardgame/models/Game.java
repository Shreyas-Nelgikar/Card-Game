package com.cardgame.models;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private ArrayList<Player> players;
    private ArrayList<Card> standardDeck;
    private int currPlayerIndex;
    private Card topCard;
    private Player player;

    Scanner scanner = new Scanner(System.in);

    public Game() {};

    public Game (ArrayList<Player> players) {
        this.currPlayerIndex = 0;
        this.players = players;
        this.topCard = null;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public ArrayList<Card> getStandardDeck() {
        return standardDeck;
    }

    public void setStandardDeck(ArrayList<Card> standardDeck) {
        this.standardDeck = standardDeck;
    }

    public int getCurrPlayerIndex() {
        return currPlayerIndex;
    }

    public void setCurrPlayerIndex(int currPlayerIndex) {
        this.currPlayerIndex = currPlayerIndex;
    }

    public Card getTopCard() {
        return topCard;
    }

    public void setTopCard(Card topCard) {
        this.topCard = topCard;
    }

    public int getNextPlayerIndex (int currPlayerIndex, boolean reverseOrder) {
        int numPlayers = players.size();
        int nextPlayerIndex;
        if (reverseOrder) {
            nextPlayerIndex = (currPlayerIndex - 1 + numPlayers) % numPlayers;
        }
        else {
            nextPlayerIndex = (currPlayerIndex + 1) % numPlayers;
        }
        return nextPlayerIndex;
    }

    public void displayCards (Player player) {
        player.displayCards();
    }

    public void createGame () {
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
            System.out.println("Please select id for player " + i + 1);
            int id = scanner.nextInt();
            System.out.println("Please select name for player " + i + 1);
            String name = scanner.next();
            players.add(new Player(id, name, inHandCards.get(i)));
        }
        ArrayList<Card> standardDeck = new ArrayList<>();
        Card topCard = null;
    }

}
