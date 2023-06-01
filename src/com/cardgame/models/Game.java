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

    public void startGame (Game game) {
        int currPlayerIndex = game.getCurrPlayerIndex();
        while (true) {
            System.out.println("####################################################");
            System.out.println("Player 1's turn, please select a card");
            displayCards(game.getPlayers().get(currPlayerIndex));
            int value = scanner.nextInt();

        }
    }

}
