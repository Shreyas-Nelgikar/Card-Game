package com.cardgame.models;

import java.util.ArrayList;

public class Card {

    private CardRank rank;
    private CardSuit suit;

    public Card (CardRank rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public CardRank getRank() {
        return rank;
    }

    public CardSuit getSuit() {
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
