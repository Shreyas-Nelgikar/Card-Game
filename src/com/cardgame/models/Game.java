package com.cardgame.models;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    private ArrayList<Card> standardDeck;
    private int currPlayerIndex;
    private Card topCard;

    Game (ArrayList<Player> players) {
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








}
