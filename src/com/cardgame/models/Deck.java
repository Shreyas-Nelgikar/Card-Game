package com.cardgame.models;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private final String[] suit = {"Heart", "Diamond", "Spade", "Club"};
    private final String[] rank = {"A", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private ArrayList<Card> standardDeck;

    Deck () {
        completeDeck();
    }

    public void completeDeck () {
        standardDeck = new ArrayList<>();
        for (String suits : suit) {
            for (String ranks : rank) {
                Card card = new Card(suits, ranks);
                standardDeck.add(card);
            }
        }
    }

    public ArrayList<Card> drawCards (int size) {
        ArrayList<Card> list = new ArrayList<>();
        for (int i=0; i<size; i++) {
            int random = (int) (Math.random() * (size - i) + i);
            Card card = standardDeck.get(random);
            list.add(card);
            Collections.swap(standardDeck, i, random);
        }
        return list;
    }

}
