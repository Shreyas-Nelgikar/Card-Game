package com.cardgame.models;

import java.util.ArrayList;

public class Card {

    private String rank;
    private String suit;

    public Card (String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public void display (ArrayList<Card> list) {
        ArrayList<String> arr = new ArrayList<>();
        for (Card cards: list) {
            arr.add(cards.getRank() + " " + cards.getSuit());
        }
        System.out.println(arr);
    }

}
