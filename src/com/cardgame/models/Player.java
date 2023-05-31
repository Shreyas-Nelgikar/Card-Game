package com.cardgame.models;

import java.util.ArrayList;

public class Player {

    private int playerId;
    private String playerName;
    private ArrayList<Card> cardsInHand;

    Player (int playerId, String playerName, ArrayList<Card> cardsInHand) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.cardsInHand = cardsInHand;
    }

    public void addCard (ArrayList<Card> list, Card card) {
        list.add(card);
    }

    public void removeCard (ArrayList<Card> list, Card card) {
        list.remove(card);
    }

    public void displayCards (ArrayList<Card> list) {
        ArrayList<String> arr = new ArrayList<>();
        for (Card cards : list)
            arr.add(cards.getRank() + " " + cards.getSuit());
        System.out.println(arr);
    }

    public boolean hasWon (ArrayList<Card> list) {
        return list.isEmpty();
    }

}
