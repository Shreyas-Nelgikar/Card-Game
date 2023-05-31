package com.cardgame.models;

import java.util.ArrayList;

public class Card {

    private int rank;
    private char suit;

    Card (int rank, char suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public char getSuit() {
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
