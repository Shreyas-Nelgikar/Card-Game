package com.cardgame.models;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private final String[] suit = {"Heart", "Diamond", "Spade", "Club"};
    private final String[] rank = {"A", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private ArrayList<Card> standardDeck;

    public Deck () {
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

    public ArrayList<ArrayList<Card>> drawCards (int players, int size) {
        ArrayList<ArrayList<Card>> list = new ArrayList<>();
        int counter = 0;
        for (int i=0; i<players; i++) {
            ArrayList<Card> arr = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                int random = (int) (Math.random() * (52 - counter) + counter);
//            System.out.println(random);
                Card card = standardDeck.get(random);
                arr.add(card);
                Collections.swap(standardDeck, counter, random);
                counter++;
            }
            list.add(arr);
        }
        return list;
    }

}
