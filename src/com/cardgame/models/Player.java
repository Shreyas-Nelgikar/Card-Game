package com.cardgame.models;

import java.util.ArrayList;
import java.util.Objects;

public class Player {

    private int playerId;
    private String playerName;
    private ArrayList<Card> cardsInHand;
    private final String[] bonus = {"A", "K", "Q", "J"};

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

    public void hasPlayableCard (Card card, Card topCard) {
        if (!card.getRank().equals(topCard.getRank()) || !card.getSuit().equals(topCard.getSuit()))
            System.out.println("Please re-select a Card that matches Rank or Suit of the topCard");
    }

    public boolean hasWon (ArrayList<Card> list) {
        return list.isEmpty();
    }

}
